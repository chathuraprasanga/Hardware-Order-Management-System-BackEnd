package com.homs.hardware_order_management_system.controller;

import com.homs.hardware_order_management_system.dto.DashboardDTO;
import com.homs.hardware_order_management_system.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/get-all-value-jdbc")
    public ResponseEntity<DashboardDTO> getAllValue(){
        DashboardDTO dashboardDTO = this.dashboardService.getAllValue();
        return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
    }
}
