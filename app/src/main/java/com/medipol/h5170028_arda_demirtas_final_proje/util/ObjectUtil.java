package com.medipol.h5170028_arda_demirtas_final_proje.util;

import com.google.gson.Gson;
import com.medipol.h5170028_arda_demirtas_final_proje.model.FilmModel;

public class ObjectUtil {//gson ile json verisi okunur ve liste alınır.
    public static String filmToJsonString(FilmModel FilmModel)
    {
        Gson gson = new Gson();
        return gson.toJson(FilmModel);

    }
    public static FilmModel jsonStringTofilm(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,FilmModel.class);
    }
}
