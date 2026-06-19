class Persona {

    private String nombre;

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }
}

public class Main {
    public static void main(String[] args) {

        Persona p = new Persona();

        p.setNombre("Ana");

        System.out.println("Nombre: " + p.getNombre());
    }
}