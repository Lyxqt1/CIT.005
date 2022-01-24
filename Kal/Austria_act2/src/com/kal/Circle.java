package com.kal;
public class Circle {
    private Point center;
    private static float radius;

    // Constructors
    public Circle(int x1, int y1, float r1) {
        center = new Point(x1,y1);
        radius = r1;
    }


    public static float area(){
        return (float)(radius*radius*Math.PI);
    }
    public static float circumference(){
        return (float) (radius*2*Math.PI);
    }

    public String toString()  {
        return "Center: " + center + "\nRadius: " + radius+"\nArea: "+area()+"\nCircumference: "+circumference();
    }
}
