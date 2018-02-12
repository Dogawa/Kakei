package com.example.ribery.kakei.activity;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;

        import com.example.ribery.kakei.R;
        import com.example.ribery.kakei.activity.AddBillActivity;
        import com.example.ribery.kakei.adapter.Bill;
        import com.example.ribery.kakei.adapter.BillListAdapter;

        import java.util.ArrayList;

public class MainActivity extends Activity {
    public Button btn_add_bill;
    public RecyclerView rcv_bill_list;
    RecyclerView.LayoutManager layoutManager;
    BillListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialViewItems();
    }

    private void initialViewItems() {
        layoutManager = new LinearLayoutManager(this);
        rcv_bill_list = (RecyclerView) this.findViewById(R.id.rcv_bill_list);
        rcv_bill_list.setHasFixedSize(true);
        rcv_bill_list.setLayoutManager(layoutManager);
        adapter = new BillListAdapter(getDummy());
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
}
