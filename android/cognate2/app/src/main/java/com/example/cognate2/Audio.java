package com.example.cognate2;

import android.util.Log;

public class Audio extends OutputDevice{
    int decibel;
    String audioType;
    public Audio(String name, int hz, String plugType, int decibel, String audioType) {
        super(name, hz, plugType);
        this.audioType = audioType;
        this.decibel = decibel;
    }
    public void playMusic(){
        Log.w("play", name+ " is playing music" );
    }
}
