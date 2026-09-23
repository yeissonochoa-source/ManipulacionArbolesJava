import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion = -1;

        System.out.println("--- Bienvenido al Sistema de Inventario Tree-Stock ---");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                // Leemos la opción como String y la pasamos a Entero para evitar saltos de línea basura
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el ID del producto (número entero): ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        inventario.insertar(id, nombre);
                        System.out.println("-> Producto registrado con éxito.");
                        break;
                        
                    case 2:
                        System.out.println("\n--- INVENTARIO (Ordenado por ID) ---");
                        inventario.recorridoInorden();
                        break;
                        
                    case 3:
                        System.out.print("Ingrese el ID del producto a buscar: ");
                        int idBuscar = Integer.parseInt(scanner.nextLine());
                        Producto encontrado = inventario.buscar(idBuscar);
                        
                        if (encontrado != null) {
                            System.out.println("-> Producto encontrado - ID: " + encontrado.id + " | Nombre: " + encontrado.nombre);
                        } else {
                            System.out.println("-> El producto con ID " + idBuscar + " NO existe en el inventario.");
                        }
                        break;
                        
                    case 0:
                        System.out.println("Saliendo de Tree-Stock... ¡Hasta luego!");
                        break;
                        
                    default:
                        System.out.println("Error: Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico válido.");
            }
            
        } while (opcion != 0);

        scanner.close();
    }
}