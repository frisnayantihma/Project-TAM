package com.example.project531.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project531.Adapter.KategoriAdapter;
import com.example.project531.Adapter.RecommendedAdapter;
import com.example.project531.Domain.KategoriDomain;
import com.example.project531.Domain.CoffeDomain;
import com.example.project531.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewKategoriList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout profilBtn=findViewById(R.id.profilBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeranjangActivity.class));
            }
        });

        profilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfilActivity.class));
            }
        });
    }




    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<CoffeDomain> foodlist = new ArrayList<>();
        foodlist.add(new CoffeDomain("Kopi Robusta", "kopirobusta", "kopi Robusta adalah pekat dan agak pahit", 15.000, 5, 30, 1000));
        foodlist.add(new CoffeDomain("Kopi Luwak", "kopiluwak", "kopi luwak memiliki rasa yang smooth full body, , dan after taste yang exellent ", 17.000, 4, 25, 1500));
        foodlist.add(new CoffeDomain("Kopi Gayo", "kopigayo", " Kopi Aceh Gayo memiliki karakter dan cita rasa kuat", 16.000, 5, 20, 800));

        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewKategoriList = findViewById(R.id.view1);
        recyclerViewKategoriList.setLayoutManager(linearLayoutManager);

        ArrayList<KategoriDomain> categoryList = new ArrayList<>();
        categoryList.add(new KategoriDomain("Robusta", "robusta"));
        categoryList.add(new KategoriDomain("Arabika", "arabika"));
        categoryList.add(new KategoriDomain("Gayo", "gayo"));
        categoryList.add(new KategoriDomain("Luwak", "luak"));
        categoryList.add(new KategoriDomain("Lampung", "koplam"));

        adapter = new KategoriAdapter(categoryList);
        recyclerViewKategoriList.setAdapter(adapter);

    }
}