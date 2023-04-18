package com.homs.hardware_order_management_system.model.dto;

import com.homs.hardware_order_management_system.model.Hardware;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class HardwareDTO {

    private Integer hardwareID;
    private String hardwareName;
    private String hardwareAddress;
    private String hardwareTel;
    private String hardwareEmail;
    private String hardwareStatus;

    public HardwareDTO() {
    }

    public HardwareDTO(Hardware hardware) {
        this.hardwareID = hardware.getHardwareID();
        this.hardwareName = hardware.getHardwareName();
        this.hardwareAddress = hardware.getHardwareAddress();
        this.hardwareTel = hardware.getHardwareTel();
        this.hardwareEmail = hardware.getHardwareEmail();
        this.hardwareStatus = hardware.getHardwareStatus();
    }

    public Integer getHardwareID() {
        return hardwareID;
    }

    public void setHardwareID(Integer hardwareID) {
        this.hardwareID = hardwareID;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    public String getHardwareTel() {
        return hardwareTel;
    }

    public void setHardwareTel(String hardwareTel) {
        this.hardwareTel = hardwareTel;
    }

    public String getHardwareEmail() {
        return hardwareEmail;
    }

    public void setHardwareEmail(String hardwareEmail) {
        this.hardwareEmail = hardwareEmail;
    }

    public String getHardwareStatus() {
        return hardwareStatus;
    }

    public void setHardwareStatus(String hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }
}
