package com.example.kursovayapharmacy;

import java.util.ArrayList;
import java.util.List;

public class BasketHelper {

    private static BasketModel basket = new BasketModel();

    public static BasketModel getBasket(){
        if(basket == null){
            basket = new BasketModel();
        }

        return basket;
    }

    public static List<BasketItemsModel> getBasketItems(){
        List<BasketItemsModel> items = new ArrayList<>();
        ProductModel[] x = getBasket().getProducts();

        for(int i = 0; i<x.length; i++){
            if(x[i]!=null) {
                BasketItemsModel item = new BasketItemsModel();
                item.setProduct(x[i]);
                items.add(item);
            }
        }

        return items;
    }
}
