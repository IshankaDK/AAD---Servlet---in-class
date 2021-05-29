package lk.ijse.ee.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ishanka on 5/29/21 at 8:20 PM
 * @since 0.0.1
 */
@WebFilter(urlPatterns = "/item")
public class BFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("B init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("B do filter");
        servletRequest.setAttribute("x","Institute");// set some new information

        filterChain.doFilter(servletRequest,servletResponse);// forward to servlet

        // can modify response object if we want
        servletResponse.setContentType("application/json");// add a response content type before sending the response

//        HttpServletResponse http = (HttpServletResponse) servletResponse;
//        http.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        System.out.println("B destroy");
    }
}
