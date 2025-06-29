package DaoImplementation;

import domain.Users;

import java.sql.*;

public class UserImp {

    // JDBC connection method
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/zomato"; // Replace 'zomato' with your DB name if different
        String user = "root"; // your DB username
        String pass = "root"; // your DB password
        return DriverManager.getConnection(url, user, pass);
    }

    // Save user
    public boolean saveUser(Users user) {
        boolean saved = false;
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO users(Name, Username, Password, Email, Phone, Address, Role, CreateDate) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getRole());

            int rows = ps.executeUpdate();
            saved = rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    // Fetch user by encrypted username & password
    public Users getUsers(String username, String password) {
        Users user = null;
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM users WHERE Username = ? AND Password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new Users();
                user.setUserId(rs.getInt("UserID"));
                user.setName(rs.getString("Name"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setRole(rs.getString("Role"));
                user.setCreateDate(rs.getTimestamp("CreateDate"));
                user.setLoginDate(rs.getTimestamp("LoginDate")); // nullable
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
