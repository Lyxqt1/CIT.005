package com.example.empty;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

interface Animal {
    public void move();

    public void eat();

    public void sleep();
}

class Fish implements Animal {
    int depth;
    String water;

    public Fish(int d, String w) {
        depth = d;
        water = w;
    }

    @Override
    public void move() {
        Log.i("move: ", " the fish is swimming");
    }

    @Override
    public void eat() {
        Log.i("eat: ", " the fish is eating");
    }

    @Override
    public void sleep() {
        Log.i("sleep: ", " the fish is sleeping");
    }

    public void depth() {
        Log.i("depth: ", "depth: " + depth);
    }

    public void waterType() {
        Log.v("water type: ", "water Type: " + water + " water");
    }
}

class Goldfish extends Fish {
    String name;
    String color;
    String breed;

    public Goldfish(int d, String w, String name, String breed) {
        super(d, w);
        this.name = name;
        this.breed = breed;
    }

    public void clean() {
        Log.w("clean: ", "replaced the water and cleaned the bowl of " + name);
    }
}

class Tuna extends Fish {
    String region;

    public Tuna(int d, String w, String region) {
        super(d, w);
        this.region = region;
    }

    public void cook() {
        Log.w(TAG, "cook the " + region);
    }
}

class Dog implements Animal {
    String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public void move() {
        Log.w(TAG, "dog run");
    }

    @Override
    public void eat() {
        Log.w(TAG, "dog eat");
    }

    @Override
    public void sleep() {
        Log.w(TAG, "dog sleep");
    }
}

class Husky extends Dog {
    public Husky(String breed) {
        super(breed);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main();
    }

    public void Main() {
        Goldfish gold = new Goldfish(10, "fresh", "goldi", "red");
        gold.eat();
        gold.move();
        gold.sleep();
        gold.depth();
        gold.waterType();
        gold.clean();
        Log.i(TAG, "Main: " + gold.name);

    }
}