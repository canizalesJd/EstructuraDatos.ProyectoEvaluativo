package Controlador;

import Modelo.Producto;
import Modelo.ListaProductos;
import Modelo.Nodo;
import java.util.InputMismatchException;
import java.util.Random;

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
    private Random random;
    // Constantes
    private static final int INTENTOS_MAXIMOS = 100;
    private static final int ID_MINIMO = 10;
    private static final int ID_MAXIMO = 99;
    
    // Constructor
    public Controlador() {
        this.listaProductos = new ListaProductos();
        this.random = new Random();
    }
    
    // Obtener ID unico aleatorio
    private int obtenerIdUnico() {
        for (int intento = 0; intento < INTENTOS_MAXIMOS; intento++) {
            // Ref: https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/
            int id = random.nextInt(ID_MAXIMO - ID_MINIMO + 1) + ID_MINIMO;
            if (!existeId(id)) {
                return id;
            }
        }
        return -1; // No hay IDs disponibles
    }
    
    // Verificar si existe un ID
    private boolean existeId(int id) {
        Nodo actual = listaProductos.getHead();
        while (actual != null) {
            if (actual.data.getId() == id) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    
    
    // Agregar producto a la lista
    public void agregarProducto(String nombre, double precio, String tipo) {
        // Validar datos
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new InputMismatchException(
                "Error, nombre no debe estar vacio"
            );
        }
        
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new InputMismatchException(
                "Error, debe seleccionar un tipo de reposteria"
            );
        }
        
        if (precio <= 0) {
            throw new InputMismatchException(
                "Error, el precio deben ser mayor a 0"
            );
        }
        
        // Generar ID
        int id = obtenerIdUnico();
        if (id == -1) {
            throw new IllegalStateException(
                "Error, No hay IDs disponibles (maximo 90 productos)"
            );
        }
        
        // Crear producto e insertar
        Producto p = new Producto(id, nombre, precio, tipo);
        listaProductos.insertarOrdenado(p);
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
            datos[fila][3] = actual.data.getTipo();
            fila++;
            actual = actual.siguiente;
        }
        
        return datos;
    }
    
    // Contar productos por rango de precio (o categoría)
    public int contarTipo(String tipo) {
        int contador = 0;
        Nodo actual = listaProductos.getHead();
        
        while (actual != null) {
            if (actual.data.getTipo().equals(tipo)) {
                contador++;
            }
            actual = actual.siguiente;
        }
        
        return contador;
    }
}