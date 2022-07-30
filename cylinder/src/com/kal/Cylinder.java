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


    // Methods to create a rectangle enclosing the current rectangle and the argument
    public Cylinder encloses(Cylinder cylin) {
        // Return a new rectangle defined by the minimum x,y for to left and the and maximum x,y for bottom right
        return new Cylinder((int) Math.min(center.getX(),(int) cylin.center.getX()),
                (int) Math.min(center.getY(), (int)cylin.center.getY()), (float) cylin.radius, (float)cylin.height);

    }
    public float cylinumference(){
        return (float) (radius*2*Math.PI);
    }
    public String toString()  {
        return "yes"+Circle.area();
    }
}
