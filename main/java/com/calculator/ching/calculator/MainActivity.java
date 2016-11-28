package com.calculator.ching.calculator;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

import View.Text_View;

import static java.security.AccessController.getContext;

public class MainActivity extends Activity {
    private Text_View text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
