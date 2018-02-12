package com.example.ribery.kakei.dbHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ribery.kakei.dbHelper.DBContract.KakeiEntry;

/**
 * Created by Ribery on 2018/2/12.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE =  " INT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + KakeiEntry.TABLE_NAME + " (" +
                    KakeiEntry._ID + " INTEGER PRIMARY KEY," +
                    KakeiEntry.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
                    KakeiEntry.COLUMN_NAME_MONEY + NUMBER_TYPE + COMMA_SEP +
                    KakeiEntry.COLUMN_NAME_ABOUT + TEXT_TYPE + COMMA_SEP +
                    KakeiEntry.COLUMN_NAME_GENRE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + KakeiEntry.TABLE_NAME;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kakei.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
