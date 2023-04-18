package com.homs.hardware_order_management_system.dao.jdbc;

import com.homs.hardware_order_management_system.dto.HardwareSearchRequestDTO;
import com.homs.hardware_order_management_system.model.dto.HardwareDTO;
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
public class HardwareJDBCDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<HardwareDTO> getAllHardwaresJdbc(HardwareSearchRequestDTO hardwareRQ) {
        List<HardwareDTO> result = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT									\n");
        SQL.append("    ht.Hardware_id,						\n");
        SQL.append("    ht.HARDWARE_NAME,					\n");
        SQL.append("    ht.HARDWARE_ADDRESS,				\n");
        SQL.append("    ht.HARDWARE_TEL,					\n");
        SQL.append("    ht.HARDWARE_EMAIL,					\n");
        SQL.append("    ht.HARDWARE_STATUS					\n");
        SQL.append("FROM									\n");
        SQL.append("    hardware_table ht					\n");
        SQL.append("WHERE									\n");
        SQL.append("    ht.Hardware_id IS NOT null          \n");

        if (hardwareRQ.getHardwareName()!=null && !hardwareRQ.getHardwareName().equals("")){
            SQL.append("    AND 								\n");
            SQL.append("    ht.HARDWARE_NAME LIKE '%"+hardwareRQ.getHardwareName()+"%' 			\n");
        }

        if (hardwareRQ.getHardwareTel()!=null && !hardwareRQ.getHardwareTel().equals("")){
            SQL.append("    AND 								\n");
            SQL.append("    ht.HARDWARE_TEL LIKE '%"+hardwareRQ.getHardwareTel()+"%' 		\n");
        }
        if (hardwareRQ.getHardwareStatus()!=null && !hardwareRQ.getHardwareStatus().equals("")){
            SQL.append("    AND 								\n");
            SQL.append("    ht.HARDWARE_STATUS = \""+hardwareRQ.getHardwareStatus()+"\" 		\n");
        }


        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<HardwareDTO>>() {
            @Override
            public List<HardwareDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()){
                    HardwareDTO hardwareDTO = new HardwareDTO();
                    hardwareDTO.setHardwareID(rs.getInt("Hardware_id"));
                    hardwareDTO.setHardwareName(rs.getString("HARDWARE_NAME"));
                    hardwareDTO.setHardwareAddress(rs.getString("HARDWARE_ADDRESS"));
                    hardwareDTO.setHardwareTel(rs.getString("HARDWARE_TEL"));
                    hardwareDTO.setHardwareEmail(rs.getString("HARDWARE_EMAIL"));
                    hardwareDTO.setHardwareStatus(rs.getString("HARDWARE_STATUS"));

                    result.add(hardwareDTO);
                }

                return result;
            }
        });


    }

    //get all active hardware
    public List<HardwareDTO> getAllActiveHardware() {
        List<HardwareDTO> activeHarwdareList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT								\n");
        SQL.append("    *								\n");
        SQL.append("FROM								\n");
        SQL.append("    hardware_table ht				\n");
        SQL.append("WHERE								\n");
        SQL.append("    ht.HARDWARE_STATUS = \"ACTIVE\";	\n");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<HardwareDTO>>() {
            @Override
            public List<HardwareDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {


                while (rs.next()){
                    HardwareDTO hardwareDTO = new HardwareDTO();
                    hardwareDTO.setHardwareID(rs.getInt("Hardware_id"));
                    hardwareDTO.setHardwareName(rs.getString("HARDWARE_NAME"));
                    hardwareDTO.setHardwareAddress(rs.getString("HARDWARE_ADDRESS"));
                    hardwareDTO.setHardwareTel(rs.getString("HARDWARE_TEL"));
                    hardwareDTO.setHardwareEmail(rs.getString("HARDWARE_EMAIL"));
                    hardwareDTO.setHardwareStatus(rs.getString("HARDWARE_STATUS"));

                    activeHarwdareList.add(hardwareDTO);
                }
                return activeHarwdareList;
            }
        });

    }
}
