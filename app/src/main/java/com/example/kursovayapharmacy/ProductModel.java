package com.example.kursovayapharmacy;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductModel implements Serializable {
    private int id;
    private String name;
    private int price;
    private String description;
    private String image;

    public ProductModel(){
        super();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof ProductModel)) return false;

        return (this.id == ((ProductModel) o).getId());
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescr(){
        return description;
    }

    public void setDescr(String descr){
        this.description = descr;
    }

    public String getImg(){
        return image;
    }

    public void setImg(String img){
        this.image = img;
    }

}
