package com.medipol.h5170028_arda_demirtas_final_proje.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.medipol.h5170028_arda_demirtas_final_proje.R;

import org.w3c.dom.Text;

public class FilmViewHolder extends RecyclerView.ViewHolder {

    ImageView imgFilmLogo;
    TextView txtFilmAdi;
    TextView txtTarih;

    public FilmViewHolder(@NonNull View cardView, FilmAdaptor.OnItemClickListener listener) {//verideki listeleri getirir.
        super(cardView);

        imgFilmLogo =cardView.findViewById(R.id.imgFilmLogo);
        txtFilmAdi =cardView.findViewById(R.id.txtFilmAdi);
        txtTarih =cardView.findViewById(R.id.txtTarih);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listener.onClik(getAdapterPosition());//basıldığında ekrana getirir.
            }
        });

    }
}
