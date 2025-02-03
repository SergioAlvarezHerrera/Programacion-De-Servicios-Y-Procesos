package Juego;

public class Verificador extends Thread {
    private Resultado resultado;
    private int id;

    public Verificador(Resultado resultado, int id) {
        this.resultado = resultado;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            int suma = resultado.getSuma();
            int numeroAleatorio = (int) (Math.random() * 9) + 2; 
            System.out.println("Verificador " + id + ": Número aleatorio = " + numeroAleatorio);

            if (suma % numeroAleatorio == 0) {
                System.out.println("Verificador " + id + ": La suma es divisible por " + numeroAleatorio);
            } else {
                System.out.println("Verificador " + id + ": La suma NO es divisible por " + numeroAleatorio);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Verificador " + id + " interrumpido.");
        }
    }
}