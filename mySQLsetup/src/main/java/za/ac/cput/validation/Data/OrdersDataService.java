package za.ac.cput.validation.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import za.ac.cput.validation.Models.OrderModel;
import za.ac.cput.validation.Models.OrdersMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class OrdersDataService implements OrdersDataAccessInterface{

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public OrderModel getById(long id) {
        List<OrderModel> result = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID=?", new OrdersMapper(), id);
        if(!result.isEmpty()){
            return result.getFirst();
        }else {return null;}
    }

    @Override
    public List<OrderModel> getOrders() {
        return jdbcTemplate.query("SELECT * FROM ORDERS;",new OrdersMapper());
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?", new OrdersMapper(),"%" +searchTerm + "%");
    }

    @Override
    public long addOne(OrderModel newOrder) {
        //long result = jdbcTemplate.update("INSERT INTO ORDERS(ORDER_NUMBER,PRODUCT_NAME,PRICE,QTY) VALUES (?,?,?,?)",newOrder.getOrderNo(),newOrder.getProductName(),newOrder.getPrice(),newOrder.getQuantity());
        //return result;

        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);

        simpleInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ORDER_NUMBER", newOrder.getOrderNo());
        parameters.put("PRODUCT_NAME", newOrder.getProductName());
        parameters.put("PRICE", newOrder.getPrice());
        parameters.put("QTY", newOrder.getQuantity());

        return simpleInsert.executeAndReturnKey(parameters).longValue();
    }

    @Override
    public boolean deleteOne(long id) {
        int result = jdbcTemplate.update("DELETE FROM ORDERS WHERE ID=?", id);
        return result > 0;
    }

    @Override
    public OrderModel updateOne(long id, OrderModel updatedOrder) {
        int result = jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER=?, PRODUCT_NAME=?, PRICE=?, QTY=? WHERE ID=?", updatedOrder.getOrderNo(),updatedOrder.getProductName(), updatedOrder.getPrice(), updatedOrder.getQuantity(), id);
        if(result>0){
            return updatedOrder;
        }else {return null;}
    }
}
