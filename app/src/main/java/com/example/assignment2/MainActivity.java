package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText distMi, distKilo, temperatureC, temperatureF, amtGal, amtLiter, pounds, kilograms;
    DecimalFormat dc = new DecimalFormat("#.####");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureC = findViewById(R.id.tempC);
        temperatureF = findViewById(R.id.tempF);
        amtGal = findViewById(R.id.gallons);
        amtLiter = findViewById(R.id.liter);
        distMi = findViewById(R.id.miles);
        distKilo = findViewById(R.id.kiloMeter);
        pounds = findViewById(R.id.lbs);
        kilograms = findViewById(R.id.kg);

        distKilo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                      if (distKilo.hasFocus() && distKilo.length() != 0 && !(s.toString().equals("-"))) {
                          distMi.getText().clear();
                          String milesStr = kiloToMiles(s.toString());
                          distMi.setText(milesStr);
                      }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        distMi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (distMi.hasFocus() && distMi.length() != 0 && !(s.toString().equals("-"))) {
                        distKilo.getText().clear();
                        String kiloStr = milesToKilo(s.toString());
                        distKilo.setText(kiloStr);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        amtLiter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(amtLiter.hasFocus() && amtLiter.length() != 0 && !(s.toString().equals("-"))){
                    amtGal.getText().clear();
                    String galStr = literToGallon(s.toString());
                    amtGal.setText(galStr);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        amtGal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (amtGal.hasFocus() && amtGal.length() != 0 && !(s.toString().equals("-"))){
                    amtLiter.getText().clear();
                    String literStr = galToLiter(s.toString());
                    amtLiter.setText(literStr);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        temperatureF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (temperatureF.hasFocus() && temperatureF.length() != 0 && !(s.toString().equals("-"))){
                    temperatureC.getText().clear();
                    String tempCStr = tempFToC(s.toString());
                    temperatureC.setText(tempCStr);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        temperatureC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (temperatureC.hasFocus() && temperatureC.length() != 0 && !(s.toString().equals("-"))){
                    temperatureF.getText().clear();
                    String tempF = tempCtoF(s.toString());
                    temperatureF.setText(tempF);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pounds.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pounds.hasFocus() && pounds.length() != 0 && !(s.toString().equals("-"))){
                    kilograms.getText().clear();
                    String kiloGrams = weightLbsToKg(s.toString());
                    kilograms.setText(kiloGrams);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        kilograms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (kilograms.hasFocus() && kilograms.length() != 0 && !(s.toString().equals("-"))){
                    pounds.getText().clear();
                    String pound = weightKgToLbs(s.toString());
                    pounds.setText(pound);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public String kiloToMiles(String s){
        double kiloMeters = Double.parseDouble(s);
        double miles = kiloMeters * .62137;
        return dc.format(miles);
    }

    public String milesToKilo(String s) {
        double miles = Double.parseDouble(s);
        double kiloM = miles * 1.609;
        return dc.format(kiloM);
    }

    public String galToLiter(String s){
        double gal = Double.parseDouble(s);
        double liter = gal * 3.785;
        return dc.format(liter);

    }

    public String literToGallon(String s){
        double liter = Double.parseDouble(s);
        double gallon = liter / 3.785;
        return dc.format(gallon);
    }

    public String tempFToC(String s){
        double tempF = Double.parseDouble(s);
        double tempC = (tempF - 32) * 5/9;
        return dc.format(tempC);
    }

    public String tempCtoF(String s){
        double tempC = Double.parseDouble(s);
        double tempF = (tempC * 9/5) + 32;
        return dc.format(tempF);
    }

    public String weightLbsToKg(String s){
        double lbs = Double.parseDouble(s);
        double kg = lbs / 2.205;
        return dc.format(kg);
    }

    public String weightKgToLbs(String s){
        double kg = Double.parseDouble(s);
        double lbs = kg * 2.205;
        return dc.format(lbs);
    }
}
