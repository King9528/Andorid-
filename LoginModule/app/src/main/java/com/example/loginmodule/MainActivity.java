package com.example.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static int no_of_attempts=3;
    public void login(View v) {
        EditText e1=(EditText) findViewById(R.id.username);
        EditText e2=(EditText) findViewById(R.id.password);
        TextView attempts_textView=(TextView) findViewById(R.id.attempts_view);
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

        String username=e1.getText().toString();
        String password=e2.getText().toString();
        if(no_of_attempts>0) {
            if (username.equals("") || password.equals("")) {
                toast.setText("Username or password cannot be empty!");
                toast.show();
            }
            else {
                if (username.equals("admin") && password.equals("admin")) {
                    Intent intent = new Intent(this, LoginSuccessful.class);
                    toast.setText("Login successful");
                    toast.show();
                    startActivity(intent);
                } else {
                    attempts_textView.setText("Attempts left: " + (--no_of_attempts));
                    toast.setText("Login failed!");
                    toast.show();
                }
            }
        }
    }
}