package Controlador;

import Modelo.Celular;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class GestionReportesDAO implements GestionReportes {
    
    Conexion c = new Conexion();

    private GestionCelularesDAO celDAO = new GestionCelularesDAO();

    @Override
    public List<Celular> ListarStockBajo() {

        List<Celular> celulares = celDAO.ListaCelulares();

        List<Celular> stockBajo = celulares.stream()
                .filter(c -> c.getStock() < 5)
                .toList();

        return stockBajo;
    }

    @Override
    public void GenerarReporteVentas() {

    String sql = """
        SELECT v.id AS venta_id,
               c.nombre,
               v.fecha,
               v.total,
               ce.marca,
               ce.modelo,
               dv.cantidad,
               dv.subtotal
        FROM ventas v
        INNER JOIN clientes c ON v.id_cliente = c.id
        INNER JOIN detalle_ventas dv ON dv.id_venta = v.id
        INNER JOIN celulares ce ON dv.id_celular = ce.id
        ORDER BY v.id;
        """;

    try (Connection con = c.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         PrintWriter writer = new PrintWriter(new FileWriter("reporte_ventas.txt"))) {

        writer.println("----------- REPORTE DE VENTAS -----------\n");

        boolean hayDatos = false;
        int ventaActual = -1;

        while (rs.next()) {

            hayDatos = true;

            int idVenta = rs.getInt("venta_id");

            if (idVenta != ventaActual) {

                writer.println("-----------------------------------------");
                writer.println("Venta ID: " + idVenta);
                writer.println("Cliente: " + rs.getString("nombre"));
                writer.println("Fecha: " + rs.getDate("fecha"));
                writer.println("Total: $" + rs.getDouble("total"));
                writer.println("Detalles:");

                ventaActual = idVenta;
            }

            writer.println("   Celular: "
                    + rs.getString("marca") + " "
                    + rs.getString("modelo"));
            writer.println("   Cantidad: " + rs.getInt("cantidad"));
            writer.println("   Subtotal: $" + rs.getDouble("subtotal"));
            writer.println();
        }

        if (!hayDatos) {
            writer.println("No hay ventas registradas.");
        }

        writer.println("=========== FIN DEL REPORTE ===========");

        System.out.println("Archivo reporte_ventas.txt generado correctamente.");

    } catch (Exception e) {
        System.out.println("Error al generar reporte: " + e.getMessage());
    }
}


}
