package DaoImplementation;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import DaoInterface.CartDAO;
//import domain.Cartitem;
//import domain.Menu;
//
//public class CartImp implements CartDAO {
//
//
//		  private final String url = "jdbc:mysql://localhost:3306/zomato";
//		    private final String uname = "root";
//		    private final String password = "root";
//			private Connection connection;
//			private Menu getAllMenu;
//
//		    	public CartImp() {
//					try {
//						Class.forName("com.mysql.cj.jdbc.Driver");
//					connection = DriverManager.getConnection(url, uname, password);
//					} catch (ClassNotFoundException | SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				
//	}
//
//				@Override
//				public void saveCartItem(Cartitem cartitem) {
//					 String query = "INSERT INTO cartitems (itemid, itemname, quantity, price, userId, menuId, restaurantId,restaurantName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//				        try (PreparedStatement statement = connection.prepareStatement(query)) {
//				            statement.setInt(1, cartitem.getItemid());
//				            statement.setString(2,cartitem.getItemname());
//				            statement.setInt(3, cartitem.getQuantity());
//				            statement.setInt(4, cartitem.getPrice());
//				            statement.setInt(5, cartitem.getUserId());
//				            statement.setInt(6, cartitem.getMenuId());
//				            statement.setInt(7, cartitem.getRestaurantId());
//				            statement.setString(8,cartitem.getRestaurantName());
//				            statement.executeUpdate();
//				        } catch (SQLException e) {
//				            e.printStackTrace();
//				            // Handle exception appropriately (e.g., log, throw custom exception)
//				        }
//					
//				}
//
//				@Override
//				public Cartitem getCartItemByMenuId(int id) {
//					 Cartitem cartitem = null;
//				        String query = "SELECT * FROM cartitems WHERE menuId=?";
//				        try (PreparedStatement statement = connection.prepareStatement(query)) {
//				            statement.setInt(1, id);
//				            try (ResultSet resultSet = statement.executeQuery()) {
//				                while (resultSet.next()) {
//				                    int itemid = resultSet.getInt(1);
//				                    String itemname = resultSet.getString(2);
//				                    int quantity = resultSet.getInt(3);
//				                    int price = resultSet.getInt(4);
//				                    int userId = resultSet.getInt(5);
//				                    int menuId = resultSet.getInt(6);
//				                    int restaurantId = resultSet.getInt(7);
//				                    String restaurantName = resultSet.getString(8);
//				                    cartitem= new Cartitem(itemid, itemname, quantity, price, userId, menuId, restaurantId,restaurantName);
//				                   
//				                    System.out.println("executed"+cartitem.toString());
//				                }
//				            }
//				        } catch (SQLException e) {
//				            e.printStackTrace();
//				            // Handle exception appropriately (e.g., log, throw custom exception)
//				        }
//				        return cartitem;
//				        
//				}
//
//				@Override
//				public void updateCartItem(Cartitem cartitem) {
//					 String query = "UPDATE cartitems SET itemname=?, quantity=?, price=?, userId=?, menuId=?, restaurantId=?,restaurantName=? WHERE itemid=?";
//				        try (PreparedStatement statement = connection.prepareStatement(query)) {
////				        	  statement.setInt(1, cartitem.getItemid());
//				        	
//					            statement.setString(1,cartitem.getItemname());
//					            statement.setInt(2, cartitem.getQuantity());
//					            statement.setInt(3, cartitem.getPrice());
//					            statement.setInt(4, cartitem.getUserId());
//					            statement.setInt(5, cartitem.getMenuId());
//					            statement.setInt(6, cartitem.getRestaurantId());
//					            statement.setString(7,cartitem.getRestaurantName());
//					            statement.setInt(8, cartitem.getItemid());
//				            statement.executeUpdate();
//				        } catch (SQLException e) {
//				            e.printStackTrace();
//				            // Handle exception appropriately (e.g., log, throw custom exception)
//				        }
//					
//				}
//
////				@Override
////				public List<Cartitem> getCartItemsByUserId(int id) {
////					 Cartitem cartitem = null;
////					 ArrayList<Cartitem> cartItemList=new ArrayList<Cartitem>();
////				        String query = "SELECT * FROM cartitems WHERE userId=?";
////				        try (PreparedStatement statement = connection.prepareStatement(query)) {
////				            statement.setInt(1, id);
////				            try (ResultSet resultSet = statement.executeQuery()) {
////				                while (resultSet.next()) {
////				                    int itemid = resultSet.getInt(1);
////				                    String itemname = resultSet.getString(2);
////				                    int quantity = resultSet.getInt(3);
////				                    int price = resultSet.getInt(4);
////				                    int userId = resultSet.getInt(5);
////				                    int menuId = resultSet.getInt(6);
////				                    int restaurantId = resultSet.getInt(7);
////				                    String restaurantName = resultSet.getString(8);
////				                    cartitem= new Cartitem(itemid, itemname, quantity, price, userId, menuId, restaurantId,restaurantName);
////				                    cartItemList.add(cartitem);
////				                    System.out.println("executed"+cartitem.toString());
////				                }
////				            }
////				        } catch (SQLException e) {
////				            e.printStackTrace();
////				            // Handle exception appropriately (e.g., log, throw custom exception)
////				        }
////				        return cartItemList;
////				}
//				
//				   
//
//				public void deleteCartItemById(Object cartId) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public List<Cartitem> getCartItemsByUserId(int id) {
//					Cartitem item = null;
//				    try {
//				        
//				        String sql = "SELECT * FROM cartitems WHERE menu_id = ? AND user_id = ?";
//				        PreparedStatement ps = connection.prepareStatement(sql);
//				        
//						ps.setInt(1, MenuId);
//				        ps.setInt(2, UserId);
//				        ResultSet rs = ps.executeQuery();
//
//				        if (rs.next()) {
//				            item = new Cartitem(
//				                rs.getInt("cart_id"),
//				                rs.getString("itemname"),
//				                rs.getInt("quantity"),
//				                rs.getDouble("price"),
//				                rs.getInt("user_id"),
//				                rs.getInt("menu_id"),
//				                rs.getInt("restaurant_id"),
//				                rs.getString("restaurant_name")
//				            );
//				        }
//
//				    } catch (Exception e) {
//				        e.printStackTrace();
//				    }
//				    return item;
//				}
//				
//
//}







import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DaoInterface.CartDAO;
import domain.Cartitem;

public class CartImp implements CartDAO {

    private final String url = "jdbc:mysql://localhost:3306/zomato";
    private final String uname = "root";
    private final String password = "root";
    private Connection connection;

    public CartImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, uname, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCartItem(Cartitem cartitem) {
        String query = "INSERT INTO cartitems (ItemId, ItemName, Quantity, Price, UserId, MenuId, RestaurantId, RestaurantName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cartitem.getItemid());
            statement.setString(2, cartitem.getItemname());
            statement.setInt(3, cartitem.getQuantity());
            statement.setDouble(4, cartitem.getPrice());
            statement.setInt(5, cartitem.getUserId());
            statement.setInt(6, cartitem.getMenuId());
            statement.setInt(7, cartitem.getRestaurantId());
            statement.setString(8, cartitem. getRestaurantName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cartitem getCartItemByMenuIdAndUserId(int menuId, int userId ,int restaurantId) {
        Cartitem item = null;
        try {
        	String sql = "SELECT * FROM cartitems WHERE MenuId = ? AND UserId = ? AND RestaurantId = ?";

             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setInt(1, menuId);
             ps.setInt(2, userId);
             ps.setInt(3, restaurantId);
             ResultSet rs = ps.executeQuery();

             if (rs.next()) {
                 item = new Cartitem();
                 item.setCartId(rs.getInt("ItemId")); // ✅ Important
                 item.setUserId(rs.getInt("UserId"));
                 item.setMenuId(rs.getInt("MenuId"));
                 item.setItemname(rs.getString("itemname"));
                 item.setPrice(rs.getDouble("price"));
                 item.setQuantity(rs.getInt("Quantity"));
                 item.setRestaurantId(rs.getInt("restaurantId"));
                 item.setRestaurantName(rs.getString("restaurantName"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return item;
    }


    public List<Cartitem> getCartItemsByUserId(int userId) {
        List<Cartitem> cartItems = new ArrayList<>();
       
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // your DB connection method

            // ✅ Make sure to JOIN with restaurants table to get the name
        	 String sql = "SELECT c.ItemId, c.userId, c.menuId, c.Quantity, " +
                     "m.itemname, m.price, m.restaurantId, r.name AS restaurantName " +
                     "FROM cartitems c " +
                     "JOIN menus m ON c.menuId = m.menuId " +
                     "JOIN restaurants r ON m.restaurantId = r.restaurantId " +
                     "WHERE c.userId = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, userId);
 rs = stmt.executeQuery();
        while (rs.next()) {
            Cartitem item = new Cartitem();
            item.setCartId(rs.getInt("ItemId"));
            item.setUserId(rs.getInt("userId"));
            item.setMenuId(rs.getInt("menuId"));
            item.setQuantity(rs.getInt("Quantity"));
            item.setItemname(rs.getString("itemname"));
            item.setPrice(rs.getDouble("price"));
            item.setRestaurantId(rs.getInt("restaurantId"));
            item.setRestaurantName(rs.getString("restaurantName")); // ✅ This line is critical!

            cartItems.add(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return cartItems;
    }



    @Override
    public void updateCartItem(Cartitem cartitem) {
        String query = "UPDATE cartitems SET ItemName=?, Quantity=?, price=?, UserId=?, MenuId=?, RestaurantId=?, RestaurantName=? WHERE ItemId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cartitem.getItemname());
            statement.setInt(2, cartitem.getQuantity());
            statement.setDouble(3, cartitem.getPrice());
            statement.setInt(4, cartitem.getUserId());
            statement.setInt(5, cartitem.getMenuId());
            statement.setInt(6, cartitem.getRestaurantId());
            statement.setString(7, cartitem.getRestaurantName());
            statement.setInt(8, cartitem.getItemid());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartItemById(Object cartId) {
        String query = "DELETE FROM cartitems WHERE Itemid=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, (int) cartId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void addToCart(Cartitem newItem) {
		// TODO Auto-generated method stub
		    try {
		         PreparedStatement ps = connection.prepareStatement("INSERT INTO cartitems (menuId, userId, quantity, price) VALUES (?, ?, ?, ?)"); {
		        Cartitem item = null;
				ps.setInt(1, item.getMenuId());
		        ps.setInt(2, item.getUserId());
		        ps.setInt(3, item.getQuantity());
		        ps.setDouble(4, item.getPrice());
		        ps.executeUpdate();
		    } }catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		



	@Override
	public Cartitem getCartItemByMenuId(int menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getMenuPriceById(int menuId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cartitem getCartItemByMenuIdAndUserId(int menuId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
