package com.example.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.Database.ChatDBHelper;
import com.example.demo.Database.ChatDBUtility;
import com.example.demo.Database.CommonConstants;
import com.example.demo.Model.DataList;
import com.example.demo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SummaryActivity extends AppCompatActivity {

    TextView name_show,answer,answer_flag;
    Button finish;


    ChatDBHelper chatDBHelper;
    ChatDBUtility chatDBUtility;

    int id;

    ArrayList<DataList> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        chatDBUtility = new ChatDBUtility();
        chatDBHelper = chatDBUtility.CreateChatDB(SummaryActivity.this);

        initializeView();
        initializeListener();
        GetSharedPreference();
        setData();



    }

    private void setData() {


        dataLists=chatDBUtility.GetDataList(chatDBHelper,id);
        answer.setText(getString(R.string.answer)+dataLists.get(0).getFav_cricketer());
        answer_flag.setText(getString(R.string.answer)+dataLists.get(0).getColors());
        name_show.setText(getString(R.string.hello)+dataLists.get(0).getName());

    }

    private void initializeListener() {

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDateAndTime();

                //Clearing all previous activity.
                Intent i = new Intent(SummaryActivity.this, HomepageActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(CommonConstants.USER_SETTINGS_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(CommonConstants.ID,  0);
                editor.commit();
                startActivity(i);
            }
        });

    }

    private void updateDateAndTime() {

        Date date = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);

        String dateAndTime=getFormattedDate(cal.getTime());
        chatDBUtility.UpdateDate(chatDBHelper,dateAndTime,id);

    }

    private void initializeView() {

        name_show=(TextView)findViewById(R.id.game);
        answer=(TextView)findViewById(R.id.answer);
        answer_flag=(TextView)findViewById(R.id.answer_flag);
        finish=(Button) findViewById(R.id.finish);
    }


    public void GetSharedPreference()
    {
        SharedPreferences userSettings;
        userSettings = getSharedPreferences(CommonConstants.USER_SETTINGS_PREFERENCE, Context.MODE_PRIVATE);
        id = userSettings.getInt(CommonConstants.ID, 0);

    }

    public static String getFormattedDate(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        //2nd of march 2015
        int day=cal.get(Calendar.DATE);

        if(!((day>10) && (day<19)))
            switch (day % 10) {
                case 1:
                    return new SimpleDateFormat("d'st' 'of' MMMM hh:mm aaa").format(date);
                case 2:
                    return new SimpleDateFormat("d'nd' 'of' MMMM hh:mm aaa ").format(date);
                case 3:
                    return new SimpleDateFormat("d'rd' 'of' MMMM hh:mm aaa").format(date);
                default:
                    return new SimpleDateFormat("d'th' 'of' MMMM hh:mm aaa").format(date);
            }
        return new SimpleDateFormat("d'th' 'of' MMMM hh:mm aaa").format(date);
    }

}