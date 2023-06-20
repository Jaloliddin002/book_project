package uz.spring.book_project.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "/*")
public class SecurityFilter implements Filter {
    /*
    *
    * /book/list
    * /login
    * /register
     */
    private static final List<String> urlList = List.of(
            "/",
            "/book/list",
            "/login",
            "/register"
            );

    private static final List<String> adminUrls = List.of(
            "/user/list",
            "/book/create",
            "/book/update",
            "/book/delete"
            );

    private static Predicate<String> isOpen = urlList::contains;

    private static Predicate<String> isAdmin = adminUrls::contains;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        Object role = session.getAttribute("role");
        if (Objects.isNull(role)) {
            if (isOpen.test(requestURI)) {
                filterChain.doFilter(request, response);
            }else {
                response.sendRedirect("/login");
            }
        }else if (isAdmin.test(requestURI)) {
            if (role.equals("ADMIN")) {
                filterChain.doFilter(request, response);
            }else {
                response.sendError(403);
            }
        }else {
            filterChain.doFilter(request, response);
        }

    }
}
