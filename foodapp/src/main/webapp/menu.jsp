<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #f8f9fa, #e3f2fd);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        h2 {
            text-align: center;
            margin-top: 30px;
            font-weight: bold;
            color: #343a40;
        }

        .card {
            width: 18rem;
            margin: 15px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            transition: transform 0.2s ease-in-out;
        }

        .card:hover {
            transform: scale(1.03);
        }

        .card-img-top {
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            height: 160px;
            object-fit: cover;
        }

        .card-title {
            color: #dc3545;
            font-size: 1.2rem;
            font-weight: 600;
        }

        .card-text {
            color: #333;
        }

        .add-btn {
            margin-top: 10px;
            width: 100%;
            background-color: #28a745;
            border: none;
            color: white;
            padding: 8px;
            border-radius: 5px;
            font-weight: bold;
        }

        .add-btn:hover {
            background-color: #218838;
        }

        .menu-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
    </style>
</head>
<body>

    <h2>Menu Items</h2>

    <div class="container mt-4">
   
    
        <c:if test="${not empty allMenu}">
            <div class="menu-grid">
                <c:forEach var="menu" items="${allMenu}">
                    <div class="card">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/${menu.imagepath}" alt="${menu.itemname}">
                        <div class="card-body">
                            <h5 class="card-title">${menu.itemname}</h5>
                            <p class="card-text">Price: ₹${menu.price}</p>
<p class="card-text"> Quantity: ${menu.quantity}</p>
                            <form method="post" action="addToCart">
                                <input type="hidden" name="menuId" value="${menu.menuId}" />
                                <input type="hidden" name="restaurantId" value="${menu.restaurantId}" />
                                <button type="submit" class="add-btn">Add to Cart</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>

        <c:if test="${empty allMenu}">
            <p class="text-center text-danger">No menu items available.</p>
        </c:if>
         <a href="home" style="text-decoration:none;">
    <button style="
        margin: 20px;
        padding: 10px 20px;
        background-color: #e23744;
        color: white;
        border: none;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
    ">← Back to Restaurants</button>
</a>
    </div>

</body>
</html>
