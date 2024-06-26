import java.util.Random;
import java.util.Scanner;
public class juegoAdivinacionDeTerror{
public static void main(String[] args) throws InterruptedException {
    Scanner teclado = new Scanner(System.in);
    Random random = new Random();
    int numeroPensado = random.nextInt(100) + 1;
    int intentos = 3;
    int saldoCuenta = random.nextInt(400)+100;
    String nombre;
    int numeroAdivinado;
    boolean juegoTerminado = false;
    String respuesta;
    String Bienvenida = """
            Bienvenido usuario a este humilde juego de adivinacion, tendra 3 oportunidades.
            Si falla en los 3 intentos se reiniciara hasta que lo logre, por cada reinicio
            se le cobrara 100 usd de su cuenta bancaria.
            
            BUENA SUERTE
            """;
    String familiarSacrificado = """
            El sacrificio fue aceptado, se le ha concedido un nuevo intento. 
            Disfrutelo.""";
    String goodEnding = """
            Veo que logro adivinar en menos de 3 intentos, sus familiares y vida como la conoce
            no sufriran ninguna repercurcion. GRACIAS POR JUGAR. 
            """;
    String badEnding = """
            Lo siento pero lastimosamente ha fallado en los 3 primeros intentos, para seguir
            jugando debera dar a una persona cercana a usted como canje, si por el contrario
            desea abandonar, debera dar su vida a cambio. GRACIAS
            """;

    System.out.println(Bienvenida);
    System.out.println("Escriba su nombre por favor: ");

    nombre = teclado.nextLine();

    System.out.println("Bienvenido me alegra conocerte "+nombre);
    System.out.println("Pensando numero");
    for (int i = 0; i < 3; i++) {
        System.out.print(".");
        Thread.sleep(800);
    }
    System.out.println(" ");
    while(!juegoTerminado){
        System.out.println("Te quedan: "+intentos+" intentos para adivinar el numero.");
        System.out.println("Tu saldo actual es de: $"+saldoCuenta+".");
        System.out.println("Introduce un numero entre 1 y 100: ");
        numeroAdivinado = teclado.nextInt();
        if(numeroAdivinado == numeroPensado){
            System.out.println(goodEnding);
            juegoTerminado = true;
        }else {
            intentos--;
            saldoCuenta-=100;
            if (intentos == 0) {
                System.out.println(badEnding);
                System.out.println("¿Deseas sacrificara un familiar para reiniciar el juego? (Si/No)");
                respuesta = teclado.next();
                if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println(familiarSacrificado);
                for (int i = 0; i < 8; i++) {
                    System.out.print(".");
                    Thread.sleep(500);
                }
                    reiniciarJuego(random,teclado);
                }
                else{
                    System.out.println("Gracias por jugar, pronto recibiras nuestra visita.");
                    juegoTerminado = true;
                }
            }else {
                System.out.println("Incorrecto");
                }
            }
        }
    }
    private static void reiniciarJuego(Random random,Scanner teclado){
    int numeroPensado = random.nextInt(100)+1;
    int intentos = 3;
    int saldoCuenta = random.nextInt(201)+100;
    String nuevoJuego = """
            Debido a su reciente infecacia para adivinar un numero ha tenido que pasar por
            la penosa perdida de uno de sus familiares, de seguir asi no le quedara nadie. 
            NO VUELVA A FALLAR.
            """;
        System.out.println(nuevoJuego);
        jugar(random,teclado,numeroPensado, intentos, saldoCuenta);
    }
    private static void jugar(Random random, Scanner teclado, int numeroPensado, int intentos, int saldoCuenta){
    boolean juegoTerminado = false;
    while (!juegoTerminado){
        System.out.println("Te quedan "+intentos+" intentos restantes.");
        System.out.println("Tu saldo actual es de: $"+saldoCuenta+".");
        System.out.println("Introduce un numero del 1 al 100");
        String goodEnding = """
            Veo que logro adivinar en menos de 3 intentos, sus familiares y vida como la conoce
            no sufriran ninguna repercurcion. GRACIAS POR JUGAR. 
            """;
        int numeroAdivinanza = teclado.nextInt();
        if(numeroAdivinanza==numeroPensado){
            System.out.println(goodEnding);
            juegoTerminado=true;

        }else{
            intentos--;
            saldoCuenta-=100;
        }
    }
}
}