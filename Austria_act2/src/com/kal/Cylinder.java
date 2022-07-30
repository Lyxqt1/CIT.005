package com.kal;

import java.awt.*;
public class Cylinder {
    private Point center;
    private float radius;
    private float height;
    // Constructors
    public Cylinder(int x1, int y1, float r1, float h1) {
        center = new Point(x1,y1);
        radius = r1;
        height = h1;
    }
    public float areaCylinder(){
        return 2*Circle.area()+(height*Circle.circumference());
    }
    public float volumeCylinder(){
        return Circle.area()*height;
    }
    public String toString() {
       return "Center: " + center + "\nRadius: " + radius+"\nArea: "+areaCylinder()+"\nVolume: "+volumeCylinder();
    }
}
