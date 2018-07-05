package xyz.sleepygamers.maithoncenteen;

import android.content.Context;
import android.icu.util.Measure;
import android.provider.ContactsContract;
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

import static com.cepheuen.elegantnumberbutton.view.ElegantNumberButton.*;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ViewHolder>  {
    Context mCtx;
    private List<foodmenu> breakfastList;

    public BreakfastAdapter(Context mCtx, List<foodmenu> breakfastList) {
        this.mCtx = mCtx;
        this.breakfastList=breakfastList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.breakfast_view, parent,false);
        return new BreakfastAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final foodmenu foodmenu= breakfastList.get(position);
        holder.name.setText(foodmenu.getName());
        holder.price.setText((CharSequence) foodmenu.getPrice());
        Glide.with(mCtx)
                .load(foodmenu.getImg())
                .into(holder.imageView);
        holder.elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = holder.elegantNumberButton.getNumber();
                foodmenu.setCount(Integer.parseInt(s));
            }
        });
    }

    @Override
    public int getItemCount() {
        return breakfastList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,price;
        private ImageView imageView;
        private Button add;
        public ElegantNumberButton elegantNumberButton;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.breakfast_img);
            name=itemView.findViewById(R.id.breakfast_name);
            price=itemView.findViewById(R.id.breakfast_price);
            add=itemView.findViewById(R.id.add_btn);
            elegantNumberButton=(ElegantNumberButton) itemView.findViewById(R.id.qty_button);

        }

    }
}
