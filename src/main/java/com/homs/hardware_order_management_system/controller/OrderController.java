package com.homs.hardware_order_management_system.controller;

import com.homs.hardware_order_management_system.dto.OrderSearchRequestDTO;
import com.homs.hardware_order_management_system.dto.ResponseDTO;
import com.homs.hardware_order_management_system.model.Order;
import com.homs.hardware_order_management_system.model.dto.OrderDTO;
import com.homs.hardware_order_management_system.service.OrderService;
import com.homs.hardware_order_management_system.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    //get all order
    @GetMapping(value = "/get-all-order")
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        List<OrderDTO> orderList = this.orderService.getAllOrder();
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }


    //search order by id
    @GetMapping(value = "/search-order/{orderID}")
    public ResponseEntity<OrderDTO> searchHardware(@PathVariable Integer orderID){
        OrderDTO orderDTO = this.orderService.searchOrder(orderID);
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }

    //save order
//    @PostMapping(value = "save-order")
//    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO){
//        OrderDTO newOrder = this.orderService.saveOrder(orderDTO);
//        return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
//    }

    //update hardwareID
//    @PutMapping(value = "/update-order")
//    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO){
//        OrderDTO existingOrder = this.orderService.updateOrder(orderDTO);
//        return new ResponseEntity<>(existingOrder,HttpStatus.CREATED);
//    }

    //save and update order
    @PostMapping(value = "save-and-update-order")
    public ResponseEntity<OrderDTO> saveAndUpdateOrder(@RequestBody OrderDTO orderDTO){
        OrderDTO newOrder = this.orderService.saveAndUpdateOrder(orderDTO);
        return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
    }

    //delete order
    @DeleteMapping(value = "/delete-order/{orderID}")
    public ResponseEntity<Boolean> deleteOrdersByID(@PathVariable Integer orderID){
        Boolean result = this.orderService.deleteOrdersByID(orderID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    //get all orders jdbc
    @PostMapping(value = "/get-all-order-jdbc")
    public ResponseEntity<List<OrderDTO>> getAllOrdersWithSearch(@RequestBody OrderSearchRequestDTO orderSearchRequestDTO){
        List<OrderDTO> orders = this.orderService.getAllOrdersjdbc(orderSearchRequestDTO);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }





}
