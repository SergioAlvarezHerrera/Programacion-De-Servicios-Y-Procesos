
public class Camarero extends Thread{
	private final Bandeja bandeja;
    private final String nombre;

    public Camarero(Bandeja bandeja, String nombre) {
        this.bandeja = bandeja;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String plato = bandeja.retirarPlato();
                System.out.println(nombre + " está sirviendo: " + plato);
                Thread.sleep((int) (Math.random() * 3000) + 1000); // Simula tiempo de servicio
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
