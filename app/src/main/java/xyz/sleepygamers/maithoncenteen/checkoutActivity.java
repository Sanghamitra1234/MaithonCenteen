package xyz.sleepygamers.maithoncenteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import xyz.sleepygamers.maithoncenteen.models.foodmenu;

public class checkoutActivity extends AppCompatActivity {
    List<foodmenu> checkoutList;
    RecyclerView recyclerView;
    public checkoutAdapter checkoutAdapter;
    public Button checkout;
    public int total;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_acitivity);
        recyclerView = findViewById(R.id.recylcerView_checkout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        checkout=findViewById(R.id.checkout);

        checkoutList= (ArrayList<foodmenu>) getIntent().getSerializableExtra("food_array");
        checkoutAdapter = new checkoutAdapter(checkoutActivity.this, checkoutList);
        recyclerView.setAdapter(checkoutAdapter);



    }
}
