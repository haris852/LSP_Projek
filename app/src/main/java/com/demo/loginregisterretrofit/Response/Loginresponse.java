package com.demo.loginregisterretrofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loginresponse {
    @SerializedName("user_id")
    @Expose()
    public String user_id;

    @SerializedName("username")
    @Expose()
    public String username;

    @SerializedName("nama")
    @Expose()
    public String nama;

    @SerializedName("email")
    @Expose()
    public String email;

    @SerializedName("tgl_lahir")
    @Expose()
    public String tgl_lahir;

    @SerializedName("tempat_lahir")
    @Expose()
    public String tempat_lahir;

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    @SerializedName("no_telp")
    @Expose()
    public String no_telp;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @SerializedName("alamat")
    @Expose()
    public String alamat;
}

