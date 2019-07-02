package com.firyalf.sub1made;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView imgMovie;
    TextView txtjudul, txtDesc, txtWaktu;
    public static final String EXTRA_OBJEK = "obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgMovie = findViewById(R.id.imgMovie);
        txtjudul = findViewById(R.id.judulMovie);
        txtDesc = findViewById(R.id.descMovie);
        txtWaktu = findViewById(R.id.waktuMovie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_OBJEK);
//
        String judul = movie.getJudul();
        String waktu = movie.getWaktu();
        String desc = movie.getDesc();
        int gambar = movie.getGambar();

        txtjudul.setText(judul);
        txtWaktu.setText(waktu);
        txtDesc.setText(desc);
        Glide.with(this).load(gambar).into(imgMovie);


//        String judul = movie.
//        txtjudul.setText( getIntent().getParcelableExtra( "jdl", movie ) );
//        txtWaktu.setText( (CharSequence) getIntent().getParcelableExtra( "waktu" ) );
//        txtDesc.setText( (CharSequence) getIntent().getParcelableExtra( "desc" ) );
    }
}
