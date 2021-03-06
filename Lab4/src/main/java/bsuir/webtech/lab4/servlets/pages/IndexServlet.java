package bsuir.webtech.lab4.servlets.pages;

import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.presentation.html.content.Header;
import bsuir.webtech.lab4.presentation.html.content.Welcome;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    private final View view = new View(new Header(), new Welcome());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(view.get(new ServletSession(req)));
    }
}
