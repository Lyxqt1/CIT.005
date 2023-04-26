package com.example.cognate2;

import android.util.Log;

public class Mouse extends InputDevice{
    String shape;
    int buttonCount;
    public Mouse(String name, int transferRate, boolean isWireless, String shape, int buttonCount){
        super(name, transferRate, isWireless);
        this.shape = shape;
        this.buttonCount = buttonCount;
    }

    public void clickHeads(){
        Log.w("click", "+1 kill -- headshot");
    }
    public void whiff(){
        Log.e("whiff", " missed -- u ded");
    }
}
