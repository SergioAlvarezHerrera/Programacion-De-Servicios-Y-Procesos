package Trafico.ControlTrafico;

class Semaforo {
    private boolean enVerde = false;
    private int cochesPasados = 0;
    private final int limiteCoches;

    public Semaforo(int limiteCoches) {
        this.limiteCoches = limiteCoches;
    }

    public synchronized void cambiarEstado(boolean estado) {
        enVerde = estado;
        cochesPasados = 0;
        notifyAll();
    }

    public synchronized void esperarVerde() {
        while (!enVerde) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized boolean permitirPaso() {
        if (cochesPasados < limiteCoches) {
            cochesPasados++;
            return true;
        }
        return false;
    }

    public synchronized boolean estaVerde() {
        return enVerde;
    }
}
