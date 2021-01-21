package com.medipol.h5170028_arda_demirtas_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.medipol.h5170028_arda_demirtas_final_proje.R;
import com.medipol.h5170028_arda_demirtas_final_proje.adaptor.FilmAdaptor;
import com.medipol.h5170028_arda_demirtas_final_proje.model.FilmModel;
import com.medipol.h5170028_arda_demirtas_final_proje.network.Service;
import com.medipol.h5170028_arda_demirtas_final_proje.util.Constants;
import com.medipol.h5170028_arda_demirtas_final_proje.util.NetworkUtil;
import com.medipol.h5170028_arda_demirtas_final_proje.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    NetworkUtil myReceiver;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        progressDialog = new ProgressDialog(ListeActivity.this);//ekran açılırken yükleniyor görüntüsü verir.
        progressDialog.show();


        init();

    }

    private  void  init()
    {
        getNetworkUtil();//networkutil çağırır.
        filmleriGetir();//filmlerigetir çağırır.
    }
    void  filmleriGetir()
    {

        new Service().getServiceApi().filmleriGetir().//get ile çağırır ve filmleri getirir.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FilmModel>>() {

                    List<FilmModel> filmler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<FilmModel> filmList) {//verileri alır
                        Log.e("RETROFIT","onNext : ");
                        filmler=filmList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());//hata gelirse log atar
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        progressDialog.dismiss();

                        if(filmler.size()>0) {



                            initRecycleView(filmler);//veriler ile recyleview hazırlar
                        }
                    }
                });
    }


    private  void  initRecycleView(List<FilmModel> filmList)
    {
        recyclerView =findViewById(R.id.rcvFilmler);
        FilmAdaptor filmAdaptor =new FilmAdaptor(filmList, getApplicationContext(), new FilmAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {//tıklanan filmleri açar.
                FilmModel tiklananFilm = filmList.get(position);//film listesini getirir.
                Toast.makeText(getApplicationContext(), " " +tiklananFilm.getFilmAdi(), Toast.LENGTH_SHORT).show();
                opennextActivity(tiklananFilm);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(filmAdaptor);
    }
    private void opennextActivity(FilmModel tiklananFilm){//tıklanan film
        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), FilmDetayActivity.class);
        String tiklananFilmString = ObjectUtil.filmToJsonString(tiklananFilm);
        secondActivityIntent.putExtra(Constants.TIKLANAN_FILM_TASINANIN_BASLIGI,tiklananFilmString);//activitye bilgi aktarılır
        startActivity(secondActivityIntent);


    }

    @Override    public void onBackPressed() {// geri tuşuna basıldığında yapılacaklar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Çıkış Yapmak istiyor musunuz?");
        builder.setPositiveButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Hayıra basarsak program cancel komutu ile durur ve çıkmaz.
                dialog.cancel();
            }
        });
        builder.setNegativeButton("EVET", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Evete basarsak program kendini kapatır.
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void getNetworkUtil (){//cihazın internete bağlı olup olmadığını kontrol eder.
        myReceiver = new NetworkUtil();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        myReceiver =new NetworkUtil();
        registerReceiver(myReceiver, intentFilter);

    }
}