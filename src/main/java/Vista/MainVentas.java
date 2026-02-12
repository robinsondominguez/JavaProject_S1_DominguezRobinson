package Vista;

import Controlador.GestionVentasDAO;
import Modelo.Cliente;
import Modelo.Celular;
import Modelo.Venta;
import Controlador.GestionVentasDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainVentas {

    public static int Validacion(int minimo, int maximo, String mensaje) {

        int numero = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(new Scanner(System.in).nextLine());
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

    private static GestionVentasDAO gestionDAO = new GestionVentasDAO();

    public static void menuVentas() {

        int opcion;

        do {

            System.out.println("-------------Gestion de ventas------------");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Ver Reporte");
            System.out.println("3. Listar Ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Validacion(1, 4, "Error: Escoga una opcion disponible");

            switch (opcion) {

                case 1:

                    System.out.print("ID del cliente: ");
                    int idCliente = new Scanner(System.in).nextInt();

                    Cliente cli = new Cliente();
                    cli.setId(idCliente);

                    System.out.print("¿Cuántos celulares desea comprar?: ");
                    int cantidad = new Scanner(System.in).nextInt();

                    List<Celular> listaCelulares = new ArrayList<>();

                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Ingrese ID del celular #" + (i + 1) + ": ");
                        int idCel = new Scanner(System.in).nextInt();

                        Celular cel = new Celular();
                        cel.setId(idCel);

                        listaCelulares.add(cel);
                    }

                    gestionDAO.registrarVenta(cli, listaCelulares);

                    break;

                case 2:
                    gestionDAO.reporte();
                    break;

                case 3:
                    gestionDAO.listarVentas();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

            }

        } while (opcion != 4);
    }

}
