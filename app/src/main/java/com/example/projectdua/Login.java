package com.example.projectdua;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button login, register;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        username = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);

        preferences = getSharedPreferences("Userinfo", 0);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                String registeredUsername = preferences.getString("username", "");
                String registeredPassword = preferences.getString("password", "");

                if(usernameValue.equals(registeredUsername)&&passwordValue.equals(registeredPassword)){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}

//
//        btnLogin.setOnClickListener(new View.OnClickListener(){
//            @Override
//            protected void onCreate(Bundle savedInstanceState){
//                Login.super.onCreate(savedInstanceState);
//                setContentView(R.layout.login);
//
//
//                String user = etName.getText().toString();
//                String password = etPassword.getText().toString();
//
//                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
//                String userDetails = preferences.getString(user + password + "data", "username or pass incorect");
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("display", userDetails);
//                editor.commit();
//
//                Intent displayScreen = new Intent(Login.this, DisplayScreen.class);
//                startActivity(displayScreen);
//            }
//
//        });
//
//        btnRegister.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent registerScreen = new Intent(Login.this, Register.class);
//                startActivity(registerScreen);
//            }
//        });

