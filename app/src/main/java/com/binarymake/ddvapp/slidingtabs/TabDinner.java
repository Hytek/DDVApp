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

public class TabDinner extends Fragment implements View.OnClickListener {

    RelativeLayout relativeLayout;
    View view;
    private EditText mAddDescription;
    Button mBtnAdd;
    private MealDAO mMealDao;
    public static final String TAG = "TabDinner";
    private int maaltid;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.tab_dinner);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_dinner, container, false);
        this.mMealDao = new MealDAO(getActivity());

        maaltid = getActivity().getIntent().getIntExtra("maaltid", -1);
        mAddDescription = (EditText) view.findViewById(R.id.tabDiAddDescription);

        Meal description = mMealDao.getMealById(maaltid);

        if (description.getDescription().length() < 12) {
            mAddDescription.setText(description.getDescription());
        } else {
            mAddDescription.setText(description.getDescription().substring(13));
        }
        mAddDescription.setSelection(mAddDescription.getText().length());

        mBtnAdd = (Button) view.findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(this);

        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Editable description = mAddDescription.getText();
                if (!TextUtils.isEmpty(description) && maaltid < 5) {
                    // add the meal to database
                    Meal createdMeal = mMealDao.createMeal(3, "Aftensmad:  \n" + description.toString());

                    Log.d(TAG, "added meal : " + createdMeal.getType());
                    Toast.makeText(getActivity(), R.string.dinner_created_successfully, Toast.LENGTH_LONG).show();
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else if (!TextUtils.isEmpty(description) && maaltid > 4) {
                    // update meal in database
                    Meal createdMeal = mMealDao.updateMeal(maaltid, 3, "Aftensmad:  \n" + description.toString());

                    Log.d(TAG, "added meal : " + createdMeal.getType());
                    Toast.makeText(getActivity(), R.string.dinner_created_successfully, Toast.LENGTH_LONG).show();
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), R.string.empty_fields_message, Toast.LENGTH_LONG).show();
                }
                break;

            default:
                break;
        }
    }
}