<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/14/2025
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Shopping</title>
</head>

<style>
    .container {
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
        gap: 30px;
    }

    .header {
        width: 80%;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .img {
        object-fit: cover;
        width: 200px;

    }

    .list-cart {
        display: flex;
        align-items: center;
        width: 70%;
        gap: 20px;
        flex-wrap: wrap;
    }

    .card {
        width: 220px;
        display: flex;
        flex-direction: column;
        border-radius: 10px;
        border: 1px solid #ccc;
        overflow: hidden;
        background-color: white;
        cursor: pointer;
        transition: transform 0.3s ease, box-shadow 0.3s ease;

    }


    .card:hover {
        transform: translateY(-4px);
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
    }


    .content {
        display: flex;
        flex-direction: column;
        padding: 16px;
        gap: 10px;
    }

    .title {
        font-size: 16px;
        font-weight: 700;

    }

    .price {
        color: #fa2f2f;
        font-weight: 700;
        font-size: 18px;
    }

    .btn {
        padding: 14px 12px;
        background-color: #f4f125;
        border-radius: 10px;
        cursor: pointer;
        border: 0;
        font-size: 16px;
        font-weight: 600;
        color: black;
        text-decoration: none;
        text-align: center;

    }


    .btn:hover {
        background-color: #efec09;
    }

    .cart {
        padding: 12px 14px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        float: right;
        border-radius: 10px;
        box-shadow: 2px 3px 4px 2px #807878;
    }

    .cart:hover {
        opacity: 0.8;
    }

</style>
<body style="background-color: #faf8f8">
<div class="container">
    <div style="background-color: #f4f125; width: 100%; display: flex; justify-content: center">
        <div class="header">
            <h2>LIST PRODUCT</h2>
            <a class="cart" href="cart">🛒 My Cart</a>
        </div>
    </div>
    <div class="list-cart">
        <c:forEach var="product" items="${products}">
            <div class="card">
                <img class="img" src="${pageContext.request.contextPath}/images/${product.image}" alt="img">
                <div class="content">
                    <label class="title">${product.name}</label>
                    <span class="price">
                        <fmt:formatNumber value="${product.price}" type="number"/> VND
                    </span>

                    <form action="cart" method="post">
                        <input type="hidden" name="id" value="${product.id}"/>
                        <button type="submit" name="action" value="add" class="btn">Add to Cart</button>
                    </form>

                </div>

            </div>
        </c:forEach>


    </div>
</div>
</body>
</html>
