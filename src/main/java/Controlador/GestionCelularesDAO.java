package Controlador;

import Modelo.Celular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionCelularesDAO implements GestionCelulares {

    Conexion c = new Conexion();

    @Override
    public void RegistrarCelular(Celular cel) {
        String sql = "INSERT INTO celulares (marca, modelo, sistema_operativo, categoriaGama, precio, stock) VALUES (?,?,?,?,?,?)";

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cel.getMarca());
            ps.setString(2, cel.getModelo());
            ps.setString(3, cel.getSistema_operativo());
            ps.setString(4, cel.getCategoriaGama());
            ps.setDouble(5, cel.getPrecio());
            ps.setInt(6, cel.getStock());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cel.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void EliminarCelular(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("DELETE from celulares where id = ?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este celular?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("Se ha elimnado el celular");
            } else {
                System.out.println("Se ha cancelado la eliminacion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Celular> ListaCelulares() {
        ArrayList<Celular> Celulares = new ArrayList<>();
        try (Connection con = c.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT * from celulares")) {
            while (rs.next()) {
                Celulares.add(new Celular(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(6), rs.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Celulares;
    }

    @Override
    public void ActualizarCelular(Celular cel, int id) {
        String sql = "UPDATE celulares SET stock = ?, precio = ? WHERE id = ?";

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cel.getStock());
            ps.setDouble(2, cel.getPrecio());
            ps.setInt(3, id);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Celular BuscarCelular(int id) {
        Celular cel = new Celular();

        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM celulares WHERE id =" + id);
            while (rs.next()) {
                cel.setId(rs.getInt("id"));
                cel.setMarca(rs.getString("marca"));
                cel.setModelo(rs.getString("modelo"));
                cel.setSistema_operativo(rs.getString("sistema"));
                cel.setCategoriaGama(rs.getString("categoria_gama"));
                cel.setPrecio(rs.getDouble(6));
                cel.setStock(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cel;
    }

    

}
