/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.filter;

import com.projetos.ci.clinica.controller.SessionBean;
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
@WebFilter(filterName = "UsuarioFilter", description = "Filtro dedicado ao controle dos usuários e seus respectivos acessos",
        urlPatterns = {"/faces/dashboard.xhtml", "/faces/consultas.xhtml"})
public class UsuarioFilter implements Filter {

    @Inject
    private SessionBean session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        System.out.println(req.getRequestURL().toString());
        if (session == null) {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/login.xhtml");
        } else if (!session.getLogado()) {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
