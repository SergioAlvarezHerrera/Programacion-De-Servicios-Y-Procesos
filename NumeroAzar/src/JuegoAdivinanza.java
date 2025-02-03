public class JuegoAdivinanza {
    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();
        Thread[] jugadores = new Thread[10];

        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador(numeroOculto, i + 1);
            jugadores[i].start();
        }

        for (Thread jugador : jugadores) {
            try {
                jugador.join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El juego ha terminado.");
    }
}
