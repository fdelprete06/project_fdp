package com.example.cazzhit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button loginBtn;
    Button registerBtn;

    EditText emailEt;
    EditText passwordEt;
    private static int LEN_PASS = 6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        passwordEt = findViewById(R.id.passord_et);
        emailEt = findViewById(R.id.email_et);

        if(hasInvitationCode())
            registerBtn.setVisibility(View.VISIBLE);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);

        Log.i("LoginActivity", "Activty created");

    }

    private boolean hasInvitationCode() {
        return false;
    }


    private void doLogin(){
        if(Utilities.isValidEmail(emailEt.getText().toString()) && Utilities.isValidPassword(passwordEt.getText().toString(),LEN_PASS))
            Utilities.showToast(this, R.string.login_OK);
        else
            Utilities.showToast(this, R.string.login_KO);
    }

    private void doRegister(){
        // definisco l'intenzione di aprire l'Activity "Page1.java"
        Intent openPage1 = new Intent(this, RegisterActivity.class);
        // passo all'attivazione dell'activity page1.java
        startActivity(openPage1);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            doLogin();
        }else if(v.getId() == R.id.register_btn){
            doRegister();
        }
    }
}
