package com.example.submission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity {
    private RecyclerView rvChara;
    private ArrayList<Chara> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChara = findViewById(R.id.rv_games);
        rvChara.setHasFixedSize(true);

        list.addAll(getListData());
        showRecyclerList();
    }
    private ArrayList<Chara> getListData() {
        String[] dataName = getResources().getStringArray(R.array.chara_name);
        String[] dataDetail = getResources().getStringArray(R.array.detail);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.gambar);
        String[] dataKelebihan = getResources().getStringArray(R.array.chara_kelebihan);
        String[] dataKekurangan = getResources().getStringArray(R.array.chara_kekurangan);
        String[] dataUlti = getResources().getStringArray(R.array.chara_ulti);
        String[] dataRole = getResources().getStringArray(R.array.chara_role_speciality);


        ArrayList<Chara> list = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Chara chara = new Chara ();
            chara.setName(dataName[i]);
            chara.setDetail(dataDetail[i]);
            chara.setPhoto(dataPhoto.getResourceId(i, -1));
            chara.setChara_kelebihan(dataKelebihan[i]);
            chara.setChara_kekurangan(dataKekurangan[i]);
            chara.setChara_ulti(dataUlti[i]);
            chara.setRole(dataRole[i]);
            list.add(chara);
        }
        return list;
    }
    private void showRecyclerList() {
        Log.d(MainActivity.class.getSimpleName(), "Isi List "+list.size());
        rvChara.setLayoutManager(new LinearLayoutManager(this));
        ListCharaAdapter listGameAdapter = new ListCharaAdapter (list);
        rvChara.setAdapter(listGameAdapter);

        listGameAdapter.setOnItemClickCallback(new ListCharaAdapter.OnItemClickCallback () {
            @Override
            public void onItemClicked(Chara data) {
                Intent moveToDetailActivity = new Intent(MainActivity.this, DetailActivity.class);
                moveToDetailActivity.putExtra(DetailActivity.EXTRA_DATA, data);
                startActivity(moveToDetailActivity);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Intent moveIntent = new Intent(MainActivity.this, About.class);
            startActivity(moveIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
