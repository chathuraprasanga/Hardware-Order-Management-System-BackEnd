package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.dao.ProductDAO;
import com.homs.hardware_order_management_system.dao.jdbc.ProductJDBCDAO;
import com.homs.hardware_order_management_system.dto.ProductSearchRequestDTO;
import com.homs.hardware_order_management_system.model.Product;
import com.homs.hardware_order_management_system.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductJDBCDAO productJDBCDAO;


    //get all method
    public List<ProductDTO> getAllProduct(){
        List<Product> productList = this.productDAO.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product: productList){
            ProductDTO productDTO = new ProductDTO(product);


            productDTOList.add(productDTO);
        }
        return productDTOList;
    }


    //search productID by id
    public Product searchProduct(Integer productID){
        Product product = this.productDAO.getProductByProductID(productID);
        return product;
    }

    //save productID
//    public ProductDTO saveProduct(ProductDTO productDTO){
//        Product product = new Product();
//        product.setProductCode(productDTO.getProductCode());
//        product.setProductName(productDTO.getProductName());
//        product.setProductSize(productDTO.getProductSize());
//        product.setProductPrice(productDTO.getProductPrice());
//        product.setProductStatus(productDTO.getProductStatus());
//
//        this.productDAO.saveAndFlush(product);
//        return new ProductDTO(product);
//    }

    //save and update method
    public ProductDTO saveAndUpdateProduct(ProductDTO productDTO){

        Product newProduct = null;

        if (productDTO.getProductID()!= null){
            newProduct = productDAO.getReferenceById(productDTO.getProductID());
        }else {
            newProduct = new Product();
        }

        newProduct.setProductCode(productDTO.getProductCode());
        newProduct.setProductName(productDTO.getProductName());
        newProduct.setProductSize(productDTO.getProductSize());
        newProduct.setProductPrice(productDTO.getProductPrice());
        newProduct.setProductStatus(productDTO.getProductStatus());

        this.productDAO.saveAndFlush(newProduct);
        return new ProductDTO(newProduct);
    }

    //get all product jdbc
    public  List<ProductDTO> getAllProductsJdbc(ProductSearchRequestDTO productRQ){
        List<ProductDTO> productDTOList = this.productJDBCDAO.getAllProductsJdbc(productRQ);
        return productDTOList;
    }


    //delete productID
    public Boolean deleteProduct(Integer productID) {
        Product existingProduct = this.productDAO.getProductByProductID(productID);
        if (existingProduct!=null){
            productDAO.deleteById(productID);
            return true;
        }else {
            return false;
        }

    }

    //get all active products
    public List<ProductDTO> getAllActiveProduct() {
        List<ProductDTO> result = this.productJDBCDAO.getAllActiveProduct();
        return result;
    }

    //get product price by product code
    public Integer getProductPriceByCode(Integer productID) {

        Product selectedProduct = this.productDAO.getProductByProductID(productID);
        Integer productPrice = selectedProduct.getProductPrice();
        return productPrice;
    }

    //update productID
//    public Product updateProduct(Product product){
//
//        Product existingProduct = this.productDAO.saveAndFlush(product);
//        return existingProduct;
//    }

}
