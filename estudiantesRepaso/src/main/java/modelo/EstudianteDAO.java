package modelo;

import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
	
	List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
	
	public List<Estudiante> getLista(){
		return listaEstudiantes;
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		listaEstudiantes.add(estudiante);
		
	}
	
	public void eliminarEstudiante(int id) {
		listaEstudiantes.removeIf(estudiante -> estudiante.getId()==id);
		
	}


}
