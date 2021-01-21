package com.medipol.h5170028_arda_demirtas_final_proje.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.medipol.h5170028_arda_demirtas_final_proje.model.FilmModel;
import com.medipol.h5170028_arda_demirtas_final_proje.util.GlideUtil;
import com.medipol.h5170028_arda_demirtas_final_proje.R;

import java.util.List;

public class FilmAdaptor extends RecyclerView.Adapter<FilmViewHolder> {


    List<FilmModel> filmler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);//basıldığında çağrılır.
    }


    public FilmAdaptor(List<FilmModel> filmler, Context context, OnItemClickListener listener) {
        this.filmler = filmler;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Bize bir görünüm veren xml i şişiriyoruz
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_film,parent,false);
        return new FilmViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int position) {
        //cardview için tarihi ve ismi aktarır
        viewHolder.txtTarih.setText(filmler.get(position).getFilmTarihi());
        viewHolder.txtFilmAdi.setText(filmler.get(position).getFilmAdi());

        GlideUtil.resmiIndiripGoster(context,filmler.get(position).getLogoURL(),viewHolder.imgFilmLogo);
         //resmi yükleyip görüntüler
    }

    @Override
    public int getItemCount() {
        return filmler.size();
    }
}
