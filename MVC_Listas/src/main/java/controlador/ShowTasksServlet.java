package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorTareas;
import modelo.Tarea;

@WebServlet("/ShowTasksServlet")
public class ShowTasksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorTareas gestorTareas = (GestorTareas) getServletContext().getAttribute("gestorTareas");
        if (gestorTareas == null) {
            gestorTareas = new GestorTareas();
            getServletContext().setAttribute("gestorTareas", gestorTareas);
        }

        List<Tarea> tasks = gestorTareas.getAllTasks();
        request.setAttribute("tasks", tasks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("showTasks.jsp");
        dispatcher.forward(request, response);
    }
}