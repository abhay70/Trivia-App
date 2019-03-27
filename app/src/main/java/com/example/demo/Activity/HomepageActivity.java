package com.example.demo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.Database.ChatDBHelper;
import com.example.demo.Database.ChatDBUtility;
import com.example.demo.R;

public class HomepageActivity extends AppCompatActivity {

    EditText et_name;
    Button next;

    ChatDBHelper chatDBHelper;
    ChatDBUtility chatDBUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        chatDBUtility = new ChatDBUtility();
        chatDBHelper = chatDBUtility.CreateChatDB(HomepageActivity.this);

        initializeView();
        initializeListener();
        setData();


    }

    private void setData() {

    }

    private void initializeListener() {

    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!et_name.getText().toString().equals(""))
            {
                chatDBUtility.AddToDataListDB(chatDBHelper,et_name.getText().toString());
                Intent intent=new Intent(HomepageActivity.this,CricketerActivity.class);
                startActivity(intent);

            }else
            {
                Toast.makeText(HomepageActivity.this, "Please Enter name to continue", Toast.LENGTH_SHORT).show();
            }
        }
    });

    }

    private void initializeView() {
        et_name=(EditText)findViewById(R.id.et_name);
        next=(Button)findViewById(R.id.next);

    }
}
