package com.example.shadowtencent;

import android.app.Application;
import android.content.Context;

import com.example.shadowstandard.LifecycleInterface;
import com.example.shadowstandard.RouteHolder;
import com.example.shadowstandard.RouteInit;

import dalvik.system.DexClassLoader;

public class HostApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initRoute();
    }

    public static Context getContext() {
        return context;
    }

    private void initRoute() {
        PluginManagerImpl.getInstance().loadPath();
        DexClassLoader dexClassLoader = PluginManagerImpl.getInstance().getDexClassLoader();
        try {
            LifecycleInterface lifecycleInterface = (LifecycleInterface) dexClassLoader.loadClass("com.example.plugin.MainActivity").newInstance();
            RouteInit instance = (RouteInit) dexClassLoader.loadClass("com.example.plugin.Route").newInstance();
            instance.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        RouteHolder instance = RouteHolder.getInstance();
        LifecycleInterface route = instance.getRoute("plugin/MainActivity");
        if (route == null) {

        } else {

        }
    }
}
