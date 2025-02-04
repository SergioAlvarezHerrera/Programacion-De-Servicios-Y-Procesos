package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorTareas;

/**
 * Servlet implementation class AddTaskServlets
 */
@WebServlet("/AddTaskServlets")
public class AddTaskServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String description = request.getParameter("description");
	        if (description == null || description.trim().isEmpty()) {
	            request.setAttribute("error", "La descripción no puede estar vacía.");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	            return;
	        }

	        GestorTareas gestorTareas = (GestorTareas) getServletContext().getAttribute("gestorTareas");
	        if (gestorTareas == null) {
	            gestorTareas = new GestorTareas();
	            getServletContext().setAttribute("gestorTareas", gestorTareas);
	        }

	        gestorTareas.addTask(description);
	        
	        getServletContext().setAttribute("gestorTareas",gestorTareas);
	        response.sendRedirect("ShowTasksServlet");
	}

}
