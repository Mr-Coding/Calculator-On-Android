package com.calculator.ching.calculator;

import android.app.Activity;

public class BaseActivity extends Activity {
    protected final <T> T $(int id){
        return (T)findViewById(id);
    }
}
