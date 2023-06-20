package uz.spring.book_project.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.spring.book_project.entity.User;
import uz.spring.book_project.enums.Role;
import uz.spring.book_project.service.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private static UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        var user = User
                .childBuilder()
                .email(email)
                .password(password)
                .role(Role.USER)
                .build();
        boolean result = userService.create(user);
        if (result) {
            HttpSession session = req.getSession();
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole().name());
            session.setAttribute("id", user.getId());
            resp.sendRedirect("/book/list");
        }else {
            req.setAttribute("email_error", "Email already exists");
            req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
        }
    }
}
