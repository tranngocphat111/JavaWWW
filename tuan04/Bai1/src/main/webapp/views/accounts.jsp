<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>D

    <meta charset="UTF-8">
    <title>Danh sách Account</title>
    <style>
        table {
            border-collapse: collapse;
            width: 70%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px 12px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Danh sách Account</h2>
<table>
    <tr>
        <th>Email</th>
        <th>Full Name</th>
        <th>Day Of Birth</th>
        <th>Gender</th>
    </tr>
    <c:forEach var="acc" items="${accounts}">
        <tr>
            <td>${acc.email}</td>
            <td>${acc.firstName} ${acc.lastName}</td>
            <td>
                <fmt:formatDate value="${acc.dob}" pattern="yyyy-MM-dd"/>
            </td>
            <td>${acc.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
