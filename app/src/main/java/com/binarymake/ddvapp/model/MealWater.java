package com.binarymake.ddvapp.model;

/**
 * Created by Jakob on 02-09-2015.
 */

import java.io.Serializable;

public class MealWater extends Meal implements Serializable {

    public static final String TAG = "MealWater";
    private static final long serialVersionUID = -7406082437623008161L;

    private int mId;
    private String mFoodId;
//    private String mLastName;
    private String mDescription;
//    private String mPhoneNumber;
//    private String mEmail;
//    private double mSalary;
    private Meal mMeal;

    public MealWater() {

    }

    public MealWater(String foodId, String description) {
        this.mFoodId = foodId;
//        this.mLastName = lastName;
        this.mDescription = description;
//        this.mPhoneNumber = phoneNumber;
//        this.mEmail = email;
//        this.mSalary = salary;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getFoodId() {
        return mFoodId;
    }

    public void setFoodId(String mFoodId) {
        this.mFoodId = mFoodId;
    }

//    public String getLastName() {
//        return mLastName;
//    }

//    public void setLastName(String mLastName) {
//        this.mLastName = mLastName;
//    }

    public String getDescription() {
        return mDescription;
    }

//    public void setAddress(String mAddress) {
//        this.mAddress = mAddress;
//    }

//    public String getPhoneNumber() {
//        return mPhoneNumber;
//    }

//    public void setPhoneNumber(String mPhoneNumber) {
//        this.mPhoneNumber = mPhoneNumber;
//    }

//    public String getEmail() {
//        return mEmail;
//    }

//    public void setEmail(String mEmail) {
//        this.mEmail = mEmail;
//    }

//    public double getSalary() {
//        return mSalary;
//    }

//    public void setSalary(double mSalary) {
//        this.mSalary = mSalary;
//    }

    public Meal getMeal() {
        return mMeal;
    }

    public void setMeal(Meal mMeal) {
        this.mMeal = mMeal;
    }
}
