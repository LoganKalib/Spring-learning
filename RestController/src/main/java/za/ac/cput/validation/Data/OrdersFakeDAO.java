package za.ac.cput.validation.Data;

import org.springframework.stereotype.Repository;
import za.ac.cput.validation.Models.OrderModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface{
    List<OrderModel> orders = new ArrayList<OrderModel>();

    public OrdersFakeDAO() {
        orders.add(new OrderModel(0L,"000", "Sky Diving", 1500f,5));
        orders.add(new OrderModel(1L,"001", "Space Ride", 1000000f,6));
        orders.add(new OrderModel(2L,"002", "Run with Bulls", 4300f,8));
        orders.add(new OrderModel(3L,"003", "shot from Cannon", 2400f,2));
        orders.add(new OrderModel(4L,"004", "Ziplining", 6500f,8));
        orders.add(new OrderModel(5L,"005", "Wingsuit lessons", 3400f,9));
    }

    @Override
    public OrderModel getById(long id) {

        for (OrderModel order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {

        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {

        List<OrderModel> foundItems = new ArrayList<>();

        for (OrderModel order : orders) {
            if (order.getProductName().toLowerCase().contains(searchTerm.toLowerCase())) {
                foundItems.add(order);
            }
        }
        return foundItems;
    }

    @Override
    public long addOne(OrderModel newOrder) {
        boolean success = orders.add(newOrder);

        if(success){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public boolean deleteOne(long id) {
        for (OrderModel order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderModel updateOne(long id, OrderModel updatedOrder) {
        for (int i=0;i<orders.size();i++) {
            if (orders.get(i).getId() == id) {
                orders.set(i,updatedOrder);
                return orders.get(i);
            }
        }
        return null;
    }
}
