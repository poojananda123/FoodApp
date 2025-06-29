package DaoInterface;

import java.util.List;

import domain.Order;
import domain.Users;


import domain.Order;
import java.util.List;

public interface OrderDao {
    void saveOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
    Order getOrderById(int orderId);
 
    void deleteOrdersInRange(int startId, int endId);
	boolean deleteOrderById(int orderId);
}

