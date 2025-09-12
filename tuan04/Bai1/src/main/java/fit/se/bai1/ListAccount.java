package fit.se.bai1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list-account")
public class ListAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = new ArrayList<>();

        String sql = "SELECT * FROM account";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                accounts.add(new Account(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDate("dayOfBirth"),
                        rs.getString("gender")

                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Xuất HTML
        resp.setContentType("text/html;charset=UTF-8");
        var out = resp.getWriter();

        out.println("<html><head><title>List Accounts</title></head><body>");
        out.println("<h2>Danh sách Account</h2>");
        out.println("<table border='1' cellpadding='8' cellspacing='0'>");
        out.println("<tr>");
        out.println("<th>Email</th>");
        out.println("<th>Password</th>");
        out.println("<th>Full Name</th>");
        out.println("<th>Day Of Birth</th>");
        out.println("<th>Gender</th>");
        out.println("</tr>");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Account acc : accounts) {
            out.println("<tr>");
            out.println("<td>" + acc.getEmail() + "</td>");
            out.println("<td>" + acc.getPassword() + "</td>");
            out.println("<td>" + acc.getFirstName() + " " + acc.getLastName() + "</td>");
            out.println("<td>" + sdf.format(acc.getDob()) + "</td>");
            out.println("<td>" +acc.getGender() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }

}
