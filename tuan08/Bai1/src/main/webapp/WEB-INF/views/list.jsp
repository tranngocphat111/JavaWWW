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

<div style="width: 70%; display: flex; flex-direction: column; justify-content: center">
    <div style="display: flex; justify-content: flex-end; gap: 10px; width: 100%">
        <form action="${pageContext.request.contextPath}/search" method="get" style="display: flex; gap: 10px;">
            <input name="keyword" value="${keyword}" placeholder="Enter name"
                   style="padding: 10px 12px; border-radius: 6px; border: 1px solid #ccc;" type="text" />

            <button type="submit"
                    style="border: 0; cursor: pointer; padding: 10px 12px; background-color: #6c747d; color: white; border-radius: 6px">
                Search
            </button>
        </form>

        <a href="${pageContext.request.contextPath}/show-form"
           style="text-decoration: none; cursor: pointer; padding: 10px 12px; background-color: #0c6efd; color: white; border-radius: 6px">
            Add Employee
        </a>
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
                <td style="display: flex; flex-direction: row; gap: 10px">
                    <a href="${pageContext.request.contextPath}/update?id=${employee.id}" style="text-decoration: none; cursor: pointer;padding: 10px 12px; background-color: #0c6efd; color: white; border-radius: 6px">Update</a>
                    <form action="${pageContext.request.contextPath}/delete?id=${employee.id}" method="post"
                          onsubmit="return confirm('Bạn có chắc chắn muốn xóa nhân viên này không?');">
                        <button style="cursor: pointer;border: 0;padding: 10px 12px; background-color: red; color: white; border-radius: 6px" type="submit" >Delete</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>