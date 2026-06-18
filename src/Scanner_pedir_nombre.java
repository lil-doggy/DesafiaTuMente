import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escribe tu nombre: ");
        String nombre = entrada.nextLine();

        System.out.println("Hola, " + nombre);
    }
}