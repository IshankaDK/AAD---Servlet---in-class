package lk.ijse.ee.pos.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.*;

/**
 * @author ishanka on 5/7/21 at 9:45 AM
 * @since 0.0.1
 */
@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "7278");
            PreparedStatement pstm = connection.prepareStatement("select  * from Customer");
            ResultSet set = pstm.executeQuery();
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
/*            writer.write("[");

            while (set.next()){
                String id = set.getString(1);
                String name = set.getString(2);
                String address = set.getString(3);
                String salary = set.getString(4);
                writer.write("{\"id\":\""+id+"\",\"name\":\""+name+"\",\"address\":\""+address+"\",\"salary\":"+salary+"},");
            }

            writer.write("{}");
            writer.write("]");*/


            String json = "[";
            while (set.next()){
                String id = set.getString(1);
                String name = set.getString(2);
                String address = set.getString(3);
                String salary = set.getString(4);
                json += "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"address\":\"" + address + "\",\"salary\":" + salary + "},";
            }
            json = json.substring(0,json.length()-1);
            json += "]";
            writer.write(json);
            writer.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "7278");
            PreparedStatement pstm = connection.prepareStatement("insert into Customer value  (?,?,?,?)");
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, salary);
            int i = pstm.executeUpdate();

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");

            if (i > 0) {
                writer.write("{\"operation\":\"success\"}");
            }

            writer.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
