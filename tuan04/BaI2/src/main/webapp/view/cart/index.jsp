<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>My Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin: 20px 0;
            color: #333;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
            background: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #fafafa;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .qty-btn {
            padding: 6px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 0 4px;
            font-size: 14px;
        }

        .btn-plus {
            background: #4CAF50;
            color: white;
        }

        .btn-minus {
            background: #e74c3c;
            color: white;
        }

        .btn-delete {
            background: #ff9800;
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-checkout {
            display: block;
            width: 220px;
            margin: 20px auto;
            background: #2196F3;
            color: white;
            text-align: center;
            padding: 14px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
        }

        .total-container {
            width: 80%;
            margin: 20px auto;
            text-align: right;
        }

        .total-container h2 {
            color: #e74c3c;
            font-size: 24px;
        }
    </style>
</head>
<body>
<h1>🛒 My Cart</h1>

<c:set var="total" value="0" scope="page"/>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Price (VND)</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="itemCart" items="${cart}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${itemCart.product.name}</td>
            <td><fmt:formatNumber value="${itemCart.product.price}" type="number" groupingUsed="true"/> VND</td>
            <td>
                <form action="cart" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${itemCart.product.id}"/>
                    <button type="submit" name="action" value="decrease" class="qty-btn btn-minus">-</button>
                </form>
                    ${itemCart.quantity}
                <form action="cart" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${itemCart.product.id}"/>
                    <button type="submit" name="action" value="increase" class="qty-btn btn-plus">+</button>
                </form>
            </td>
            <td>
                <fmt:formatNumber value="${itemCart.quantity * itemCart.product.price}" type="number" groupingUsed="true"/> VND
            </td>
            <td>
                <form action="cart" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${itemCart.product.id}"/>
                    <button type="submit" name="action" value="delete" class="btn-delete">🗑 Remove</button>
                </form>
            </td>
        </tr>
        <c:set var="total" value="${total + (itemCart.quantity * itemCart.product.price)}" scope="page"/>
    </c:forEach>
    </tbody>
</table>

<div class="total-container">
    <h2>TOTAL: <fmt:formatNumber value="${total}" type="number" groupingUsed="true"/> VND</h2>
</div>

<a href="products" class="btn-checkout">Continue to Shopping</a>

</body>
</html>
