package com.example.cazzhit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class RegisterActivity  extends AppCompatActivity implements View.OnClickListener {

    EditText emailEt;
    EditText passwordEt;
    EditText phoneEt;
    Button registerBtn;
    boolean controlloEmail, controlloPassword, controlloPhone;

    TextWatcher emailWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (isValidEmail(s.toString()))
                controlloEmail=true;
            else

                controlloEmail=false;

        }

        @Override
        public void afterTextChanged(Editable s) {
            controllo();
        }
    };

    TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (isValidPassword(s.toString()))
                controlloPassword=true;
            else
                controlloPassword=false;

        }

        @Override
        public void afterTextChanged(Editable s) {
            controllo();
        }
    };

    TextWatcher phoneWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (isValidPhone(s.toString()))
                controlloPhone=true;
            else
                controlloPhone=false;

        }

        @Override
        public void afterTextChanged(Editable s) {
            controllo();
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailEt=findViewById(R.id.email_et);
        passwordEt=findViewById(R.id.passord_et);
        phoneEt=findViewById(R.id.phone_et);
        registerBtn=findViewById(R.id.register_btn);
        emailEt.addTextChangedListener(emailWatcher);
        passwordEt.addTextChangedListener(passwordWatcher);
        phoneEt.addTextChangedListener(phoneWatcher);
    }

    private void controllo(){
        if (controlloEmail && controlloPassword && controlloPhone)
            registerBtn.setEnabled(true);
        else
            registerBtn.setEnabled(false);
    }

    private boolean isValidEmail(String s){
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }

    private boolean isValidPhone(String s){
        return Patterns.PHONE.matcher(s).matches();
    }

    private boolean isValidPassword(String s){
        if (s.length()>=6)
            return true;
        else
            return false;
    }


    @Override
    public void onClick(View v) {


    }
}
