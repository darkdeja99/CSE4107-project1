package com.example.proje1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    private EditText debtIn;
    private EditText rateIn;
    private EditText result5;
    private EditText result10;
    private EditText result15;
    private EditText result20;
    private EditText result25;
    private EditText result30;

    private double debtAmount;
    private double ınterestRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        debtIn = (EditText) findViewById(R.id.debtIn);
        rateIn = (EditText) findViewById(R.id.rateIn);

        result5 = (EditText) findViewById(R.id.fiveYout);
        result10 = (EditText) findViewById(R.id.tenYout);
        result15 = (EditText) findViewById(R.id.fifteenYout);
        result20 = (EditText) findViewById(R.id.twentyYout);
        result25 = (EditText) findViewById(R.id.twentyfiveYout);
        result30 = (EditText) findViewById(R.id.thirtyYout);

        debtIn.addTextChangedListener(debtInWatcher);
        rateIn.addTextChangedListener(rateInWatcher);

        Button butCalculate= (Button) findViewById(R.id.calculateBut);
        butCalculate.setOnClickListener(butCalculateClick);





    }
    private void show5Year(double number){
        result5.setText(String.format("%d", number));
    }
    private void show10Year(double number){
        result10.setText(String.format("%d", number));
    }
    private void show15Year(double number){
        result15.setText(String.format("%d", number));
    }
    private void show20Year(double number){
        result20.setText(String.format("%d", number));
    }
    private void show25Year(double number){
        result25.setText(String.format("%d", number));
    }
    private void show30Year(double number){
        result30.setText(String.format("%d", number));
    }

    public OnClickListener butCalculateClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            double debt5Y = debtAmount*Math.pow((1+ınterestRate),5);
            double debt10Y = debtAmount*Math.pow((1+ınterestRate),10);
            double debt15Y = debtAmount*Math.pow((1+ınterestRate),15);
            double debt20Y = debtAmount*Math.pow((1+ınterestRate),20);
            double debt25Y = debtAmount*Math.pow((1+ınterestRate),25);
            double debt30Y = debtAmount*Math.pow((1+ınterestRate),30);

            show5Year(debt5Y/(5*12));
            show5Year(debt10Y/(10*12));
            show5Year(debt15Y/(15*12));
            show5Year(debt20Y/(20*12));
            show5Year(debt25Y/(25*12));
            show5Year(debt30Y/(30*12));

        }
    };

    private TextWatcher debtInWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (s.toString().length() > 0){
                debtAmount = Double.parseDouble(s.toString());
                //showResult();
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher rateInWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (s.toString().length() > 0){
                ınterestRate = Double.parseDouble(s.toString());
                //showResult();
            }

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
