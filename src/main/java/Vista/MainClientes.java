package Vista;

import java.util.Scanner;
import Controlador.GestionClientesDAO;
import Modelo.Cliente;

public class MainClientes {

    GestionClientesDAO gcdao = new GestionClientesDAO();

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

    public void menuCliente() {
        System.out.println("""
                               ***********************
                               Gestion de celulares
                               
                               Eliga una opcion:
                               
                               1. registrar cliente
                               2. Buscar cliente
                               """);

        int opcion = Validacion(1, 2, "Error, fuera del rango permitido, por favor seleccione uno disponible");

        switch (opcion) {
            case 1 -> {
                System.out.println("");



                System.out.print("Ingrese Nombre completo: ");
                String nombre = new Scanner(System.in).nextLine();

                System.out.print("Ingrese Identificación (Cédula): ");
                long identificacion = new Scanner(System.in).nextLong();

                System.out.print("Ingrese Correo: ");
                String correo = new Scanner(System.in).nextLine();

                System.out.print("Ingrese Teléfono: ");
                int telefono = new Scanner(System.in).nextInt();

                Cliente cli = new Cliente(0, nombre, identificacion, correo, telefono);
                gcdao.registrarCliente(cli);
            }

            case 2 -> {
                System.out.print("Ingrese el ID del cliente a consultar: ");
                int id = Integer.parseInt(new Scanner(System.in).nextLine());
                gcdao.listarCliente(id);
            }

        }

    }
}
