package domain;

import java.util.Date;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private Long phone;
    private int rating;
    private String cuisine;
    private Boolean isActive;
    private Date eta;
    private int userId;
    private String imageUrl; // ✅ This will store imagepath

    public Restaurant() {}

    public Restaurant(int restaurantId, String name, String address, Long phone,
                      int rating, String cuisine, Boolean isActive, Date eta,
                      int userId, String imageUrl) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
        this.cuisine = cuisine;
        this.isActive = isActive;
        this.eta = eta;
        this.userId = userId;
        this.imageUrl = imageUrl;
    }

    // ✅ Getters and setters
    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Long getPhone() { return phone; }
    public void setPhone(Long phone) { this.phone = phone; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Date getEta() { return eta; }
    public void setEta(Date eta) { this.eta = eta; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address +
                ", phone=" + phone + ", rating=" + rating + ", cuisine=" + cuisine + ", isActive=" + isActive +
                ", eta=" + eta + ", userId=" + userId + ", imageUrl=" + imageUrl + "]";
    }
}
