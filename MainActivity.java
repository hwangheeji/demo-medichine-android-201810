package org.androidtown.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
     ImageButton imageButton;
     EditText editText;

     Api api = new Api();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.usernameInput);

        findViewById(R.id.imageButton).setOnClickListener((v)->{
                Intent intent= new Intent(getApplicationContext(), SearchMain.class);
                intent.putExtra("query", editText.getText().toString());
                startActivity(intent);
        });

    }

    public void onButton1Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(),Button1Activity.class);
        startActivity(intent);
    }

    public void onButton2Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(),Button2Activity.class);
        startActivity(intent);
    }

    public void onButton3Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(),Button3Activity.class);
        startActivity(intent);
    }

    public void onButton4Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(),Button4Activity.class);
        startActivity(intent);
    }


}
