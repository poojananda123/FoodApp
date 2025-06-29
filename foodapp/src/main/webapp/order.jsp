<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Summary</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: #f5f5f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            max-width: 750px;
            margin: 50px auto;
            background-color: #fff;
            padding: 35px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #28a745;
            font-weight: 600;
            margin-bottom: 30px;
        }

        .table td, .table th {
            vertical-align: middle;
        }

        .table th {
            width: 35%;
            background-color: #f8f9fa;
        }

        .summary-footer {
            margin-top: 30px;
            text-align: center;
        }

        .summary-footer a button {
            background-color: #dc3545;
            border: none;
            color: white;
            padding: 10px 30px;
            font-size: 16px;
            border-radius: 6px;
            font-weight: bold;
            transition: 0.3s ease;
        }

        .summary-footer a button:hover {
            background-color: #bd2130;
        }

        .badge-status {
            font-size: 0.95rem;
            padding: 5px 12px;
            border-radius: 12px;
            font-weight: 500;
        }

        .badge-confirmed {
            background-color: #28a745;
            color: #fff;
        }

        .badge-pending {
            background-color: #ffc107;
            color: #212529;
        }

        .badge-failed {
            background-color: #dc3545;
            color: #fff;
        }
    </style>
</head>
<body>

<%
    Order order = (Order) request.getAttribute("order");
    String address = (String) request.getAttribute("address");
    String city = (String) request.getAttribute("city");
    String zip = (String) request.getAttribute("zip");
%>

<div class="container">
    <h2>Thank You! Your Order is Confirmed</h2>

    <% if (order != null) { %>
        <table class="table table-bordered">
            <tbody>
                <tr>
                    <th>Order ID</th>
                    <td><%= order.getOrderId() %></td>
                </tr>
                <tr>
                    <th>User ID</th>
                    <td><%= order.getUserId() %></td>
                </tr>
                <tr>
                    <th>Restaurant Name</th>
                  
                   <td> <%= order.getRestaurantName() %></td>
                    
                </tr>
                <tr>
                    <th>Order Date</th>
                    <td><%= order.getOrderDate() %></td>
                </tr>
                <tr>
                    <th>Total Amount (₹)</th>
                    <td><strong>₹ <%= order.getTotalAmount() %></strong></td>
                </tr>
                <tr>
                    <th>Status</th>
                    <td>
                        <span class="badge-status 
                            <%= "Confirmed".equalsIgnoreCase(order.getStatus()) ? "badge-confirmed" :
                                 "Pending".equalsIgnoreCase(order.getStatus()) ? "badge-pending" : "badge-failed" %>">
                            <%= order.getStatus() %>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th>Payment Mode</th>
                    <td><%= order.getPaymentmode() %></td>
                </tr>
                <tr>
                    <th>Delivery Address</th>
                    <td><%= address %>, <%= city %> - <%= zip %></td>
                </tr>
            </tbody>
        </table>
    <% } else { %>
        <div class="alert alert-danger text-center">
            No order information found.
        </div>
    <% } %>

    <div class="summary-footer">
        <a href="home">
            <button>Return to Home</button>
        </a>
    </div>
</div>

</body>
</html>
