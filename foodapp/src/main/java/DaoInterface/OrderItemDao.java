package DaoInterface;

import java.util.List;

import domain.OrderItem;


public interface OrderItemDao {
	void save(OrderItem orderitem);
	void update(OrderItem orderitem);
	void delete(OrderItem orderitem);
	OrderItem getUser(int orderitem);
	List<OrderItem> getAllUser();
}
