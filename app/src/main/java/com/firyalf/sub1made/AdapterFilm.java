package com.firyalf.sub1made;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterFilm extends RecyclerView.Adapter<AdapterFilm.ViewHolder> {
    Context context;
    String[] namaMovie, detailMovie, waktuMovie;
    int[] gambarMovie;

    public AdapterFilm(Context context, int[] gambarMovie,
                       String[] namaMovie, String[] detailMovie, String[] waktuMovie) {
        this.context = context;
        this.gambarMovie = gambarMovie;
        this.namaMovie = namaMovie;
        this.detailMovie = detailMovie;
        this.waktuMovie = waktuMovie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_film, viewGroup, false);
        return new ViewHolder(view);
    }

//    final String urlgambar =


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtJudul.setText(namaMovie[i]);
        viewHolder.txtwaktu.setText(waktuMovie[i]);

        Glide.with(context).load(gambarMovie[i]).into(viewHolder.imgMovie);


//        final String img = String.valueOf( gambarMovie[i] );

//        gambarMovie.toString();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new Movie();
                movie.setJudul(namaMovie[i]);
                movie.setWaktu(waktuMovie[i]);
                movie.setDesc(detailMovie[i]);
                movie.setGambar(gambarMovie[i]);
//                movie.setGambar();


                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_OBJEK, movie);
                context.startActivity(intent);
//                Intent move = new Intent( context, DetailActivity.class );
//                move.putExtra( "jdl", namaMovie[i] );
//                move.putExtra( "waktu", waktuMovie[i] );
//                move.putExtra( "desc", detailMovie[i] );
//                context.startActivity( move );
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarMovie.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView txtJudul, txtwaktu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.imgMovie);
            txtJudul = itemView.findViewById(R.id.judulMovie);
            txtwaktu = itemView.findViewById(R.id.waktuMovie);
        }
    }
}
