package za.ac.cput.validation.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import za.ac.cput.validation.Models.OrderModel;

import java.util.ArrayList;
import java.util.List;


// if you have more than one service you need to use the below @
//@Primary
public class OrderBusinessService2 implements OrderBusinessServiceInterface{

    List<OrderModel> orders;
    @Override
    public void test() {
        System.out.println("service is working...");
    }

    @Override
    public List<OrderModel> getOrders() {

        orders.add(new OrderModel(0L,"AAA", "Kush", 80f,50));
        orders.add(new OrderModel(1L,"AAB", "Wedding cake", 100f,60));
        orders.add(new OrderModel(2L,"AAC", "Lemon haze", 60f,80));
        orders.add(new OrderModel(3L,"AAD", "Green crack", 75f,20));
        orders.add(new OrderModel(4L,"AAE", "MAC #1", 55f,80));
        orders.add(new OrderModel(5L,"AAF", "Girl scout cookies", 70f,90));

        return orders;
    }

    @Override
    public void init() {
        orders = new ArrayList<>();
        System.out.println("init method2");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method2");
    }
}
