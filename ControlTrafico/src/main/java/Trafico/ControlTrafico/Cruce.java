package Trafico.ControlTrafico;

public class Cruce {
    private final Semaforo semaforo1;
    private final Semaforo semaforo2;
    private int cochesPasados = 0;
    private final int totalCoches;

    public Cruce(int totalCoches) {
        this.totalCoches = totalCoches;
        this.semaforo1 = new Semaforo(5);
        this.semaforo2 = new Semaforo(5);
    }

    public void iniciar() {
        semaforo1.cambiarEstado(true); 
        Thread[] coches = new Thread[totalCoches];

        for (int i = 0; i < totalCoches / 2; i++) {
            coches[i] = new Coche(i + 1, semaforo1, "1", this);
            coches[i + totalCoches / 2] = new Coche(i + 1, semaforo2, "2", this);
        }

        for (Thread coche : coches) {
            coche.start();
        }

        for (Thread coche : coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Simulación completada. Todos los coches han pasado.");
    }

    public synchronized void notificarPaso() {
        cochesPasados++;
        if (cochesPasados % 5 == 0) {
            alternarSemaforos();
        }
    }

    private void alternarSemaforos() {
        if (semaforo1.estaVerde()) {
            System.out.println("Semáforo 1 ahora está en ROJO.");
            semaforo1.cambiarEstado(false);
            System.out.println("Semáforo 2 ahora está en VERDE.");
            semaforo2.cambiarEstado(true);
        } else {
            System.out.println("Semáforo 2 ahora está en ROJO.");
            semaforo2.cambiarEstado(false);
            System.out.println("Semáforo 1 ahora está en VERDE.");
            semaforo1.cambiarEstado(true);
        }
    }
}
