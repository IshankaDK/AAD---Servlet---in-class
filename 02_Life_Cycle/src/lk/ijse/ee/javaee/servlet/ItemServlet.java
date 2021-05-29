package lk.ijse.ee.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ishanka on 5/4/21 at 10:52 PM
 * @since 0.0.1
 */
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Item Servlet do get called");
        resp.getWriter().write("Item Servlet doGet Called..");
    }
}
