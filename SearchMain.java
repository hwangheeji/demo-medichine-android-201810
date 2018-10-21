package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchMain extends AppCompatActivity {

    TextView textView,name,company,use;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        Intent intent = getIntent();

        //mainActivity에서 받아온것
        String query = intent.getStringExtra("query");
            textView=findViewById(R.id.query);
            textView.setText("'" +query+"'로 검색한 결과");

        ////////////////////////

        name=findViewById(R.id.name);
        company=findViewById(R.id.company);
        use=findViewById(R.id.use);

        Api.request(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //-------------콜백성공한경우--------------
             //   String res = response.body().string();
             //   Log.i("Main", res);
                List<Api.Drug> drugList = Api.drugJsonAdapter.fromJson(response.body().source());

                Log.i("Main", drugList.toString());
              //  textView.setText(drugList.toString());

                update(drugList.toString());
        }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

        });
    }
    //https://android.jlelse.eu/handmade-backend-for-android-app-using-python-flask-framework-b173ba2bb3aa
    //https://github.com/Audhil/FlaskWithAndroid
    void update(String label) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                name.setText(label);

            }
        });
    }
}
