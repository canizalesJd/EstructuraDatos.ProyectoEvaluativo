package Controlador;

import Modelo.Producto;
import Modelo.ListaProductos;
import Modelo.Nodo;
import java.util.InputMismatchException;

/*
 * Universidad Estatal a Distancia (UNED)
 * Cuatrimestre: I Cuatrimestre 2026
 * Proyecto: Proyecto Evaluativo - Estructura de Datos
 * Descripción: Controlador de Productos
 * Estudiante: Jose David Canizales Azocar
 * Fecha: Marzo 2026
 */

public class Controlador {
    private ListaProductos listaProductos;
    private int contadorId;
    
    // Constructor
    public Controlador() {
        this.listaProductos = new ListaProductos();
        this.contadorId = 1;
    }
    
    // Agregar producto a la lista
    public void agregarProducto(String nombre, double precio, int cantidad) {
        // Validar datos
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new InputMismatchException(
                "Error, nombre no debe estar vacio"
            );
        }
        if (precio < 0 || cantidad < 0) {
            throw new InputMismatchException(
                "Error, el precio y la cantidad deben ser mayores a 0"
            );
        }
        
        // Crear producto e insertar
        Producto p = new Producto(contadorId, nombre, precio, cantidad);
        listaProductos.insertarOrdenado(p);
        contadorId++;
    }
    
    // Obtener la lista de productos
    public ListaProductos obtenerLista() {
        return listaProductos;
    }
    
    // Obtener total de productos
    public int obtenerTotalProductos() {
        return listaProductos.contarProductos();
    }
    
    // Obtener lista como array para JTable
    public Object[][] obtenerProductosArray() {
        int total = listaProductos.contarProductos();
        Object[][] datos = new Object[total][4];
        
        int fila = 0;
        Nodo actual = listaProductos.getHead();
        while (actual != null) {
            datos[fila][0] = actual.data.getId();
            datos[fila][1] = actual.data.getNombre();
            datos[fila][2] = actual.data.getPrecio();
            datos[fila][3] = actual.data.getCantidad();
            fila++;
            actual = actual.siguiente;
        }
        
        return datos;
    }
    
    // Contar productos por rango de precio (o categoría)
    public int contarPorRango(double precioMin, double precioMax) {
        int contador = 0;
        Nodo actual = listaProductos.getHead();
        
        while (actual != null) {
            if (actual.data.getPrecio() >= precioMin && 
                actual.data.getPrecio() <= precioMax) {
                contador++;
            }
            actual = actual.siguiente;
        }
        
        return contador;
    }
    
    // Obtener ID para producto nuevo
    public int obtenerProximoId() {
        return contadorId;
    }
}