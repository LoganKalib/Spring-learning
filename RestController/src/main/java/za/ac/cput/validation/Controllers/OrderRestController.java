package za.ac.cput.validation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;
import za.ac.cput.validation.Models.OrderModel;
import za.ac.cput.validation.Services.OrderBusinessServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
    // we define the service object
    OrderBusinessServiceInterface service;

    //@Autowired is how we inject the dependency, with use of the constructor
    @Autowired
    public OrderRestController(OrderBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<OrderModel> showAllOrders(){
        return service.getOrders();
    }
    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm){
        return service.searchOrders(searchTerm);

    }

    @PostMapping("/")
    public long addOrder(@RequestBody OrderModel model){
        return service.addOne(model);
    }

    @GetMapping("/{id}")
    public OrderModel getById(@PathVariable(name="id") long id){
        return service.getById(id);
    }
    @GetMapping("/delete/{id}")
    public boolean deleteOne(@PathVariable(name="id") long id){
        return service.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public OrderModel updateOrder(@RequestBody OrderModel model, @PathVariable(name="id") long id){
        return service.updateOne(id, model);
    }
}
