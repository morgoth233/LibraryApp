package com.example.daskalski.libraryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daskalski.libraryapp.model.UsersManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    Button register;
    EditText username;
    EditText password;

    //String user = username.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        register = (Button) findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                UsersManager um = UsersManager.getInstance();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(um.existsUser(user)){
                    Toast.makeText(register.getContext(),"Such user already exist", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                    username.setError(user + " exist in db");
                }else{
                    um.add(user,pass);
                    username.setText("");
                    password.setText("");
                }

            }
        });
    }


    @Override
    public void onClick(View v) {
        String msg;
        UsersManager um = UsersManager.getInstance();
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if(um.existsUser(user)) {
            if(um.validPass(user, pass)) {
                msg = "Welcome, " + user;
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
            else {
                msg = "Sorry, invalid password for this user!";
                password.requestFocus();
                password.setText("");
                password.setError(msg);
            }
        }
        else {
            msg = "Sorry, no such user in our DataBase!";
            username.requestFocus();
            username.setText("");
            password.setText("");
            username.setError(msg);
        }
    }


}
