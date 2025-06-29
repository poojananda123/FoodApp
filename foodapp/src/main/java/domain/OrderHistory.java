package domain;

import java.sql.Timestamp;

public class OrderHistory {

	private int orderhistoryId;
	private int userId;
	private int orderId;
	private Timestamp orderDate;
	private int totalAmount;
	private String status;
	public OrderHistory(int orderhistoryId, int userId, int orderId, Timestamp orderDate, int totalAmount, String status) {
		super();
		this.orderhistoryId = orderhistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public int getOrderhistoryId() {
		return orderhistoryId;
	}
	public void setOrderhistoryId(int orderhistoryId) {
		this.orderhistoryId = orderhistoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orderhistory [orderhistoryId=" + orderhistoryId + ", userId=" + userId + ", orderId=" + orderId
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	


}
