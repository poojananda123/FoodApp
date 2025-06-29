<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Order History</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        h2 {
            color: #007bff;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center mb-4">Order History</h2>
    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        if (orders != null && !orders.isEmpty()) {
    %>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Order ID</th>
                <th>Restaurant ID</th>
                <th>Amount (₹)</th>
                <th>Status</th>
                <th>Date</th>
                <th>Payment Mode</th>
            </tr>
        </thead>
        <tbody>
        <% for (Order o : orders) { %>
            <tr>
                <td><%= o.getOrderId() %></td>
                <td><%= o.getRestaurantId() %></td>
                <td>₹<%= o.getTotalAmount() %></td>
                <td><%= o.getStatus() %></td>
                <td><%= o.getOrderDate() %></td>
                <td><%= o.getPaymentmode() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
        <div class="alert alert-info text-center">You have no orders yet.</div>
    <% } %>
</div>

</body>
</html>
