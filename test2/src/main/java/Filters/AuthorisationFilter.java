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
        //подгрузка из web.xml параметра (включать или нет этот фильтр )
        this.config = config;
        String act = config.getInitParameter("active");
        if (act != null)
            active = (act.toLowerCase().equals("true"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //если в web.xml отключена фильтрация на аутентификацию
        if (!active) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //если зашли не из браузера
        if (!(servletRequest instanceof HttpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //пропускаем проверку авторизации для перечисленных страниц
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        if (url.equals("/login") || url.equals("/") || url.startsWith("/css") || url.startsWith("/js") || url.startsWith("/img")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //Всё ОК. Дальше просто проверка на авторизацию
        Authorisation authorisation = new Authorisation();
        User authorisedUser = authorisation.getAuthorisedUser((HttpServletRequest) servletRequest);
        if (authorisedUser == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
            return;
        }

        //перебросить к следующему фильтру или сервлету
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
