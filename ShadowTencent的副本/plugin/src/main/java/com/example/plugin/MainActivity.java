package com.example.plugin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends ShadowContext {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        that.setContentView(R.layout.activity_main);
        Toast.makeText(that, "------->222", Toast.LENGTH_SHORT).show();

        that.findViewById(R.id.tv_hello_world).setOnClickListener(v -> {
            startActivity(new Intent(that, SecondActivity.class));
        });
    }
}