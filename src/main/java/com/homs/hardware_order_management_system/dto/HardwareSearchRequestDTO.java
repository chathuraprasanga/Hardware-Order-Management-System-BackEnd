package com.homs.hardware_order_management_system.dto;

public class HardwareSearchRequestDTO {

    private String hardwareName;

    private String hardwareAddress;

    private String hardwareTel;

    private String hardwareStatus;

    public String getHardwareStatus() {
        return hardwareStatus;
    }

    public void setHardwareStatus(String hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
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
}
