package com.example.cognate2;

import android.util.Log;

public interface IO_devices {

    public default void connect(){
        Log.i("connect", "connected I/O device");
    }
    public default void remove(){
        Log.i("remove", "remove I/O device");
    }
    public default void communicate(){
        Log.i("comm", "communicating with I/O device");
    }
}
