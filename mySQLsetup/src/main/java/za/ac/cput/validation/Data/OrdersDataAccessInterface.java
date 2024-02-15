package za.ac.cput.validation.Data;

import org.springframework.core.annotation.Order;
import za.ac.cput.validation.Models.OrderModel;

import java.util.List;

public interface OrdersDataAccessInterface {

    public OrderModel getById(long id);
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String searchTerm);
    public long addOne(OrderModel newOrder);
    public boolean deleteOne(long id);
    public OrderModel updateOne(long id, OrderModel updatedOrder);

}
