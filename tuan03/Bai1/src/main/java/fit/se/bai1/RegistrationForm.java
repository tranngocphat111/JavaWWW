package fit.se.bai1;


import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet("/registration-form")

public class RegistrationForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dobStr = req.getParameter("dateOfBirth");
        String email = req.getParameter("email");
        String mobilePhong = req.getParameter("mobileNumber");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pinCode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String[] hobbiesArray = req.getParameterValues("hobbies");
        String course = req.getParameter("course");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        try {
            dateOfBirth = sdf.parse(dobStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> hobbies = new ArrayList<>();

        if (hobbiesArray != null) {
            hobbies.addAll(Arrays.asList(hobbiesArray));

            if (Arrays.asList(hobbiesArray).contains("Others")) {
                String otherHobby = req.getParameter("txtOthers");
                if (otherHobby != null && !otherHobby.trim().isEmpty()) {
                    hobbies.add(otherHobby.trim());
                }
            }
        }

        Student student = new Student(firstName, lastName, dateOfBirth, email, mobilePhong, gender, address, city, pinCode, state, country, hobbies, course);

        req.setAttribute("student", student);

        RequestDispatcher reqd = req.getRequestDispatcher("/result-form.jsp");

//        resp.sendRedirect(req.getContextPath() + "/infomation?student=" + student );


        reqd.forward(req,resp);

    }
}
