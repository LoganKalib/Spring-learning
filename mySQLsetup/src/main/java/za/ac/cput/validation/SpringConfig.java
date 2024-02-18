package za.ac.cput.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import za.ac.cput.validation.Data.OrdersDataAccessInterface;
import za.ac.cput.validation.Data.OrdersDataService;
import za.ac.cput.validation.Services.OrderBusinessService;
import za.ac.cput.validation.Services.OrderBusinessServiceInterface;

@Configuration
public class SpringConfig {
    @Bean(name="OrderBusinessService", initMethod="init" ,destroyMethod="destroy")
    //the default for a bean is singleton, requestScope creates and destroys the bean, sessionScope holds the bean even on refresh
    @RequestScope
    //@SessionScope
    public OrderBusinessServiceInterface getOrderBusiness(){
        return new OrderBusinessService();
    }

    @Bean(name="OrdersDAO")
    //the default for a bean is singleton, requestScope creates and destroys the bean, sessionScope holds the bean even on refresh
    @RequestScope
    //@SessionScope
    public OrdersDataAccessInterface getDataService(){
        return new OrdersDataService();
    }
}
