package lk.ijse.ee.javaee.listener;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ishanka on 5/16/21 at 8:59 PM
 * @since 0.0.1
 */
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Was Created");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/company");
        dataSource.setUsername("root");
        dataSource.setPassword("7278");
        dataSource.setMaxTotal(2);
        dataSource.setInitialSize(2);
        servletContextEvent.getServletContext().setAttribute("ds",dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Was Destroyed");
    }
}
