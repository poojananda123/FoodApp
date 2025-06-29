package DaoInterface;

import java.util.List;

import domain.Restaurant;



public interface RestaurantDao {
	void save(Restaurant rest);
	void update(Restaurant rest);
	void delete(Restaurant rest);
	Restaurant  getRestaurant(int rest);
	List<Restaurant> getAllRestaurant();
}
