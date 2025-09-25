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
<div class="container">
    <form class="form" method="post" action="phones" enctype="multipart/form-data">
        <h1>Thêm Điện Thoại Mới</h1>

        <div class="input-row">
            <label>Tên điện thoại: </label>
            <input class="input" type="text" name="tenDt" placeholder="Nhập tên điện thoại" value="${param.tenDt}">
            <span class="regex" style="color: red">${errors.tenDt}</span>
        </div>

        <div class="input-row">
            <label>Năm sản xuất: </label>
            <input class="input" type="text" name="namSanXuat" placeholder="Nhập năm sản xuất" value="${param.namSanXuat}">
            <span class="regex" style="color: red">${errors.namSanXuat}</span>
        </div>

        <div class="input-row">
            <label>Cấu hình: </label>
            <textarea class="input-content" name="cauHinh" placeholder="Nhập cấu hình điện thoại">${param.cauHinh}</textarea>
            <span class="regex" style="color: red">${errors.cauHinh}</span>
        </div>

        <div class="input-row">
            <label>Hình ảnh (URL): </label>
            <input class="input" type="file" name="hinhAnh" placeholder="Nhập link hình ảnh"  value="${param.hinhAnh}">
            <span class="regex" style="color: red">${errors.hinhAnh}</span>
        </div>

        <div class="input-row">
            <label>Nhà cung cấp: </label>
            <select name="maNcc" class="input">
                <c:forEach var="ncc" items="${suppliers}">
                    <option value="${ncc.maNcc}">${ncc.tenNcc}</option>
                </c:forEach>
            </select>
            <span class="regex" style="color: red">${errors.nhaCungCap}</span>
        </div>

        <button type="submit"
                name="action" value="add"
                style="border-radius: 10px ;height: 50px; font-size: 18px; background: #0072ff;; color: white; border: 0; cursor: pointer">
            Thêm
        </button>
    </form>
</div>
</body>
</html>
