package Vista;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        System.out.println("""
                           *************************
                           Bienvenido a TecnoStore
                           
                           Por favor eliga una opcion:
                           
                           1. Gestionar Celulares
                           2. Gestionar Clientes
                           3. Gestionar Ventas
                           4. Generar Reporte
                           . Salir
                           """);

        int op = new Scanner(System.in).nextInt();
        if (op < 0 || op > 7) {
            System.out.println("Error, Opcion no Valida");
        } else {
            switch (op) {
                case 1:
                    menuCelular();
                case 2:

                case 3:
                    
                case 4:
            }
        }
    }
}
    
