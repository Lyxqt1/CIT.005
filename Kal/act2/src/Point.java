public class Point {
    // Create a Point object from a coordinate pair
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Create a Point object from another Point
    public Point(Point p) {
        x = p.x;
        y = p.y;
    }

    // Get the value of the x coordinate
    double getX() {
        return x;
    }

    // Get the value of the y coordinate
    double getY() {
        return y;
    }

    public String toString(){
        return x +","+y;
    }

    // Fields store the point coordinates
    private double x;
    private double y;
}