
public class Corredor implements Runnable {
	
	private int x;
	private int y;
	private int meta = 950;
	private boolean corriendo;
	private VistaCarrera vistaCarrera;  
	
	public Corredor(int x, int y, int meta, boolean corriendo,VistaCarrera vistaCarrera) {
		super();
		this.x = x;
		this.y = y;
		this.meta = 950;
		this.corriendo = corriendo;
		this.vistaCarrera = vistaCarrera;
	}
	
	public Corredor() {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMeta() {
		return meta;
	}

	public void setMeta(int meta) {
		this.meta = meta;
	}

	public boolean isCorriendo() {
		return corriendo;
	}

	public void setCorriendo(boolean corriendo) {
		corriendo = corriendo;
	}

	@Override
	public String toString() {
		return "Corredor [x=" + x + ", y=" + y + ", meta=" + meta + ", Corriendo=" + corriendo + "]";
	}

	@Override
	public void run() {
		String hiloEjecutado = Thread.currentThread().getName();
		
		while (corriendo) {
	        if ("corredor1".equals(hiloEjecutado)) {
	        	x = x + (int)(Math.random() * 10);
	        	vistaCarrera.moverCorredor1(x);
	        }
	        
	        if ("corredor2".equals(hiloEjecutado)) {
	        	x = x + (int)(Math.random() * 10);
	        	vistaCarrera.moverCorredor2(x);
	        }

	      
	        if (x >= meta && corriendo) {
	            corriendo = false;  
	            vistaCarrera.mostrarResultado(hiloEjecutado + " ha llegado a la meta!");
	        }

	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        vistaCarrera.repaint();
	    }
	}

	
}
