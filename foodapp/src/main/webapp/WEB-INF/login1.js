// script.js
resp.get
document.getElementById('login-form').addEventListener('submit', function(e) {
    e.preventDefault();
    // Perform login validation here
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    // Example validation: check if username and password are not empty
    if (username.trim() === '' || password.trim() === '') {
        alert('Please enter both username and password');
    } else {
        
        alert('Login successful!');
    }
});

document.getElementById('register-link').addEventListener('click', function(e) {
    e.preventDefault();
    document.getElementById('overlay').style.display = 'flex';
});

document.getElementById('close-popup').addEventListener('click', function() {
    document.getElementById('overlay').style.display = 'none';
});
