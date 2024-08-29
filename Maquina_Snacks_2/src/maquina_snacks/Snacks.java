package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    //Creamos arrayList static que va a tener objetos de tipo Snack
    static List <Snack> snacks = new ArrayList<>();

    //Agregamos snacks por defecto al arrayList
    static {
        Snacks.agregarSnack(new Snack("Chocolate", 21.50));
        Snacks.agregarSnack(new Snack("Refresco", 18.99));
        Snacks.agregarSnack(new Snack("Palomitas", 35.50));
        Snacks.agregarSnack(new Snack("Jugo de Frutas", 25.80));
    }

    //Metodo que agrega un snack al arrayList de snacks
    public static void agregarSnack(Snack snack){
        //Agregamos el snack que recibimos al arrayList
        snacks.add(snack);
    }

    //Metodo que muestra el arrayList de snacks
    public static void mostrarSnacks(){
        //Recorremos el arrayList
        System.out.println("--- SNACKS EN EL INVENTARIO ---");
        for (Snack snack: snacks){
            System.out.println(snack);
        }
    }

    //Metodo que regresa la lista de Snacks
    public static List<Snack> getSnacks(){
        return snacks;
    }
}
