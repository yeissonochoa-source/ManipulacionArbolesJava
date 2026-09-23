public class Producto {
    // Datos del nodo
    int id;
    String nombre;
    
    // Punteros a los nodos hijos
    Producto izquierdo;
    Producto derecho;

    // Constructor
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // Al crearse, los punteros inician nulos (son nodos hoja temporalmente)
        this.izquierdo = null;
        this.derecho = null;
    }
}