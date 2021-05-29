package lk.ijse.ee.javaee.servlet;

import javax.annotation.Resource;
import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

/**
 * @author ishanka on 5/16/21 at 11:06 PM
 * @since 0.0.1
 */

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = ds.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from Customer");
            ResultSet set = pstm.executeQuery();
            resp.setContentType("application/json");

            JsonArrayBuilder allCustomers = Json.createArrayBuilder();
            while (set.next()) {
                JsonObjectBuilder customer = Json.createObjectBuilder();
                customer.add("id", set.getString(1));
                customer.add("name", set.getString(2));
                customer.add("address", set.getString(3));
                customer.add("salary", set.getString(4));
                allCustomers.add(customer.build());
            }
            resp.getWriter().print(allCustomers.build());
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());

        JsonArray jsonValues = reader.readArray();

//        for (int i = 0; i < jsonValues.size(); i++) {
//            JsonObject jsonObject = jsonValues.getJsonObject(i);
//            String id = jsonObject.getString("id");
//            System.out.println(id);
//        }

        for (JsonValue jsonValue : jsonValues) {
            JsonObject jsonObject = jsonValue.asJsonObject();
            String id = jsonObject.getString("id");
            System.out.println(id);
            ;

        }
    }
}
