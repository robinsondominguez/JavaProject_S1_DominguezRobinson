package Controlador;

import java.util.ArrayList;
import Modelo.Celular;

public interface GestionCelulares {

    void RegistrarCelular(Celular cel);
    void ActualizarCelular(Celular cel, int id);
    void EliminarCelular(int id);
    
    ArrayList<Celular> ListaCelulares();
    Celular BuscarCelular(int id);
}
