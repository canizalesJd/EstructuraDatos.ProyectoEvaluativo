package Modelo;
/*
 * Universidad Estatal a Distancia (UNED)
 * Cuatrimestre: I Cuatrimestre 2026
 * Proyecto: Proyecto Evaluativo - Estructura de Datos
 * Descripción: Clase Nodo
 * Estudiante: Jose David Canizales Azocar
 * Fecha: Marzo 2026
 */
public class Nodo {
    // Atributos de la clase
    public Producto data;
    public Nodo siguiente;
    
    // Constructor
    public Nodo(Producto data) {
        this.data = data;
        this.siguiente = null;
    }
}