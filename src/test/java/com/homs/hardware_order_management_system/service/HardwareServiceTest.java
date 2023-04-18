package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.model.dto.HardwareDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HardwareServiceTest {

    @Autowired
    private HardwareService hardwareService;

    @Test
    void saveAndUpdateHardware() {
        HardwareDTO hardwareDTO = new HardwareDTO();
        hardwareDTO.setHardwareID(10);
        hardwareDTO.setHardwareName("Prasanga");
        hardwareDTO.setHardwareAddress("Mawathagama");
        hardwareDTO.setHardwareTel("0779250108");
        hardwareDTO.setHardwareEmail("prasanga98@Gmail.com");
        hardwareDTO.setHardwareStatus("DEACTIVE");

        this.hardwareService.saveAndUpdateHardware(hardwareDTO);
    }
}