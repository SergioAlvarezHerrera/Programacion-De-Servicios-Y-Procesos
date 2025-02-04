package modelo;
public class Libro {
    private int id_libro;
    private String titulo;
    private String autor;
    
    public Libro (int id , String titulo , String autor) {
    	this.id_libro=id;
    	this.titulo=titulo;
    	this.autor = autor;
    }
  
    
	public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
