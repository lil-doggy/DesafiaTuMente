public class Adivinanza {

    private String pregunta;
    private String respuesta;
    private String pista;

    // Constructor
    public Adivinanza(String pregunta, String respuesta, String pista) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.pista = pista;
    }

    // Getters
    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String getPista() {
        return pista;
    }

    // Validar respuesta del jugador
    public boolean validarRespuesta(String respuestaJugador) {
        return respuestaJugador.trim().equalsIgnoreCase(respuesta.trim());
    }
}
