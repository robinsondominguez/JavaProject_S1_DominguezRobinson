package Modelo;

import java.util.List;
import java.util.Date;

public class Venta {
    private int id;
    private int idCliente;
    private Date fecha;
    private double total;
    
    public Venta(int id, int idCliente, Date fecha, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public Venta(){}

    
    
}
