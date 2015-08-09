package com.binarymake.ddvapp.slidingtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.binarymake.ddvapp.MainActivity;
import com.binarymake.ddvapp.R;
import com.binarymake.ddvapp.dao.MealDAO;
import com.binarymake.ddvapp.model.Meal;

/**
 * Created by Jakob on 27-08-2015.
 */

public class TabBreakfast extends Fragment implements View.OnClickListener {

    RelativeLayout relativeLayout;
    View view;
    private EditText mAddDescription;
    private EditText mAddMeat1;
    Button mBtnAdd;
    private MealDAO mMealDao;
    public static final String TAG = "TabBreakfast";
    private int maaltid;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.tab_breakfast);
        this.mMealDao = new MealDAO(getActivity());
        maaltid = getActivity().getIntent().getIntExtra("maaltid", 66);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_breakfast, container, false);

        Toast.makeText(getActivity(), "maaltidID i TabBreakfast er "+ maaltid, Toast.LENGTH_LONG).show();

        mAddDescription = (EditText) view.findViewById(R.id.tabBrAddDescription);
//        Meal description = mMealDao.getMealById(getActivity().getIntent().getIntExtra("måltid", -1));
//        mAddDescription.setText(description.getDescription());
//        mAddDescription.setText(maaltid);
        mBtnAdd = (Button) view.findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(this);
        mAddMeat1 = (EditText) view.findViewById(R.id.tabBrAddMeat1);
//        mAddFish1 = (EditText) view.findViewById(R.id.tabBrAddDescription);
//        mAddEggs = (EditText) view.findViewById(R.id.tabBrAddDescription);
//        mAddMeat2 = (EditText) view.findViewById(R.id.tabBrAddDescription);
//        mAddMeat3 = (EditText) view.findViewById(R.id.tabBrAddDescription);

        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Editable description = mAddDescription.getText();
                if (!TextUtils.isEmpty(description)) {
                    // add the meal to database
                    Meal createdMeal = mMealDao.createMeal(1, "Morgenmad:\n" + description.toString());

                    Log.d(TAG, "added meal : " + createdMeal.getType());
                    Toast.makeText(getActivity(), R.string.breakfast_created_successfully, Toast.LENGTH_LONG).show();
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), R.string.empty_fields_message, Toast.LENGTH_LONG).show();
                }
                break;

            default:
                break;
        }
    }
}