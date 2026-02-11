package Vista;

import Controlador.GestionCelularesDAO;
import Modelo.Celular;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCelulares {

    public static int Validacion(int minimo, int maximo, String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(sc.nextLine());
                if (numero >= minimo && numero <= maximo) {
                    continuar = false;
                } else {
                    System.out.println("Opcion fuera de rango " + minimo + "-" + maximo + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se aceptan numeros enteros.");
            }
        }
        return numero;
    }

    public static int validarEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine();
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero.");
            }
        }
        return numero;
    }

    public static double validarDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número valido.");
            }
        }
    }

    private GestionCelularesDAO gcd = new GestionCelularesDAO();

    public void menuCelular() {

        System.out.println("""
                               ***********************
                               Gestion de celulares
                               
                               Eliga una opcion:
                               
                               1. registrar celular
                               2. eliminar celular
                               3. actualizar celular
                               4. listar celulares
                               5. buscar celular
                               6. Salir
                               7. Opcion no requerida pero por que aja
                               """);
        int validacion = Validacion(1, 8, "Error, fuera del rango permitido, por favor seleccione uno disponible");

        switch (validacion) {

            case 1 -> {

                System.out.print("Marca: ");
                String marca = new Scanner(System.in).nextLine();

                System.out.print("Modelo: ");
                String modelo = new Scanner(System.in).nextLine();

                System.out.print("Sistema Operativo: ");
                String sistema = new Scanner(System.in).nextLine();

                System.out.print("Gama (Baja, Media, Alta): ");
                String gama = new Scanner(System.in).nextLine();

                double precio = validarDouble("Ingrese el precio");

                System.out.print("Stock inicial: ");
                int stock = Integer.parseInt(new Scanner(System.in).nextLine());

                Celular nuevoCel = new Celular(marca, modelo, precio, stock, gama, sistema);

                gcd.RegistrarCelular(nuevoCel);

                System.out.println("¡Celular registrado con éxito!");
            }

            case 2 -> {
                System.out.println("Ingrese el id del Celular a eliminar");
                int id = validarEntero(new Scanner(System.in).nextLine());
                gcd.EliminarCelular(id);

            }

            case 3 -> {

                System.out.print("Ingrese el ID del celular que desea actualizar: ");
                int id = Integer.parseInt(new Scanner(System.in).nextLine());

                System.out.print("Ingrese el nuevo stock: ");
                int nuevoStock = Integer.parseInt(new Scanner(System.in).nextLine());

                System.out.print("Ingrese el nuevo precio: ");
                double nuevoPrecio = Double.parseDouble(new Scanner(System.in).nextLine());

                Celular datosNuevos = new Celular();
                datosNuevos.setStock(nuevoStock);
                datosNuevos.setPrecio(nuevoPrecio);

                gcd.ActualizarCelular(datosNuevos, id);
            }

            case 4 -> {

                ArrayList<Celular> lista = gcd.ListaCelulares();

                if (lista.isEmpty()) {
                    System.out.println("No hay celulares registrados en el inventario.");
                } else {
                    for (Celular cel : lista) {
                        System.out.printf("%-10s %-15s $%-9.2f %-10d\n",
                                cel.getMarca(),
                                cel.getModelo(),
                                cel.getPrecio(),
                                cel.getStock());
                    }
                }
            }

        }

    }
}
