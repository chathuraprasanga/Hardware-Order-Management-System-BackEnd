package com.homs.hardware_order_management_system.dao;

import com.homs.hardware_order_management_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {

    Product getProductByProductID(Integer productID);

    Product getProductByProductCode(String productCode);

    Product findByProductName(String productName);



}
