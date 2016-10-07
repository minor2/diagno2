package com.example.aryakk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{
    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Toast.makeText(MainActivity.this, "a12", Toast.LENGTH_LONG).show();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ET_NAME = (EditText) findViewById(R.id.user_name);
            ET_PASS = (EditText) findViewById(R.id.user_pass);
        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    }
    public void userReg(View view) {
        try {
            Toast.makeText(MainActivity.this, "a13", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, register.class));
        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }

    }

    public void userLogin(View view) {
        try {


            Toast.makeText(MainActivity.this, "a14", Toast.LENGTH_LONG).show();
            login_name = ET_NAME.getText().toString();
            Toast.makeText(MainActivity.this, "a1a", Toast.LENGTH_LONG).show();

            login_pass = ET_PASS.getText().toString();
            Toast.makeText(MainActivity.this, "a1b", Toast.LENGTH_LONG).show();
            String method = "login";
            Toast.makeText(MainActivity.this, "a1c", Toast.LENGTH_LONG).show();
            BackgroundTask backgroundTask = new BackgroundTask(this);
            Toast.makeText(MainActivity.this, "a1d", Toast.LENGTH_LONG).show();
            backgroundTask.execute(method, login_name, login_pass);
        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    }
}