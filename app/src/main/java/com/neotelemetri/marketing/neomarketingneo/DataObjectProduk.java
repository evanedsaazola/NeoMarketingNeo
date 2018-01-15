package com.neotelemetri.marketing.neomarketingneo;

/**
 * Created by ACER on 1/14/2018.
 */

public class DataObjectProduk {

    private String mText1;
    private String mText2;

    DataObjectProduk (String mText1, String mText2) {
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

}
