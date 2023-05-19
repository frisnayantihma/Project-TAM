package com.example.project531.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project531.Domain.CoffeDomain;
import com.example.project531.Helper.ManagementKeranjang;
import com.example.project531.R;

public class DetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt, starTxt, beratTxt, driverTxt;
    private ImageView plusBtn, minusBtn, picCoffe;
    private CoffeDomain object;
    private int numberOrder = 1;
    private ManagementKeranjang managementKeranjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementKeranjang = new ManagementKeranjang(this);

        iniView();
        getBundle();
    }

    private void getBundle() {
        object = (CoffeDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picCoffe);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("RP" + object.getBayar());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        beratTxt.setText(object.getBerat() + " berat");
        starTxt.setText(object.getStar() + " star");
        driverTxt.setText(object.getDriver() + " menit");
        totalPriceTxt.setText("RP"+Math.round(numberOrder * object.getBayar()));
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+Math.round(numberOrder * object.getBayar()));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+Math.round(numberOrder * object.getBayar()));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementKeranjang.insertFood(object);
            }
        });
    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberItemTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picCoffe = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        starTxt = findViewById(R.id.starTxt);
        beratTxt = findViewById(R.id.beratTxt);
        driverTxt = findViewById(R.id.timeTxt);
    }
}
