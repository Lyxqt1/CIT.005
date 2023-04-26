package com.example.cognate2;

import android.util.Log;

public class InputDevice implements IO_devices {
    String name;
    int transferRate;
    boolean isWireless;

    public InputDevice(String name, int transferRate, boolean isWireless) {
        this.name = name;
        this.transferRate = transferRate;
        this.isWireless = isWireless;
    }

    @Override
    public void connect() {
        Log.w("connect: ", "Your " + name + " input device is ready");
    }

    @Override
    public void remove() {
        Log.w("remove: ", "Your " + name + " input device has been disconnected");
    }

    @Override
    public void communicate() {
        Log.w("comm: ", "Your " + name + " input device has sent data to your PC");
    }
}
