package com.example.cognate2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Keyboard NuphyAir = new Keyboard("NuphyAir60", 2000, true, "Cherry MX", 60);
        Keyboard Custom = new Keyboard("KA-65XT", 1000, false, "Gateron Yellow", 70);
        Keyboard[] arrkeeb = {NuphyAir, Custom};
        for (int i = 0; i < 2; i++) {
            Log.v("name", arrkeeb[i].name);
            Log.v("TR", arrkeeb[i].transferRate + " data transfer rate");
            if (arrkeeb[i].isWireless) {
                Log.v("w", "The keyboard is wireless capable");
            } else {
                Log.v("w", "The keyboard is only wired");
            }
            Log.v("sw", "switches: " + arrkeeb[i].switches + "\tsize: " + arrkeeb[i].keyboardSize);
            arrkeeb[i].mod();
            arrkeeb[i].type();
            arrkeeb[i].connect();
            arrkeeb[i].communicate();
            arrkeeb[i].remove();
        }
        Mouse G305 = new Mouse("Logitech G305", 10000, true, "Symmetrical", 7);
        Mouse Ergo = new Mouse("Logitech MX ergo", 1000, true, "Ergonomic", 7);

        Mouse[] arrMouse = {G305, Ergo};
        for (int i = 0; i < 2; i++) {
            Log.v("name", arrMouse[i].name);
            Log.v("TR", arrMouse[i].transferRate + " data transfer rate");
            if (arrMouse[i].isWireless) {
                Log.v("w", "The mice is wireless capable");
            } else {
                Log.v("w", "The mice is only wired");
            }
            Log.v("sh", "shape: " + arrMouse[i].shape + "\tbuttons: " + arrMouse[i].buttonCount);
            arrMouse[i].clickHeads();
            arrMouse[i].whiff();
            arrMouse[i].connect();
            arrMouse[i].communicate();
            arrMouse[i].remove();

        }
        Audio Sennheiser = new Audio("Sennheiser HD 560S", 16000, "3.5mm", 69, "Open-back Headphones");
        Audio Moondrops = new Audio("MOONDROP S8 8BA", 17000, "3.5mm/Type-C", 42, "In-Ear Monitors");

        Audio[] arrAud = {Sennheiser, Moondrops};
        for (int i = 0; i < 2; i++) {
            Log.v("name", arrAud[i].name);
            Log.v("TR", arrAud[i].hz + " hz");
            Log.v("plug", arrAud[i].plugType);
            Log.v("sw", "db: " + arrAud[i].decibel + "\tType: " + arrAud[i].audioType);
            arrAud[i].playMusic();
            arrAud[i].connect();
            arrAud[i].communicate();
            arrAud[i].remove();
        }
        Monitor Samsung = new Monitor(" Odyssey G9 Gaming Monitor", 240, "HDMI 2.1/Display Port", "VA", 1000);
        Monitor Asus = new Monitor("ROG SWIFT PG259QN", 360, "HDMI 2.0/Display Port 1.4", "Fast IPS", 400);
        Monitor[] arrMonitor = {Samsung, Asus};
        for (int i = 0; i < 2; i++) {
            Log.v("name", arrMonitor[i].name);
            Log.v("TR", "refresh rate; "+ arrMonitor[i].hz + " hz");
            Log.v("plug", "ports: " + arrMonitor[i].plugType);
            Log.v("sw", "panel: " + arrMonitor[i].panelType + "\tpeak brightness: "+arrMonitor[i].peakBrightness);
            arrMonitor[i].hdrOn();
            arrMonitor[i].connect();
            arrMonitor[i].communicate();
            arrMonitor[i].remove();
        }
    }
}