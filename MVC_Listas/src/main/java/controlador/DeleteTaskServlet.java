package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorTareas;

@WebServlet("/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        GestorTareas gestorTareas = (GestorTareas) getServletContext().getAttribute("gestorTareas");
        if (gestorTareas != null) {
            gestorTareas.deleteTask(id);
        }
        
        getServletContext().setAttribute("gestorTareas" , gestorTareas);

        response.sendRedirect("ShowTasksServlet");
    }
}