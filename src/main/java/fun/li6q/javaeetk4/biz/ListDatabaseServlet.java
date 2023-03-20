package fun.li6q.javaeetk4.biz;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/list-database")
public class ListDatabaseServlet extends HttpServlet {
    @Inject
    private Logger book;

    @EJB
    private ListDatabase lister;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        book.info("/list-database");
        request.setAttribute("text", lister.list());
        request.getRequestDispatcher("/list-database.jsp").forward(request, response);
    }
}