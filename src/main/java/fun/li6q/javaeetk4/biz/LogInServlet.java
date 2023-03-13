package fun.li6q.javaeetk4.biz;

import fun.li6q.javaeetk4.dao.Dao;
import fun.li6q.javaeetk4.entity.User;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Named
@WebServlet("/pleaseLogIn")
public class LogInServlet extends HttpServlet {
    @Inject
    private Dao dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = dao.fetchUserByDisplayNameAndPasswordOrNull(
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

