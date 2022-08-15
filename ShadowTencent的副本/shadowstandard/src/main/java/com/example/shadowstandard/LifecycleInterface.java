package com.example.shadowstandard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public interface LifecycleInterface {

    void attach(Activity proxyActivity);

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onSaveInstanceState(Bundle outState);

    boolean onTouchEvent(MotionEvent event);

    void onBackPressed();

    Context getContext();

    default void startActivity(Intent intent) {
        Intent target = new Intent();
        target.putExtra("className", intent.getComponent().getClassName());
        getContext().startActivity(target);
    }
}
