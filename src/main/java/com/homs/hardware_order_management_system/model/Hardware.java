package com.homs.hardware_order_management_system.model;

import javax.persistence.*;


@Entity
@Table(name = "hardware_table")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HARDWARE_ID")
    private Integer hardwareID;

    @Column(name = "HARDWARE_NAME")
    private String hardwareName;

    @Column(name = "HARDWARE_ADDRESS")
    private String hardwareAddress;

    @Column(name = "HARDWARE_TEL")
    private String hardwareTel;

    @Column(name = "HARDWARE_EMAIL")
    private String hardwareEmail;

    @Column(name = "HARDWARE_STATUS")
    private String hardwareStatus;

    public Hardware() {
    }

    public Hardware(Integer hardwareID, String hardwareName, String hardwareAddress, String hardwareTel, String hardwareEmail, String hardwareStatus) {
        this.hardwareID = hardwareID;
        this.hardwareName = hardwareName;
        this.hardwareAddress = hardwareAddress;
        this.hardwareTel = hardwareTel;
        this.hardwareEmail = hardwareEmail;
        this.hardwareStatus = hardwareStatus;
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
