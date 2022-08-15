package com.example.shadowtencent;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        findViewById(R.id.btn_load).setOnClickListener(this::load);
        findViewById(R.id.btn_jump).setOnClickListener(this::click);
    }

    public boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 1);
        }
        return false;
    }

    public void load(View view) {
//        File file = new File(Environment.getExternalStorageDirectory(), "plugin.apk");
        PluginManagerImpl.getInstance().loadPath();
    }

    public void click(View view) {
        Class<PluginContainerActivity> pluginContainerActivityClass = PluginContainerActivity.class;
        Intent intent = new Intent(this, PluginContainerActivity.class);
        startActivity(intent);
    }
}