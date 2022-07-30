package com.kal;

public class Point {
    // Create a Point object from a coordinate pair
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Create a Point object from another Point
    public Point(Point p) {
        x = p.x;
        y = p.y;
    }

    // Get the value of the x coordinate
    int getX() {
        return (int) x;
    }

    // Get the value of the y coordinate
    int getY() {
        return (int) y;
    }

    public String toString(){
        return "("+x +", "+y+")";
    }

    // Fields store the point coordinates
    private int x;
    private int y;
}