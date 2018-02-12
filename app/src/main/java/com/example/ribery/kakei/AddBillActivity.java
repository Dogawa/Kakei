package com.example.ribery.kakei;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * Created by Ribery on 2018/2/12.
 */

public class AddBillActivity extends Activity {
    EditText etv_add_bill_money;
    DatePicker etv_add_bill_date;
    EditText etv_add_bill_genre;
    EditText etv_add_bill_about;
    Button btn_add_bill_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bill_activity);
        initViewItems();
    }

    private void initViewItems() {
        etv_add_bill_money = (EditText) findViewById(R.id.etv_add_bill_money);
        etv_add_bill_date = (DatePicker) findViewById(R.id.etv_add_bill_date);
        etv_add_bill_genre = (EditText) findViewById(R.id.etv_add_bill_genre);
        etv_add_bill_about = (EditText) findViewById(R.id.etv_add_bill_about);
        btn_add_bill_add = (Button) findViewById(R.id.btn_add_bill_add);
        btn_add_bill_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                insert into db
            }
        });
    }
}
