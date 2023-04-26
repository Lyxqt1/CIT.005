package com.example.cognate2;

import android.util.Log;

public class OutputDevice implements IO_devices{
    String name;
    int hz;//could be refresh rate or kHz for audio
    String plugType;

    public OutputDevice(String name, int hz, String plugType) {
        this.name = name;
        this.hz = hz;
        this.plugType = plugType;
    }

    @Override
    public void connect() {
        Log.w("connect: ", "Your " + name + " output device is ready");
    }

    @Override
    public void remove() {
        Log.w("remove: ", "Your " + name + " output device has been disconnected");
    }

    @Override
    public void communicate() {
        Log.w("comm: ", "Your " + name + " output device has received data from your PC");
    }
}
