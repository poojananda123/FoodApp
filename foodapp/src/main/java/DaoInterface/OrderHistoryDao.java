package DaoInterface;

import java.util.List;

import domain.OrderHistory;



public interface OrderHistoryDao {
	void save(OrderHistoryDao orderhistory);
	void update(OrderHistoryDao orderhistory);
	void delete(OrderHistoryDao orderhistory);
	OrderHistory getUser(int orderhistory);
	List<OrderHistory> getAllUser();
}
