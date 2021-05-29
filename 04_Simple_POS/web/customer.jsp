<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: ishanka
  Date: 5/6/21
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer View</title>
    <link rel="stylesheet" href="assests/css/bootstrap.min.css">
</head>
<body>

<section class="container-fluid">
    <section class="row">
        <h1>Customer View</h1>
    </section>

    <section class="row">
        <div class="col-md-6">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Salary</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ResultSet set = (ResultSet) request.getServletContext().getAttribute("set");

                    while (set.next()) {
                        String id = set.getString(1);
                        String name = set.getString(2);
                        String address = set.getString(3);
                        String salary = set.getString(4);
                %>
                <tr>
                    <td><%=id%>
                    </td>
                    <td><%=name%>
                    </td>
                    <td><%=address%>
                    </td>
                    <td><%=salary%>
                    </td>
                </tr>

                <%}%>

                </tbody>
            </table>
        </div>
    </section>
</section>

</body>
</html>

<%--

<%%> scriptlet
<%!%> declaration  <%! int age = 10;%>
<%=%> expression    <%= age %>

--%>



