package com.example.kursovayapharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ProductModel> catalogModels;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public ProductRecyclerAdapter(Context context, List<ProductModel> catalogModels){
        this.context = context;
        this.catalogModels = catalogModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReceiveViewHolder viewHolder = (ReceiveViewHolder) holder;
        viewHolder.title.setText(catalogModels.get(position).getName());
        viewHolder.description.setText(catalogModels.get(position).getDescr());
        viewHolder.price.setText(String.format(context.getString(R.string.dollars_format), catalogModels.get(position).getPrice()));
        Picasso.get().load(catalogModels.get(position).getImg()).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return catalogModels.size();
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.title)
                TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.buyButton1)
        Button buyButton;

        public ReceiveViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            buyButton.setOnClickListener(view -> {
                onItemClickListener.onItemClick(catalogModels.get(getAdapterPosition()));
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(ProductModel productModel);
    }
}
