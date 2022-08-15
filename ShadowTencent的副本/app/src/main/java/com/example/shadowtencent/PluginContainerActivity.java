package com.example.shadowtencent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.example.shadowstandard.LifecycleInterface;
import com.example.shadowstandard.RouteHolder;


/**
 * Activity壳
 * 插件页面的代理 ----> 插件
 */
public class PluginContainerActivity extends Activity {
    String className = "";

    LifecycleInterface pluginActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");
        if (TextUtils.isEmpty(className)) {
            className = "com.example.plugin.MainActivity";
        }
        String[] split = className.split("\\.");
        String routeName = "plugin/" + split[split.length - 1];
        pluginActivity = RouteHolder.getInstance().getRoute(routeName);
        pluginActivity.attach(this);
        Bundle bundle = new Bundle();
        bundle.putString("account", "1398471745");
        pluginActivity.onCreate(bundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pluginActivity.onResume();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManagerImpl.getInstance().getDexClassLoader();
    }

    @Override
    public Resources getResources() {
        // resource重定向
        return PluginManagerImpl.getInstance().getResources();
    }

    @Override
    public void startActivity(Intent intent) {
        String className = intent.getStringExtra("className");
        Intent target = new Intent(this, PluginContainerActivity.class);
        target.putExtra("className", className);
        super.startActivity(target);
    }
}
