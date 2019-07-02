package com.firyalf.sub1made;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv1;
    String[] judulMovie, waktuMovie, descMovie;
    int[] gambarMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);

        judulMovie = getResources().getStringArray(R.array.judul);
        waktuMovie = getResources().getStringArray(R.array.time);
        descMovie = getResources().getStringArray(R.array.desc);
        gambarMovie = new int[]{R.drawable.poster_aquaman,
                R.drawable.poster_avengerinfinity,
                R.drawable.poster_bohemian,
                R.drawable.poster_bumblebee,
                R.drawable.poster_deadpool,
                R.drawable.poster_dragon,
                R.drawable.poster_glass,
                R.drawable.poster_robinhood,
                R.drawable.poster_spiderman,
                R.drawable.poster_venom};


//        String number = new Integer("gambarMovie").toString();

        AdapterFilm adapterFilm = new AdapterFilm(MainActivity.this,
                gambarMovie, judulMovie, waktuMovie, descMovie);

        rv1.setHasFixedSize(true);
        rv1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv1.setAdapter(adapterFilm);
    }
}
