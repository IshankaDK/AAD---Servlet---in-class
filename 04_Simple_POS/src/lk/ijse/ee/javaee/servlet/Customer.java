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
@WebServlet(urlPatterns = "/customer")
public class Customer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*//        gather the information from the request

        String pathInfo = req.getPathInfo();
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        String queryString = req.getQueryString();
        StringBuffer requestURL = req.getRequestURL();
        String servletPath = req.getServletPath();

        System.out.println(pathInfo);
        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(queryString);
        System.out.println(requestURL);
        System.out.println(servletPath);*/

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

            if (i>0){
                resp.getWriter().write("Customer Saved bitch..!");
            }else {
                resp.getWriter().write("Customer Not Saved bitch..!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println(id + " " + name + " " + address + " " + salary);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "7278");
            PreparedStatement pstm = connection.prepareStatement("select * from Customer ");
            ResultSet set = pstm.executeQuery();
            resp.setContentType("text/html");

            PrintWriter writer = resp.getWriter();

            writer.write(" <link rel=\"stylesheet\" href=\"assests/css/bootstrap.min.css\">");
            writer.write("<table class=\"table table-bordered\">");
            writer.write("<thead>");
            writer.write("<tr>");
            writer.write("<td>ID</td><td>Name</td><td>Address</td><td>Salary</td>");
            writer.write("</tr>");
            writer.write("</thead>");
            writer.write("<tbody>");

            while (set.next()){
                String id = set.getString(1);
                String name = set.getString(2);
                String address = set.getString(3);
                String salary = set.getString(4);

                writer.write("<tr><td>"+ id +"</td><td>"+ name +"</td><td>"+ address +"</td><td>"+ salary +"</td></tr>");
               /* System.out.println(id);
                System.out.println(name);
                System.out.println(address);
                System.out.println(salary);*/
            }

            writer.write("</tbody>");
            writer.write("</table>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
