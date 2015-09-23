package com.binarymake.ddvapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.binarymake.ddvapp.R;
import com.binarymake.ddvapp.activities.AddActivity;
import com.binarymake.ddvapp.model.Meal;

import java.util.List;

public class ListMealsAdapter extends ArrayAdapter<Meal> {

    public static final String TAG = "ListMealsAdapter";

    Activity mActivity;
    private List<Meal> mBrItems;
    private List<Meal> mLuItems;
    private List<Meal> mDiItems;
    private List<Meal> mSnItems;
    private LayoutInflater mInflater;

    public ListMealsAdapter(Context context, List<Meal> brListMeals, List<Meal> luListMeals, List<Meal> diListMeals, List<Meal> snListMeals, Activity activity) {
        super(context, android.R.layout.simple_list_item_1);
        mActivity = activity;
        this.setBrItems(brListMeals);
        this.setLuItems(luListMeals);
        this.setDiItems(diListMeals);
        this.setSnItems(snListMeals);
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
//        int result = mBrItems.size();
//        if (result > 7){
//            result = 7;
//        }
//        return result;
        return 7;
    }

    public Meal getBrItem(int position) {
        Meal brResult;
        try {
            brResult = (getBrItems() != null && !getBrItems().isEmpty()) ? getBrItems().get(position) : null;
        } catch (Exception e) {
            Meal brDefault = getBrItem(0);
            return brDefault;
        }
        return brResult;
    }

    public Meal getLuItem(int position) {
        Meal luResult;
        try {
            luResult = (getLuItems() != null && !getLuItems().isEmpty()) ? getLuItems().get(position) : null;
        } catch (Exception e) {
            Meal luDefault = getLuItem(0);
            return luDefault;
        }

        return luResult;
    }

    public Meal getDiItem(int position) {
        Meal diResult;
        try {
            diResult = (getDiItems() != null && !getDiItems().isEmpty()) ? getDiItems().get(position) : null;
        } catch (Exception e) {
            Meal diDefault = getDiItem(0);
            return diDefault;
        }

        return diResult;
    }

    public Meal getSnItem(int position) {
        Meal snResult;
        try {
            snResult = (getSnItems() != null && !getSnItems().isEmpty()) ? getSnItems().get(position) : null;
        } catch (Exception e) {
            Meal snDefault = getSnItem(0);
            return snDefault;
        }

        return snResult;
    }

//    @Override
//    public long getItemId(int position) {
//        return (getBrItems() != null && !getBrItems().isEmpty()) ? getBrItems().get(position).getId() : position;
//    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View v = convertView;
        final ViewHolder holder;
        if (v == null) {
            v = mInflater.inflate(R.layout.list_item_daily, parent, false);
            holder = new ViewHolder();

            holder.txtBrDescription = (TextView) v.findViewById(R.id.txtBreakfast);
            holder.txtLuDescription = (TextView) v.findViewById(R.id.txtLunch);
            holder.txtDiDescription = (TextView) v.findViewById(R.id.txtDinner);
            holder.txtSnDescription = (TextView) v.findViewById(R.id.txtSnacks);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        // fill row data (breakfast)
        final Meal currentBrItem = getBrItem(position + 1);

        if (currentBrItem != null) {
            holder.txtBrDescription.setText(currentBrItem.getDescription());
        }

        // fill row data (lunch)
        final Meal currentLuItem = getLuItem(position + 1);

        if (currentLuItem != null) {
            holder.txtLuDescription.setText(currentLuItem.getDescription());
        }

        // fill row data (dinner)
        final Meal currentDiItem = getDiItem(position + 1);

        if (currentDiItem != null) {
            holder.txtDiDescription.setText(currentDiItem.getDescription());
        }

        // fill row data (snack)
        final Meal currentSnItem = getSnItem(position + 1);

        if (currentSnItem != null) {
            holder.txtSnDescription.setText(currentSnItem.getDescription());
        }

        Button mBtnBreakfast = (Button) v.findViewById(R.id.btnBreakfast);
        mBtnBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, AddActivity.class);
                intent.putExtra("dag", position);
                intent.putExtra("tidspunkt", 0);
                intent.putExtra("maaltid", currentBrItem.getId());
//                Toast.makeText(getContext(), "maaltidID i ListMealsAdapter er " + currentBrItem.getId(), Toast.LENGTH_LONG).show();
                mActivity.startActivity(intent);
            }
        });

        Button mBtnLunch = (Button) v.findViewById(R.id.btnLunch);
        mBtnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, AddActivity.class);
                intent.putExtra("dag", position);
                intent.putExtra("tidspunkt", 1);
                intent.putExtra("maaltid", currentLuItem.getId());
                mActivity.startActivity(intent);
            }
        });

        Button mBtnDinner = (Button) v.findViewById(R.id.btnDinner);
        mBtnDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, AddActivity.class);
                intent.putExtra("dag", position);
                intent.putExtra("tidspunkt", 2);
                intent.putExtra("maaltid", currentDiItem.getId());
                mActivity.startActivity(intent);
            }
        });

        Button mBtnSnacks = (Button) v.findViewById(R.id.btnSnacks);
        mBtnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, AddActivity.class);
                intent.putExtra("dag", position);
                intent.putExtra("tidspunkt", 3);
                intent.putExtra("maaltid", currentSnItem.getId());
                mActivity.startActivity(intent);
            }
        });

        return v;
    }

    public List<Meal> getBrItems() {

        return mBrItems;
    }

    public List<Meal> getLuItems() {

        return mLuItems;
    }

    public List<Meal> getDiItems() {

        return mDiItems;
    }

    public List<Meal> getSnItems() {

        return mSnItems;
    }

    public void setBrItems(List<Meal> mBrItems) {

        this.mBrItems = mBrItems;
    }

    public void setLuItems(List<Meal> mLuItems) {

        this.mLuItems = mLuItems;
    }

    public void setDiItems(List<Meal> mDiItems) {

        this.mDiItems = mDiItems;
    }

    public void setSnItems(List<Meal> mSnItems) {

        this.mSnItems = mSnItems;
    }

    class ViewHolder {
        TextView txtBrDescription;
        TextView txtLuDescription;
        TextView txtDiDescription;
        TextView txtSnDescription;
    }

}