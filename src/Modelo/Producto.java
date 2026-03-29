package Modelo;

/*
 * Universidad Estatal a Distancia (UNED)
 * Cuatrimestre: I Cuatrimestre 2026
 * Proyecto: Proyecto Evaluativo - Estructura de Datos
 * Descripción: Clase Producto
 * Estudiante: Jose David Canizales Azocar
 * Fecha: Maro 2026
 */

public class Producto {
    // Atributos de la clase
    private int id;
    private String nombre;
    private double precio;
    private String tipo;
    
    // Tipo de reposteria
    public static final String[] TIPOS = {
        "Dulce",
        "Salada"
    };
    
    
    // Constructor vacio
    public Producto() {
        this.nombre = "";
        this.precio = 0.0;
        this.tipo = "";
    }
    
    // Constructor sobrecargado
    public Producto(int id, String nombre, double precio, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    // Representacion Visual
    @Override
    public String toString() {
        return "Producto(id: " + this.id + " | " + 
                "nombre: " + this.nombre + " | " +
                "precio: " + this.precio + " | " +
                "tipo: " + this.tipo + ")";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
