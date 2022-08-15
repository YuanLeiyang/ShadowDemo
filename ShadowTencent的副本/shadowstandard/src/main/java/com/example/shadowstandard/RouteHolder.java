package com.example.shadowstandard;

import java.util.HashMap;

public class RouteHolder {
    private static HashMap<String, LifecycleInterface> route;

    private static RouteHolder sInstance = new RouteHolder();

    private RouteHolder() {
        route = new HashMap<>();
    }

    public static RouteHolder getInstance() {
        return sInstance;
    }

    public LifecycleInterface getRoute(String routeName) {
        return route.get(routeName);
    }

    public void putRoute(String routeName, LifecycleInterface lifecycleInterface) {
        route.put(routeName, lifecycleInterface);
    }
}
