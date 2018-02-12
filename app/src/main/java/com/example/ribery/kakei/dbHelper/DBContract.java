package com.example.ribery.kakei.dbHelper;

import android.provider.BaseColumns;

/**
 * Created by Ribery on 2018/2/12.
 */

public final class DBContract {
    private DBContract() {}

    /* Inner class that defines the table contents */
    public static class KakeiEntry implements BaseColumns {
        public static final String TABLE_NAME = "kakei";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_GENRE = "genre";
        public static final String COLUMN_NAME_MONEY = "money";
        public static final String COLUMN_NAME_ABOUT = "about";
    }
}
