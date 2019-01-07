package com.example.muhammaddanyialkhan.projectprototype.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.muhammaddanyialkhan.projectprototype.MyApp;

public class SharedPereferenceUtils {
    private static String PREFERENCE_NAME = "EcommerceApp_No1";
    private static SharedPereferenceUtils sharedPereferenceUtils;
    private SharedPreferences sharedPreferences;

    private SharedPereferenceUtils(Context context){
        PREFERENCE_NAME = PREFERENCE_NAME + context.getPackageName();
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, context.MODE_PRIVATE);
    }

    public static SharedPereferenceUtils getInstance(){
        if(sharedPereferenceUtils == null){
            sharedPereferenceUtils = new SharedPereferenceUtils(MyApp.getContext());
        }
        return sharedPereferenceUtils;
    }

    public void saveString(String key, String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public String getString(String key, String defVal){
         return sharedPreferences.getString(key, defVal);
    }

    public String getString(String key){
         return sharedPreferences.getString(key, "");
    }
}
