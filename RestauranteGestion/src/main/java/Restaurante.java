
public class Restaurante {
    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja(4);

        Chef chef1 = new Chef(bandeja, "Chef 1");
        Chef chef2 = new Chef(bandeja, "Chef 2");
        Camarero camarero1 = new Camarero(bandeja, "Camarero 1");
        Camarero camarero2 = new Camarero(bandeja, "Camarero 2");

        chef1.start();
        chef2.start();
        camarero1.start();
        camarero2.start();
    }
}
