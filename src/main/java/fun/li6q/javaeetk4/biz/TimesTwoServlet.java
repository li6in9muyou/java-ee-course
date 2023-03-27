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

@WebServlet("/show-times-two")
public class TimesTwoServlet extends HttpServlet {
    @Inject
    private Logger book;

    @EJB
    private TimesTwo two;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        book.info("/show-times-two");
        request.setAttribute("text", two.calculateTwo());
        request.getRequestDispatcher("/show-times-two.jsp").forward(request, response);
    }
}