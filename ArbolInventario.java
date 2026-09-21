public class ArbolInventario {
    Producto raiz;

    // Constructor
    public ArbolInventario() {
        this.raiz = null;
    }

    // MÉTODOS DE INSERCIÓN

    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto nodo, int id, String nombre) {
        // Si el puntero actual está vacío, creamos el nuevo nodo aquí
        if (nodo == null) {
            return new Producto(id, nombre);
        }

        // Recursividad: Comparamos IDs para saber hacia qué puntero ir
        if (id < nodo.id) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, id, nombre); // Va a la izquierda
        } else if (id > nodo.id) {
            nodo.derecho = insertarRecursivo(nodo.derecho, id, nombre);     // Va a la derecha
        } else {
            System.out.println("Advertencia: El producto con ID " + id + " ya existe.");
        }

        return nodo; // Retorna el nodo sin cambios
    }

    // MÉTODOS DE BÚSQUEDA

    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto nodo, int id) {
        // Si llegamos a un nodo nulo o encontramos el ID, retornamos el nodo
        if (nodo == null || nodo.id == id) {
            return nodo;
        }

        // Recursividad: Si el ID a buscar es menor, vamos por la izquierda
        if (id < nodo.id) {
            return buscarRecursivo(nodo.izquierdo, id);
        }
        
        // Si es mayor, vamos por la derecha
        return buscarRecursivo(nodo.derecho, id);
    }

    // MÉTODO RECORRIDO INORDEN (Izquierda -> Raíz -> Derecha)

    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
        recorridoInordenRecursivo(raiz);
    }

    private void recorridoInordenRecursivo(Producto nodo) {
        if (nodo != null) {
            recorridoInordenRecursivo(nodo.izquierdo); // 1. Visita hijo izquierdo
            System.out.println("ID: " + nodo.id + " | Nombre: " + nodo.nombre); // 2. Imprime nodo actual
            recorridoInordenRecursivo(nodo.derecho); // 3. Visita hijo derecho
        }
    }
}