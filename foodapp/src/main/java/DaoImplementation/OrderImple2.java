package DaoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DaoInterface.Order2;
import domain.Order;

public class OrderImple2 implements Order2 {
	 private final String url = "jdbc:mysql://localhost:3306/zomato";
	    private final String uname = "root";
	    private final String password = "root";
	    private Connection conn;

	    public OrderImple2() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(url, uname, password);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (userId, restaurantId, orderDate, totalAmount, status, paymentmode) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getRestaurantId());
            ps.setDate(3, order.getOrderDate());
            ps.setInt(4, order.getTotalAmount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentmode());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                order.setOrderId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE orderId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getInt("restaurantId"),
                    rs.getDate("orderDate"),
                    rs.getInt("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentmode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE userId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getInt("restaurantId"),
                    rs.getDate("orderDate"),
                    rs.getInt("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentmode")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

	
}
