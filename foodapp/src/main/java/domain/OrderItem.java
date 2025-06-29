package domain;

public class OrderItem {

	private int orderitemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private double totalPrice;
	public OrderItem() {
		
	}
	public OrderItem(int orderitemId, int orderId, int menuId, int quantity, int totalPrice) {
		super();
		this.orderitemId = orderitemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}
	@Override
	public String toString() {
		return "Orderitems [orderitemId=" + orderitemId + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}
	
}
