package com.example.projectdua;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText username, password, email;
    Button register;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        username = findViewById(R.id.etNewName);
        password = findViewById(R.id.etNewPassword);
        email = findViewById(R.id.etNewEmail);
        register = findViewById(R.id.btnRegister);

        preferences = getSharedPreferences("userInfo", 0);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();

                if(usernameValue.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("email", emailValue);
                    editor.apply();
                    Toast.makeText(Register.this, "User Regitered!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Register.this, "Enter Values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
