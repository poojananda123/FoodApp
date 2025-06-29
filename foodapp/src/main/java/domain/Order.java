package domain;

import java.sql.Date;

public class Order {

	private int orderId;
	private int userId;
	private String restaurantName;
	public Order(int orderId, int userId, String restaurantName, int restaurantId, Date orderDate, int totalAmount,
			int addressId, String status, String paymentmode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantName = restaurantName;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		TotalAmount = totalAmount;
		this.addressId = addressId;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	private int restaurantId;
	private Date orderDate;
	private int TotalAmount;
	 private int addressId;
	public Order(int orderId, int userId, int restaurantId, Date orderDate, int totalAmount, String status,
			String paymentmode, int addressId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		TotalAmount = totalAmount;
		this.status = status;
		this.paymentmode = paymentmode;
		this.addressId = addressId;
	}
	private String status;
	private String paymentmode;

	public int getAddressId() {
		return addressId;
	}
	public Order() {
		
	}
	public Order(int orderId, int userId, int restaurantId, Date orderDate, int amount, String status,
			String paymentmode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.TotalAmount = amount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
				+ orderDate + ", TotalAmount=" + TotalAmount + ", status=" + status + ", paymentmode=" + paymentmode
				+ "]";
	}
	public void setAddressId(int addressId) {
		// TODO Auto-generated method stub
		this.addressId=addressId;
	}
	

}
