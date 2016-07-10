package com.gmatuella.clinic.filter;

import com.gmatuella.clinic.controller.SessionBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gmatuella
 */
@WebFilter(filterName = "VisitorFilter", description = "Filter dedicated to the control of visitors and its respective accesses",
        urlPatterns = {"/faces/login.xhtml"})
public class VisitorFilter implements Filter {

    @Inject
    private SessionBean session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (session.getLogged()) {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/dashboard.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
