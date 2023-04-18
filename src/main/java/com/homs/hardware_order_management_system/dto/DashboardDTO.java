package com.homs.hardware_order_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DashboardDTO {

    private Integer orderCount;
    private Integer hardwareCount;
    private Integer productCount;
    private Integer totalRevenue;
    private Integer cashRevenue;
    private Integer chequeRevenue;
    private Integer creditRevenue;

}
