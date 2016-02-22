package com.example.daskalski.libraryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Calculator extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button minus;
    Button plus;
    Button product;
    Button mod;
    Button zero;
    Button clear;
    Button equals;

    int a;
    int b;
    String sign;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText = (EditText)findViewById(R.id.editText);
        one = (Button)findViewById(R.id.button1);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        five = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine = (Button)findViewById(R.id.button9);
        zero = (Button)findViewById(R.id.button);
        clear = (Button)findViewById(R.id.clear);
        plus = (Button)findViewById(R.id.plus);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);



        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.setText("");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                sign = "+";
                editText.setText("");
//                if(a!=0) {
//                    //ako nqma vyvedeno chislo predi operaciqta
//                    //number = editText.getText().toString();
//                    //a = Integer.parseInt(number);
//                }else{
                    b = Integer.parseInt(editText.getText().toString());
                    calculate(a,b,sign);
                    editText.setText(result);
                    a = 0;
                    b = 0;
                //}
                //editText.setText("");
            }

        });

    }

    public void calculate(int a,int b, String sign){
        switch (sign){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }

    }

    @Override
    public void onClick(View v) {
        String buttonPressed = ((Button) v).getText().toString();
        editText.setText(editText.getText().append(buttonPressed));
        a = Integer.parseInt(editText.getText().toString());
    }
}
