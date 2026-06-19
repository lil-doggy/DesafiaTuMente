import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String ROJO = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    private Jugador jugador;
    private ArrayList<Nivel> niveles;
    private Scanner scanner;

    public Juego() {
        scanner = new Scanner(System.in);
        niveles = new ArrayList<>();
        cargarNiveles();
    }

    public void iniciar() {
        System.out.println("===================================");
        System.out.println("      BIENVENIDO A DESAFIA TU MENTE");
        System.out.println("===================================");

        System.out.println("\n1. Jugar");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 2) {
            System.out.println("Gracias por jugar.");
            return;
        }

        System.out.print("\nIngresa tu nombre: ");
        String nombre = scanner.nextLine();

        jugador = new Jugador(nombre);

        jugar();
    }

    private void jugar() {
        for (Nivel nivel : niveles) {

            String color = obtenerColorNivel(nivel.getNombre());

            imprimirColor(color, "\n======================");
            imprimirColor(color, "Nivel: " + nivel.getNombre());
            imprimirColor(color, "======================");

            for (Adivinanza adivinanza : nivel.getAdivinanzas()) {

                if (!jugador.estaVivo()) {
                    gameOver();
                    return;
                }

                imprimirColor(color, "\nAdivinanza:");
                imprimirColor(color, adivinanza.getPregunta());

                System.out.print(color + "Tu respuesta: " + RESET);
                String respuesta = scanner.nextLine();

                if (adivinanza.validarRespuesta(respuesta)) {
                    imprimirColor(color, "¡Correcto!");
                    jugador.sumarPuntos(10);
                } else {
                    imprimirColor(color, "Incorrecto.");
                    imprimirColor(color, "Pista: " + adivinanza.getPista());

                    System.out.print(color + "Segundo intento: " + RESET);
                    respuesta = scanner.nextLine();

                    if (adivinanza.validarRespuesta(respuesta)) {
                        imprimirColor(color, "¡Correcto!");
                        jugador.sumarPuntos(10);
                    } else {
                        imprimirColor(color, "Incorrecto otra vez.");
                        jugador.perderVida();
                        imprimirColor(color, "Perdiste una vida.");
                        imprimirColor(color, "Vidas restantes: " + jugador.getVidas());
                    }
                }

                imprimirColor(color, "Puntaje: " + jugador.getPuntaje());
            }

            jugador.sumarPuntos(20);
            imprimirColor(color, "\n¡Nivel superado!");
            imprimirColor(color, "Completaste el nivel " + nivel.getNombre());
            imprimirColor(color, "+20 puntos bonus");
        }

        victoria();
    }

    private String obtenerColorNivel(String nivel) {
        if (nivel.equals("Facil")) {
            return VERDE;
        } else if (nivel.equals("Intermedio")) {
            return AMARILLO;
        } else {
            return ROJO;
        }
    }

    private void imprimirColor(String color, String mensaje) {
        System.out.println(color + mensaje + RESET);
    }

    private void gameOver() {
        System.out.println(ROJO + "\n===== GAME OVER =====" + RESET);
        System.out.println(ROJO + "Te quedaste sin vidas." + RESET);
        System.out.println(ROJO + "Puntaje final: " + jugador.getPuntaje() + RESET);
    }

    private void victoria() {
        System.out.println(VERDE + "\n=======================" + RESET);
        System.out.println(VERDE + "     ¡FELICIDADES!" + RESET);
        System.out.println(VERDE + "=======================" + RESET);
        System.out.println(VERDE + "Completaste todos los niveles." + RESET);
        System.out.println(VERDE + "Jugador: " + jugador.getNombre() + RESET);
        System.out.println(VERDE + "Puntaje final: " + jugador.getPuntaje() + RESET);
    }

    private void cargarNiveles() {
        Nivel facil = new Nivel("Facil");
        facil.agregarAdivinanza(new Adivinanza(
                "Oro parece, plata no es. El que no lo adivine, bien tonto es.",
                "platano",
                "Es una fruta amarilla"
        ));
        facil.agregarAdivinanza(new Adivinanza(
                "Blanca por dentro, verde por fuera. Si quieres que te lo diga, espera.",
                "pera",
                "Es una fruta verde"
        ));
        facil.agregarAdivinanza(new Adivinanza(
                "Agua pasa por mi casa, cate de mi corazon.",
                "aguacate",
                "Es una fruta verde"
        ));

        Nivel intermedio = new Nivel("Intermedio");
        intermedio.agregarAdivinanza(new Adivinanza(
                "Tengo ojos y no veo, tengo agua y no la bebo.",
                "papa",
                "Es un tuberculo"
        ));
        intermedio.agregarAdivinanza(new Adivinanza(
                "Sube llena y baja vacia. Si no se apura, la sopa se enfria.",
                "cuchara",
                "Se usa para comer"
        ));
        intermedio.agregarAdivinanza(new Adivinanza(
                "Vuelo sin alas, lloro sin ojos. ¿Que soy?",
                "nube",
                "A veces es blanca, gris o negra."
        ));

        Nivel dificil = new Nivel("Dificil");
        dificil.agregarAdivinanza(new Adivinanza(
                "Tiene dientes y no come, tiene cabeza y no es hombre.",
                "ajo",
                "Se usa en la cocina"
        ));
        dificil.agregarAdivinanza(new Adivinanza(
                "Todos lo pisan, pero nadie lo toca.",
                "sombra",
                "Siempre te sigue"
        ));
        dificil.agregarAdivinanza(new Adivinanza(
                "Aunque no tengo corazón, hago llorar a más de uno cuando me conocen.",
                "cebolla",
                "no es tu ex"
        ));
        niveles.add(facil);
        niveles.add(intermedio);
        niveles.add(dificil);
    }
}