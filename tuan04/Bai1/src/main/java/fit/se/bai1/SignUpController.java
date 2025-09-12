package fit.se.bai1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");

        String dateStr = req.getParameter("birthday");
        String gender = req.getParameter("gender");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth;
        try {
            dateOfBirth = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        if (!reEmail.equals(email)) {
            resp.getWriter().println("Email Không khớp!!! Vui lòng thử lại");
            return;
        }

        Account account = new Account(firstName, lastName, email, password, dateOfBirth,gender);

//        req.setAttribute("account", account);


        String sql = "INSERT INTO account (firstName, lastName, email, password, dayOfBirth, gender) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account.getFirstName());
            stmt.setString(2, account.getLastName());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getPassword());
            stmt.setString(5, sdf.format(account.getDob()));
            stmt.setString(6, account.getGender());

            int rows = stmt.executeUpdate();
            if (rows > 0) {

                System.out.println("Redirect tới: " + req.getContextPath() + "/list-account");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/list-account");


    }
}
