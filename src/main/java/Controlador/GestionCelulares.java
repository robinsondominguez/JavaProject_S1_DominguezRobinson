package Controlador;

import java.util.Scanner;

public class GestionCelulares {
    
    public int validacion(int minimo, int maximo, String mensaje){
        int validacion = 0;
        try {
            System.out.println(mensaje);
            validacion = new Scanner(System.in).nextInt();
            while (validacion < minimo || validacion > maximo){
                System.out.println("Opcion no valida");
                validacion = new Scanner(System.in).nextInt();
            }
        }catch (Exception e){
            System.out.println("Solo se aceptan numeros enteros");
        }
        return validacion;
    }
    
    public void menuCelular(int op1){
        System.out.println("""
                           ************************
                           Gestion de celulares
                           
                           1. Registrar Celular
                           2. Ver celulares
                           """);
        int opCelulares = validacion(1,2, "Por favor, eliga una opcion.");
        
    }
    
    public void registrarCelular(){
        
    }
    
    public void celularesDisponibles(){
        
    }
    
}
