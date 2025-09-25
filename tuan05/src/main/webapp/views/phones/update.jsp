<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật Điện Thoại</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
    }
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
        border: 1px solid #ccc;
    }

    .input-content {
        height: 80px;
        padding: 10px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-family: Arial, sans-serif;
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

    .submit-btn {
        border-radius: 10px ;
        height: 50px;
        font-size: 18px;
        background: #28a745; /* Màu xanh lá cho update */
        color: white;
        border: 0;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    .submit-btn:hover {
        background: #218838;
    }

</style>
<body>
<div class="container">
    <%-- Giả sử đối tượng điện thoại được truyền từ Servlet có tên là "phone" --%>
    <form class="form" method="post" action="phones" enctype="multipart/form-data">
        <h1>Cập nhật thông tin Điện Thoại</h1>

        <%-- Trường ẩn để gửi mã điện thoại về server --%>
        <input type="hidden" name="maDt" value="${phone.maDt}">
        <%-- Trường ẩn để giữ lại tên ảnh cũ nếu không chọn ảnh mới --%>
        <input type="hidden" name="hinhAnhCu" value="${phone.hinhAnh}">
        <input type="hidden" name="maDt" value="${phone.maDt}">



        <div class="input-row">
            <label>Tên điện thoại: </label>
            <input class="input" type="text" name="tenDt" placeholder="Nhập tên điện thoại" value="${phone.tenDt}">
            <span class="regex" style="color: red">${errors.tenDt}</span>
        </div>

        <div class="input-row">
            <label>Năm sản xuất: </label>
            <input class="input" type="text" name="namSanXuat" placeholder="Nhập năm sản xuất" value="${phone.namSanXuat}">
            <span class="regex" style="color: red">${errors.namSanXuat}</span>
        </div>

        <div class="input-row">
            <label>Cấu hình: </label>
            <textarea class="input-content" name="cauHinh" placeholder="Nhập cấu hình điện thoại">${phone.cauHinh}</textarea>
            <span class="regex" style="color: red">${errors.cauHinh}</span>
        </div>

        <div class="input-row">
            <label>Ảnh hiện tại:</label>
            <img src="images/${phone.hinhAnh}" alt="Ảnh hiện tại" width="120" style="border-radius: 5px;">
            <label>Chọn ảnh mới (nếu muốn thay đổi): </label>
            <input class="input" type="file" name="hinhAnh">
            <span class="regex" style="color: red">${errors.hinhAnh}</span>
        </div>

        <div class="input-row">
            <label>Nhà cung cấp: </label>
            <select name="maNcc" class="input">
                <c:forEach var="ncc" items="${suppliers}">
                    <%-- Dùng toán tử 3 ngôi để kiểm tra và thêm thuộc tính 'selected' --%>
                    <option value="${ncc.maNcc}" ${ncc.maNcc == phone.nhaCungCap.maNcc ? 'selected' : ''}>
                            ${ncc.tenNcc}
                    </option>
                </c:forEach>
            </select>
            <span class="regex" style="color: red">${errors.nhaCungCap}</span>
        </div>

        <button type="submit" name="action" value="update" class="submit-btn">
            Cập nhật
        </button>
    </form>
</div>
</body>
</html>