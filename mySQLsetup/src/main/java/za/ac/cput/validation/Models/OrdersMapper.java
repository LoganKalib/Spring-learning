package za.ac.cput.validation.Models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersMapper implements RowMapper<OrderModel> {
    @Override
    public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderModel(rs.getLong("ID"),rs.getString("ORDER_NUMBER"),rs.getString("PRODUCT_NAME"),rs.getFloat("PRICE"),rs.getInt("QTY"));
    }
}
