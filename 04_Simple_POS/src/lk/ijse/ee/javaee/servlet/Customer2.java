package lk.ijse.ee.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author ishanka on 5/5/21 at 8:08 PM
 * @since 0.0.1
 */
@WebServlet(urlPatterns = "/customer2")
public class Customer2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "7278");
            PreparedStatement pstm = connection.prepareStatement("insert into Customer value (?,?,?,?)");
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, salary);

            int i = pstm.executeUpdate();

            resp.sendRedirect("customer2");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

//        System.out.println(id + " " + name + " " + address + " " + salary);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "7278");
            PreparedStatement pstm = connection.prepareStatement("select * from Customer ");
            ResultSet set = pstm.executeQuery();

            req.getServletContext().setAttribute("set",set);

            resp.sendRedirect("index.jsp");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
