package Vista;

import java.util.Scanner;

public class Main {


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

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("""
                               *************************
                               Bienvenido a TecnoStore
                               
                               Por favor elija una opcion:
                               
                               1. Gestionar Celulares
                               2. Gestionar Clientes
                               3. Gestionar Ventas
                               4. Generar Reporte
                               5. Salir
                               """);

            opcion = Validacion(1, 5, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    
                    MainCelulares mc = new MainCelulares();
                    mc.menuCelular();
                    
                    break;
                case 2:
                    
                    MainClientes mcl = new MainClientes();
                    mcl.menuCliente();
                    
                    break;
                case 3:
                    
                    MainVentas mv = new MainVentas();
                    mv.menuVentas();
                    break;
                    
                case 4:
                   MainReportes mr = new MainReportes();
                   mr.menuReporte();
                    break;
                    
                case 5:
                    
                    System.out.println("Adiosito");
                    break;
            }
        } while (opcion != 5);
    }
}
