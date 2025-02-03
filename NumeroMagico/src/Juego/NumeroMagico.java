package Juego;

public class NumeroMagico {
    public static void main(String[] args) {
        Resultado resultado = new Resultado();
        Generador generador = new Generador(resultado);

        Verificador[] verificadores = new Verificador[5];
        for (int i = 0; i < verificadores.length; i++) {
            verificadores[i] = new Verificador(resultado, i + 1);
        }

        generador.start();

        for (Verificador verificador : verificadores) {
            verificador.start();
        }

         
        try {
            generador.join();
            for (Verificador verificador : verificadores) {
                verificador.join();
            }
        } catch (InterruptedException e) {
            System.out.println("El programa fue interrumpido.");
        }

        System.out.println("Todos los hilos han terminado. Programa finalizado.");
    }
}