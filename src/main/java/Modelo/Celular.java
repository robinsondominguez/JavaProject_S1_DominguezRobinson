package Modelo;

public class Celular {

    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private String sistema_operativo;
    private String categoriaGama;
    
    public Celular(String marca, String modelo, double precio, int stock, String sistema_operativo, String categoriaGama) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.sistema_operativo = sistema_operativo;
        this.categoriaGama = categoriaGama;
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

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public String getCategoriaGama() {
        return categoriaGama;
    }

    public void setCategoriaGama(String categoriaGama) {
        this.categoriaGama = categoriaGama;
    }
    
    public Celular(){
        
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
              
              """.formatted(id, marca, modelo, precio, sistema_operativo, categoriaGama, stock);
    }
}
