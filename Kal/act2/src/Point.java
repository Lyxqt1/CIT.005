public class Point {
    // Create a Point object from a coordinate pair
    public Point(double x, double y) {
        this.x = (Math.round(x*100.0))/100.0;
        this.y = (Math.round(y*100.0))/100.0;
    }

    // Create a Point object from another Point
    public Point(Point p) {
        x = p.x;
        y = p.y;
    }

    // Get the value of the x coordinate
    double getX() {
        return (Math.round(x*100.0))/100.0;
    }

    // Get the value of the y coordinate
    double getY() {
        return (Math.round(y*100.0))/100.0;
    }

    public String toString(){
        return x +", "+y;
    }

    // Fields store the point coordinates
    private double x;
    private double y;
}