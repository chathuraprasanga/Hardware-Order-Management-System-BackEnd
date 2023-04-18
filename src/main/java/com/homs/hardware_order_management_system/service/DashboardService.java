package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.dao.jdbc.DashboardDTOJDBCDAO;
import com.homs.hardware_order_management_system.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private DashboardDTOJDBCDAO dashboardDTOJDBCDAO;


    public DashboardDTO getAllValue() {
        DashboardDTO dashboardDTO = this.dashboardDTOJDBCDAO.getAllValuesJDBC();
        return dashboardDTO;
    }
}
