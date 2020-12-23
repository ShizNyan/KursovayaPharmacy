package com.example.kursovayapharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsActivity extends FragmentActivity implements ProductRecyclerAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        ProductRecyclerAdapter productRecyclerAdapter = new ProductRecyclerAdapter(this, ProductsHelper.getProductsList());
        productRecyclerAdapter.setOnItemClickListener(this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(productRecyclerAdapter);

        ImageButton back_button1 = (ImageButton)findViewById(R.id.button_back1);

        back_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onItemClick(ProductModel productModel){
        BasketModel basket = BasketHelper.getBasket();
        basket.add(productModel, 1);

        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);

    }
}
