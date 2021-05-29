package lk.ijse.ee.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ishanka on 5/4/21 at 11:16 PM
 * @since 0.0.1
 */
@WebServlet(name = "PathMapping",urlPatterns = "/path")
public class PathMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Path Servlet doGet Invoked");
    }

}
