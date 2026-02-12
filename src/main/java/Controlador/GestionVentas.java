package Controlador;

import Modelo.Cliente;
import Modelo.Celular;
import Modelo.Venta;
import java.util.List;

public interface GestionVentas {
    
    void registrarVenta(Cliente cli, List<Celular> listaCelulares);
 
    double Iva(List<Celular> listaCelulares);
    
    List<Venta> listarVentas();
    
    void celularesStockBajo();
    
    void reporte();
}
