package za.ac.cput.validation.Services;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.validation.Data.OrdersDataAccessInterface;
import za.ac.cput.validation.Models.OrderModel;

import java.util.List;

//we define this class as a service that implements our interface
//@Service
public class OrderBusinessService implements OrderBusinessServiceInterface{

    @Autowired
    OrdersDataAccessInterface ordersDAO;
    @Override
    public void test() {
        System.out.println("service is working...");
    }

    @Override
    public OrderModel getById(long id) {
        return ordersDAO.getById(id);
    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel newOrder) {

        return ordersDAO.addOne(newOrder);
    }

    @Override
    public boolean deleteOne(long id) {
        return ordersDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long id, OrderModel updatedOrder) {
        return ordersDAO.updateOne(id, updatedOrder);
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

}
