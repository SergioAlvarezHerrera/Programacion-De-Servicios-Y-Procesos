import java.util.LinkedList;
import java.util.Queue;

public class Bandeja {
	private final int capacidad;
    private final Queue<String> platos = new LinkedList<>();

    public Bandeja(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void agregarPlato(String plato) throws InterruptedException {
        while (platos.size() >= capacidad) {
            System.out.println("Bandeja llena. El chef espera...");
            wait();
        }
        platos.add(plato);
        System.out.println("Chef preparó: " + plato);
        notifyAll();
    }

    public synchronized String retirarPlato() throws InterruptedException {
        while (platos.isEmpty()) {
            System.out.println("Bandeja vacía. El camarero espera...");
            wait();
        }
        String plato = platos.poll();
        System.out.println("Camarero sirvió: " + plato);
        notifyAll();
        return plato;
    }
}
