package Juego;

public class Generador extends Thread {
    private Resultado resultado;

    public Generador(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public void run() {
        int suma = 0;
        for (int i = 1; i <= 50; i++) {
            suma += i;
        }
        System.out.println("Generador: La suma calculada es " + suma);
        resultado.setSuma(suma);
    }
}