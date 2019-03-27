package com.example.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.demo.Database.ChatDBHelper;
import com.example.demo.Database.ChatDBUtility;
import com.example.demo.Database.CommonConstants;
import com.example.demo.R;

public class CricketerActivity extends AppCompatActivity {


    CheckBox sachin,virat,adam,kallis;
    Button next;


    ChatDBHelper chatDBHelper;
    ChatDBUtility chatDBUtility;

    int id;

    String cricketer="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketer);

        chatDBUtility = new ChatDBUtility();
        chatDBHelper = chatDBUtility.CreateChatDB(CricketerActivity.this);

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

                if(!cricketer .equals(""))
                {
                    chatDBUtility.UpdateCricketer(chatDBHelper,cricketer ,id);
                    Intent intent=new Intent(CricketerActivity.this,ColorsActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(CricketerActivity.this, "Please select any cricketer", Toast.LENGTH_SHORT).show();
                }



            }
        });

        sachin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {


                    virat.setChecked(false);
                    adam.setChecked(false);
                    kallis.setChecked(false);
                }
            }
        });
        virat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {


                    sachin.setChecked(false);
                    adam.setChecked(false);
                    kallis.setChecked(false);
                }
            }
        });
        adam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    sachin.setChecked(false);
                    virat.setChecked(false);
                    kallis.setChecked(false);
                }
            }
        });


        kallis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    sachin.setChecked(false);
                    virat.setChecked(false);
                    adam.setChecked(false);
                }
            }
        });


        sachin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    cricketer=getResources().getString(R.string.sachin_tendulkar);
                    // Do your coding
                }
                else{
                    cricketer="";
                    // Do your coding
                }
            }
        });


        kallis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    cricketer=getResources().getString(R.string.jacques_kallis);

                }
                else{
                    cricketer="";

                }
            }
        });

        virat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    cricketer=getResources().getString(R.string.virat_kohli);

                }
                else{
                    cricketer="";

                }
            }
        });

        adam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    cricketer=getResources().getString(R.string.adam_gilchrist);

                }
                else{
                    cricketer="";

                }
            }
        });


    }

    private void initializeView() {


        sachin=(CheckBox)findViewById(R.id.sachin);
        virat=(CheckBox)findViewById(R.id.virat);
        adam=(CheckBox)findViewById(R.id.adam);
        kallis=(CheckBox)findViewById(R.id.kallis);

        next=(Button)findViewById(R.id.next);

    }

    public void GetSharedPreference()
    {
        SharedPreferences userSettings;
        userSettings = getSharedPreferences(CommonConstants.USER_SETTINGS_PREFERENCE, Context.MODE_PRIVATE);
        id = userSettings.getInt(CommonConstants.ID, 0);

    }

}
