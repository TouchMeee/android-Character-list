package com.example.submission;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ImageView imgPhoto = findViewById(R.id.img_item_photo);
        TextView tvName = findViewById(R.id.tv_detail_nama);
        TextView tvDetail = findViewById(R.id.tv_detail_chara);
        TextView tvKelebihan = findViewById(R.id.tv_detail_kelebihan);
        TextView tvKekurangan = findViewById(R.id.tv_detail_kekurangan);
        TextView tvRole = findViewById(R.id.tv_detail_role);
        TextView tvUltimate = findViewById(R.id.tv_detail_ulti);

        Chara chara = getIntent().getParcelableExtra(EXTRA_DATA);

        getSupportActionBar().setTitle("Detail Character");

        if (chara != null) {
            Glide.with(this)
                    .load(chara.getPhoto())
                    .into(imgPhoto);
            Log.d(MainActivity.class.getSimpleName(), "testing gambar " + chara.getPhoto());

            tvName.setText(chara.getName());
            tvDetail.setText(chara.getDetail());
            tvKelebihan.setText(chara.getChara_kelebihan());
            tvKekurangan.setText(chara.getChara_kekurangan());
            tvUltimate.setText(chara.getChara_ulti());
            tvRole.setText(chara.getRole());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}