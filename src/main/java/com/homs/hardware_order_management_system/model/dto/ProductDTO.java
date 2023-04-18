package com.homs.hardware_order_management_system.model.dto;

import com.homs.hardware_order_management_system.model.Product;


public class ProductDTO {

    private Integer productID;
    private String productCode;
    private String productName;
    private String productSize;
    private Integer productPrice;
    private String productStatus;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.productID = product.getProductID();
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.productSize = product.getProductSize();
        this.productPrice = product.getProductPrice();
        this.productStatus = product.getProductStatus();
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
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

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
