package com.example.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.Database.ChatDBHelper;
import com.example.demo.Database.ChatDBUtility;
import com.example.demo.Database.CommonConstants;
import com.example.demo.Model.DataList;
import com.example.demo.R;

import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

    EditText et_name;
    Button next;

    ChatDBHelper chatDBHelper;
    ChatDBUtility chatDBUtility;
    int id;



    ArrayList<DataList> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        chatDBUtility = new ChatDBUtility();
        chatDBHelper = chatDBUtility.CreateChatDB(HomepageActivity.this);

        initializeView();
        initializeListener();
        GetSharedPreference();
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
                if(id!=0)
                {
                    chatDBUtility.UpdateName(chatDBHelper,et_name.getText().toString(),id);

                }else
                {
                    chatDBUtility.AddToDataListDB(chatDBHelper,et_name.getText().toString());
                    dataLists=new ArrayList<>();
                    dataLists=chatDBUtility.GetDataList(chatDBHelper,0);
                    SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(CommonConstants.USER_SETTINGS_PREFERENCE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt(CommonConstants.ID,  dataLists.get(dataLists.size()-1).getId());
                    editor.commit();
                }


                Intent intent=new Intent( HomepageActivity.this,CricketerActivity.class);
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

    public void GetSharedPreference()
    {
        SharedPreferences userSettings;
        userSettings = getSharedPreferences(CommonConstants.USER_SETTINGS_PREFERENCE, Context.MODE_PRIVATE);
        id = userSettings.getInt(CommonConstants.ID, 0);

    }
}
