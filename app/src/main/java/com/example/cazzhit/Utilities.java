package com.example.cazzhit;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.Patterns;
import android.widget.Toast;

public class Utilities {
    public static boolean isValidEmail(String s){
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }

    public static boolean isValidPhone(String s){
        return Patterns.PHONE.matcher(s).matches();
    }

    public static boolean isValidPassword(String s, int LEN_PASS){
        if (s.length()>=LEN_PASS)
            return true;
        else
            return false;
    }

    public static void showToast(Context context, @StringRes int id) {
        Toast.makeText(context, id,Toast.LENGTH_LONG).show();
    }


}
