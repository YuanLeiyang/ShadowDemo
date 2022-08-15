package com.example.shadowtencent;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class PluginManagerImpl {
    private Resources resources;

    private DexClassLoader dexClassLoader;

    private static PluginManagerImpl sInstance = new PluginManagerImpl();

    private PluginManagerImpl() {
    }

    public static PluginManagerImpl getInstance() {
        return sInstance;
    }

    public void loadPath() {
        File file = new File(Environment.getExternalStorageDirectory(), "plugin.apk");
        String path = file.getAbsolutePath();
        Context context = HostApplication.getContext();
        File dexOutFile = context.getDir("dex", Context.MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(path, dexOutFile.getAbsolutePath(), null,
            HostApplication.getContext().getClassLoader());

        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, path);
            resources = new Resources(assetManager, HostApplication.getContext().getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public void setDexClassLoader(DexClassLoader dexClassLoader) {
        this.dexClassLoader = dexClassLoader;
    }
}
