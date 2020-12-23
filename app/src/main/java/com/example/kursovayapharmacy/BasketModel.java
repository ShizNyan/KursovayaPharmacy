package com.example.kursovayapharmacy;

import java.io.Serializable;
import java.math.BigDecimal;

public class BasketModel implements Serializable {
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private int totalQuantity = 0;
    private ProductModel[] x = new ProductModel[10]; //products array
    private int[] y = new int[10]; //quantity array

    public void add(ProductModel p, int quantity){
        int id;
        id = p.getId();
        x[id] = p;
        y[id] = quantity+1;
        totalPrice = totalPrice.add(BigDecimal.valueOf(p.getPrice()*quantity));
        totalQuantity += quantity;
    }

    public void update(ProductModel p, int quantity){
        int productPrice = p.getPrice()*quantity;
        x[p.getId()] = p;
        y[p.getId()] = quantity;
        totalQuantity =totalQuantity+quantity+1;
        totalPrice = totalPrice.subtract(BigDecimal.valueOf(productPrice)).add(BigDecimal.valueOf(p.getPrice()).multiply(BigDecimal.valueOf(quantity)));
    }

    public void remove(ProductModel p, int quantity){
        int id;
        id = p.getId();
        x[id] = null;
        y[id] = 0;
        totalPrice = totalPrice.subtract(BigDecimal.valueOf(p.getPrice()*quantity));
        totalQuantity -= quantity;
    }

    public void remove(ProductModel p){
        int id;
        id = p.getId();
        int quantity = y[id];
        x[id] = null;
        y[id] = 0;
        totalPrice = totalPrice.subtract(BigDecimal.valueOf(p.getPrice()*quantity));
        totalQuantity -= quantity;
    }

    public void clear(){
        for(int i = 0; i<100; i++){
            x[i] = null;
            y[i] = 0;
        }
        totalPrice = BigDecimal.ZERO;
        totalQuantity = 0;
    }

    public BigDecimal getTotalPrice(){
        return totalPrice;
    }

    public int getTotalQuantity(){
        return totalQuantity;
    }

    public ProductModel[] getProducts(){
        return x;
    }

    public int[] getQuantities(){
        return y;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<100; i++){
            if (x[i] != null) {
                str.append(String.format("Товар: %s; Цена: %f; Количество: %d%n", x[i].getName(), x[i].getPrice(), y[i]));
            }
        }
        str.append(String.format("Общее количество товаров: %d; Общая цена: %f"));

        return str.toString();
    }

}
