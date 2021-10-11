package com.example.emiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Math;
public class MainActivity extends AppCompatActivity {

    float mortgage, interest, emi;
    int amortization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mortgageEntry = findViewById(R.id.mortgageEntry);
        EditText interestEntry = findViewById(R.id.interestEntry);
        EditText amortizationEntry = findViewById(R.id.amortizationEntry);
        Button calculateButton = findViewById(R.id.calculate_button);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                TextView e = findViewById(R.id.emiamount_textView);
                TextView paid_interest = findViewById(R.id.paidinterest_textView);

                if(TextUtils.isEmpty(mortgageEntry.getText().toString()) || TextUtils.isEmpty(interestEntry.getText().toString()) || TextUtils.isEmpty(amortizationEntry.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please fill out form correctly", Toast.LENGTH_LONG).show();
                }
                else{
                    mortgage = Float.valueOf(mortgageEntry.getText().toString());
                    interest = Float.valueOf(interestEntry.getText().toString());
                    amortization = Integer.valueOf(amortizationEntry.getText().toString());
                    interest = interest / 100;
                    int n = amortization * 12;
                    float r = interest / 12;
                    float eq = (float) Math.pow((1 + r), n);
                    emi = mortgage * r * (eq / (eq - 1));
                    float total_interest = (emi * n) - mortgage;
                    e.setText("$ " + String.valueOf(emi));
                    paid_interest.setText("$ " + String.valueOf(total_interest));
                }
            }
        });


    }
}