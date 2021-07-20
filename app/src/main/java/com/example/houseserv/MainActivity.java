package com.example.houseserv;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HouseServAdapter houseServAdapter;
    private List<HouseServMenu> houseServMenuListView = new ArrayList<>();

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        houseServAdapter = new HouseServAdapter(this,houseServMenuListView);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(houseServAdapter);
        DevTechPrepare();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void DevTechPrepare() {
        HouseServMenu data = new HouseServMenu(R.mipmap.logo6, R.mipmap.quemsomosport, "Quem é a DevTech?", R.mipmap.imagem_post_desenvolvimento_web, "Nosso Portfólio", R.mipmap.faleconosco, "Agende um horário!");
        houseServMenuListView.add(data);

        Collections.sort(houseServMenuListView, new Comparator<HouseServMenu>() {
            @Override
            public int compare(HouseServMenu o1, HouseServMenu o2) {

                return o1.imgLogo.compareTo(o2.imgLogo); }
        });
    }
}