package cl.gestiona.appmascotas.data;

/**
 * Created by roman on 01-09-17.
 */

public class Mascota {
    private int id;
    private String nombre;
    private String raza;
    private String genero;
    private double peso;


    public Mascota() {
    }

    public Mascota(int id, String nombre, String raza, String genero, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
        this.peso = peso;
    }

    public Mascota(String nombre, String raza, String genero, double peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
        this.peso = peso;
    }

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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
