package com.example.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.Database.CommonConstants;
import com.example.demo.Model.DataList;
import com.example.demo.R;

import java.util.ArrayList;
import java.util.Locale;

public class HistoryAdapter extends  RecyclerView.Adapter<HistoryAdapter.MyViewHolder>  {

    LayoutInflater vi;
    Context context;
    ArrayList<DataList> dataLists=new ArrayList<DataList>();

    public HistoryAdapter(Context context, ArrayList<DataList> dataLists) {
        this.dataLists = dataLists;
        this.context = context;
        vi = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView game,name,answer,answer_flag;



        //  public Button furnished;






        public MyViewHolder(View itemView) {
            super(itemView);
            this.game=(TextView)itemView.findViewById(R.id.game);
            this.name=(TextView)itemView.findViewById(R.id.name);
            this.answer=(TextView)itemView.findViewById(R.id.answer);
            this.answer_flag=(TextView)itemView.findViewById(R.id.answer_flag);


        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {



        View  view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_history, parent, false);



        // view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.setIsRecyclable(false);




        try{

            holder.name.setText(context.getString(R.string.name)+dataLists.get(position).getName());
            holder.answer.setText(context.getString(R.string.answer)+dataLists.get(position).getFav_cricketer());
            holder.answer_flag.setText(context.getString(R.string.answer)+dataLists.get(position).getColors());
            holder.game.setText("Game "+dataLists.get(position).getId() + " : "+dataLists.get(position).getColors());

        }catch (Exception e)
        {
            e.printStackTrace();
        }






    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }





}
