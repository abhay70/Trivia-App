package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ImageView;

import com.example.demo.Activity.HomepageActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initializeViews();
        setData();

    }


    private void initializeViews() {

        imageView=(ImageView)findViewById(R.id.image);

    }

    private void setData() {

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground));

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                  {
                        Intent intent = new Intent(MainActivity.this, HomepageActivity.class);
                        startActivity(intent);

                        MainActivity.this.finish();
                    }

                }
            }
        };

        timer.start();
    }


}
