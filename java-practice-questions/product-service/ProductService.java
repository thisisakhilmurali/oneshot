package com.tasks.problem;

 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

 

public class ProductService {

    List<Product> products;

    public List<Product> getAllProducts() {

        if (products != null){
            return products;
        }

        try(Reader reader = new BufferedReader(new FileReader("products.csv"))) {

            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
            .withType(Product.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build(); 

            products = csvToBean.parse();

            return products;

        } catch (Exception e) {
            throw new RuntimeException("FAILURE_TO_PROCESS_CSV", e);
        }
    }   


    public List<Product> getProductsWithPriceGreaterThan(Double price){

        if(products == null) {
            getAllProducts();
        } 

        List<Product> filteredProducts = new ArrayList<>();

        for(Product product : products) {
            if(product.getPrice() > price){
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

   

    public Double groupByCategoryAndAggregateValue(String category){

        if(products == null) {
            getAllProducts();
        }

        double tot = 0.0;
        for (Product product : products){

            if(product.getCategory().equals(category)){
                tot += product.getPrice();
            }
        }
        return tot;
    }

   

    public Double calculateAverageOfAllProducts(){
        if(products == null) {
            getAllProducts();
        }

        double tot = 0.0;

        for(Product product : products){
            tot += product.getPrice();
        }
        return tot / products.size();

    }

   

    public Product findProductWithHighestPrice(){

        if(products == null) {
            getAllProducts();
        }

        Product maxProduct = null;         

        for (Product product : products) {
            if(maxProduct == null || product.getPrice() > maxProduct.getPrice()){
                maxProduct = product;
            }
        }
        return maxProduct;
    }

}