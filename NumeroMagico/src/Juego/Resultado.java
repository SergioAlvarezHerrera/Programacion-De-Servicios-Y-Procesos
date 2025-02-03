package Juego;

public class Resultado {
    private int suma;
    private boolean calculado = false;

    public synchronized void setSuma(int suma) {
        this.suma = suma;
        this.calculado = true;
        notifyAll();
    }

    public synchronized int getSuma() throws InterruptedException {
        while (!calculado) {
            wait();
        }
        return suma;
    }
}