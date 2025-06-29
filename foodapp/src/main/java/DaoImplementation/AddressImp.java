package DaoImplementation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Address;
public class AddressImp {
	private final String url = "jdbc:mysql://localhost:3306/zomato";
    private final String uname = "root";
    private final String password = "root";
	private Connection connection;
	public AddressImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, uname, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
		

	public int saveAddress(Address addr) {
	    int addressId = -1;
	    try {
	    	String sql = "INSERT INTO address (address, city, zipCode, userId) VALUES (?, ?, ?, ?)";

	       
	        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, addr.getAddress());
	        stmt.setString(2, addr.getCity());
	        stmt.setString(3, addr.getZip());
	        stmt.setInt(4, addr.getUserId());

	        int rows = stmt.executeUpdate();
	        if (rows > 0) {
	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                addressId = rs.getInt(1); // this is the generated addressId
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return addressId;
	}
}


