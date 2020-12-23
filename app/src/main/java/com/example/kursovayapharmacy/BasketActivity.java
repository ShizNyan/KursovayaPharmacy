package com.example.kursovayapharmacy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

public class BasketActivity extends FragmentActivity implements BasketRecyclerAdapter.OnItemClickListener{
    private BasketRecyclerAdapter basketRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);

        onUpdateList();

        ImageButton back_button3 = (ImageButton)findViewById(R.id.button_back3);
        back_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasketActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        Button buy_button = (Button)findViewById(R.id.buy_button);
        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasketActivity.this, FillInForm.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(BasketItemsModel basketItemsModel) {

    }

    @Override
    public void onItemPlusClicked(int position, BasketItemsModel basketItemsModel) {
        int quantity = basketItemsModel.getQuantity();
        BasketItemsModel basketItemsModel1 = new BasketItemsModel();
        basketItemsModel1.setProduct(basketItemsModel.getProduct());
        quantity++;
        basketItemsModel1.setQuantity(quantity);
        basketRecyclerAdapter.updateItem(position, basketItemsModel1);

    }

    @Override
    public void onItemMinusClicked(int position, BasketItemsModel basketItemsModel) {
        int quantity = basketItemsModel.getQuantity();
        BasketItemsModel basketItemsModel1 = new BasketItemsModel();
        basketItemsModel1.setProduct(basketItemsModel.getProduct());
        quantity--;
        basketItemsModel1.setQuantity(quantity);
        basketRecyclerAdapter.updateItem(position, basketItemsModel1);

    }

    @Override
    public void onUpdateList() {
        basketRecyclerAdapter = new BasketRecyclerAdapter(this, BasketHelper.getBasketItems());
        basketRecyclerAdapter.setOnItemClickListener(this);
        RecyclerView recyclerView1 = (RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(basketRecyclerAdapter);
    }

}
