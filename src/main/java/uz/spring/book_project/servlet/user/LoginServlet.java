package uz.spring.book_project.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.spring.book_project.entity.User;
import uz.spring.book_project.service.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("role", user.getRole().name());
                resp.sendRedirect("/book/list");
            }else {
                req.setAttribute("password_error", "Invalid password");
                req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("email_error", "Invalid email");
            req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
        }
    }
}
