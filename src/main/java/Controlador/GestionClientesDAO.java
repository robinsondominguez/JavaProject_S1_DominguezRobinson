package Controlador;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionClientesDAO implements GestionClientes {

    Conexion c = new Conexion();

    @Override
    public void registrarCliente(Cliente Cli) {

        try (Connection con = c.conectar()) {
            if (con != null && !con.isClosed()) {
                System.out.println("Conexión establecida con MySQL");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (!GmailValidation.correoValido(Cli.getCorreo())) {
            System.out.println("Error: El formato del correo electrónico " + Cli.getCorreo() + "no es válido.");
            return;
        }

        String sql = " INSERT INTO clientes (nombre, identificacion, correo, telefono) VALUES (?, ?, ?, ?)";
        try (Connection con = c.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, Cli.getNombre());
            ps.setLong(2, Cli.getIdentificacion());
            ps.setString(3, Cli.getCorreo());
            ps.setInt(4, Cli.getTelefono());

            ps.executeUpdate();
            System.out.println("Cliente registrado correctamente");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listarCliente(int id) {
    String sql = "SELECT * FROM clientes WHERE id = ?";

    try (Connection con = c.conectar(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                System.out.println("--- Datos del Cliente Encontrado ---");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Identificación: " + rs.getLong("identificacion"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Teléfono: " + rs.getInt("telefono"));
                System.out.println("-------------------------");
            } else {
                System.out.println("El ID: " + id + " no existe.");
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}
