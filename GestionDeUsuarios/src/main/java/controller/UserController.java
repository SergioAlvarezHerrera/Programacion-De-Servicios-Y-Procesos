package controller;

import modelo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private List<User> userList;

    @Override
    public void init() throws ServletException {
        // Inicializar la lista con algunos usuarios por defecto
        userList = new ArrayList<>();
        userList.add(new User(1, "John Doe", "john@example.com"));
        userList.add(new User(2, "Jane Doe", "jane@example.com"));
        userList.add(new User(3, "Jim Doe", "jim@example.com"));

        // Guardar la lista en el contexto de la aplicación para compartirla entre los servlets
        getServletContext().setAttribute("userList", userList);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Validar si los campos están vacíos
        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            request.setAttribute("errorMessage", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // Obtener el próximo ID (basado en el tamaño actual de la lista)
        int id = userList.size() + 1;
        User newUser = new User(id, name, email);
        userList.add(newUser);

        // Redirigir a la lista de usuarios
        response.sendRedirect("UserController?action=list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            request.setAttribute("usuarios", userList);
            request.getRequestDispatcher("listsUsers.jsp").forward(request, response);
        } else if ("add".equals(action)) {
            response.sendRedirect("index.jsp");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            userList.removeIf(user -> user.getId() == id);
            response.sendRedirect("UserController?action=list");
        }
    }
}

