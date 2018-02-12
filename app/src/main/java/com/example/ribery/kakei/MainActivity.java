package com.example.ribery.kakei;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends Activity {
    public Button btn_add_bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialViewItems();
    }

    private void initialViewItems() {
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
}
