package DaoInterface;

import java.util.List;

import domain.Cartitem;

public interface CartDAO {
void saveCartItem(Cartitem cartitem);
Cartitem getCartItemByMenuId(int menuId);
void updateCartItem(Cartitem cartitem);
List<Cartitem> getCartItemsByUserId(int id);
void deleteCartItemById(Object cartId);
Cartitem getCartItemByMenuIdAndUserId(int menuId, int userId);
Cartitem getCartItemByMenuIdAndUserId(int menuId, int userId, int restaurantId);

}
