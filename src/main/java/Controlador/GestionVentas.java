package Controlador;

import Modelo.Cliente;
import Modelo.Celular;
import java.util.List;

public interface GestionVentas {
    
    void registrarVenta(Cliente cli, List<Celular> listaCelulares);
 
    double Iva(List<Celular> listaCelulares);
    
    void reporte();
}
