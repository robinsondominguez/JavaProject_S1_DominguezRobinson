package Vista;

import Controlador.GestionCelularesDAO;
import Modelo.Celular;
import java.util.Scanner;

public class MainCelulares {
    
    public static int Validacion(int minimo, int maximo, String mensaje) {
        int validacion = 0;
        try {
            System.out.println(mensaje);
            validacion = new Scanner(System.in).nextInt();
            while (validacion < minimo || validacion > maximo) {
                System.out.println("Opcion no valida");
                validacion = new Scanner(System.in).nextInt();
            }
        } catch (Exception e) {
            System.out.println("Solo se aceptan numeros enteros");
        }
        return validacion;

    }

    public static int validarEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine();
                numero = Integer.parseInt(entrada);
                esValido = true;
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
                System.out.println("❌ Error: Ingresa un número decimal válido (ej: 1500.99).");
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
                System.out.println("--- Registro de Nuevo Celular ---");

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
                gc.EliminarCelular(validacion);
                break;

                gc.ActualizarCelular(cel, id);
            }

            case 4 ->
                gc;

            case 5 ->
                gc.RegistrarCelular;

        }

    }
}