package com.homs.hardware_order_management_system.dao.jdbc;


import com.homs.hardware_order_management_system.dto.ProductSearchRequestDTO;
import com.homs.hardware_order_management_system.model.dto.ProductDTO;
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
public class ProductJDBCDAO{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //get all products
    public List<ProductDTO> getAllProductsJdbc(ProductSearchRequestDTO productRQ) {
        List<ProductDTO> result = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT								\n");
        SQL.append("    pt.PRODUCT_ID,					\n");
        SQL.append("    pt.PRODUCT_CODE,				\n");
        SQL.append("    pt.PRODUCT_NAME,				\n");
        SQL.append("    pt.PRODUCT_SIZE,				\n");
        SQL.append("    pt.PRODUCT_PRICE,				\n");
        SQL.append("    pt.PRODUCT_STATUS				\n");
        SQL.append("FROM								\n");
        SQL.append("    product_table pt				\n");
        SQL.append("WHERE								\n");
        SQL.append("    pt.PRODUCT_ID IS NOT null		\n");



        if (productRQ.getProductCode()!=null && !productRQ.getProductCode().equals("")){
            SQL.append("    AND 								\n");
            SQL.append("    pt.PRODUCT_CODE LIKE '%"+productRQ.getProductCode()+"%'       \n");
        }

        if (productRQ.getProductStatus()!=null && !productRQ.getProductStatus().equals("")){
            SQL.append("    AND 								\n");
            SQL.append("    pt.PRODUCT_STATUS = \""+productRQ.getProductStatus()+"\"	    \n");
        }

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<ProductDTO>>() {
            @Override
            public List<ProductDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<ProductDTO> result = new ArrayList<>();

                while (rs.next()){
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProductID(rs.getInt("PRODUCT_ID"));
                    productDTO.setProductCode(rs.getString("PRODUCT_CODE"));
                    productDTO.setProductName(rs.getString("PRODUCT_NAME"));
                    productDTO.setProductSize(rs.getString("PRODUCT_SIZE"));
                    productDTO.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                    productDTO.setProductStatus(rs.getString("PRODUCT_STATUS"));

                    result.add(productDTO);
                }

                return result;
            }
        });

    }

    //get all active products
    public List<ProductDTO> getAllActiveProduct() {
        List<ProductDTO> result = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT								\n");
        SQL.append("    *								\n");
        SQL.append("FROM								\n");
        SQL.append("    product_table pt				\n");
        SQL.append("WHERE								\n");
        SQL.append("    pt.PRODUCT_STATUS = \"ACTIVE\";	\n");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<ProductDTO>>() {
            @Override
            public List<ProductDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()){
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProductID(rs.getInt("PRODUCT_ID"));
                    productDTO.setProductCode(rs.getString("PRODUCT_CODE"));
                    productDTO.setProductName(rs.getString("PRODUCT_NAME"));
                    productDTO.setProductSize(rs.getString("PRODUCT_SIZE"));
                    productDTO.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                    productDTO.setProductStatus(rs.getString("PRODUCT_STATUS"));

                    result.add(productDTO);
                }
                return result;
            }
        });
    }
}
