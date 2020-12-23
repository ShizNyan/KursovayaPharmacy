package com.example.kursovayapharmacy;

public class BasketItemsModel {
    private ProductModel p;
    private int quantity = 1;

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public ProductModel getProduct(){
        return p;
    }

    public void setProduct(ProductModel p){
        this.p = p;
    }

}
