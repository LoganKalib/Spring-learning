package za.ac.cput.validation.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.validation.Models.OrderModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/")
    public String showAllOrders(Model model){

        List<OrderModel> orders = new ArrayList<>();

        orders.add(new OrderModel(0L,"000", "Sky Diving", 1500f,5));
        orders.add(new OrderModel(1L,"001", "Space Ride", 1000000f,6));
        orders.add(new OrderModel(2L,"002", "Run with Bulls", 4300f,8));
        orders.add(new OrderModel(3L,"003", "shot from Cannon", 2400f,2));
        orders.add(new OrderModel(4L,"004", "Ziplining", 6500f,8));
        orders.add(new OrderModel(5L,"004", "Wingsuit lessons", 3400f,9));

        model.addAttribute("title", "list of adventures");
        model.addAttribute("orders", orders);

        return "orders";

    }
}
