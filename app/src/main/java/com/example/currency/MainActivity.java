package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected Spinner spinner1, spinner2;
    protected TextView icon1, icon2, input, output, txt;
    protected Button buttonNumber0,
            buttonNumber1,
            buttonNumber2,
            buttonNumber3,
            buttonNumber4,
            buttonNumber5,
            buttonNumber6,
            buttonNumber7,
            buttonNumber8,
            buttonNumber9,
            clear,
            clear_all
    ;
    String[] currency = new String[]{
            "Vietnam - VND",
            "United States - USD",
            "Euro - EUR",
            "United Kingdom - GBP"};
    String[] codes = new String[]{
            "VND",
            "USD",
            "EUR",
            "GBP"};
    Double[] rates = new Double[] {23200.0, 1.0, 0.96, 0.82};
    String[] icons = new String[] {"₫", "$", "€", "£"};
    Double rate = 1.0;
    int id1 = 0, id2 = 0;
    String inputText = "0";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinner1 = (Spinner) findViewById(R.id.spinner_1);
        this.spinner2 = (Spinner) findViewById(R.id.spinner_2);
        this.icon1 = (TextView) findViewById(R.id.icon1);
        this.icon2 = (TextView) findViewById(R.id.icon2);
        this.input = (TextView) findViewById(R.id.input);
        this.output = (TextView) findViewById(R.id.output);
        this.txt = (TextView) findViewById(R.id.txt1);
        buttonNumber0 = (Button) findViewById(R.id.button_0);
        buttonNumber1 = (Button) findViewById(R.id.button_1);
        buttonNumber2 = (Button) findViewById(R.id.button_2);
        buttonNumber3 = (Button) findViewById(R.id.button_3);
        buttonNumber4 = (Button) findViewById(R.id.button_4);
        buttonNumber5 = (Button) findViewById(R.id.button_5);
        buttonNumber6 = (Button) findViewById(R.id.button_6);
        buttonNumber7 = (Button) findViewById(R.id.button_7);
        buttonNumber8 = (Button) findViewById(R.id.button_8);
        buttonNumber9 = (Button) findViewById(R.id.button_9);
        clear_all = (Button) findViewById(R.id.button_clear_all);
        clear = (Button) findViewById(R.id.button_clear);


        final List<String> currencyList = new ArrayList<>(Arrays.asList(this.currency));
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyList);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner1.setAdapter(spinnerArrayAdapter);
        this.spinner2.setAdapter(spinnerArrayAdapter);

        this.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id1 = (int) id;
                updateRate();
                icon1.setText(icons[id1]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id2 = (int) id;
                updateRate();
                icon2.setText(icons[id2]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonNumber0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("0");
            }
        });

        buttonNumber1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("1");
            }
        });

        buttonNumber2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("2");
            }
        });

        buttonNumber3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("3");
            }
        });

        buttonNumber4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("4");
            }
        });

        buttonNumber5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("5");
            }
        });

        buttonNumber6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("6");
            }
        });

        buttonNumber7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("7");
            }
        });

        buttonNumber8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("8");
            }
        });

        buttonNumber9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("9");
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("CE");
            }
        });

        clear_all.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMoney("BS");
            }
        });

    }

    private void updateRate() {
        this.rate = 1.0 / (this.rates[this.id1] / this.rates[this.id2]);
        this.txt.setText("1 " + this.codes[this.id1] + " = " + this.rate + ' ' +this.codes[this.id2]);
        updateMoney("");
    }
    private void updateMoney(String id) {
        if(id == "CE") {
            inputText = inputText.replace(inputText.substring(inputText.length()-1), "");
            if(inputText == "") inputText = "0";
        } else if(id == "BS") {
            inputText = "0";
        } else if(id != "") {
            inputText = inputText + id;
        }

        input.setText(inputText);

        try {
            output.setText(String.valueOf(rate * Integer.parseInt(inputText)));
        } catch (Exception ex) {
            output.setText(String.valueOf(rate * Double.parseDouble(inputText)));
        }
    }

}