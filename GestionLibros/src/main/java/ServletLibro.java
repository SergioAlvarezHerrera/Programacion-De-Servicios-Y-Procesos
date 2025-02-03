import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.LibroDAO;

@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
    private LibroDAO libroDAO = new LibroDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            
            case "new":
                request.getRequestDispatcher("agregalibro.jsp").forward(request, response);
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                libroDAO.eliminarLibro(id);
                response.sendRedirect("ServletLibro?action=list");
                break;
                
            case "list":
                request.setAttribute("listalibros", libroDAO.listarLibro());
                request.getRequestDispatcher("listalibros.jsp").forward(request, response);
                break;
                
              default: 
            	  break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");

            libroDAO.agregarLibro(titulo, autor);
            response.sendRedirect("ServletLibro?action=list");
        }

       
    }

