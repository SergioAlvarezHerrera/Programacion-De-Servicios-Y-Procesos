public class Jugador extends Thread {
    private final NumeroOculto numeroOculto;
    private final int id;

    public Jugador(NumeroOculto numeroOculto, int id) {
        this.numeroOculto = numeroOculto;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            int intento = (int) (Math.random() * 101);
            int resultado = numeroOculto.propuestaNumero(intento);

            if (resultado == 1) {
                System.out.println("Jugador " + id + " acertó el número: " + intento);
                break;
            } else if (resultado == -1) {
                System.out.println("Jugador " + id + " se detiene porque otro jugador acertó.");
                break;
            } else {
                System.out.println("Jugador " + id + " intentó: " + intento + " y falló.");
            }
        }
    }
}