package controller;

import modelo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EditUserController")
public class EditUserController extends HttpServlet {
    private List<User> userList;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
       userList= (List<User>) context.getAttribute("userList");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);

            
            User userToEdit = null;
            for (User user : userList) {
                if (user.getId() == id) {
                    userToEdit = user;
                    break;
                }
            }

            if (userToEdit != null) {
                request.setAttribute("user", userToEdit);
                request.getRequestDispatcher("editUser.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

       
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
                user.setEmail(email);
                break;
            }
        }

        
        response.sendRedirect("UserController?action=list");
    }
}
