package Modelo;

public class Celular {

    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private String sistema;
    private String categoriaGama;

    public Celular(String marca, String modelo, double precio, int stock, String categoriaGama, String sistema) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.categoriaGama = categoriaGama;
        this.sistema = sistema;

    }
    
    public Celular(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public void setCategoriaGama(String categoria) {
        this.categoriaGama = categoria;
    }

    public String getCategoriaGama() {
        return categoriaGama;
    }

    @Override
    public String toString() {
        return """
              Id:      %s
              Marca:      %s
              Modelo:     %s
              Precio:     %s
              SO:         %s
              Gama:       %s
              Stock:      %s
              
              """.formatted(id, marca, modelo, precio, sistema, categoriaGama, stock);
    }
}
