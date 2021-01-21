package com.medipol.h5170028_arda_demirtas_final_proje.network;

import com.medipol.h5170028_arda_demirtas_final_proje.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {//retrofit ile istek yapmak için ilgili ayarları gönderir.

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static OkHttpClient okHttpClient;//OKHTPP Request objesi olusturur.
    private static OkHttpClient getOkHttpClient()
    {
        if(okHttpClient == null) {
            okHttpClient =  new OkHttpClient().newBuilder().build();
        }

        return okHttpClient;
    }

    ServiceApi serviceApi;
    public ServiceApi getServiceApi() {
     //bitiş noktasını belirttiğimiz dosyayı ayarlar
        if(serviceApi == null) {
            serviceApi = getRetrofit().create(ServiceApi.class);
        }

        return serviceApi;
    }
}
