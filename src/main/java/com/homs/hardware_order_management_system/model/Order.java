package com.homs.hardware_order_management_system.model;

import javax.persistence.*;


@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_id")
    private Integer orderID;

    @Column(name = "Invoice_number")
    private String invoiceNumber;

    @Column(name = "Date")
    private String orderDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Hardware_id")
    private Hardware hardware;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Product_id")
    private Product product;

    @Column(name = "Order_quantity")
    private Integer orderQuantity;

    @Column(name = "Order_amount")
    private Integer orderAmount;

    @Column(name = "Payment_method")
    private String paymentMethod;

    @Column(name = "Payment_status")
    private String paymentStatus;

    public Order() {
    }

    public Order(Integer orderID, String invoiceNumber, String orderDate, Hardware hardware, Product product, Integer orderQuantity, Integer orderAmount, String paymentMethod, String paymentStatus) {
        this.orderID = orderID;
        this.invoiceNumber = invoiceNumber;
        this.orderDate = orderDate;
        this.hardware = hardware;
        this.product = product;
        this.orderQuantity = orderQuantity;
        this.orderAmount = orderAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
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

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}
