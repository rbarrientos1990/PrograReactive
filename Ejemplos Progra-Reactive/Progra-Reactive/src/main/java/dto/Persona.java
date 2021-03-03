package dto;

public class Persona {
    private int id;
    private int edad;
    private String nombre;

    public Persona() {
    }

    public Persona(int id, int edad) {
        this.id = id;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
