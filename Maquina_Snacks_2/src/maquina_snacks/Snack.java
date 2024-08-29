package maquina_snacks;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    //Atributos de la clase
    private static int contadorSnacks = 0;
    private int idSnack;
    private String nombre;
    private double precio;

    //Constructor vacio
    public Snack(){

    }

    //Constructor que inicializa los atributos
    public Snack(String nombre, double precio){
        //Asignamos un idSnack acorde al contador de objetos de tipo Snack
        this.idSnack = ++Snack.contadorSnacks;
        this.nombre = nombre;
        this.precio = precio;
    }

    //Metodos GET y SET para atributos
    public int getContadorSnacks(){
        return Snack.contadorSnacks;
    }

    public int getIdSnack(){
        return this.idSnack;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    //Sobreescribimos metodo toString
    @Override
    public String toString(){
        return "Id_Snack: " + this.idSnack + ", Nombre: " + this.nombre + ", Precio: " + this.precio;
    }

    //Sobreescribimos metodo equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(precio, snack.precio) == 0 && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }
}
