package uz.spring.book_project.servlet.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.spring.book_project.entity.User;
import uz.spring.book_project.service.UserService;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "UserListServlet", urlPatterns = "/user/list")
public class UserListServlet extends HttpServlet {

    private static UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.getAll();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/views/admin/user_list.jsp").forward(req, resp);
    }
}
