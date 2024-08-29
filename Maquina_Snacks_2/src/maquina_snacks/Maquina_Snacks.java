package maquina_snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maquina_Snacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Variable bandera para salir de la aplicacion
        boolean salir = false;
        //Lista que tiene los snacks que se agregan al ticket
        List <Snack> productos = new ArrayList<>();

        do {
            //Variable que lee la opcion del ingresada por el usuario
            int opcion;
            System.out.println("\n\t*** MAQUINA DE SNACKS ***");
            //Llamamos al metodo mostrarSnacks
            Snacks.mostrarSnacks();

            System.out.println("-------------------------------------------------");
            System.out.println("--- MENU ---");
            System.out.println("1. Comprar Snack");
            System.out.println("2. Mostrar Ticket");
            System.out.println("3. Agregar Nuevo Snack");
            System.out.println("4. Eliminar Snack del Ticket");
            System.out.println("5. Vaciar ticket");
            System.out.println("6. Salir");

            //Envolvemos en un bloque try-catch
            try {
                System.out.print("Digita la opcion que realizar: ");
                opcion = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (opcion){
                    case 1:
                        //Llamamos al metodo comprarSnack()
                        comprarSnack(scanner, productos);
                        break;
                    case 2:
                        //Llamamos al metodo mostrarTicket()
                        mostrarTicket(productos);
                        break;
                    case 3:
                        //Llamamos a la funcion agregarNuevoSnack
                        agregarNuevoSnack(scanner);
                        break;
                    case 4:
                        if (!productos.isEmpty()){
                            //Llamamos a la funcion que elimina un snack del tiacket
                            eliminarSnack(scanner, productos);
                        }else {
                            System.out.println("→ Tu ticket esta vacio, agrega productos");
                            continue;
                        }
                        break;
                    case 5:
                        //Llamamos al metodo vaciarTicket
                        vaciarTicket(productos);
                        break;
                    case 6:
                        System.out.println("Hasta luego... :)");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        salir = true;
                        break;
                }
            }catch (Exception e){
                System.out.println("Ocurrio un error...");
                e.printStackTrace(System.out);
            }
        }while (!salir);
    }

    //Metodo que agrega un snack a la lista de snacks
    public static void comprarSnack(Scanner scanner, List <Snack> productos){
        int idSnack;
        System.out.print("¿Que snack quieres comprar (id)?: ");
        idSnack = Integer.parseInt(scanner.nextLine());
        var snackEncontrado = false;

        //Recorremos el arrayList de snacks
        for (Snack snack: Snacks.getSnacks()){
            if (idSnack == snack.getIdSnack()){
                //Agregamos ese snack al arrayList de productos
                productos.add(snack);
                System.out.println("Ok, snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado){
            System.out.println("Id de snack no encontrado: " + idSnack);
        }
    }

    //Metodo que muestra el arrayList de productos. Son los productos agregados
    public static void mostrarTicket(List<Snack> productos){
        System.out.println("*** TICKET DE PRODUCTOS ***");
        for (Snack snack: productos){
            System.out.println(snack);
        }
        //Llamamos a la funcion que calcula el total del ticket
        var total = calcularTotalTicket(productos);
        System.out.print("→ TOTAL TICKET: $" + total);
        System.out.println();

    }

    //Funcion que calcula el total del costo del ticket
    public static double calcularTotalTicket(List<Snack> productos){
        //Acumulador
        var totalTiacket = 0.0;
        //Recorremos el tikcet
        for (var snack: productos){
            totalTiacket += snack.getPrecio();
        }
        return  totalTiacket;
    }

    //Funcion que agrega un nuevo snack al arrayList de snack
    public static void agregarNuevoSnack(Scanner scanner){
        //Pedimos el nombre del nuevo snack
        System.out.print("Ingresa el nombre del nuevo snack: ");
        var nombreNuevo = scanner.nextLine();
        //Pedimos el precio del nuevo sanck
        System.out.print("Ingresa el precio del nuevo snack: ");
        var precioNuevo = Double.parseDouble(scanner.nextLine());

        //Creamos nuevo objeto de Snack con el nombre y precio nuevo
        Snack snackNuevo = new Snack(nombreNuevo, precioNuevo);

        //Agregamos snackNuevo al arrayList de Snacks
        Snacks.agregarSnack(snackNuevo);
        System.out.println("Snack agregado: " + snackNuevo);
    }

    //Funcion que elimina un snack del ticket
    public static void eliminarSnack(Scanner scanner, List<Snack> productos){
        List<Snack> nuevaLista = new ArrayList<>();

        System.out.println("→ ESTE ES TU TICKET DE COMPRA: ");
        //Llamamos al metodo mostrarTiacket
        mostrarTicket(productos);

        System.out.println("Digita el producto que quieres eliminar (id): ");
        var idProducto = Integer.parseInt(scanner.nextLine());

        //Recorremos el arrayList de productos
        for (var producto: productos){
            if (idProducto == producto.getIdSnack()){
                System.out.println("Producto eliminado: " + producto);
                //Removemos el producto del arrayList productos
                productos.remove(producto);
                //Llamamos el metodo mostrarTiacket
                mostrarTicket(productos);
                break;
            }
        }
    }

    //Funcion que vacia el ticket de compra
    public static void vaciarTicket(List<Snack> productos){
        System.out.println("→ VACIANDO TICKET");
        productos.clear();
    }
}
