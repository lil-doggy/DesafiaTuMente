public class Jugador {

    private String nombre;
    private int vidas;
    private int puntaje;

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vidas = 3;
        this.puntaje = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    // Sumar puntos
    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }

    // Restar vida
    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    // Verificar si sigue vivo
    public boolean estaVivo() {
        return vidas > 0;
    }
}