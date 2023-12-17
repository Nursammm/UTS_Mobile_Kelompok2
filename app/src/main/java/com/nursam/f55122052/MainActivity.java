package com.nursam.f55122052;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLingkungan;
    private ArrayList<Lingkungan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvLingkungan = findViewById(R.id.rv_lingkungan);
        rvLingkungan.setHasFixedSize(true);

        list.addAll(getListLingkungan());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_list){
            rvLingkungan.setLayoutManager(new LinearLayoutManager(this));
        }else if (item.getItemId() == R.id.action_grid){
            rvLingkungan.setLayoutManager(new GridLayoutManager(this, 2));
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Lingkungan> getListLingkungan(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray
                (R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Lingkungan> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Lingkungan lingkungan = new Lingkungan();
            lingkungan.setName(dataName[i]);
            lingkungan.setDescription(dataDescription[i]);
            lingkungan.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(lingkungan);
        }
        return listHero;
    }
    private void showRecyclerList(){
        rvLingkungan.setLayoutManager(new LinearLayoutManager(this));
        ListLingkunganAdapter listLingkunganAdapter = new ListLingkunganAdapter(list);
        rvLingkungan.setAdapter(listLingkunganAdapter);

        listLingkunganAdapter.setOnItemClickCallback(this::showSelectedLingkungan);
    }
    private void showSelectedLingkungan(Lingkungan lingkungan){
        Toast.makeText(this, "Kamu Memilih " + lingkungan.getName(), Toast.LENGTH_SHORT).show();
    }
}