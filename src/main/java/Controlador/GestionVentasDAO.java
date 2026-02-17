package Controlador;

import Modelo.Cliente;
import Modelo.Celular;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionVentasDAO implements GestionVentas {

    Conexion c = new Conexion();

    @Override
    public double Iva(List<Celular> listaCelulares) {
        double subtotal = 0;

        for (Celular cel : listaCelulares) {
            subtotal += cel.getPrecio();
        }
        return subtotal * 1.19;
    }

    @Override
    public void registrarVenta(Cliente cli, List<Celular> listaCelulares) {

    try (Connection con = c.conectar()) {

        double subtotal = 0;

        String sqlCel = "SELECT precio, stock FROM celulares WHERE id = ?";
        PreparedStatement psCel = con.prepareStatement(sqlCel);


        for (Celular cel : listaCelulares) {

            psCel.setInt(1, cel.getId());
            ResultSet rs = psCel.executeQuery();

            if (rs.next()) {

                int stock = rs.getInt("stock");

                if (stock <= 0) {
                    System.out.println("No hay stock disponible para el celular ID: " + cel.getId());
                    return;
                }

                double precio = rs.getDouble("precio");
                cel.setPrecio(precio);
                subtotal += precio;

            } else {
                System.out.println("Celular con ID " + cel.getId() + " no existe.");
                return;
            }
        }

        double totalConIva = subtotal * 1.19;

   
        String sqlVenta = "INSERT INTO ventas (id_cliente, fecha, total) VALUES (?, CURDATE(), ?)";
        PreparedStatement psVenta = con.prepareStatement(sqlVenta, PreparedStatement.RETURN_GENERATED_KEYS);

        psVenta.setInt(1, cli.getId());
        psVenta.setDouble(2, totalConIva);
        psVenta.executeUpdate();

        ResultSet rsVenta = psVenta.getGeneratedKeys();
        int idVenta = 0;

        if (rsVenta.next()) {
            idVenta = rsVenta.getInt(1);
        }

 
        String sqlDetalle = "INSERT INTO detalle_ventas (id_venta, id_celular, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);

        for (Celular cel : listaCelulares) {

            psDetalle.setInt(1, idVenta);
            psDetalle.setInt(2, cel.getId());
            psDetalle.setInt(3, 1); // cantidad fija 1
            psDetalle.setDouble(4, cel.getPrecio());

            psDetalle.executeUpdate();
        }


        String sqlStock = "UPDATE celulares SET stock = stock - 1 WHERE id = ?";
        PreparedStatement psStock = con.prepareStatement(sqlStock);

        for (Celular cel : listaCelulares) {
            psStock.setInt(1, cel.getId());
            psStock.executeUpdate();
        }

        System.out.println("Venta registrada.");
        System.out.println("Total con IVA: " + totalConIva);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    @Override
    public void reporte() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TecnoStore", "campus2023", "campus2023");

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

    @Override
    public List<Venta> listarVentas() {
        List<Venta> lista = new ArrayList<>();

        try (Connection con = c.conectar()) {
            String sql = "SELECT * FROM ventas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setTotal(rs.getDouble("total"));
                lista.add(v);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public void celularesStockBajo() {

        List<Celular> lista = new ArrayList<>();

        try (Connection con = c.conectar()) {

            String sql = "SELECT * FROM celulares";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Celular cel = new Celular();
                cel.setId(rs.getInt("id"));
                cel.setMarca(rs.getString("marca"));
                cel.setModelo(rs.getString("modelo"));
                cel.setStock(rs.getInt("stock"));
                cel.setPrecio(rs.getDouble("precio"));

                lista.add(cel);
            }

            lista.stream()
                    .filter(cel -> cel.getStock() < 5)
                    .forEach(cel -> System.out.println(
                    "ID: " + cel.getId()
                    + " | " + cel.getMarca()
                    + " " + cel.getModelo()
                    + " | Stock: " + cel.getStock()
            ));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
