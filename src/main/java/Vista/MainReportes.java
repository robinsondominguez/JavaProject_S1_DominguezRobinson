package Vista;

import java.util.Scanner;
import Controlador.GestionReportesDAO;

public class MainReportes {

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

    int opcion;

    public void menuReporte() {
        GestionReportesDAO grDAO = new GestionReportesDAO();
        do {
            System.out.println("""
                               ********* gestion de reportes ***********
                               1. Listar stocks bajos
                               2. Generar Reporte (.txt)
                               3. Salir
                               """);

            opcion = Validacion(1, 5, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    grDAO.ListarStockBajo().forEach(c
                            -> System.out.println(
                                    "ID: " + c.getId()
                                    + " | Marca: " + c.getMarca()
                                    + " | Modelo: " + c.getModelo()
                                    + " | Stock: " + c.getStock()
                            )
                    );
                    break;
                    
                case 2:
                    grDAO.GenerarReporteVentas();
                    break;

            }
        } while (opcion != 3);
    }
}
