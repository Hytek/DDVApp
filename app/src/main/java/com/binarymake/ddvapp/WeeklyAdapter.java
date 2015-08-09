package com.binarymake.ddvapp;

/**
 * Created by Jakob on 05-08-2015.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.WeeklyViewHolder> {

    private List<WeeklyInfo> weeklyList;

    public WeeklyAdapter(List<WeeklyInfo> weeklyList) {

        this.weeklyList = weeklyList;
    }

    @Override
    public int getItemCount() {

        return weeklyList.size();
    }

    @Override
    public void onBindViewHolder(WeeklyViewHolder weeklyViewHolder, int i) {
        WeeklyInfo wi = weeklyList.get(i);
        weeklyViewHolder.vBreakfast.setText(wi.breakfast);
        weeklyViewHolder.vDinner.setText(wi.dinner);
        weeklyViewHolder.vLunch.setText(wi.lunch);
        weeklyViewHolder.vTitle.setText(wi.weekday);
        weeklyViewHolder.vSnacks.setText(wi.snacks);

    }

    @Override
    public WeeklyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new WeeklyViewHolder(itemView);
    }

    public static class WeeklyViewHolder extends RecyclerView.ViewHolder {

        protected TextView vBreakfast;
        protected TextView vDinner;
        protected TextView vLunch;
        protected TextView vTitle;
        protected TextView vSnacks;

        public WeeklyViewHolder(View v) {
            super(v);
            vBreakfast =  (TextView) v.findViewById(R.id.txtBreakfast);
            vDinner = (TextView)  v.findViewById(R.id.txtDinner);
            vLunch = (TextView)  v.findViewById(R.id.txtLunch);
            vTitle = (TextView) v.findViewById(R.id.title);
            vSnacks = (TextView) v.findViewById(R.id.txtSnacks);

        }
    }
}