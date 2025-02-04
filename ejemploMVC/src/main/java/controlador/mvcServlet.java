package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Bean;

/**
 * Servlet implementation class mvcServlet
 */
@WebServlet("/mvcServlet")
public class mvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mvcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if (action == null) {
			
			action="intro";
		}
		
		switch(action) {
		case "intro":
			RequestDispatcher  dispatcher = request.getRequestDispatcher(action);
			dispatcher.forward(request, response);
			
			break;
			
		case "volver":
			RequestDispatcher  dispatcher1 = request.getRequestDispatcher("index.jsp");
			dispatcher1.forward(request, response);
			
				break;
		default:
			
			break;
		
		
		
		
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Bean b = new Bean();
		b.setemail(email);
		b.setpassword(password);
		
		if(b.comprueba()) {
			
			request.setAttribute("envio", b);
			request.getRequestDispatcher("exito.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("introDatos.jsp").forward(request, response);
		}
	}

}
