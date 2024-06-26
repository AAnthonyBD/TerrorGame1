import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinacionDeTerror {

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int saldoCuenta = random.nextInt(400) + 100;
        String nombre;
        int numeroPensado;
        int intentos;
        boolean juegoTerminado;

        String bienvenida = """
                Bienvenido usuario a este humilde juego de adivinación, tendrás 3 oportunidades.
                Si fallas en los 3 intentos se reiniciará hasta que lo logres, por cada reinicio
                se te cobrará 100 USD de tu cuenta bancaria.

                BUENA SUERTE
                """;

        String familiarSacrificado = """
                El sacrificio fue aceptado, se te ha concedido un nuevo intento.
                Disfrútalo.
                """;

        String goodEnding = """
                Veo que lograste adivinar en menos de 3 intentos, tus familiares y vida como la conoces
                no sufrirán ninguna repercusión. GRACIAS POR JUGAR.
                """;

        String badEnding = """
                Lo siento, pero has fallado en los 3 primeros intentos. Para seguir jugando deberás dar a
                una persona cercana a ti como canje. Si por el contrario deseas abandonar, deberás dar tu 
                vida a cambio. GRACIAS.
                """;

        System.out.println(bienvenida);
        System.out.println("Escribe tu nombre por favor: ");
        nombre = teclado.nextLine();
        System.out.println("Bienvenido, me alegra conocerte " + nombre);

        do {
            numeroPensado = random.nextInt(100) + 1;
            intentos = 3;
            juegoTerminado = false;

            System.out.println("Pensando número...");
            Thread.sleep(1000);

            while (intentos > 0 && !juegoTerminado) {
                System.out.println("\nTe quedan " + intentos + " intentos para adivinar el número.");
                System.out.println("Tu saldo actual es de: $" + saldoCuenta);
                System.out.println("Introduce un número entre 1 y 100: ");
                int numeroAdivinado = teclado.nextInt();

                if (numeroAdivinado == numeroPensado) {
                    System.out.println(goodEnding);
                    juegoTerminado = true;
                } else {
                    intentos--;
                    saldoCuenta -= 100;

                    if (intentos > 0) {
                        System.out.println("Incorrecto. Inténtalo de nuevo.");
                    } else {
                        System.out.println(badEnding);
                        System.out.println("¿Deseas sacrificar un familiar para reiniciar el juego? (Si/No)");
                        String respuesta = teclado.next();
                        if (respuesta.equalsIgnoreCase("Si")) {
                            System.out.println(familiarSacrificado);
                            Thread.sleep(2000); // Espera para dar efecto dramático
                            // Se reinicia el juego
                            intentos = 3;
                            saldoCuenta -= 100; // Se cobra el sacrificio
                            System.out.println("Pensando número...");
                            Thread.sleep(1000);
                        } else {
                            System.out.println("Gracias por jugar, pronto recibirás nuestra visita.");
                            juegoTerminado = true;
                        }
                    }
                }
            }
        } while (!juegoTerminado);
        teclado.close();
    }
}