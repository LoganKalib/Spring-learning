package za.ac.cput.validation.Services;

import org.springframework.stereotype.Service;
import za.ac.cput.validation.Models.OrderModel;

import java.util.ArrayList;
import java.util.List;

//we define this class as a service that implements our interface
//@Service
public class OrderBusinessService implements OrderBusinessServiceInterface{
    @Override
    public void test() {
        System.out.println("service is working...");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<OrderModel>();

        orders.add(new OrderModel(0L,"000", "Sky Diving", 1500f,5));
        orders.add(new OrderModel(1L,"001", "Space Ride", 1000000f,6));
        orders.add(new OrderModel(2L,"002", "Run with Bulls", 4300f,8));
        orders.add(new OrderModel(3L,"003", "shot from Cannon", 2400f,2));
        orders.add(new OrderModel(4L,"004", "Ziplining", 6500f,8));
        orders.add(new OrderModel(5L,"004", "Wingsuit lessons", 3400f,9));

        return orders;
    }
}
