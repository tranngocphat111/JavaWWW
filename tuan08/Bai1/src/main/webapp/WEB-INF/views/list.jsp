<%@ page language="java" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Employee</title>
</head>
<style>
    table{
        margin: 30px 0;
        border-collapse: collapse;
    }

    th, td {
        text-align: center;
        padding: 20px;
        border: 1px solid #000;
    }
</style>

<body style="display: flex; justify-content: center; flex-direction: column; align-items: center">
<h1 style="text-align: center; font-weight: 600">EMPLOYEE LIST</h1>

<div style="display: flex; justify-content: flex-end; gap: 10px; width: 57%">
    <input name="" style="padding: 10px 12px; border-radius: 6px" type="text" />
    <a href="" style="text-decoration: none; cursor: pointer; padding: 10px 12px; background-color: #6c747d; color: white; border-radius: 6px">Search</a>
    <a href="" style="text-decoration: none; cursor: pointer;padding: 10px 12px; background-color: #0c6efd; color: white; border-radius: 6px">Add Employee</a>
</div>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Date of birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.gender}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.email}</td>
            <td>${employee.phoneNumber}</td>
            <td>
                <a style="cursor: pointer;padding: 10px 12px; background-color: #0c6efd; color: white; border-radius: 6px">Update</a>

            </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>