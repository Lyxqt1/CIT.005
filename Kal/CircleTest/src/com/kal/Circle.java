package com.kal;

import java.awt.*;

public class Circle {
    private Point center;
    private float radius;

    // Constructors
    public Circle(int x1, int y1, float r1) {
        center = new Point(x1,y1);
        radius = r1;
    }


    // Methods to create a rectangle enclosing the current rectangle and the argument
    public Circle encloses(Circle circ) {
        // Return a new rectangle defined by the minimum x,y for to left and the and maximum x,y for bottom right
        return new Circle((int) Math.min(center.getX(), circ.center.getX()),
                (int) Math.min(center.getY(), circ.center.getY()), (float) circ.radius);

    }
    public float area(){
        return (float)(radius*radius*Math.PI);
    }
    public float circumference(){
        return (float) (radius*2*Math.PI);
    }

    public String toString()  {
            return "Center: " + center + "\nRadius: " + radius+"\nArea: "+area()+"\nCircumference: "+circumference();
    }
}
