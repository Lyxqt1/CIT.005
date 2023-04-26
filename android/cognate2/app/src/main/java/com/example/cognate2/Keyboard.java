package com.example.cognate2;

import android.util.Log;

public class Keyboard extends InputDevice {
    int keyboardSize;
    String switches;

    public Keyboard(String name, int transferRate, boolean isWireless, String switches, int keyboardSize) {
        super(name, transferRate, isWireless);
        this.switches = switches;
        this.keyboardSize = keyboardSize;
    }

    public void mod() {
        Log.w("mod", name + " has been modded and lubed its switches");
    }

    public void type() {
        Log.w("type", "clack clack clack");
    }
}
