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
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegistranActivity2 extends AppCompatActivity {

    EditText name, email, phone, password;
    Button register;
    TextView login;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    TextInputLayout nameError, emailError, phoneError, passError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registran2);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        nameError = (TextInputLayout) findViewById(R.id.nameError);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        phoneError = (TextInputLayout) findViewById(R.id.phoneError);
        passError = (TextInputLayout) findViewById(R.id.passError);

  register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

          setValidation();

      }
  });
  login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {


          Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
          startActivity(intent);

      }
  });

    }

    private void setValidation() {

if(name.getText().toString().isEmpty()){

  nameError.setError(getResources().getString(R.string.name_error));
isNameValid=false;
}
else{

    isNameValid=true;
    nameError.setErrorEnabled(true);

}

if (email.getText().toString().isEmpty()){
    emailError.setError(getResources().getString(R.string.email_error));
    isEmailValid=false;


}
else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
    emailError.setError(getResources().getString(R.string.email_error));
    isEmailValid=false;

}
else{
   isEmailValid=true;
   emailError.setErrorEnabled(true);

}
if(phone.getText().toString().isEmpty()){

    phoneError.setError(getResources().getString(R.string.phone_error));
    isPhoneValid=false;


}
else{
   isPhoneValid=true;
   phoneError.setErrorEnabled(true);

}


if(password.getText().toString().isEmpty()){
    passError.setError(getResources().getString(R.string.password_error));
    isPasswordValid=false;


}
else if(password.getText().length() <6){
    passError.setError(getResources().getString(R.string.password_error));
    isPasswordValid=false;


}
else{
isPasswordValid=true;
passError.setErrorEnabled(true);

}
        if (isNameValid && isEmailValid && isPhoneValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }



    }


}