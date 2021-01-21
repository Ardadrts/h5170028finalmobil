package com.medipol.h5170028_arda_demirtas_final_proje.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.medipol.h5170028_arda_demirtas_final_proje.R;
import com.medipol.h5170028_arda_demirtas_final_proje.model.FilmModel;
import com.medipol.h5170028_arda_demirtas_final_proje.util.Constants;
import com.medipol.h5170028_arda_demirtas_final_proje.util.GlideUtil;
import com.medipol.h5170028_arda_demirtas_final_proje.util.ObjectUtil;

public class FilmDetayActivity extends AppCompatActivity {
    ImageView imgKapak;//verileri göstermek içindir.
    TextView txtBaslik;
    TextView txtDetay;
    TextView txtOyuncuDetay;
    TextView txtOyuncular;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {//activity den aktarılan bilgiyi alır.
        // önceki XML düzeninde tanımlanan metin görünümünün içeriğinin nasıl değiştirileceğini gösterir.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);
        init();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void init() {
        String tasinanFilmString = getIntent().getStringExtra(Constants.TIKLANAN_FILM_TASINANIN_BASLIGI);

        FilmModel filmModel = ObjectUtil.jsonStringTofilm(tasinanFilmString);

        imgKapak = findViewById(R.id.imgKapak);//findViewById yöntemin sonucunu viewdan, textViewa değiştiriyoruz.
        txtOyuncuDetay = findViewById(R.id.txtOyuncuDetay);//özel bir kimlik verir.
        txtOyuncular = findViewById(R.id.txtOyuncular);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);

        txtBaslik.setText(filmModel.getFilmAdi());//jsondaki verileri çeker,film adı,oyuncular,açıklamayı ve resmi getirir.
        txtOyuncuDetay.setText(filmModel.getOyuncular());
        txtDetay.setText(Html.fromHtml(filmModel.getAciklama(), Html.FROM_HTML_MODE_COMPACT));//html olarak çekmek için kullanılır.
        GlideUtil.resmiIndiripGoster(getApplicationContext(), filmModel.getKapakFotoURL(), imgKapak);

    }
}