<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Home</title>
</head>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 0;
    }

    h1 {
        margin: 20px 0;
        text-transform: uppercase;
        letter-spacing: 2px;
    }

    .product-container {
        display: grid;
        grid-template-columns: repeat(4, 1fr); /* luôn 4 cột */
        gap: 20px;
        padding: 20px;
        justify-items: center;
    }

    .product-card {
        width: 220px;
        background: #fff;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        overflow: hidden;
        padding: 16px;
        text-align: center;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        cursor: pointer;
    }

    .product-card:hover {
        transform: translateY(-8px);
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    }

    .product-card img {
        width: 100%;
        height: 180px;
        object-fit: cover;
        border-radius: 8px;
        margin-bottom: 12px;
    }

    .product-card h4 {
        font-size: 18px;
        margin: 8px 0;
        color: #333;
    }

    .product-card span {
        display: block;
        font-size: 14px;
        color: #555;
        margin: 4px 0;
    }

    .product-card .price {
        font-size: 18px;
        font-weight: bold;
        color: red;
        margin-top: 8px;
    }
</style>
<body>
<jsp:include page="header.jsp" />

<div style="display: flex; flex-direction: column; align-items: center">

    <h1>Danh sách sản phẩm</h1>
    <div class="product-container">
        <c:forEach var="phone" items="${phones}">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/images/${phone.hinhAnh}" alt="${phone.tenDt}" />
                <h4>${phone.tenDt}</h4>
                <span>Năm sản xuất: ${phone.namSanXuat}</span>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
