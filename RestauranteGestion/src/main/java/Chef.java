
class Chef extends Thread {
    private final Bandeja bandeja;
    private final String nombre;
    private int contadorPlatos = 1;

    public Chef(Bandeja bandeja, String nombre) {
        this.bandeja = bandeja;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String plato = "Plato " + contadorPlatos + " del " + nombre;
                bandeja.agregarPlato(plato);
                contadorPlatos++;
                Thread.sleep((int) (Math.random() * 2000) + 1000); // Simula tiempo de preparación
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}