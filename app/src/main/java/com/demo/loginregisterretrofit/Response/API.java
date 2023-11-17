package com.demo.loginregisterretrofit.Response;

import java.sql.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    //String BaseURL = "http://192.168.43.207/digital_reader/";
    String BaseURL = "http://10.10.182.184/webservices/";

    //register

    @FormUrlEncoded
    @POST("register.php")
    Call<RegsiterResponse> getUserRegi(
            @Field("username") String username,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("tempat_lahir") String tempat_lahir,
            @Field("tgl_lahir") String tgl_lahir,
            @Field("no_telp") String no_telp,
            @Field("email") String email,
            @Field("password") String password
    );

    //Update user
    @FormUrlEncoded
    @POST("Update_user.php/{user_id}")
    Call<UpdateUserResponse> sentUserUpdateddata(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("user_id") String user_id
    );

    //login
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginUserResponse> getUserLogin(
            @Field("username") String username,
            @Field("password") String password
    );

}