<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Shopping iPhone</title>
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    /* Header */
    .header {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 120px;
        background: linear-gradient(90deg, #00c6ff, #0072ff);
        color: white;
        font-size: 32px;
        font-weight: bold;
        letter-spacing: 3px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        text-transform: uppercase;
    }

    .header h1 {
        margin: 0;
    }

    /* Menu */
    .menu {
        list-style: none;
        display: flex;
        justify-content: center;
        background: #ffffff;
        padding: 12px 0;
        margin: 0;
        border-radius: 0 0 8px 8px;
        box-shadow: 0 3px 6px rgba(0,0,0,0.15);
    }

    .menu li {
        margin: 0 20px;
        list-style: none;
    }

    .menu li a {
        display: block;
        padding: 10px 18px;
        color: #0072ff;
        font-size: 18px;
        font-weight: 600;
        text-decoration: none;
        border-radius: 6px;
        transition: all 0.3s ease;
    }

    .menu li a:hover {
        background: #0072ff;
        color: white;
        transform: scale(1.05);
    }


</style>
<body>

<header class="header">
    <h1>Shopping iPhone</h1>
</header>

<nav>
    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/">Danh sách sản phẩm</a></li>
        <li><a href="${pageContext.request.contextPath}/add">Thêm mới sản phẩm</a></li>
        <li><a href="${pageContext.request.contextPath}/management">Chức năng quản lý</a></li>

    </ul>
</nav>


<c:if test="${not empty page}">
    <jsp:include page="${page}" />
</c:if>


</body>
</html>
