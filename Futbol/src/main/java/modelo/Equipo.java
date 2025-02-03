package modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private String nombre;
	private List<Jugador> listaJugadores = new ArrayList<Jugador>();
	
	public Equipo(String nombre, List<Jugador> listaJugadores) {
		super();
		this.nombre = nombre;
		this.listaJugadores = listaJugadores;
	}
	
	public Equipo() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listaJugadores=" + listaJugadores + "]";
	}
	
	public void añadirJugadores(Jugador jugador) {
		this.listaJugadores.add(jugador);
	}
	
	public void listarJugadores() {
		for(Jugador jugador : listaJugadores){
			System.out.println(jugador);
	}
	
	}
	
	
	
	
	
}
