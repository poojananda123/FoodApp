<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - FoodApp</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        background: url('foodappimg/log2.jpg') no-repeat center center fixed;
        background-size: cover;
    }

    .login-container {
        background-color: rgba(255, 255, 255, 0.95);
        width: 350px;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.3);
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    h2 {
        text-align: center;
        color: #e23744;
        margin-bottom: 20px;
    }

    .input-group {
        margin-bottom: 20px;
    }

    .input-group label {
        display: block;
        font-weight: 500;
        margin-bottom: 6px;
    }

    .input-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-sizing: border-box;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #e23744;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #c2182b;
    }

    a {
        display: block;
        margin-top: 15px;
        text-align: center;
        color: #333;
        text-decoration: none;
        font-size: 14px;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form action="log" method="post">
        <div class="input-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit">Login</button>
        <a href="Register.html">Don't have an account? Register</a>
    </form>
</div>

</body>
</html>
