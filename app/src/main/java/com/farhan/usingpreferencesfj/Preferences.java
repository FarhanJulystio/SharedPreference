package com.farhan.usingpreferencesfj;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    /** Pada pendeklarasian key data ini yang berupa String sebgai penyimpanan data. lalu setiap data mempunyai key yang berbeda pada satu sama lain */
    static final String KEY_USER_TEREGISTER ="user", KEY_PASS_TEREGISTER ="pass";
    static final String KEY_USERNAME_SEDANG_LOGIN = "Username_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";

    /** Pada pendeklarasian shared ini Preferences yang ada berdasarkan paramater contextnya code dibawah */
    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /** Pada deklarasi edit ini code nya ada Preferences dan Change data yang memiliki key yang isi KEY_USER_TEREGISTER tersebut dengan nama parameternya yaitu username */
    public static void setRegisteredUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USER_TEREGISTER, username);
        editor.apply();
    }
    /** Code ini mengembalikan nilai dari key KEY_USER_TEREGISTER berupa String */
    public static String getRegisteredUser(Context context){
        return getSharedPreference(context).getString(KEY_USER_TEREGISTER,"");
    }

    /** Pada code deklarasi edit ada Preferences dan mengubah data yang memiliki key KEY_PASS_TEREGISTER dengan nama parameternya yaitu password */
    public static void setRegisteredPass(Context context, String password){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_PASS_TEREGISTER, password);
        editor.apply();
    }
    /** Code ini akan mengembalikan nilai dari key KEY_PASS_TEREGISTER yang berupa code String */
    public static String getRegisteredPass(Context context){
        return getSharedPreference(context).getString(KEY_PASS_TEREGISTER,"");
    }

    /** Pada Code ini di deklarasikan dengan edit Preferences dan mengubah data
     *  yang memiliki key KEY_USERNAME_SEDANG_LOGIN dengan parameter username */
    public static void setLoggedInUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USERNAME_SEDANG_LOGIN, username);
        editor.apply();
    }
    /** Code ini akan mengembalikan nilai dari key KEY_USERNAME_SEDANG_LOGIN yang berupa code String */
    public static String getLoggedInUser(Context context){
        return getSharedPreference(context).getString(KEY_USERNAME_SEDANG_LOGIN,"");
    }

    /** Code ini akan dideklarasikan oleh Edit Preferences dan mengubah data dan memiliki key KEY_STATUS_SEDANG_LOGIN dengan nama parameternya status */
    public static void setLoggedInStatus(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN,status);
        editor.apply();
    }
    /** Code ini akan mengembalikan nilai dari key KEY_STATUS_SEDANG_LOGIN yang berupa boolean */
    public static boolean getLoggedInStatus(Context context){
        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN,false);
    }

    /** Code ini akan dideklarasikan oleh Edit Preferences dan menghapus data, sehingga code tersebut menjadikannya berupa nilai default
     *  khususnya pada data yang memiliki key KEY_USERNAME_SEDANG_LOGIN dan KEY_STATUS_SEDANG_LOGIN */
    public static void clearLoggedInUser (Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();
    }
}
