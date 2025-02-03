package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Estudiante;
import modelo.EstudianteDAO;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EstudianteDAO estudianteDao = new EstudianteDAO();
	private int id = 1 ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		
		case "listar": 
			request.setAttribute("lista", estudianteDao.getLista());
			request.getRequestDispatcher("listaEstudiantes.jsp").forward(request, response);
			
			break;
			
		
		case "eliminar" :
			
			int id = Integer.parseInt(request.getParameter("id"));
			estudianteDao.eliminarEstudiante(id);
			response.sendRedirect("servlet?action=listar");
			
			break;
		
		default:
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("Nombre");
		String apellido = request.getParameter("Apellido");
		int edad = Integer.parseInt(request.getParameter("Edad"));
		
		Estudiante estudiante = new Estudiante(id++ ,nombre ,apellido ,edad);
		estudianteDao.agregarEstudiante(estudiante);
		
		response.sendRedirect("servlet?action=listar");
		
		
	}

}
