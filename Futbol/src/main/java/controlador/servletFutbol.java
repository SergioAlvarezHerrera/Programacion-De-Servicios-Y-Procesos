package controlador;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Equipo;
import modelo.Jugador;

/**
 * Servlet implementation class servletFutbol
 */
@WebServlet("/servletFutbol")
public class servletFutbol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Equipo equipo = new Equipo();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletFutbol() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int dorsal = Integer.parseInt(request.getParameter("dorsal"));
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String equipos = request.getParameter("equipos");
		
		
		equipo.getListaJugadores().add(new Jugador(dorsal ,nombre, edad , equipo));
		equipo.setNombre(equipos);
	
		
		getServletContext().setAttribute("equipo", equipo);
		
		
		response.sendRedirect("AddEquipo?action=list");
		
		
	}

}
