package com.example.demo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.demo.Database.ChatDBHelper;
import com.example.demo.Database.ChatDBUtility;
import com.example.demo.Model.DataList;
import com.example.demo.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView history_list;

    ChatDBHelper chatDBHelper;
    ChatDBUtility chatDBUtility;

    ArrayList<DataList> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        chatDBUtility = new ChatDBUtility();
        chatDBHelper = chatDBUtility.CreateChatDB(HistoryActivity.this);

        initializeView();
        initializeListener();

        setData();

    }

    private void setData() {


    }


    private void initializeListener() {


    }

    private void initializeView() {


    }
}
