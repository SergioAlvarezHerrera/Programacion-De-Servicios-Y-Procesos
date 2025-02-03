package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorTareas;
import modelo.Tarea;

public class EditTaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        GestorTareas gestorTareas = (GestorTareas) getServletContext().getAttribute("gestorTareas");
        Tarea tarea = gestorTareas.getTaskById(id);

        if (tarea != null) {
            request.setAttribute("task", tarea);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editTask.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("showTasks");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newDescription = request.getParameter("description");

        GestorTareas gestorTareas = (GestorTareas) getServletContext().getAttribute("gestorTareas");
        if (gestorTareas != null) {
            gestorTareas.updateTask(id, newDescription);
        }

        response.sendRedirect("showTasks");
    }
}