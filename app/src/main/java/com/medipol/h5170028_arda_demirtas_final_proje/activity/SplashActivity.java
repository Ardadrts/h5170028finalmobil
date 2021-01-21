package com.medipol.h5170028_arda_demirtas_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.medipol.h5170028_arda_demirtas_final_proje.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//tasarım için oluşturulan xml dosyası.
        setContentView(R.layout.activity_splash);//içerik ekranı yüklemek için.
        init();
    }
    private void init(){

        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            //splash ekranında 3 saniye durmasını sağlar ve 3 saniye sonra ekranı kapatır.
            @Override
            public void onTick(long l) {

                Log.e("COUNTER","TİCK");
            }

            @Override
            public void onFinish() {
                opennextActivity();

            }
        };

        countDownTimer.start();
    }
    private void opennextActivity(){
        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);//başka bir Activity'yi başlatmak için  kullanılır.
        startActivity(secondActivityIntent);// intent başlatmak için startActivity() fonksiyonunu kullanmamız gerekir.
        finish();

}}