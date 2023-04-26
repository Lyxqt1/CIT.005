package com.example.cognate2;

import android.util.Log;

public class Monitor extends OutputDevice{
    String panelType;
    int peakBrightness;
    public Monitor(String name, int hz, String plugType, String panelType, int peakBrightness) {
        super(name, hz, plugType);
        this.panelType = panelType;
        this.peakBrightness = peakBrightness;
    }
    public void hdrOn(){
        Log.w("HDR", name+ " HDR is now turned on");
    }
}
