package com.example.qsshop.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.qsshop.MainActivity;
import com.example.qsshop.R;

public class AdminCategoryActivity extends AppCompatActivity
{
    private ImageView skincare, packmask, makeup, beautytools;
    private ImageView bodycare, haircare, bathbody, health;
    private ImageView medicine, facemask;

    private Button LogoutBtn, CheckOrdersBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        CheckOrdersBtn = (Button) findViewById(R.id.check_orders_btn);
        LogoutBtn = (Button) findViewById(R.id.admin_logout_btn);

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });

        skincare = (ImageView) findViewById(R.id.skin_care);
        packmask = (ImageView) findViewById(R.id.pack_mask);
        makeup = (ImageView) findViewById(R.id.make_up);
        beautytools = (ImageView) findViewById(R.id.beauty_tools);

        bodycare = (ImageView) findViewById(R.id.body_care);
        haircare = (ImageView) findViewById(R.id.hair_care);
        bathbody = (ImageView) findViewById(R.id.bath_body);
        health = (ImageView) findViewById(R.id.health_wellness);

        medicine = (ImageView) findViewById(R.id.medicine);
        facemask = (ImageView) findViewById(R.id.face_mask);


        skincare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Skin Care");
                startActivity(intent);
            }
        });

        packmask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Pack Mask");
                startActivity(intent);
            }
        });

        makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Make Up");
                startActivity(intent);
            }
        });

        beautytools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Beauty Tools");
                startActivity(intent);
            }
        });

        bodycare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Body Care");
                startActivity(intent);
            }
        });

        haircare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Hair Care");
                startActivity(intent);
            }
        });

        bathbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Bath & Body");
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Health & Wellness");
                startActivity(intent);
            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Medicine");
                startActivity(intent);
            }
        });

        facemask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Face Mask & Sanitizer");
                startActivity(intent);
            }
        });

    }
}