package Vista;

import java.util.Scanner;

public class MainCelulares {

    public static int validacion(int minimo, int maximo, String mensaje) {
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

    public void menuCelular() {
        
            System.out.println("""
                               ***********************
                               Gestion de celulares
                               
                               Eliga una opcion:
                               
                               1. registrar celular
                               2. eliminar celular
                               3. actualizar celular
                               4. eliminar celular
                               5. listar celulares
                               6. buscar celular
                               7. Regresar al menu
                               8. Opcion no requerida pero por que aja
                               """);
            int validacion = validacion(1,8, "Error, fuera del rango permitido, por favor seleccione uno disponible");
            switch (validacion) {
            case 1:
                
                break;
        }

    }
}
