package com.homs.hardware_order_management_system.dao;

import com.homs.hardware_order_management_system.model.Hardware;
import com.homs.hardware_order_management_system.model.Order;
import com.homs.hardware_order_management_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

    Order getOrderByOrderID(Integer orderID);

    Order getOrderByInvoiceNumber(String inovoiceNumber);

    Order getOrderByHardware(Hardware hardwareID);

    Order getOrderByProduct (Product productID);

    Order getOrderByOrderQuantity (Integer orderQuantity);

    Order getAllByOrderQuantity (Integer orderQuantity);

    Order getOrderByOrderAmount(Double orderAmount);

    Order getAllByOrderAmount(Double orderAmount);

    Order getAllByPaymentMethod(String paymentMethod);

    Order getAllByPaymentStatus (String paymentStatus);

    Order findAllByPaymentStatus (String paymentStatus);

}
