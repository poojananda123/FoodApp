<%@ page import="java.util.*" %>
<%@ page import="domain.Cartitem" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart - FoodApp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 1000px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 25px rgba(0, 0, 0, 0.05);
        }

        h2 {
            text-align: center;
            color: #dc3545;
            font-weight: bold;
            margin-bottom: 30px;
        }

        table th {
            background-color: #dc3545;
            color: white;
        }

        table td, table th {
            vertical-align: middle !important;
        }

        .btn-sm {
            font-size: 0.85rem;
            padding: 5px 10px;
            font-weight: 500;
        }

        .total {
            text-align: right;
            font-size: 1.3rem;
            font-weight: bold;
            color: #343a40;
        }

        .add-more, .checkout-btn {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 25px;
        }

        .empty {
            text-align: center;
            color: #6c757d;
            font-size: 1.3rem;
        }

        .empty a button {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Your Cart</h2>

    <%
        List<Cartitem> cartItems = (List<Cartitem>) request.getAttribute("cartItemList");
        Double totalPrice = (Double) request.getAttribute("totalPrice");
        int restaurantId = 0;

        if (cartItems != null && !cartItems.isEmpty()) {
            restaurantId = cartItems.get(0).getRestaurantId();
    %>

    <table class="table table-hover text-center align-middle">
        <thead>
        <tr>
            <th>Restaurant</th>
            <th>Item</th>
            <th>Price (₹)</th>
            <th>Quantity</th>
            <th>Total (₹)</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Cartitem item : cartItems) { %>
        <tr>
            <td><%= item.getRestaurantName() %></td>
            <td><strong><%= item.getItemname() %></strong></td>
            <td>₹<%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td>₹<%= item.getPrice() * item.getQuantity() %></td>
            <td class="actions">
                <form action="add-to-cart" method="get" style="display:inline;">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>" />
                    <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>" />
                    <input type="hidden" name="action" value="add" />
                    <button type="submit" class="btn btn-sm btn-success">+</button>
                </form>

                <form action="add-to-cart" method="get" style="display:inline;">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>" />
                    <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>" />
                    <input type="hidden" name="action" value="remove" />
                    <button type="submit" class="btn btn-sm btn-danger">-</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <div class="total">Total: ₹ <%= totalPrice %></div>

    <div class="add-more">
        <button class="btn btn-outline-secondary" onclick="window.location.href='<%= request.getContextPath() %>/menu?restaurantId=<%= restaurantId %>'">
            ← Add More Items
        </button>

        <form action="checkout" method="post">
            <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
            <input type="hidden" name="totalAmount" value="<%= totalPrice != null ? totalPrice : 0.0 %>">
            <button type="submit" class="btn btn-primary">Checkout</button>
        </form>
    </div>

    <% } else { %>
    <div class="empty">
        <p>Your cart is empty.</p>
        <a href="home"><button class="btn btn-danger">Browse Restaurants</button></a>
    </div>
    <% } %>

</div>

</body>
</html>
