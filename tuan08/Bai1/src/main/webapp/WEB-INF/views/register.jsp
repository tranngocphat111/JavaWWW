<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Employee</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
            font-weight: 600;
        }

        .input {
            flex: 1;
            padding: 10px 12px;
            border-radius: 6px;
            border: 1px solid #6c747d;
        }

        .field {
            display: flex;
            align-items: flex-start;
            width: 100%;
        }

        .field label {
            min-width: 120px;
            padding-top: 10px;
        }

        .field .input-container {
            display: flex;
            flex-direction: column;
            flex: 1;
        }

        .error {
            color: red;
            font-size: 16px;
            margin-top: 4px;
        }

        .button-container {
            display: flex;
            gap: 10px;
            flex: 1;
        }

        a.btn, button.btn {
            text-decoration: none;
            cursor: pointer;
            padding: 10px 12px;
            border-radius: 6px;
            border: none;
            color: white;
        }

        a.btn-back {
            background-color: #6c747d;
        }

        button.btn-submit {
            background-color: #0c6efd;
        }
    </style>
</head>

<body>
<h1>REGISTRATION EMPLOYEE</h1>

<%--@elvariable id="employee" type="java"--%>
<form:form cssStyle="border-radius: 10px; margin: 40px 0; padding: 30px; border: 1px solid #6c747d; width: 40%; display: flex; flex-direction: column; justify-content: center; gap: 20px"
           modelAttribute="employee" method="post" action="${pageContext.request.contextPath}/save">

    <form:input path="id" type="hidden"/>

    <!-- First Name -->
    <div class="field">
        <label>First Name</label>
        <div class="input-container">
            <form:input path="firstName" cssClass="input" type="text" placeholder="First Name"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
    </div>


    <!-- Last Name -->
    <div class="field">
        <label>Last Name</label>
        <div class="input-container">
            <form:input path="lastName" cssClass="input" type="text" placeholder="Last Name"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
    </div>

    <!-- Email -->
    <div class="field">
        <label>Email</label>
        <div class="input-container">
            <form:input path="email" cssClass="input" type="email" placeholder="Email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
    </div>

    <!-- Date of Birth -->
    <div class="field">
        <label>Date of Birth</label>
        <div class="input-container">
            <form:input path="dateOfBirth" cssClass="input" type="date"/>
            <form:errors path="dateOfBirth" cssClass="error"/>
        </div>
    </div>

    <!-- Phone Number -->
    <div class="field">
        <label>Phone</label>
        <div class="input-container">
            <form:input path="phoneNumber" cssClass="input" type="text" placeholder="Phone Number"/>
            <form:errors path="phoneNumber" cssClass="error"/>
        </div>
    </div>

    <!-- Gender -->
    <div class="field">
        <label>Gender</label>
        <div class="input-container">
            <div style="display: flex; gap: 20px;">
                <label><form:radiobutton path="gender" value="Nam"/> Male</label>
                <label><form:radiobutton path="gender" value="Nữ"/> Female</label>
            </div>
            <form:errors path="gender" cssClass="error"/>
        </div>
    </div>

    <!-- Address -->
    <div class="field">
        <label>Address</label>
        <div class="input-container">
            <form:input path="address" cssClass="input" type="text" placeholder="Address"/>
            <form:errors path="address" cssClass="error"/>
        </div>
    </div>

    <!-- Buttons -->
    <!-- Buttons -->
    <div class="field">
        <label></label>
        <div class="button-container">
            <a href="${pageContext.request.contextPath}/list" class="btn btn-back">Back</a>
            <button type="submit" class="btn btn-submit">
                <c:if test="${employee.id == 0}">Register</c:if>
                <c:if test="${employee.id != 0}">Update</c:if>
            </button>


        </div>
    </div>


</form:form>

</body>
</html>
