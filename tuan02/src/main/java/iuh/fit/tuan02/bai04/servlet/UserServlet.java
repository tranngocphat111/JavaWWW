package iuh.fit.tuan02.bai04.servlet;

import com.google.gson.Gson;
import iuh.fit.tuan02.bai04.User;
import iuh.fit.tuan02.bai04.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=userService.getUser();
        Gson gson=new Gson();

        String json=gson.toJson(user);

        resp.setContentType("application/json");
        PrintWriter writer=resp.getWriter();
        writer.write(json);
    }
}
