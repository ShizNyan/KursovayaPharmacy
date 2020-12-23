package com.example.kursovayapharmacy;

import java.util.ArrayList;
import java.util.List;

public class ProductsHelper {
    public static List<ProductModel> getProductsList(){
        List<ProductModel> models = new ArrayList<>();

        ProductModel model = new ProductModel();
        model.setId(0);
        model.setName("Нурофен");
        model.setDescr("Обезболивающее");
        model.setImg("https://medprostatit.ru/wp-content/uploads/2018/08/nurofen-analog-brufena.png");
        model.setPrice(100);
        models.add(model);

        model = new ProductModel();
        model.setId(1);
        model.setName("Анальгин");
        model.setDescr("Обезболивающее ещё одно");
        model.setImg("https://alkogolizma.com/wp-content/uploads/2018/10/ukoly-analgin.jpg");
        model.setPrice(200);
        models.add(model);

        model = new ProductModel();
        model.setId(2);
        model.setName("Эвалар");
        model.setDescr("Укрепляет нервы");
        model.setImg("https://novosibirsk.altaimag.ru/upload/iblock/516/516577a9c45e34b218576501aff5473a.jpg");
        model.setPrice(300);
        models.add(model);

        model = new ProductModel();
        model.setId(3);
        model.setName("Калий+Магний");
        model.setDescr("Укрепляет нервы опять");
        model.setImg("https://cdn1.ozone.ru/multimedia/1036574053.jpg");
        model.setPrice(150);
        models.add(model);

        return models;
    }
}
