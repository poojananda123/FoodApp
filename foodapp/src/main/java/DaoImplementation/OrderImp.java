package DaoImplementation;

import DaoInterface.OrderDao;
import domain.Order;
import java.sql.*;
import java.util.*;

public class OrderImp implements OrderDao {

    private Connection conn;

    public OrderImp() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zomato", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void saveOrder(Order order) {
//        String sql = "INSERT INTO orders (UserId, RestaurantId, OrderDate, TotalAmount, Status, Paymentmode, addressId,restaurantName) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
//
//            ps.setInt(1, order.getUserId());
//            ps.setInt(2, order.getRestaurantId());
//            ps.setDate(3, order.getOrderDate());
//            ps.setInt(4, order.getTotalAmount());
//            ps.setString(5, order.getStatus());
//            ps.setString(6, order.getPaymentmode());
//            ps.setInt(7, order.getAddressId());
//ps.setString(8, order.getRestaurantName());
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                ResultSet rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    int generatedId = rs.getInt(1);
//                    order.setOrderId(generatedId); // ✅ Important
//                    System.out.println("Generated orderId = " + generatedId);
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void saveOrder(Order order) {
        try {
            // 1. Fetch restaurant name
            String fetchSql = "SELECT Name FROM restaurants WHERE restaurantId = ?";
            try (PreparedStatement fetchStmt = conn.prepareStatement(fetchSql)) {
                fetchStmt.setInt(1, order.getRestaurantId());
                try (ResultSet rs = fetchStmt.executeQuery()) {
                    if (rs.next()) {
                        order.setRestaurantName(rs.getString("Name"));
                    } else {
                        order.setRestaurantName("Unknown");
                    }
                }
            }

            // 2. Insert order including restaurantName
            String sql = "INSERT INTO orders (UserId, RestaurantId, OrderDate, TotalAmount, Status, Paymentmode, addressId, restaurantName) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getUserId());
                ps.setInt(2, order.getRestaurantId());
                ps.setDate(3, order.getOrderDate());
                ps.setInt(4, order.getTotalAmount());
                ps.setString(5, order.getStatus());
                ps.setString(6, order.getPaymentmode());
                ps.setInt(7, order.getAddressId());
                ps.setString(8, order.getRestaurantName());

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    try (ResultSet keys = ps.getGeneratedKeys()) {
                        if (keys.next()) {
                            order.setOrderId(keys.getInt(1));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> list = new ArrayList<>();
        try {
        	String sql = "select * from orders where UserId=?";
        			

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setRestaurantId(rs.getInt("restaurantId"));
                order.setRestaurantName(rs.getString("restaurantName")); // <-- Add this
                order.setOrderDate(rs.getDate("orderDate"));
                order.setTotalAmount(rs.getInt("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setPaymentmode(rs.getString("paymentmode"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
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
                    rs.getInt("TotalAmount"),
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
	public boolean deleteOrderById(int orderId) {
	    boolean deleted = false;
	    String sql = "DELETE FROM orders WHERE orderId = ?";

	    try {
	         PreparedStatement ps = conn.prepareStatement(sql); 
	        ps.setInt(1, orderId);
	        deleted = ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return deleted;
	}



	@Override
	public void deleteOrdersInRange(int startId, int endId) {
		// TODO Auto-generated method stub
		try {
	        String sql = "DELETE FROM orders WHERE OrderId BETWEEN ? AND ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, startId);
	        stmt.setInt(2, endId);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
