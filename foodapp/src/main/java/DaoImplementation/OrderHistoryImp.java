package DaoImplementation;

import java.util.List;

import DaoInterface.OrderHistoryDao;
import domain.OrderHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public  class OrderHistoryImp implements OrderHistoryDao {

	    
	  private final String url = "jdbc:mysql://localhost:3306/zomato";
	    private final String uname = "root";
	    private final String password = "root";
		private Connection connection;

	    	public OrderHistoryImp() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, uname, password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	   

	    public void save(OrderHistory orderHistory) {
	        String query = "INSERT INTO orderhistory (orderhistoryId,userId,orderId,orderDate,totalAmount,status) VALUES (?,?,?,?,?,?)";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderHistory.getOrderhistoryId());
	            preparedStatement.setInt(2, orderHistory.getUserId());
	            preparedStatement.setInt(3, orderHistory.getOrderId());
	            preparedStatement.setTimestamp(4, orderHistory.getOrderDate());
	            preparedStatement.setDouble(5, orderHistory.getTotalAmount());
	            preparedStatement.setString(6, orderHistory.getStatus());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	    }

	    public void update(OrderHistory orderHistory) {
	        String query = "UPDATE orderhistory SET userid=?, orderid=?, orderdate=?, totalamount=?, status=? WHERE orderhistoryid=?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderHistory.getUserId());
	            preparedStatement.setInt(2, orderHistory.getOrderId());
	            preparedStatement.setTimestamp(3, orderHistory.getOrderDate());
	            preparedStatement.setDouble(4, orderHistory.getTotalAmount());
	            preparedStatement.setString(5, orderHistory.getStatus());
	            preparedStatement.setInt(6, orderHistory.getOrderhistoryId());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	    }

	    public void delete(OrderHistory orderHistory) {
	        String query = "DELETE FROM order_history WHERE orderhistoryid=?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderHistory.getOrderhistoryId());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	    }

	    @Override
	    public OrderHistory getUser(int orderHistoryId) {
	        String query = "SELECT * FROM order_history WHERE orderhistoryid=?";
	        OrderHistory orderHistory = null;
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, orderHistoryId);
	            
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                 int historyorderid=  resultSet.getInt(1);
	                 int userid=  resultSet.getInt(2);
	                 int orderid=  resultSet.getInt(3);
	                 String orderdate=  resultSet.getString(4);
	                 int amount=  resultSet.getInt(5);
	                 String status=  resultSet.getString(6);
	                 orderHistory=new OrderHistory(orderHistoryId, userid, orderid, null, amount, status);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	        
	        return orderHistory;
	    }

	    @Override
	    public List<OrderHistory> getAllUser() {
	        String query = "SELECT * FROM order_history";
	        List<OrderHistory> orderHistoryList = new ArrayList<>();
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	            	
		                 int historyorderid=  resultSet.getInt(1);
		                 int userid=  resultSet.getInt(2);
		                 int orderid=  resultSet.getInt(3);
		                 String orderdate=  resultSet.getString(4);
		                 int amount=  resultSet.getInt(5);
		                 String status=  resultSet.getString(6);
		                 OrderHistory orderHistory = new OrderHistory(historyorderid, userid, orderid, null, amount, status);
	                orderHistoryList.add(orderHistory);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	        
	        return orderHistoryList;
	    }


		@Override
		public void save(OrderHistoryDao orderhistory) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void update(OrderHistoryDao orderhistory) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void delete(OrderHistoryDao orderhistory) {
			// TODO Auto-generated method stub
			
		}

		
	}


