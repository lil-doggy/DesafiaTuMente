import java.util.ArrayList;

public class Nivel {

    private String nombre;
    private ArrayList<Adivinanza> adivinanzas;

    public Nivel(String nombre) {
        this.nombre = nombre;
        this.adivinanzas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Adivinanza> getAdivinanzas() {
        return adivinanzas;
    }

    public void agregarAdivinanza(Adivinanza adivinanza) {
        adivinanzas.add(adivinanza);
    }
}