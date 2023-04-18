package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.dao.HardwareDAO;
import com.homs.hardware_order_management_system.dao.OrderDAO;
import com.homs.hardware_order_management_system.dao.ProductDAO;
import com.homs.hardware_order_management_system.dao.jdbc.OrderJDBCDao;
import com.homs.hardware_order_management_system.dto.OrderSearchRequestDTO;
import com.homs.hardware_order_management_system.model.Hardware;
import com.homs.hardware_order_management_system.model.Order;
import com.homs.hardware_order_management_system.model.Product;
import com.homs.hardware_order_management_system.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private HardwareDAO hardwareDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderJDBCDao orderJDBCDao;



    //get all order
    public List<OrderDTO> getAllOrder(){
        List<Order> orderList = this.orderDAO.findAll();

        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order: orderList){
            OrderDTO orderDTO = new OrderDTO(order);

            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }


    //search Order by ID
    public OrderDTO searchOrder(Integer orderID){
        Order order = this.orderDAO.getOrderByOrderID(orderID);
        return  new OrderDTO(order);
    }

    //get order by invoice number
//    public void getOrderByInvoiceNumber(String invoiceNumber){
//        Order selectedOrder = orderDAO.getOrderByInvoiceNumber(invoiceNumber);
//        System.out.println(selectedOrder);
//    }

    //get all by payment status
//    public void getAllOrdersByPaymentStatus(){
//        List<Order> selectedOrders = orderDAO.findAll();
//        System.out.println(selectedOrders);
//    }

    //save order
//    public OrderDTO saveOrder(OrderDTO orderDTO){
//        Order order = new Order();
//
//        order.setInvoiceNumber(orderDTO.getInvoiceNumber());
//        order.setOrderDate(orderDTO.getOrderDate());
//        order.setHardware(this.hardwareDAO.getReferenceById(orderDTO.getHardwareID()));
//        order.setProduct(this.productDAO.getReferenceById(orderDTO.getProductID()));
//        order.setOrderQuantity(orderDTO.getOrderQuantity());
//        order.setOrderAmount(orderDTO.getOrderAmount());
//        order.setPaymentMethod(orderDTO.getPaymentMethod());
//        order.setPaymentStatus(orderDTO.getPaymentStatus());
//
//        order = this.orderDAO.saveAndFlush(order);
//        return new OrderDTO(order);
//    }

    //update order
//    public OrderDTO updateOrder(OrderDTO orderDTO) {
//
//        Order existingOrder = null;
//
//        if (orderDTO.getOrderID() != null) {
//            existingOrder = orderDAO.getOrderByOrderID(orderDTO.getOrderID());
//        } else {
//            existingOrder = new Order();
//        }
//
//        Hardware hardware = hardwareDAO.findByHardwareID(orderDTO.getHardwareID());
//        Product product = productDAO.findByProductID(orderDTO.getProductID());
//
//        existingOrder.setHardware(hardware);
//        existingOrder.setProduct(product);
//        existingOrder.setOrderID(orderDTO.getOrderID());
//        existingOrder.setInvoiceNumber(orderDTO.getInvoiceNumber());
//        existingOrder.setOrderDate(orderDTO.getOrderDate());
//        existingOrder.setOrderQuantity(orderDTO.getOrderQuantity());
//        existingOrder.setOrderAmount(orderDTO.getOrderAmount());
//        existingOrder.setPaymentMethod(orderDTO.getPaymentMethod());
//        existingOrder.setPaymentStatus(orderDTO.getPaymentStatus());
//
//        existingOrder = orderDAO.saveAndFlush(existingOrder);
//
//        return new OrderDTO(existingOrder);
//    }

    //save and update order
    public OrderDTO saveAndUpdateOrder(OrderDTO orderDTO){
        Order existingOrder = null;

        if (orderDTO.getOrderID()!=null){
            existingOrder = orderDAO.getReferenceById(orderDTO.getOrderID());
        }else {
            existingOrder = new Order();
        }

        Hardware hardware = hardwareDAO.getReferenceById(orderDTO.getHardwareID());
        Product product = productDAO.getReferenceById(orderDTO.getProductID());

        existingOrder.setInvoiceNumber(orderDTO.getInvoiceNumber());
        existingOrder.setOrderDate(orderDTO.getOrderDate());
        existingOrder.setHardware(hardware);
        existingOrder.setProduct(product);
        existingOrder.setOrderQuantity(orderDTO.getOrderQuantity());
        existingOrder.setOrderAmount(orderDTO.getOrderAmount());
        existingOrder.setPaymentMethod(orderDTO.getPaymentMethod());
        existingOrder.setPaymentStatus(orderDTO.getPaymentStatus());

        existingOrder = orderDAO.saveAndFlush(existingOrder);
        return new OrderDTO(existingOrder);

    }

    //delete order


    //update order

    // get all orders jdbc
    public List<OrderDTO> getAllOrdersjdbc(OrderSearchRequestDTO orderRQ){
        List<OrderDTO> orderDTOList = this.orderJDBCDao.getAllOrdersjdbc(orderRQ);
        return orderDTOList;
    }

    //DELETE ORDERS
    public boolean deleteOrdersByID (Integer orderID){
        Order exisitngOrders = orderDAO.getOrderByOrderID(orderID);
        if (exisitngOrders != null){
            orderDAO.deleteById(orderID);
            return true;
        }
        return false;
    }


}
