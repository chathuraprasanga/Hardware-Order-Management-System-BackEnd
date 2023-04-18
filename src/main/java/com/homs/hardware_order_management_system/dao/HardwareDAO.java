package com.homs.hardware_order_management_system.dao;

import com.homs.hardware_order_management_system.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareDAO extends JpaRepository<Hardware,Integer> {

    Hardware getHardwareByHardwareID(Integer hardwareID);

    Hardware findByHardwareName(String hardwareName);

    Hardware findByHardwareTel(String hardwareTel);

    Hardware findByHardwareEmail(String hardwareEmail);


    List<Hardware> findAllByHardwareName(String hardwareName);
}
