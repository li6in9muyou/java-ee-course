package fun.li6q.javaeetk4;

import jakarta.inject.Named;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@Named
@WebServlet("/me")
public class PersonalProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println(String.format("<h1> Welcome, %s </h1>", u.getDisplayName()));
            out.println(String.format("<h2> Your userId is: %d </h2>", u.getId()));
            out.println(String.format("<h2> Your password is: ***%s*** </h2>", u.getPassword()));
            out.close();
        }
    }
}

