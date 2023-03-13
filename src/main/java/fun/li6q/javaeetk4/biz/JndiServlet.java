package fun.li6q.javaeetk4.biz;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/JNDIOP")
public class JndiServlet extends HttpServlet {
    @Inject
    private Logger book;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context ctx;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        String opCode = request.getParameter("op");
        book.info(String.format("/JNDIOP op: %s", opCode));
        String bindName = request.getParameter("bindName");
        String bindValue = request.getParameter("bindValue");

        String opName = "";
        try {
            switch (opCode) {
                case "bind": {
                    opName = "绑定";
                    ctx.bind(bindName, bindValue);
                    break;
                }
                case "lookUp": {
                    opName = "查询";
                    bindValue = (String) ctx.lookup(bindName);
                    break;
                }
                case "rebind": {
                    opName = "重新绑定";
                    ctx.rebind(bindName, bindValue);
                    break;
                }
                case "unbind": {
                    opName = "取消绑定";
                    ctx.unbind(bindName);
                    break;
                }
            }
        } catch (NamingException ex) {
            book.severe(String.format("messed up: %s", ex));
            request.setAttribute("failed", true);
            request.setAttribute("moreText", ex);
        }

        request.setAttribute("op", opName);
        request.setAttribute("bindName", bindName);
        request.setAttribute("bindValue", bindValue);
        request.getRequestDispatcher("/JNDIOPresult.jsp").forward(request, response);
    }
}