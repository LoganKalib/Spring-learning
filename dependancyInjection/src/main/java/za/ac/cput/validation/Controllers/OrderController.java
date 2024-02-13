package za.ac.cput.validation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.validation.Models.OrderModel;
import za.ac.cput.validation.Services.OrderBusinessService;
import za.ac.cput.validation.Services.OrderBusinessServiceInterface;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    // we define the service object
    OrderBusinessServiceInterface service;

    //@Autowired is how we inject the dependency, with use of the constructor
    @Autowired
    public OrderController(OrderBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAllOrders(Model model){
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "list of adventures");
        model.addAttribute("orders", orders);

        return "orders";

    }
}
