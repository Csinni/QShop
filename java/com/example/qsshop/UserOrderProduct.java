package com.example.qsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.qsshop.Admin.AdminUserProductsActivity;
import com.example.qsshop.Model.AdminOrders;
import com.example.qsshop.Model.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserOrderProduct extends AppCompatActivity {

    private RecyclerView ordersList;
    private DatabaseReference ordersRef;
    private String userID = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order_product);

        userID = getIntent().getStringExtra("uid");

        ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders");


        ordersList = findViewById(R.id.orders_list);
        ordersList.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerOptions<AdminOrders> options =
                new FirebaseRecyclerOptions.Builder<AdminOrders>()
                        .setQuery(ordersRef, AdminOrders.class)
                        .build();

        FirebaseRecyclerAdapter<AdminOrders, com.example.qsshop.Admin.AdminNewOrdersActivity.AdminOrdersViewHolder> adapter =
                new FirebaseRecyclerAdapter<AdminOrders, com.example.qsshop.Admin.AdminNewOrdersActivity.AdminOrdersViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull com.example.qsshop.Admin.AdminNewOrdersActivity.AdminOrdersViewHolder holder,
                                                    final int position, @NonNull final AdminOrders model) {

                        holder.userName.setText("Name: " + model.getName());
                        holder.userPhoneNumber.setText("Phone: " + model.getPhone());
                        holder.userTotalPrice.setText("Total Amount =  RM " + model.getTotalAmount());
                        holder.userDateTime.setText("Order at: " + model.getDate() + "  " + model.getTime());
                        holder.userShippingAddress.setText("Shipping Address: " + model.getAddress() + ", " + model.getCity());

                        holder.ShowOrdersBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String uID = getRef(position).getKey();

                                Intent intent = new Intent(UserOrderProduct.this, AdminUserProductsActivity.class);
                                intent.putExtra("uid", uID);
                                startActivity(intent);
                            }
                        });

                    }

                    @NonNull
                    @Override
                    public com.example.qsshop.Admin.AdminNewOrdersActivity.AdminOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_layout, parent, false);
                        return new com.example.qsshop.Admin.AdminNewOrdersActivity.AdminOrdersViewHolder(view);
                    }
                };

        ordersList.setAdapter(adapter);
        adapter.startListening();
    }


    private void RemoverOrder(String uID) {
        ordersRef.child(uID).removeValue();
    }
}

