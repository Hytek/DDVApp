package com.binarymake.ddvapp;

/**
 * Created by Jakob on 08-08-2015.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.WeeklyViewHolder> {

    private List<WeeklyOverview> weeklyList;

    public OverviewAdapter(List<WeeklyOverview> weeklyList) {

        this.weeklyList = weeklyList;
    }

    @Override
    public int getItemCount() {

        return weeklyList.size();
    }

    @Override
    public void onBindViewHolder(WeeklyViewHolder weeklyViewHolder, int i) {
        WeeklyOverview wi = weeklyList.get(i);

        weeklyViewHolder.vMeat1.setText(wi.meat1);
    }

    @Override
    public WeeklyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.activity_main, viewGroup, false);

        return new WeeklyViewHolder(itemView);
    }

    public static class WeeklyViewHolder extends RecyclerView.ViewHolder {


        protected TextView vMeat1;

        public WeeklyViewHolder(View v) {
            super(v);

            vMeat1 = (TextView) v.findViewById(R.id.txtSnacks);
        }
    }
}
