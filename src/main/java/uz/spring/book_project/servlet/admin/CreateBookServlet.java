package uz.spring.book_project.servlet.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.spring.book_project.entity.Book;
import uz.spring.book_project.service.BookService;

import java.io.IOException;


@WebServlet(name = "CreateBookServlet", urlPatterns = "/book/create")
public class CreateBookServlet extends HttpServlet {

    private static BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/create_book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        var book = Book.childBuilder()
                .title(title)
                .author(author)
                .description(description)
                .build();
        bookService.create(book);
        resp.sendRedirect("/book/list");
    }
}
