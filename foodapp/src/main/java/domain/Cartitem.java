package domain;

import java.util.List;

import DaoImplementation.MenuImp1;

public class Cartitem  {
public int itemid;
private String itemname;
public int quantity;
private double price;
private int userId;
private int menuId;
private int restaurantId;
private String restaurantName;
public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getMenuId() {
	return menuId;
}
public void setMenuId(int menuId) {
	this.menuId = menuId;
}
public int getRestaurantId() {
	return restaurantId;
}
public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}
public String getRestaurantName() {
	return restaurantName;
}
public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}



public Cartitem(int itemid, String itemname, int quantity, double price, int userId, int menuId, int restaurantId,
		String restaurantName) {
	super();
	this.itemid = itemid;
	this.itemname = itemname;
	this.quantity = quantity;
	this.price = price;
	this.userId = userId;
	this.menuId = menuId;
	this.restaurantId = restaurantId;
	this.restaurantName = restaurantName;
}
public Cartitem() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Cartitem [itemid=" + itemid + ", itemname=" + itemname + ", quantity=" + quantity + ", price=" + price
			+ ", userId=" + userId + ", menuId=" + menuId + ", restaurantId=" + restaurantId + ", restaurantName="
			+ restaurantName + "]";
}
public int getCartId() {
    return itemid;
}

public void setCartId(int cartId) {
    this.itemid = cartId;
}






}
