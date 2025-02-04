package modelo;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    private static List<Libro> listarLibros = new ArrayList<Libro>();
    private static int incrementoID = 1;

    
    public static List<Libro> listarLibro() {
        return listarLibros;
    }

    public static void agregarLibro(String titulo , String autor) {
         listarLibros.add(new Libro(incrementoID++,titulo, autor));
    }

   
	public void eliminarLibro(int id) {
       listarLibros.removeIf(Libro -> Libro.getId_libro()==id);
       }
}