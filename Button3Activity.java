package org.androidtown.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Button3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3);
    }

    public void onButtonBackClicked(View view) {
        Toast.makeText(getApplicationContext(),"돌아가기",Toast.LENGTH_LONG).show();
        finish();

    }
}
