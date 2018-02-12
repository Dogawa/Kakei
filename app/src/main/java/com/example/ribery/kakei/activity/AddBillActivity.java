package com.example.ribery.kakei.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.ribery.kakei.R;
import com.example.ribery.kakei.dbHelper.DBContract;
import com.example.ribery.kakei.dbHelper.DBHelper;

/**
 * Created by Ribery on 2018/2/12.
 */

public class AddBillActivity extends Activity {
    EditText etv_add_bill_money;
    DatePicker dpk_add_bill_date;
    EditText etv_add_bill_genre;
    EditText etv_add_bill_about;
    Button btn_add_bill_add;
    DBHelper dbHelper;
    SQLiteDatabase db;
    ContentValues insertValues;
    String dateValue, genreValue, aboutValue;
    long moneyValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bill_activity);
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        insertValues = new ContentValues();
        initViewItems();
    }

    private void initViewItems() {
        etv_add_bill_money = (EditText) findViewById(R.id.etv_add_bill_money);
        dpk_add_bill_date = (DatePicker) findViewById(R.id.etv_add_bill_date);
        etv_add_bill_genre = (EditText) findViewById(R.id.etv_add_bill_genre);
        etv_add_bill_about = (EditText) findViewById(R.id.etv_add_bill_about);
        btn_add_bill_add = (Button) findViewById(R.id.btn_add_bill_add);
        btn_add_bill_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                insert into db
                moneyValue = Long.parseLong(etv_add_bill_money.getText().toString());
                dateValue = getDateValue();
                genreValue = etv_add_bill_genre.getText().toString();
                aboutValue = etv_add_bill_about.getText().toString();
                insertValues.put(DBContract.KakeiEntry.COLUMN_NAME_DATE, dateValue);
                insertValues.put(DBContract.KakeiEntry.COLUMN_NAME_MONEY, moneyValue);
                insertValues.put(DBContract.KakeiEntry.COLUMN_NAME_GENRE, genreValue);
                insertValues.put(DBContract.KakeiEntry.COLUMN_NAME_ABOUT, aboutValue);
                long newRowId = db.insert(DBContract.KakeiEntry.TABLE_NAME, null, insertValues);
                Log.v("tag", newRowId + " newRowId");
            }
        });
    }

    private String getDateValue() {
        String dateValue = "";
        int month = dpk_add_bill_date.getMonth() + 1;
        dateValue = dpk_add_bill_date.getYear() + "-" + month + "-" +dpk_add_bill_date.getDayOfMonth();
        Log.v("tag", dateValue);
        return dateValue;
    }
}
