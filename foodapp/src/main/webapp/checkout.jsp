<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f7f7f7;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            margin-top: 60px;
            max-width: 700px;
            background: #fff;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }

        h2 {
            color: #dc3545;
            margin-bottom: 25px;
            font-weight: bold;
            text-align: center;
        }

        .form-group label {
            font-weight: 500;
        }

        .payment-method {
            padding: 15px;
            border-radius: 6px;
            background-color: #f8f9fa;
            margin-top: 25px;
        }

        .total-price {
            font-size: 1.3rem;
            font-weight: bold;
            color: #343a40;
            margin-top: 20px;
            text-align: right;
        }

        .btn-checkout {
            width: 100%;
            background-color: #dc3545;
            border: none;
            padding: 12px;
            font-weight: bold;
            font-size: 1rem;
            color: white;
            border-radius: 6px;
            margin-top: 25px;
        }

        .btn-checkout:hover {
            background-color: #c82333;
        }

    </style>
</head>
<body>

<div class="container">
    <h2>Checkout</h2>

    <form action="place-order" method="post">
        <input type="hidden" name="restaurantId" value="${param.restaurantId}" />
        <input type="hidden" name="totalAmount" value="${param.totalAmount}" />

        <!-- Address -->
        <div class="form-group">
            <label for="address">Delivery Address</label>
            <textarea class="form-control" id="address" name="address" rows="3" required></textarea>
        </div>

        <!-- City -->
        <div class="form-group">
            <label for="city">City</label>
            <select class="form-control" id="city" name="city" required>
                <option value="">Select your city</option>
                <option>Bangalore</option>
                <option>Chennai</option>
                <option>Hyderabad</option>
            </select>
        </div>

        <!-- Zip -->
        <div class="form-group">
            <label for="zip">Zip Code</label>
            <select class="form-control" id="zip" name="zip" required>
                <option value="">Select zip code</option>
                <option>560021</option>
                <option>125647</option>
                <option>646425</option>
            </select>
        </div>

        <!-- Payment Mode -->
        <div class="payment-method">
            <h5>Payment Method</h5>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="paymentMode" id="cod" value="Cash on Delivery" checked>
                <label class="form-check-label" for="cod">Cash on Delivery</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="paymentMode" id="upi" value="UPI">
                <label class="form-check-label" for="upi">UPI / Netbanking</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="paymentMode" id="card" value="Card">
                <label class="form-check-label" for="card">Credit / Debit Card</label>
            </div>
        </div>

        <!-- Total Price -->
        <div class="total-price">
            Total Price: ₹ <strong><%= request.getAttribute("parameter2") %></strong>
        </div>
        <input type="hidden" name="totalAmount" value="<%= request.getAttribute("parameter2") %>">

        <!-- Submit Button -->
        <button type="submit" class="btn btn-checkout">Place Order</button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
