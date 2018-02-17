package com.example.ribery.kakei.activity;

        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;

        import com.example.ribery.kakei.R;
        import com.example.ribery.kakei.activity.AddBillActivity;
        import com.example.ribery.kakei.adapter.Bill;
        import com.example.ribery.kakei.adapter.BillListAdapter;
        import com.example.ribery.kakei.dbHelper.DBContract;
        import com.example.ribery.kakei.dbHelper.DBHelper;

        import java.util.ArrayList;

public class MainActivity extends Activity {
    public Button btn_add_bill;
    public RecyclerView rcv_bill_list;
    RecyclerView.LayoutManager layoutManager;
    BillListAdapter adapter;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        initialViewItems();
    }

    private void initialViewItems() {
        layoutManager = new LinearLayoutManager(this);
        rcv_bill_list = (RecyclerView) this.findViewById(R.id.rcv_bill_list);
        rcv_bill_list.setHasFixedSize(true);
        rcv_bill_list.setLayoutManager(layoutManager);
        adapter = new BillListAdapter(getDataFromDB());
        rcv_bill_list.setAdapter(adapter);
        btn_add_bill = (Button) this.findViewById(R.id.btn_main_add);
        btn_add_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //         to add Activity
                Intent intent = new Intent(getApplication(), AddBillActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Bill> getDummy() {
        ArrayList<Bill> bills = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            String money = i * 200 + "";
            Bill bill = new Bill("2018-02-11", "food", "about", money);
            bills.add(bill);
        }
        return bills;
    }
    private ArrayList<Bill> getDataFromDB () {
        ArrayList<Bill> bills = new ArrayList<>();
        Cursor cursor = db.query(DBContract.KakeiEntry.TABLE_NAME, null, null, null, null, null, null);
        Bill bill;
        while (cursor.moveToNext()){
            String date = cursor.getString(cursor.getColumnIndex(DBContract.KakeiEntry.COLUMN_NAME_DATE));
            String genre = cursor.getString(cursor.getColumnIndex(DBContract.KakeiEntry.COLUMN_NAME_GENRE));
            int money = cursor.getInt(cursor.getColumnIndex(DBContract.KakeiEntry.COLUMN_NAME_MONEY));
            String about = cursor.getString(cursor.getColumnIndex(DBContract.KakeiEntry.COLUMN_NAME_ABOUT));

            Log.d("Query date ", date);
            Log.d("Query genre ", genre);
            Log.d("Query money ", money + "");
            Log.d("Query about", about);
            bill = new Bill(date, genre, about, money + "");
            bills.add(bill);
        }
        cursor.close();
        return bills;
    }

}
