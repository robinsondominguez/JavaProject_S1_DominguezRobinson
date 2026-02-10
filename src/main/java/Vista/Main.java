package Vista;

import java.util.Scanner;

public class Main {

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

    public static void main(String[] args) {

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

            int validacion = Validacion(0, 6, "Error, fuera del rango permitido, por favor seleccione uno disponible");
            boolean menu = false;

            while (menu == true) {
                switch (validacion) {
                    case 1:
                        MainCelulares mc = new MainCelulares();
                        mc.menuCelular();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                while (validacion != 5) {
                    menu = false;
                }
            }
        }
    }
}
