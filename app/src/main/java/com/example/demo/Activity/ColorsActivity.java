package com.example.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.Database.ChatDBHelper;
import com.example.demo.Database.ChatDBUtility;
import com.example.demo.Database.CommonConstants;
import com.example.demo.R;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    CheckBox white,yellow,orange,green;
    Button next;
    TextView header_title;

    ChatDBHelper chatDBHelper;
    ChatDBUtility chatDBUtility;

    ArrayList<String> name=new ArrayList<String>();

    int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        chatDBUtility = new ChatDBUtility();
        chatDBHelper = chatDBUtility.CreateChatDB(ColorsActivity.this);

        initializeView();
        initializeListener();
        GetSharedPreference();
        setData();


    }

    private void setData() {

        header_title.setText("Choose colors");

    }

    private void initializeListener() {



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.size()!=0)
                {

                    StringBuilder colors= new StringBuilder();
                    for (int i=0;i<name.size();i++)
                    {
                        if(i!=name.size()-1)
                        {
                            colors.append(name.get(i)+" , ");
                        }else
                        {
                            colors.append(name.get(i));
                        }

                    }
                    chatDBUtility.UpdateColors(chatDBHelper, colors.toString(),id);
                    Intent intent=new Intent(ColorsActivity.this,SummaryActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(ColorsActivity.this, "Please select any colors", Toast.LENGTH_SHORT).show();
                }


            }
        });







        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){

                    name.add(getResources().getString(R.string.green));

                }
                else{
                    for(int i=0;i<name.size();i++)
                    {
                        if(name.get(i).equals(getResources().getString(R.string.green)))
                        {
                            name.remove(i);
                            break;
                        }
                    }


                }
            }
        });

        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){

                    name.add(getResources().getString(R.string.white));

                }
                else{
                    for(int i=0;i<name.size();i++)
                    {
                        if(name.get(i).equals(getResources().getString(R.string.white)))
                        {
                            name.remove(i);
                            break;
                        }
                    }


                }
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){

                    name.add(getResources().getString(R.string.yellow));

                }
                else{
                    for(int i=0;i<name.size();i++)
                    {
                        if(name.get(i).equals(getResources().getString(R.string.yellow)))
                        {
                            name.remove(i);
                            break;
                        }
                    }


                }
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){

                    name.add(getResources().getString(R.string.orange));

                }
                else{
                    for(int i=0;i<name.size();i++)
                    {
                        if(name.get(i).equals(getResources().getString(R.string.orange)))
                        {
                            name.remove(i);
                            break;
                        }
                    }


                }
            }
        });






    }

    private void initializeView() {


        white=(CheckBox)findViewById(R.id.white);
        yellow=(CheckBox)findViewById(R.id.yellow);
        orange=(CheckBox)findViewById(R.id.orange);
        green=(CheckBox)findViewById(R.id.green);
        next=(Button) findViewById(R.id.next);
        header_title=(TextView)findViewById(R.id.header_title);
    }

    public void GetSharedPreference()
    {
        SharedPreferences userSettings;
        userSettings = getSharedPreferences(CommonConstants.USER_SETTINGS_PREFERENCE, Context.MODE_PRIVATE);
        id = userSettings.getInt(CommonConstants.ID, 0);

    }
}
