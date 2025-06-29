package DaoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import DaoInterface.RestaurantDao;
import domain.Restaurant;


public class RestaurantImp implements RestaurantDao {
	
	public RestaurantImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    // Database connection details
    private final String url = "jdbc:mysql://localhost:3306/zomato";
    private final String username = "root";
    private final String password = "root";

    // SQL queries
    private final String INSERT_RESTAURANT_QUERY = "INSERT INTO restaurants (restaurantid, restaurantname, location, ratings) VALUES (?, ?, ?, ?)";
    private final String UPDATE_RESTAURANT_QUERY = "UPDATE restaurants SET restaurantname=?, location=?, ratings=? WHERE restaurantid=?";
    private final String DELETE_RESTAURANT_QUERY = "DELETE FROM restaurants WHERE restaurantid=?";
    private final String SELECT_RESTAURANT_BY_ID_QUERY = "SELECT * FROM restaurants WHERE restaurantid=?";
    private final String SELECT_ALL_RESTAURANTS_QUERY = "SELECT * FROM restaurants";

    
    
    // Establishing database connection
       private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Save a restaurant to the database
    @Override
    public void save(Restaurant restaurant) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_RESTAURANT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, restaurant.getRestaurantId());
            stmt.setString(2, restaurant.getName());
            stmt.setString(3, restaurant.getAddress());
            stmt.setDouble(4, restaurant.getRating());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                restaurant.setRestaurantId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing restaurant in the database
    @Override
    public void update(Restaurant restaurant) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_RESTAURANT_QUERY)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getAddress());
            stmt.setDouble(3, restaurant.getRating());
            stmt.setInt(4, restaurant.getRestaurantId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a restaurant from the database
    @Override
    public void delete(Restaurant restaurant) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_RESTAURANT_QUERY)) {
            stmt.setInt(1, restaurant.getRestaurantId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a restaurant by its ID from the database
    @Override
    public Restaurant getRestaurant(int restaurantId) {
        Restaurant restaurant = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_RESTAURANT_BY_ID_QUERY)) {
            stmt.setInt(1, restaurantId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id=rs.getInt(1);
                    String name=rs.getString(2);
                    String address=rs.getString(3);  
                    Long phone=rs.getLong(4);
                    int rating=rs.getInt(5);
                    String cusine=rs.getString(6);
                    Boolean isactive=rs.getBoolean(7);
                    Date eta=rs.getDate(8);
                    int userid=rs.getInt(9);
                    String imagepath=rs.getString(10);
                     restaurant=new Restaurant(id, name, address, phone, 
                    		rating, cusine, isactive, eta, userid, imagepath);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    // Get all restaurants from the database
    @Override
    public List<Restaurant> getAllRestaurant() {
    	System.out.println(" resexecuted");
        List<Restaurant> restaurants = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_RESTAURANTS_QUERY)) {
            while (rs.next()) {
              
                		 int id=rs.getInt(1);
                         String name=rs.getString(2);
                         String address=rs.getString(3);  
                         Long phone=rs.getLong(4);
                         int rating=rs.getInt(5);
                         String cusine=rs.getString(6);
                         Boolean isactive=rs.getBoolean(7);
                         Date eta=rs.getDate(8);
                         int userid=rs.getInt(9);
                         String imagepath=rs.getString(10);
                Restaurant restaurant=new Restaurant(id, name, address, phone, 
                		rating, cusine, isactive, eta, userid, imagepath);
                restaurants.add(restaurant);
                System.out.println("executed"+restaurant.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }
}
