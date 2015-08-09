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

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.OverviewViewHolder> {

    private List<WeeklyInfo> overviewList;

    public WeeklyAdapter(List<WeeklyInfo> overviewList) {

        this.overviewList = overviewList;
    }

    @Override
    public int getItemCount() {

        return overviewList.size();
    }

    @Override
    public void onBindViewHolder(OverviewViewHolder overviewViewHolder, int i) {
        WeeklyInfo oi = overviewList.get(i);

        overviewViewHolder.vMeat1.setText(oi.meat1);
        overviewViewHolder.vFish1.setText(oi.fish1);
        overviewViewHolder.vEggs.setText(oi.eggs);
        overviewViewHolder.vMeat2.setText(oi.meat2);
        overviewViewHolder.vMeat3.setText(oi.meat3);
        overviewViewHolder.vFish2.setText(oi.fish2);
        overviewViewHolder.vCheese1.setText(oi.cheese1);
        overviewViewHolder.vCheese2.setText(oi.cheese2);
        overviewViewHolder.vCereal.setText(oi.cereal);

    }

    @Override
    public OverviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.layout_weekly, viewGroup, false);

        return new OverviewViewHolder(itemView);
    }

    public static class OverviewViewHolder extends RecyclerView.ViewHolder {


        protected TextView vMeat1;
        protected TextView vFish1;
        protected TextView vEggs;
        protected TextView vMeat2;
        protected TextView vMeat3;
        protected TextView vFish2;
        protected TextView vCheese1;
        protected TextView vCheese2;
        protected TextView vCereal;

        public OverviewViewHolder(View v) {
            super(v);

            vMeat1 = (TextView) v.findViewById(R.id.meat1);
            vFish1 = (TextView) v.findViewById(R.id.fish1);
            vEggs = (TextView) v.findViewById(R.id.eggs);
            vMeat2 = (TextView) v.findViewById(R.id.meat2);
            vMeat3 = (TextView) v.findViewById(R.id.meat3);
            vFish2 = (TextView) v.findViewById(R.id.fish2);
            vCheese1 = (TextView) v.findViewById(R.id.cheese1);
            vCheese2 = (TextView) v.findViewById(R.id.cheese2);
            vCereal = (TextView) v.findViewById(R.id.cereal);
        }
    }
}