package domain;

public class Menu {

	private int menuId;
	private  int restaurantId;
	private String itemname;
	private String Description;
	private int price;
	private int ratings;
	private  boolean isAvailable;
	private String imagepath;
	private int quantity;
	
	public Menu(int menuId, int restaurantId, String itemname, String description, int price, int ratings,
			boolean isAvailable, String imagepath, int quantity) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemname = itemname;
		Description = description;
		this.price = price;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
		this.imagepath = imagepath;
		this.quantity = quantity;
	}
	public Menu(int menuId, int restaurantId, String itemname, String description, int price, int ratings,
			boolean isAvailable, String imagepath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemname = itemname;
		Description = description;
		this.price = price;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
		this.imagepath = imagepath;
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
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public int getQuantity() {
	    return quantity;
	}

	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemname=" + itemname + ", Description="
				+ Description + ", price=" + price + ", ratings=" + ratings + ", isAvailable=" + isAvailable
				+ ", imagepath=" + imagepath + "]";
	}

	

}
