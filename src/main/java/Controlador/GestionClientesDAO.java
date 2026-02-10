package Controlador;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionClientesDAO implements GestionClientes {

    Conexion c = new Conexion();

    @Override
    public void registrarCliente(Cliente Cli) {

        try (Connection con = c.conectar()) {
            if (con != null && !con.isClosed()) {
                System.out.println("Conexión establecida con MySQL");
            }
            // ... resto de tu código
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }

        if (!GmailValidation.correoValido(Cli.getCorreo())) {
            System.out.println("Error: El formato del correo electrónico (" + Cli.getCorreo() + ") no es válido.");
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

}
