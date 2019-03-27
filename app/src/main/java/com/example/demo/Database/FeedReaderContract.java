package com.example.demo.Database;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {
    }

    /* Inner class that defines the table contents */


    public static abstract class DataList implements BaseColumns {
        public static final String TABLE_NAME = "data_list";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME = "description";
        public static final String COLUMN_NAME_FAV_CRICKETER = "fav_cricketer";
        public static final String COLUMN_NAME_COLORS = "colors";

    }




}