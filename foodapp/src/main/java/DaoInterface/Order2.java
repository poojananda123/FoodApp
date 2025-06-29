package DaoInterface;

import java.util.List;

import domain.Order;

public interface Order2 {
	void saveOrder(Order order);
    Order getOrderById(int orderId);
    List<Order> getOrdersByUserId(int userId);
}
