package org.androidtown.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.URL;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class Button4Activity extends AppCompatActivity implements View.OnClickListener {
    Button Button_Camera;
    ImageView imageView;
    //public static String IMAGE_FILE = "capture.jpg";
    //static final String TAG = "G";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button4);

        Button_Camera = findViewById(R.id.camera);
        imageView = findViewById(R.id.image);
        Button_Camera.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //카메라 불러오기
        startActivityForResult(intent, 1);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);
            imageView.setImageBitmap(scaled);


        }

        if(requestCode ==2) {
            try {
                //이미지를 하나 골랐을때
                if (requestCode ==2 && resultCode == RESULT_OK && null != data) {
                    //data에서 절대경로로 이미지를 가져옴
                    Uri uri = data.getData();

                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                   // int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
                    //   Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);

                  //  imageView.setImageBitmap(scaled);
                    imageView.setImageBitmap(bitmap);

                } else {
                 //   Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
              //  Toast.makeText(this, "Oops! 로딩에 오류가 있습니다.", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }
        //imageView.setImageURI(data.getData());
    }

    public void loadGallery(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);

    }

}
