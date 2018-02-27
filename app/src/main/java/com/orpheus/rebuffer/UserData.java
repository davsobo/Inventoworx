package com.orpheus.rebuffer;

/**
 * Created by IT-PC2 on 27/02/2018.
 */

public class UserData {
    private static String mEmail;
    private static String mLevel;

    public static void setmEmail(String x)
    {
        mEmail = x;
    }
    public static String getmEmail()
    {
        return mEmail;
    }
    public static void setmLevel(String x)
    {
        mLevel = x;
    }
    public static String getmLevel()
    {
        return mLevel;
    }
}
