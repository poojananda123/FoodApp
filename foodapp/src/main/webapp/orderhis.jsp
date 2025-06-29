<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Order" %>
<%
    List<Order> orders = (List<Order>) request.getAttribute("orders");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            margin-top: 40px;
            max-width: 920px;
        }

        h2 {
            font-weight: 600;
            margin-bottom: 30px;
        }

        .order-card {
            background: #ffffff;
            border-radius: 12px;
            padding: 20px 25px;
            margin-bottom: 25px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.06);
            transition: 0.2s ease-in-out;
        }

        .order-card:hover {
            transform: scale(1.01);
        }

        .order-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }

        .badge-status {
            font-size: 0.9rem;
            padding: 6px 14px;
            border-radius: 20px;
            font-weight: 600;
        }

        .badge-confirmed { background-color: #28a745; color: white; }
        .badge-pending   { background-color: #ffc107; color: #212529; }
        .badge-failed    { background-color: #dc3545; color: white; }

        .order-details p {
            margin: 5px 0;
        }

        .no-orders {
            text-align: center;
            padding: 60px;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
        }

        .btn-home {
            background-color: #007bff;
            color: white;
            padding: 10px 30px;
            border: none;
            border-radius: 30px;
            font-weight: 600;
            transition: 0.3s ease;
        }

        .btn-home:hover {
            background-color: #0056b3;
        }

        .delete-form {
            margin-top: 30px;
            padding: 20px;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
        }

        .delete-form input[type="number"] {
            margin: 10px 10px 10px 0;
            padding: 8px 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        .delete-form button {
            padding: 8px 25px;
            background-color: #dc3545;
            border: none;
            color: white;
            border-radius: 8px;
            font-weight: 600;
            transition: 0.3s ease;
        }

        .delete-form button:hover {
            background-color: #bd2130;
        }

        .actions {
            text-align: center;
            margin-top: 40px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center text-primary">Your Order History</h2>

  <% 
    if (orders != null && !orders.isEmpty()) {
        int displayId = 1;
        for (Order order : orders) {
            String badgeClass = "badge-status ";
            if ("Confirmed".equalsIgnoreCase(order.getStatus())) {
                badgeClass += "badge-confirmed";
            } else if ("Pending".equalsIgnoreCase(order.getStatus())) {
                badgeClass += "badge-pending";
            } else {
                badgeClass += "badge-failed";
            }
%>
    <div class="order-card">
        <div class="order-header">
            <h5>Order #<%= displayId++ %></h5> <!-- ✅ Per-user order ID shown -->
            <span class="<%= badgeClass %>"><%= order.getStatus() %></span>
        </div>
        <div class="order-details">
            <p><strong>Restaurant ID:</strong> <%= order.getRestaurantName() %></p>
            <p><strong>Order Date:</strong> <%= order.getOrderDate() %></p>
            <p><strong>Total Amount:</strong> ₹<%= order.getTotalAmount() %></p>
            <p><strong>Payment Mode:</strong> <%= order.getPaymentmode() %></p>
        </div>
        <form action="delete-orders-range" method="post" style="display:inline;">
    <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
    <button type="submit" class="btn btn-sm btn-danger mt-2">Delete</button>
</form>
    </div>
<% 
        } 
    } else { 
%>

        <div class="no-orders">
            <h4>No Orders Found</h4>
            <p>You haven't placed any orders yet.</p>
        </div>
    <% } %>

    <div class="actions">
        <a href="home"><button class="btn-home">← Return to Home</button></a>
    </div>

   

</div>

</body>
</html>
