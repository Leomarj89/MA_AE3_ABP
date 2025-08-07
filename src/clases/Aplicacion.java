package clases;

import java.util.ArrayList; // ✅ Practicar ArrayList
import java.util.Scanner;   // Usamos Scanner por compatibilidad con IDEs como IntelliJ

public class Aplicacion {

    public static void main(String[] args) {
        int numeroSecreto = (int) (Math.random() * 100) + 1;

        ArrayList<Integer> intentos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in); // alternativa a System.console()

        System.out.println("¡Bienvenido al juego de adivinar el número!");

        while (true) {
            System.out.print("Por favor ingresa un número entre 1 - 100: ");
            int numeroUsuario;

            try {
                numeroUsuario = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número entero.");
                continue;
            }

            intentos.add(numeroUsuario);

            String resultado = AdivinaNumero.compararNumeros(numeroUsuario, numeroSecreto);
            System.out.println(resultado);

            if (numeroUsuario == numeroSecreto) {
                System.out.println("Te tomó " + intentos.size() + " intento(s) adivinar el número.");
                System.out.print("Intentos: ");
                for (int intento : intentos) {
                    System.out.print(intento + " ");
                }
                System.out.println(); // salto de línea
                break;
            }
        }

        scanner.close();
    }
}