package com.homs.hardware_order_management_system.dao.jdbc;

import com.homs.hardware_order_management_system.dto.OrderSearchRequestDTO;
import com.homs.hardware_order_management_system.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderJDBCDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<OrderDTO> getAllOrdersjdbc(OrderSearchRequestDTO orderRQ){
        List<OrderDTO> result = new ArrayList<>();
        Map<String,Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT\n");
        SQL.append("    ot.Order_id,\n");
        SQL.append("    ot.Invoice_number,\n");
        SQL.append("    ot.Date,\n");
        SQL.append("    ot.Hardware_id,\n");
        SQL.append("    ht.HARDWARE_NAME,\n");
        SQL.append("    ot.Product_id,\n");
        SQL.append("    pt.PRODUCT_CODE,\n");
        SQL.append("    pt.PRODUCT_NAME,\n");
        SQL.append("    pt.PRODUCT_PRICE,\n");
        SQL.append("    ot.Order_quantity,\n");
        SQL.append("    ot.Order_amount,\n");
        SQL.append("    ot.Payment_method,\n");
        SQL.append("    ot.Payment_status\n");
        SQL.append("FROM\n");
        SQL.append("    order_table ot\n");
        SQL.append("INNER JOIN hardware_table ht ON\n");
        SQL.append("    ot.Hardware_id = ht.HARDWARE_ID\n");
        SQL.append("INNER JOIN product_table pt ON\n");
        SQL.append("    ot.Product_id = pt.PRODUCT_ID\n");
        SQL.append("WHERE\n");
//        SQL.append("    ht.HARDWARE_STATUS = \"ACTIVE\" AND \n");
        SQL.append("    ot.Order_id IS NOT null\n");

        if (orderRQ.getHardwareName()!=null && !orderRQ.getHardwareName().equals("")){
            SQL.append("    AND ht.HARDWARE_NAME LIKE '%"+orderRQ.getHardwareName()+"%'\n");
        }
        if (orderRQ.getProductID()!=null){
            SQL.append("    AND pt.PRODUCT_ID =:productID \n");
            params.put("productID", orderRQ.getProductID());
        }


        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<OrderDTO>>() {
            @Override
            public List<OrderDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()){
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setOrderID(rs.getInt("Order_id"));
                    orderDTO.setInvoiceNumber(rs.getNString("Invoice_number"));
                    orderDTO.setOrderDate(rs.getNString("Date"));
                    orderDTO.setHardwareID(rs.getInt("Hardware_id"));
                    orderDTO.setHardwareName(rs.getString("HARDWARE_NAME"));
                    orderDTO.setProductID(rs.getInt("Product_id"));
                    orderDTO.setProductCode(rs.getString("PRODUCT_CODE"));
                    orderDTO.setProductName(rs.getString("PRODUCT_NAME"));
                    orderDTO.setOrderQuantity(rs.getInt("Order_quantity"));
                    orderDTO.setOrderAmount(rs.getInt("Order_amount"));
                    orderDTO.setPaymentMethod(rs.getString("Payment_method"));
                    orderDTO.setPaymentStatus(rs.getString("Payment_status"));

                    result.add(orderDTO);
                }

                return result;
            }
        });


    }


}
