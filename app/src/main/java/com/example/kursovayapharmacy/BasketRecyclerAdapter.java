package com.example.kursovayapharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasketRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final private List<BasketItemsModel> basketItemsModel;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public BasketRecyclerAdapter(Context context, List<BasketItemsModel> basketItemsModel){
        this.context = context;
        this.basketItemsModel = basketItemsModel;
    }

    public void updateItem(int position, BasketItemsModel basketItemsModel1){
        if(basketItemsModel1.getQuantity()>0){
            basketItemsModel.set(position, basketItemsModel1);
            BasketHelper.getBasket().update(basketItemsModel1.getProduct(), basketItemsModel1.getQuantity());
        }else{
            BasketHelper.getBasket().remove(basketItemsModel.get(position).getProduct());
            onItemClickListener.onUpdateList();
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_item, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReceiveViewHolder viewHolder = (ReceiveViewHolder) holder;
        viewHolder.name.setText(basketItemsModel.get(position).getProduct().getName());
        viewHolder.description.setText(basketItemsModel.get(position).getProduct().getDescr());
        viewHolder.price.setText(String.format(context.getString(R.string.dollars_format), basketItemsModel.get(position).getProduct().getPrice()));
        viewHolder.quantity.setText(String.valueOf(basketItemsModel.get(position).getQuantity()));
        Picasso.get().load(basketItemsModel.get(position).getProduct().getImg()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return basketItemsModel.size();
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.name_basketitem)
        TextView name;
        @BindView(R.id.description_basketitem)
        TextView description;
        @BindView(R.id.image_basketitem)
        ImageView image;
        @BindView(R.id.price_basketitem)
        TextView price;
        @BindView(R.id.quantity_basketitem)
        TextView quantity;
        @BindView(R.id.plus)
        Button plus;
        @BindView(R.id.minus)
        Button minus;

        public ReceiveViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {onItemClickListener.onItemClick(basketItemsModel.get(getAdapterPosition()));
            });
            minus.setOnClickListener(view -> {onItemClickListener.onItemMinusClicked(getAdapterPosition(), basketItemsModel.get(getAdapterPosition()));
            });
            plus.setOnClickListener(view -> {onItemClickListener.onItemPlusClicked(getAdapterPosition(), basketItemsModel.get(getAdapterPosition()));
            });

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(BasketItemsModel basketItemsModel);
        void onItemPlusClicked(int position, BasketItemsModel basketItemsModel);
        void onItemMinusClicked(int position, BasketItemsModel basketItemsModel);
        void onUpdateList();
    }
}
