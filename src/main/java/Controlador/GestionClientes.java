package Controlador;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public interface GestionClientes {
    
    void registrarCliente(Cliente cli);
    
    List<Cliente> listaClientes = new ArrayList<>();
    void listarCliente(int id);
}
