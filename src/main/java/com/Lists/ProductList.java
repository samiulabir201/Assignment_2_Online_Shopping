package com.Lists;

import java.util.Arrays;
import java.util.List;

public class ProductList {
    public int productID;
    public String productName;
    public double productPrice;
    public String imageSrc;

    public ProductList(){}

    public static List<ProductList> productLists = Arrays.asList(
            new ProductList(1,"Hp Laptpop",55000,"./images/HP.jpg"),
            new ProductList(2,"MacBook Pro Laptpop",150000,"./images/macbook.jpg"),
            new ProductList(3,"IPhone",125000,"./images/iphone.jpg"),
            new ProductList(4,"Airpod",40000,"./images/airpod.jpg")
    );
    public ProductList(int productID, String productName, double productPrice, String imageSrc) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageSrc = imageSrc;
    }
}
