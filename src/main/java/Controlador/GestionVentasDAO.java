package Controlador;

import Modelo.Cliente;
import Modelo.Celular;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GestionVentasDAO implements GestionVentas {

    Conexion c = new Conexion();

    @Override
    public double Iva(List<Celular> listaCelulares) {
        double subtotal = 0;

        for (Celular c : listaCelulares) {
            subtotal += c.getPrecio();
        }
        return subtotal * 1.19;
    }

    @Override
    public void registrarVenta(Cliente cli, List<Celular> listaCelulares) {
        double totalConIva = Iva(listaCelulares);

        try {
            // 1. Conectar (ajusta los datos de tu BD)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_datos", "root", "");

            String sqlVenta = "INSERT INTO ventas (id_cliente, fecha, total) VALUES (?, ?, ?)";
            PreparedStatement psVenta = con.prepareStatement(sqlVenta);

            psVenta.setInt(1, cli.getId());
            psVenta.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            psVenta.setDouble(3, totalConIva);

            psVenta.executeUpdate();

            String sqlStock = "UPDATE celulares SET stock = stock - 1 WHERE id = ?";
            PreparedStatement psStock = con.prepareStatement(sqlStock);

            for (Celular cel : listaCelulares) {
                psStock.setInt(1, cel.getId());
                psStock.executeUpdate();
            }

            System.out.println("La venta de los celulares :" + listaCelulares.size() + "Fue realizada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void reporte() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base", "root", "");

            // La consulta que une las tablas
            String sql = "SELECT v.id, c.nombre, v.fecha, v.total FROM ventas v JOIN clientes c ON v.id_cliente = c.id";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("Reporte");
            while (rs.next()) {
                System.out.println("Factura: " + rs.getInt("id")
                        + " | Cliente: " + rs.getString("nombre")
                        + " | Fecha: " + rs.getDate("fecha")
                        + " | Total: $" + rs.getDouble("total"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
