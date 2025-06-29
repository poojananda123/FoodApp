package DaoInterface;

import java.util.ArrayList;
import java.util.List;

import domain.Cartitem;
import domain.Menu;
import domain.Users;

public interface MenuDao {
	
		void save(Menu menu);
		void update(Menu menu);
		void delete(Menu menu);
		Menu getMenu(int menu);
		List<Menu> getAllMenu();
		List<Menu> getAllMenu(int restaurantId);
		List<Cartitem> getcart(ArrayList<Cartitem> cartList);
		Menu getMenuById(int id);
}
