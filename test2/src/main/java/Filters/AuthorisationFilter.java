package main.java.Filters;

import main.java.Authorisation;
import main.java.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorisationFilter implements Filter {
    private FilterConfig config = null;
    private boolean active = false;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        String act = config.getInitParameter("active");
        if (act != null)
            active = (act.toLowerCase().equals("true"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (!active) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!(servletRequest instanceof HttpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        if (url.equals("/login") || url.equals("/")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //Всё ОК. Дальше просто проверка на авторизацию
        Authorisation authorisation = new Authorisation();
        User authorisedUser = authorisation.getAuthorisedUser((HttpServletRequest) servletRequest);
        if (authorisedUser == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
