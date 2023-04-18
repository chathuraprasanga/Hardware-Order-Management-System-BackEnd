package com.homs.hardware_order_management_system.dao.jdbc;

import com.homs.hardware_order_management_system.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DashboardDTOJDBCDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DashboardDTO getAllValuesJDBC(){
        DashboardDTO result = new DashboardDTO();
        Map<String,Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT									\n");
        SQL.append("    (									\n");
        SQL.append("    SELECT								\n");
        SQL.append("        COUNT(ot.Order_id)				\n");
        SQL.append("    FROM								\n");
        SQL.append("        order_table ot					\n");
        SQL.append(") AS orderCount,						\n");
        SQL.append("(										\n");
        SQL.append("    SELECT								\n");
        SQL.append("        COUNT(ht.HARDWARE_ID)			\n");
        SQL.append("    FROM								\n");
        SQL.append("        hardware_table ht				\n");
        SQL.append(") AS hardwareCount,						\n");
        SQL.append("(										\n");
        SQL.append("    SELECT								\n");
        SQL.append("        COUNT(pt.PRODUCT_ID)			\n");
        SQL.append("    FROM								\n");
        SQL.append("        product_table pt				\n");
        SQL.append(") AS productCount,						\n");
        SQL.append("(										\n");
        SQL.append("    SELECT								\n");
        SQL.append("        SUM(ot.Order_amount)			\n");
        SQL.append("    FROM								\n");
        SQL.append("        order_table ot					\n");
        SQL.append(") AS totalRevenue,						\n");
        SQL.append("(										\n");
        SQL.append("    SELECT								\n");
        SQL.append("        SUM(ot.Order_amount)			\n");
        SQL.append("    FROM								\n");
        SQL.append("        order_table ot					\n");
        SQL.append("    WHERE								\n");
        SQL.append("        ot.Payment_method = \"CASH\"	\n");
        SQL.append(") AS cashRevenue,						\n");
        SQL.append("(										\n");
        SQL.append("    SELECT								\n");
        SQL.append("        SUM(ot.Order_amount)			\n");
        SQL.append("    FROM								\n");
        SQL.append("        order_table ot					\n");
        SQL.append("    WHERE								\n");
        SQL.append("        ot.Payment_method = \"CHEQUE\"	\n");
        SQL.append(") AS chequeRevenue,						\n");
        SQL.append("(										\n");
        SQL.append("    SELECT								\n");
        SQL.append("        SUM(ot.Order_amount)			\n");
        SQL.append("    FROM								\n");
        SQL.append("        order_table ot					\n");
        SQL.append("    WHERE								\n");
        SQL.append("        ot.Payment_method = \"CREDIT\"	\n");
        SQL.append(") AS creditRevenue						\n");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<DashboardDTO>() {
            @Override
            public DashboardDTO extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()){

                    result.setOrderCount(rs.getInt("orderCount"));
                    result.setHardwareCount(rs.getInt("hardwareCount"));
                    result.setProductCount(rs.getInt("productCount"));
                    result.setTotalRevenue(rs.getInt("totalRevenue"));
                    result.setCashRevenue(rs.getInt("cashRevenue"));
                    result.setChequeRevenue(rs.getInt("chequeRevenue"));
                    result.setCreditRevenue(rs.getInt("creditRevenue"));


                }
                return result;
            }
        });

    }

}
