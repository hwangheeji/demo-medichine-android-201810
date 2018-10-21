package org.androidtown.myapplication;

import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by jb on 2018-10-20.
 */

public class Api {
    private static String URL = "http://192.168.35.105:5000/api3";
    //아이피주소 바꿔줘야함

    private static OkHttpClient client = new OkHttpClient();
    private static Moshi moshi = new Moshi.Builder().build();
    private static Type listDrug = Types.newParameterizedType(List.class, Drug.class);
    public static JsonAdapter<List<Drug>> drugJsonAdapter = moshi.adapter(listDrug);
    //public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void request(Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {

              //  RequestBody body = RequestBody.create(Json,json);
                Request request = new Request.Builder()
                        .url(URL)
                        //.post(body)
                        .build();

                client.newCall(request).enqueue(callback);
            }
        }).start();
    }

    static class Drug{
        String 품목명;
        String 업체명;
        String 약효분류;
    }
}
