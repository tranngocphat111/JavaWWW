<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Điện Thoại</title>
</head>
<style>
    .container {
        margin-top: 40px;
        display: flex;
        justify-content: center;
        width: 100%;
    }

    .input {
        padding-left: 10px;
        height: 40px;
        border-radius: 6px;
    }

    .input-content {
        height: 80px;
        padding: 10px;
        border-radius: 6px;
    }

    .form {
        display: flex;
        flex-direction: column;
        gap: 14px;
        border-radius: 10px;
        width: 40%;
        padding: 20px;
        border: 2px solid #dcdcdc;
        box-shadow: 1px 2px 4px #dcdcdc;
    }

    .input-row {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }
</style>

<body>
<jsp:include page="header.jsp" />

<div class="container">
    <%--@elvariable id="phone" type="java"--%>
    <form:form class="form" method="post"
               modelAttribute="phone"
               action="${pageContext.request.contextPath}/save"
               enctype="multipart/form-data">

        <h1>Thêm Điện Thoại Mới</h1>

        <div class="input-row">
            <label>Tên điện thoại:</label>
            <form:input path="tenDt" cssClass="input" placeholder="Nhập tên điện thoại" />
            <form:errors path="tenDt" cssStyle="color: red" />
        </div>

        <div class="input-row">
            <label>Năm sản xuất:</label>
            <form:input path="namSanXuat" cssClass="input" placeholder="Nhập năm sản xuất" />
            <form:errors path="namSanXuat" cssStyle="color: red" />
        </div>

        <div class="input-row">
            <label>Cấu hình:</label>
            <form:textarea path="cauHinh" cssClass="input-content" placeholder="Nhập cấu hình điện thoại" />
            <form:errors path="cauHinh" cssStyle="color: red" />
        </div>

        <div class="input-row">
            <label>Hình ảnh:</label>
            <input type="file" name="file" class="input" />
            <form:errors path="hinhAnh" cssStyle="color: red" />
        </div>

        <div class="input-row">
            <label>Nhà cung cấp:</label>
            <form:select path="maNcc" cssClass="input">
                <form:options items="${suppliers}" itemValue="maNcc" itemLabel="tenNcc"/>
            </form:select>

        </div>

        <button type="submit"
                style="border-radius: 10px; height: 50px; font-size: 18px; background: #0072ff; color: white; border: 0; cursor: pointer;">
            Thêm
        </button>
    </form:form>
</div>
</body>
</html>
