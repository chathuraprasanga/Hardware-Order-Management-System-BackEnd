package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.dto.OrderSearchRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;


    @Test
    void getAllOrdersjdbc() {

        OrderSearchRequestDTO orderSearchRequestDTO = new OrderSearchRequestDTO();
        orderSearchRequestDTO.setHardwareName("c");
        orderSearchRequestDTO.setProductCode("K");

        this.orderService.getAllOrdersjdbc(orderSearchRequestDTO);
    }
}