<%@ page import="domain.Restaurant, java.util.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Restaurant Cards</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"> <!-- Bootstrap Icons -->

    <style>
        body {
            background: linear-gradient(135deg, #f8f9fa, #e3f2fd);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .card {
            display: inline-block;
            width: 18rem;
            margin-right: 20px;
            margin-bottom: 30px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 12px;
            overflow: hidden;
            transition: transform 0.2s ease;
            cursor: pointer;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card-img-top {
            height: 200px;
            object-fit: cover;
        }

        .nav {
            background-color: whitesmoke;
            display: flex;
            height: 50px;
            align-items: center;
            justify-content: flex-end;
            padding-right: 20px;
        }

        .nav-items a {
            font-weight: bold;
            color: black;
            padding: 10px;
            text-decoration: none;
        }

        .nav-items a:hover {
            color: #007bff;
        }
    </style>
</head>
<body>

<div class="nav">
    <c:if test="${user==null}">
        <div class="nav-items">
            <a href="Register.html">Register</a>
        </div>
        <div class="nav-items">
            <a href="login1.jsp">Login</a>
        </div>
    </c:if>
    <c:if test="${user!=null}">
        <div class="nav-items">
            <a href="login1.jsp">Logout</a>
        </div>
        <div class="nav-items">
            <a href="cart">Cart</a>
        </div>
        <div class="nav-items">
            <a href="order-history">
    order-history
</a>
        </div>
    </c:if>
</div>

<br><br><br>

<div class="container">
    <c:forEach var="restaurant" items="${allRestaurant}">
        <div class="card">
            <a href="menu?restaurantId=<c:out value='${restaurant.restaurantId}'/>">
                <img src="${restaurant.imageUrl}" class="card-img-top" alt="Restaurant Image">
                <div class="card-body">
                    <h5 class="card-title text-danger fw-bold"><c:out value="${restaurant.name}" /></h5>
                    <p class="card-text text-muted mb-1">
                        <i class="bi bi-geo-alt-fill text-primary"></i>
                        <small><c:out value="${restaurant.address}" /></small>
                        
                    </p>
                    <p class="card-text text-secondary mb-1">
    <i class="bi bi-list-ul text-success"></i>
    <small><strong>Cuisine:</strong> <c:out value="${restaurant.cuisine}" /></small>
</p>
                    
                    <p class="card-text mb-1">
                        Rating:
                        <c:forEach begin="1" end="5" var="i">
                            <c:choose>
                                <c:when test="${i <= restaurant.rating}">
                                    <span style="color: gold;">&#9733;</span>
                                </c:when>
                                
                                <c:otherwise>
                                    <span style="color: lightgray;">&#9734;</span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </p>
                </div>
            </a>
        </div>
    </c:forEach>
</div>

</body>
</html>
