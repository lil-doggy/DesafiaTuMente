class Persona {

    String nombre;

    // Constructor
    Persona(String nombre) {
        this.nombre = nombre;
    }

    // Método simple
    void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

public class Main {
    public static void main(String[] args) {

        Persona p = new Persona("Ana");

        p.saludar();
    }
}