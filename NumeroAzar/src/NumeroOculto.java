
public class NumeroOculto {
    private final int numeroOculto;
    private boolean juegoTerminado = false;

    public NumeroOculto() {
        this.numeroOculto = (int) (Math.random() * 101); 
        System.out.println("Número oculto generado : " + numeroOculto);
    }

    public synchronized int propuestaNumero(int num) {
        if (juegoTerminado) {
            return -1; 
        }
        if (num == numeroOculto) {
            juegoTerminado = true;; 
            return 1;
        }
        return 0; 
    }
}
