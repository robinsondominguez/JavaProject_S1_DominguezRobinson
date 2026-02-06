package Modelo;

public class Celular {
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private String Sistema;
    private CategoriaGama categoria;
    
    
    public Celular(int id, String marca, String modelo, double precio, int stock, String Sistema, CategoriaGama categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.Sistema = Sistema;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSistema(String Sistema) {
        this.Sistema = Sistema;
    }
    
    public enum CategoriaGama{
        Alta,
        Media,
        Baja
    }
    
}
