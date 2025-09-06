<%@ page import="fit.se.bai1.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Information</title>
</head>
<body>
<%
  Student student = (Student) request.getAttribute("student");
  if (student != null) {
    out.println("<h2>Student Information</h2>");
    out.println("<table border='1' cellpadding='10' cellspacing='0'>");
    out.println("<tr><th>First Name</th><td>" + student.getFirstName() + "</td></tr>");
    out.println("<tr><th>Last Name</th><td>" + student.getLastName() + "</td></tr>");
    out.println("<tr><th>Date Of Birth</th><td>" + student.getDateOfBirth() + "</td></tr>");
    out.println("<tr><th>Email</th><td>" + student.getEmail() + "</td></tr>");
    out.println("<tr><th>Mobile Number</th><td>" + student.getMobileNumber() + "</td></tr>");
    out.println("<tr><th>Gender</th><td>" + student.getGender() + "</td></tr>");
    out.println("<tr><th>Address</th><td>" + student.getAddress() + "</td></tr>");
    out.println("<tr><th>City</th><td>" + student.getCity() + "</td></tr>");
    out.println("<tr><th>Pin Code</th><td>" + student.getPinCode() + "</td></tr>");
    out.println("<tr><th>State</th><td>" + student.getState() + "</td></tr>");
    out.println("<tr><th>Country</th><td>" + student.getCountry() + "</td></tr>");
    out.println("<tr><th>Hobbies</th><td>" + student.getHobbies() + "</td></tr>");
    out.println("<tr><th>Course Applied For</th><td>" + student.getCourse() + "</td></tr>");
    out.println("</table>");
  } else {
    out.println("<p style='color:red;'>No student data available</p>");
  }
%>
</body>
</html>
