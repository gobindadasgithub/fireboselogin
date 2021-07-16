package com.example.firebaseprojectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    TextView register;
    boolean isEmailValid, isPasswordValid;
    TextInputLayout emailError, passError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        passError = (TextInputLayout) findViewById(R.id.passError);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     SetValidiation();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),RegistranActivity2.class);
                startActivity(intent);


            }
        });


    }

    private void SetValidiation() {

        if (email.getText().toString().isEmpty()){
            emailError.setError(getResources().getString(R.string.email_error));
            isEmailValid=false;

        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid=false;

        }
        else{
          isEmailValid=true;
          emailError.setErrorEnabled(true);

        }

        if (password.getText().toString().isEmpty()){
            passError.setError(getResources().getString(R.string.password_error));
            isPasswordValid=false;

        }
        else if (password.getText().length() < 6){
            passError.setError(getResources().getString(R.string.error_invalid_password));

         isPasswordValid=false;
        }
        else{

   isPasswordValid=true;
   passError.setErrorEnabled(true);
        }


    }


}