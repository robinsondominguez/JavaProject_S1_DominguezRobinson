package Controlador;

import Modelo.Celular;
import java.util.List;

public interface GestionReportes {
    
    
    List<Celular> ListarStockBajo();
    
    void GenerarReporteVentas();
}
