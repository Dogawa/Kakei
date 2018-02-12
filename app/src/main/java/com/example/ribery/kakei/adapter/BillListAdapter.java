package com.example.ribery.kakei.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ribery.kakei.R;

import java.util.ArrayList;

/**
 * Created by Ribery on 2018/2/12.
 */

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.ViewHolder> {
    public ArrayList<Bill> bills = null;
    public BillListAdapter(ArrayList<Bill> bills) {
        this.bills = bills;
    }
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bill_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return bills.size();
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv_item_date.setText(bills.get(position).date);
        viewHolder.tv_item_genre.setText(bills.get(position).genre);
        viewHolder.tv_item_money.setText(bills.get(position).money);
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_item_date, tv_item_genre, tv_item_money;
        public ViewHolder(View view) {
            super(view);
            tv_item_date = (TextView) view.findViewById(R.id.tv_item_date);
            tv_item_genre = (TextView) view.findViewById(R.id.tv_item_genre);
            tv_item_money = (TextView) view.findViewById(R.id.tv_item_money);
        }
    }
}
