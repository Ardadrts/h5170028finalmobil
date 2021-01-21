package com.medipol.h5170028_arda_demirtas_final_proje.network;

import com.medipol.h5170028_arda_demirtas_final_proje.model.FilmModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //getireceği json ı ayarlıyoruz
    //fonksiyonu ayarlıyoruz
    @GET("finalApi.json")
    Observable<List<FilmModel>> filmleriGetir();
}
