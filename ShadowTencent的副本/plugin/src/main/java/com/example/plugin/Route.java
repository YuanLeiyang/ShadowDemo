package com.example.plugin;

import com.example.shadowstandard.RouteHolder;
import com.example.shadowstandard.RouteInit;

public class Route implements RouteInit {
    public void init() {
        RouteHolder.getInstance().putRoute("plugin/MainActivity", new MainActivity());
        RouteHolder.getInstance().putRoute("plugin/SecondActivity", new SecondActivity());
    }
}
