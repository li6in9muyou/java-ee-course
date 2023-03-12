package fun.li6q.javaeetk4;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Named
@WebServlet("/pleaseSignUp")
public class SignUpServlet extends HttpServlet {
    @Inject
    private Dao dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = dao.createUser(
                request.getParameter("displayName"),
                request.getParameter("password")
        );
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("me");
        } else {
            response.sendRedirect("login.html");
        }
    }
}

