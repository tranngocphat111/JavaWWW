package iuh.fit.se.tuan01;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Bai04", value = "/Bai04",
        initParams = {
                @WebInitParam(name = "username", value = "username01"),
                @WebInitParam(name = "password", value = "password01s")
        })
public class Bai04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Init-param</h1>");
        writer.println("<h3>Username: " + this.getServletConfig().getInitParameter("username") + "</h3>");
        writer.println("<h3>Password: " + this.getServletConfig().getInitParameter("password") + "</h3>");

        writer.println("<h1>Context-param</h1>");
        writer.println("<h3>Name: " + this.getServletContext().getInitParameter("name") + "</h3>");
        writer.println("<h3>Age: " + this.getServletContext().getInitParameter("age") + "</h3>");

        writer.println("<form action='Bai04' method='POST' style='display: flex; flex-direction: row;'>");
        writer.println("<span>Nhập tên của bạn: </span>");
        writer.println("<input type='text' id='name' name='name'>");
        writer.println("<button type='submit'>Submit</button>");
        writer.println("</form>");

        writer.println("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Xin chao " + req.getParameter("name") + "</h3>");
        writer.println("</body></html>");
    }
}
