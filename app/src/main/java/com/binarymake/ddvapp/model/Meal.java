package com.binarymake.ddvapp.model;

/**
 * Created by Jakob on 02-09-2015.
 */

import java.io.Serializable;

public class Meal implements Serializable {

    public static final String TAG = "Meal";
    private static final long serialVersionUID = -7406082437623008161L;

    private int mId;
    private int mType;
    private String mDescription;
//    private String mPhoneNumber;
//    private String mWebsite;

    public Meal() {
    }

    public Meal(int type, String description) {
        this.mType = type;
        this.mDescription = description;
//        this.mPhoneNumber = phoneNumber;
//        this.mWebsite = website;
    }

    public int getId() {

        return mId;
    }

    public void setId(int mId) {

        this.mId = mId;
    }

    public int getType() {

        return mType;
    }

    public void setType(int mType) {

        this.mType = mType;
    }

    public String getDescription() {

        return mDescription;
    }

    public void setDescription(String mDescription) {

        this.mDescription = mDescription;
    }

//    public String getPhoneNumber() {
//
//        return mPhoneNumber;
//    }

//    public void setPhoneNumber(String mPhoneNumber) {
//
//        this.mPhoneNumber = mPhoneNumber;
//    }

//      public String getWebsite() {
//
//        return mWebsite;
//    }

//    public void setWebsite(String website) {
//
//        this.mWebsite = website;
//    }
}
