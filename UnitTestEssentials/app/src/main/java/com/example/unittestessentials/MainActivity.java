package com.example.unittestessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

class CalculatorTest {
    static void testCalculatorAddFunction() {
        Calculator calc = new Calculator();
        int result = calc.add(10, 10);
        if(result == 20 ){
            Log.i("MainActivity", "Test Pass");
        } else {

            Log.i("MainActivity", "Test Fail");
        }
    }

    static void testCalculatorMultiplyFunction() {
        Calculator calc = new Calculator();
        int result = calc.multiply(10, 10);
        if(result == 100 ){
            Log.i("MainActivity", "Test Pass");
        } else {
            Log.i("MainActivity", "Test Fail");
        }
    }
}