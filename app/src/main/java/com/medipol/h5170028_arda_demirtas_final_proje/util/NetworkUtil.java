package com.medipol.h5170028_arda_demirtas_final_proje.util;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;

import com.medipol.h5170028_arda_demirtas_final_proje.R;


public class NetworkUtil extends BroadcastReceiver {
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    AlertDialog.Builder builder;
    private AlertDialog alertdialog;

    @Override
    public void onReceive(Context context, Intent intent) {//internete bağlımı diye kontrol eder.
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager !=null){
            networkInfo =connectivityManager.getActiveNetworkInfo();
            if (networkInfo !=null && networkInfo.isConnected()){

                if (alertdialog!=null){
                    alertdialog.dismiss();
                }

            }
            else{
                builder =new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.internet_connection, null);
                builder.setView(view);
                builder.setCancelable(false);
                builder.create();
                alertdialog = builder.show();//dialogu gösterir
                view.findViewById(R.id.cancel_internet)
                        .setOnClickListener(new View.OnClickListener() {//iptal tuşuna basılınca ekran kapanır.
                            @Override
                            public void onClick(View v) {
                                alertdialog.dismiss();

                            }
                        });
                view.findViewById(R.id.internet_settings)//ayarlar tuşuna basılırsa ayarlara götürülür.
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                context.startActivity(new Intent(Settings.ACTION_SETTINGS));//ayarlara götürme kodu.

                            }
                        });

            }

        }

    }

}
