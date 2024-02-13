package za.ac.cput.validation.Services;

import za.ac.cput.validation.Models.OrderModel;

import java.util.List;

public interface OrderBusinessServiceInterface {

    //we create an interface that that defines the methods we're going to implement

    public void test();

    public List<OrderModel> getOrders();

    public void init();
    public void destroy();


}
