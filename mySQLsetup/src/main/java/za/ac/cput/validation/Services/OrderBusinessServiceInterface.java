package za.ac.cput.validation.Services;

import za.ac.cput.validation.Models.OrderModel;

import java.util.List;

public interface OrderBusinessServiceInterface {

    //we create an interface that that defines the methods we're going to implement

    public void test();
    public OrderModel getById(long id);
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String searchTerm);
    public long addOne(OrderModel newOrder);
    public boolean deleteOne(long id);
    public OrderModel updateOne(long id, OrderModel updatedOrder);

    public void init();
    public void destroy();


}
