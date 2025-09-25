<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản lý điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        table {
            width: 90%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 2px 15px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
            vertical-align: middle; /* Căn giữa nội dung theo chiều dọc */
        }
        th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2; /* Tô màu cho các dòng chẵn */
        }
        tr:hover {
            background-color: #e9ecef; /* Hiệu ứng khi di chuột qua */
        }

        /* --- CSS cho nút --- */
        .action-btn {
            display: inline-block;
            padding: 8px 12px;
            border-radius: 5px;
            text-decoration: none;
            color: white;
            font-weight: bold;
            text-align: center;
            transition: background-color 0.3s, transform 0.2s;
            margin: 0 4px; /* Khoảng cách giữa các nút */
        }

        .btn-update {
            background-color: #28a745; /* Màu xanh lá */
            border: 1px solid #218838;
        }
        .btn-update:hover {
            background-color: #218838;
            transform: scale(1.05); /* Hiệu ứng phóng to nhẹ khi di chuột */
        }

        .btn-delete {
            background-color: #dc3545; /* Màu đỏ */
            border: 1px solid #c82333;
        }
        .btn-delete:hover {
            background-color: #c82333;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

<div style="width: 100%; display: flex; flex-direction: column; align-items: center" >
    <h1>Danh sách điện thoại</h1>

    <table border="1">
        <tr>
            <th>Mã ĐT</th>
            <th>Tên điện thoại</th>
            <th>Năm sản xuất</th>
            <th>Cấu hình</th>
            <th>Hình ảnh</th>
            <th>Nhà cung cấp</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach var="dt" items="${phones}">
            <tr>
                <td>${dt.maDt}</td>
                <td>${dt.tenDt}</td>
                <td>${dt.namSanXuat}</td>
                <td>${dt.cauHinh}</td>
                <td><img src="images/${dt.hinhAnh}" alt="Hình ảnh" width="100" style="border-radius: 5px;"></td>
                <td>${dt.nhaCungCap.tenNcc}</td>
                <td>
                    <a href="phones?choose=update&maDt=${dt.maDt}" class="action-btn btn-update">Sửa</a>
                    <a href="phones?choose=delete&maDt=${dt.maDt}" class="action-btn btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>