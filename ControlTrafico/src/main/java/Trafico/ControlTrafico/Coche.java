package Trafico.ControlTrafico;

public class Coche extends Thread {
    private final int id;
    private final Semaforo semaforo;
    private final String carril;
    private final Cruce cruce;

    public Coche(int id, Semaforo semaforo, String carril, Cruce cruce) {
        this.id = id;
        this.semaforo = semaforo;
        this.carril = carril;
        this.cruce = cruce;
    }

    @Override
    public void run() {
        synchronized (semaforo) {
            semaforo.esperarVerde(); 
            while (!semaforo.permitirPaso()) {
                try {
                    semaforo.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Coche " + id + " (Carril " + carril + ") pasa porque el Semáforo está en VERDE.");
            cruce.notificarPaso();
        }
    }
}


