package uz.spring.book_project.servlet.book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.spring.book_project.entity.Book;
import uz.spring.book_project.service.BookService;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "BookServlet", urlPatterns = "/book/list")
public class BookListServlet extends HttpServlet {

    private static BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.getAll();
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("/views/book/book_list.jsp").forward(req, resp);
    }
}
