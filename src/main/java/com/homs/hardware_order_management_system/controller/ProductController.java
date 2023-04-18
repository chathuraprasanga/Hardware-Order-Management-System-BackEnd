package com.homs.hardware_order_management_system.controller;


import com.homs.hardware_order_management_system.dto.ProductSearchRequestDTO;
import com.homs.hardware_order_management_system.model.Product;
import com.homs.hardware_order_management_system.model.dto.ProductDTO;
import com.homs.hardware_order_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    //get all productID
    @GetMapping(value = "/get-all-product")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        List<ProductDTO> hardwareList = this.productService.getAllProduct();
        return new ResponseEntity<>(hardwareList,HttpStatus.OK);
    }

    //get all active product
    @GetMapping(value = "get-all-active-product")
    public ResponseEntity<List<ProductDTO>> getAllActiveProduct(){
        List<ProductDTO> result = this.productService.getAllActiveProduct();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //search productID by id
    @GetMapping(value = "/search-product/{productID}")
    public ResponseEntity<Product> searchHardware(@PathVariable Integer productID){
        Product product = this.productService.searchProduct(productID);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping(value = "/get-product-price-by-ID/{productID}")
    public ResponseEntity<Integer> getPriceByCode(@PathVariable Integer productID){
        Integer productPrice = this.productService.getProductPriceByCode(productID);
        return new ResponseEntity<>(productPrice,HttpStatus.OK);
    }


    //save-productID
//    @PostMapping(value = "save-product")
//    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
//        ProductDTO newProduct = this.productService.saveProduct(productDTO);
//        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
//    }


    //update productID
//    @PutMapping(value = "/update-product")
//    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
//        Product newProduct = this.productService.updateProduct(product);
//        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
//    }

    //save and update productID
    @PostMapping(value = "/save-and-update-product")
    public ResponseEntity<ProductDTO> saveAndUpdateProduct(@RequestBody ProductDTO productDTO){
        ProductDTO newProduct = this.productService.saveAndUpdateProduct(productDTO);
        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }

    //delete productID
    @DeleteMapping(value = "/delete-product/{productID}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer productID){
        Boolean result = this.productService.deleteProduct(productID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    //get all products jdbc
    @RequestMapping(value = "/get-all-product-jdbc", method = RequestMethod.POST)
    public  ResponseEntity<List<ProductDTO>> getAllProductsWithSearch(@RequestBody ProductSearchRequestDTO productSearchRequestDTO){
        List<ProductDTO> productDTOList = this.productService.getAllProductsJdbc(productSearchRequestDTO);
        return new ResponseEntity<>(productDTOList,HttpStatus.OK);
    }


}
