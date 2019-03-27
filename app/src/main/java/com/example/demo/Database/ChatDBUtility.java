package com.example.demo.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.demo.Model.DataList;

import java.util.ArrayList;


public class ChatDBUtility {

    public static ChatDBHelper chatDBHelper;

    public ChatDBHelper CreateChatDB(Context context)
    {
        if (chatDBHelper == null) {
            chatDBHelper = new ChatDBHelper(context);
        }

        return chatDBHelper;

    }


    public long AddToDataListDB(ChatDBHelper chatDBHelper, String name) {
        // Gets the data repository in write mode
        SQLiteDatabase db = chatDBHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        //values.put(FeedReaderContract.DataList.COLUMN_NAME_ID, dataResponse.getId());
        values.put(FeedReaderContract.DataList.COLUMN_NAME_NAME, name);




        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FeedReaderContract.DataList.TABLE_NAME,
                null,
                values);
        return newRowId;
    }


    public ArrayList<DataList> GetDataList(ChatDBHelper DBHelper,int id) {
        Cursor cursor = GetRowsDataListDB(DBHelper,id);

        ArrayList<DataList> datalists = new ArrayList<DataList>();
        DataList datalist;

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            datalist = new DataList();
            datalist.setId(cursor.getInt(cursor.getColumnIndex(FeedReaderContract.DataList.COLUMN_NAME_ID)));
            datalist.setColors(cursor.getString(cursor.getColumnIndex(FeedReaderContract.DataList.COLUMN_NAME_COLORS)));
            datalist.setDate(cursor.getString(cursor.getColumnIndex(FeedReaderContract.DataList.COLUMN_NAME_DATE_AND_TIME)));
            datalist.setFav_cricketer(cursor.getString(cursor.getColumnIndex(FeedReaderContract.DataList.COLUMN_NAME_FAV_CRICKETER)));
            datalist.setName(cursor.getString(cursor.getColumnIndex(FeedReaderContract.DataList.COLUMN_NAME_NAME)));




            datalists.add(datalist);

            cursor.moveToNext();
        }


        cursor.close();
        return datalists;
    }


    Cursor GetRowsDataListDB(ChatDBHelper chatDBHelper,int id) {
        SQLiteDatabase db = chatDBHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                FeedReaderContract.DataList.COLUMN_NAME_COLORS,
                FeedReaderContract.DataList.COLUMN_NAME_FAV_CRICKETER,
                FeedReaderContract.DataList.COLUMN_NAME_NAME,
                FeedReaderContract.DataList.COLUMN_NAME_ID,
                FeedReaderContract.DataList.COLUMN_NAME_DATE_AND_TIME,

        };

        // How you want the results sorted in the resulting Cursor
        // String sortOrder =
        //
        String whereClause = "";

        if(id!=0)
        {
            whereClause = "(" + FeedReaderContract.DataList.COLUMN_NAME_ID + " = "  + id + ")";
        }


        Cursor c = db.query(
                FeedReaderContract.DataList.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                whereClause,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );


        return c;
    }


    public void UpdateCricketer(ChatDBHelper chatDBHelper, String fav_cricketer,int id) {

        SQLiteDatabase db = chatDBHelper.getWritableDatabase();

        String strSQL = "UPDATE " + FeedReaderContract.DataList.TABLE_NAME + " Set " + FeedReaderContract.DataList.COLUMN_NAME_FAV_CRICKETER + " = '" + fav_cricketer +
                "' where " + FeedReaderContract.DataList.COLUMN_NAME_ID + " = " + id;
        db.execSQL(strSQL);
    }

    public void UpdateName(ChatDBHelper chatDBHelper, String name,int id) {

        SQLiteDatabase db = chatDBHelper.getWritableDatabase();

        String strSQL = "UPDATE " + FeedReaderContract.DataList.TABLE_NAME + " Set " + FeedReaderContract.DataList.COLUMN_NAME_NAME + " = '" + name +
                "' where " + FeedReaderContract.DataList.COLUMN_NAME_ID + " = " + id;
        db.execSQL(strSQL);
    }

    public void UpdateColors(ChatDBHelper chatDBHelper, String colors,int id) {

        SQLiteDatabase db = chatDBHelper.getWritableDatabase();

        String strSQL = "UPDATE " + FeedReaderContract.DataList.TABLE_NAME + " Set " + FeedReaderContract.DataList.COLUMN_NAME_COLORS + " = '" + colors +
                "' where " + FeedReaderContract.DataList.COLUMN_NAME_ID + " = " + id;
        db.execSQL(strSQL);
    }

    public void UpdateDate(ChatDBHelper chatDBHelper, String date,int id) {

        SQLiteDatabase db = chatDBHelper.getWritableDatabase();

        String strSQL = "UPDATE " + FeedReaderContract.DataList.TABLE_NAME + " Set " + FeedReaderContract.DataList.COLUMN_NAME_DATE_AND_TIME + " = '" + date +
                "' where " + FeedReaderContract.DataList.COLUMN_NAME_ID + " = " + id;
        db.execSQL(strSQL);
    }

}
