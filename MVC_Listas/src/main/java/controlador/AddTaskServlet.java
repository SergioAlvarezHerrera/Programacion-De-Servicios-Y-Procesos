package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorTareas;

public class AddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.sendRedirect("showTasks");
    }
}