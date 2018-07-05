package xyz.sleepygamers.maithoncenteen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.List;

import xyz.sleepygamers.maithoncenteen.models.foodmenu;

public class checkoutAdapter extends RecyclerView.Adapter<checkoutAdapter.viewHolder> {
    Context mCtx;
    private List<foodmenu> checkoutList;

    public checkoutAdapter(Context mCtx, List<foodmenu> checkoutList) {
        this.mCtx = mCtx;
        this.checkoutList = checkoutList;
    }

    @NonNull
    @Override
    public checkoutAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.view_checkout, parent, false);
        return new checkoutAdapter.viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull checkoutAdapter.viewHolder holder, int position) {
        foodmenu foodmenu = checkoutList.get(position);
        holder.name.setText(foodmenu.getName());
        holder.price.setText((CharSequence) Integer.toString(Integer.parseInt(foodmenu.getPrice())*(foodmenu.getCount())));
        Glide.with(mCtx)
                .load(foodmenu.getImg())
                .into(holder.imageView);
        holder.qty.setText(Integer.toString(foodmenu.getCount()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView name, price, qty;
        private ImageView imageView;
        private Button delete;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.qty);

        }
    }
}
