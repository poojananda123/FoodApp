package DaoImplementation;

import java.util.List;

import DaoInterface.OrderItemDao;
import domain.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OrderItemImp implements OrderItemDao {

	
	    
	  private final String url = "jdbc:mysql://localhost:3306/zomato";
	    private final String uname = "root";
	    private final String password = "root";
		private Connection connection;

	    	public OrderItemImp() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, uname, password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	    @Override
	    public void save(OrderItem orderItem) {
	        String query = "INSERT INTO orders_items (orderid, menuid, quantity, totalprice) VALUES (?, ?, ?, ?)";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderItem.getOrderId());
	            preparedStatement.setInt(2, orderItem.getMenuId());
	            preparedStatement.setInt(3, orderItem.getQuantity());
	            preparedStatement.setDouble(4, orderItem.getTotalPrice());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	    }

	    @Override
	    public void update(OrderItem orderItem) {
	        String query = "UPDATE orders_items SET orderid=?, menuid=?, quantity=?, totalprice=? WHERE orderitemid=?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderItem.getOrderId());
	            preparedStatement.setInt(2, orderItem.getMenuId());
	            preparedStatement.setInt(3, orderItem.getQuantity());
	            preparedStatement.setDouble(4, orderItem.getTotalPrice());
	            preparedStatement.setInt(5, orderItem.getOrderitemId());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	    }

	    @Override
	    public void delete(OrderItem orderItem) {
	        String query = "DELETE FROM orders_items WHERE orderitemid=?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderItem.getOrderitemId());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	    }

	    @Override
	    public OrderItem getUser(int orderItemId) {
	        String query = "SELECT * FROM orders_items WHERE orderitemid=?";
	        OrderItem orderItem = null;
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderItemId);
	            
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                  int orderitemid= resultSet.getInt(1);
	                  int orderid= resultSet.getInt(2);
	                  int menuid= resultSet.getInt(3);
	                  int quantity=resultSet.getInt(4);
	                  int totalprice =resultSet.getInt(5);
	                  orderItem=new OrderItem(orderitemid, orderid, menuid, quantity, totalprice);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	        
	        return orderItem;
	    }

	    @Override
	    public List<OrderItem> getAllUser() {
	        String query = "SELECT * FROM orders_items";
	        List<OrderItem> orderItemList = new ArrayList<>();
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	            	 int orderitemid= resultSet.getInt(1);
	                  int orderid= resultSet.getInt(2);
	                  int menuid= resultSet.getInt(3);
	                  int quantity=resultSet.getInt(4);
	                  int totalprice =resultSet.getInt(5);
	                  OrderItem orderItem = new OrderItem(orderitemid, orderid, menuid, quantity, totalprice);
	                orderItemList.add(orderItem);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	        
	        return orderItemList;
	    }
	}



