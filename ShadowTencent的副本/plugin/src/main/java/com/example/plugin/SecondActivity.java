package com.example.plugin;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends ShadowContext {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        that.setContentView(R.layout.activity_second);
        Toast.makeText(that, "------->", Toast.LENGTH_SHORT).show();
    }
}
