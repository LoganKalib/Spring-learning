package za.ac.cput.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.ac.cput.validation.Services.OrderBusinessService;
import za.ac.cput.validation.Services.OrderBusinessService2;
import za.ac.cput.validation.Services.OrderBusinessServiceInterface;

@Configuration
public class SpringConfig {
    @Bean(name="OderBusinessService")
    public OrderBusinessServiceInterface getOrderBusiness(){
        return new OrderBusinessService();
    }
}
