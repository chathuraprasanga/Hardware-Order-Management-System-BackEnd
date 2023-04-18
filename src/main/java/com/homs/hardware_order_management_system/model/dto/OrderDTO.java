package com.homs.hardware_order_management_system.model.dto;


import com.homs.hardware_order_management_system.model.Order;


public class OrderDTO {


    private Integer orderID;
    private String invoiceNumber;
    private String orderDate;
    private Integer hardwareID;
    private String hardwareName;
    private Integer productID;
    private String productCode;
    private String productName;
    private Integer productPrice;
    private Integer orderQuantity;
    private Integer orderAmount;
    private String paymentMethod;
    private String paymentStatus;

    public OrderDTO() {
    }


    public OrderDTO(Order order) {
        this.orderID = order.getOrderID();
        this.invoiceNumber = order.getInvoiceNumber();
        this.orderDate = order.getOrderDate();
        if (order.getHardware()!=null){
            this.hardwareID = order.getHardware().getHardwareID();
            this.hardwareName = order.getHardware().getHardwareName();

        }
        if (order.getProduct()!=null){
            this.productID = order.getProduct().getProductID();
            this.productCode = order.getProduct().getProductCode();
            this.productName = order.getProduct().getProductName();
            this.productPrice = order.getProduct().getProductPrice();

        }
        this.orderQuantity = order.getOrderQuantity();
        this.orderAmount = order.getOrderAmount();
        this.paymentMethod = order.getPaymentMethod();
        this.paymentStatus = order.getPaymentStatus();
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getHardwareID() {
        return hardwareID;
    }

    public void setHardwareID(Integer hardwareID) {
        this.hardwareID = hardwareID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
