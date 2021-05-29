package lk.ijse.ee.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ishanka on 5/4/21 at 10:29 PM
 * @since 0.0.1
 */
//@WebServlet(name = "MyServlet", urlPatterns = "myServlet")
public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("onna Object ekk haduwa");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("onn mn servlet ekk kollo");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("My Servlet Called");
            System.out.println("My Servlet Called");
        }
    }

    @Override
    public void destroy() {
        System.out.println("im gonna die");
        ;
    }
}

