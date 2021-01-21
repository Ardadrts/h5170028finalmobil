package com.medipol.h5170028_arda_demirtas_final_proje.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//version için olan dosya
public class FilmModel {
    @SerializedName("FilmAdi")
    @Expose
    private String filmAdi;
    @SerializedName("FilmTarihi")
    @Expose
    private String filmTarihi;
    @SerializedName("KapakFotoURL")
    @Expose
    private String kapakFotoURL;
    @SerializedName("LogoURL")
    @Expose
    private String logoURL;
    @SerializedName("Oyuncular")
    @Expose
    private String oyuncular;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getFilmTarihi() {
        return filmTarihi;
    }

    public void setFilmTarihi(String filmTarihi) {
        this.filmTarihi = filmTarihi;
    }

    public String getKapakFotoURL() {
        return kapakFotoURL;
    }

    public void setKapakFotoURL(String kapakFotoURL) {
        this.kapakFotoURL = kapakFotoURL;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public String getOyuncular() {
        return oyuncular;
    }

    public void setOyuncular(String oyuncular) {
        this.oyuncular = oyuncular;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
