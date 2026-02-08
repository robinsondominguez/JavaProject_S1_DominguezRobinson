package Vista;

import java.util.Scanner;

public class Main {

    public int validacion(int minimo, int maximo, String mensaje) {
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
    
    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("""
                           *************************
                           Bienvenido a TecnoStore
                           
                           Por favor eliga una opcion:
                           
                           1. Gestionar Celulares
                           2. Gestionar Clientes
                           3. Gestionar Ventas
                           4. Generar Reporte
                           5. Salir
                           """);

            op = new Scanner(System.in).nextInt();
            if (op < 1 || op > 5) {
                System.out.println("Error, Opcion no Valida");
            } else {
                switch (op) {
                    case 1:
                        MainCelulares mc = new MainCelulares();
                        mc.mainCelulares();
                    case 2:

                    case 3:

                    case 4:
                }
            }
        } while (op != 5);
    }
}
