package modelo;

public class Jugador {
	
	private int dorsal;
	private String nombre;
	private int edad;
	private String equipo;
	
	public Jugador(int dorsal, String nombre, int edad , String equipo) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.edad = edad;
		this.equipo = equipo;
	}
	
	public Jugador() {
		
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [dorsal=" + dorsal + ", nombre=" + nombre + ", edad=" + edad + ", equipo=" + equipo + "]";
	}

	ss
	
	
	
	
}
