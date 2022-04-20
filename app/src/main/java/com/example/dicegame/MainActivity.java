package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    TextView textView, saveDice;
    Button diceButton, saveButton;
    EditText ed;
    SharedPreferences s;
    String t;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViews);
        saveDice = findViewById(R.id.textView2);
        diceButton = findViewById(R.id.button);
        saveButton = findViewById(R.id.button2);
        ed = findViewById(R.id.uInput);




        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //initialize random variable
                Random rand = new Random();

                //get value from edittext and store in variable i
                String i = ed.getText().toString();

                //apply random function on i which is our edittext user input
                int d = rand.nextInt(Integer.parseInt(i))+1;

                //show the random value in a text view
                textView.setText((String.valueOf(d)));
            }
        });

        s = getSharedPreferences("pref", Context.MODE_PRIVATE);
        //save dice in shared preference
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences sp1 = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
                 t  = textView.getText().toString();
                SharedPreferences.Editor editor = sp1.edit();
                editor.putString(String.valueOf(saveDice),t);
                editor.commit();

            }
        });




    }
}