import static java.lang.Math.abs;

public class Rectangle {
    private Point upperLeft;
    private Point lowerRight;

    // Constructors
    public Rectangle(double x1, double y1, double x2, double y2) {
        // Ensure topleft uses the smaller of x1,x2 and y1,y2
        // and topright uses the larger of x1,x2 and y1,y2
        upperLeft = new Point(Math.min(x1,x2), Math.min(y1,y2));
        lowerRight = new Point(Math.max(x1,x2), Math.max(y1,y2));
    }


    // Methods to create a rectangle enclosing the current rectangle and the argument
    public Rectangle encloses(Rectangle rect) {
        // Return a new rectangle defined by the minimum x,y for to left and the and maximum x,y for bottom right
        return new Rectangle(Math.min(upperLeft.getX(), rect.upperLeft.getX()),
                Math.min(upperLeft.getY(), rect.upperLeft.getY()),
                Math.max(lowerRight.getX(), rect.lowerRight.getX()),
                Math.max(lowerRight.getY(), rect.lowerRight.getY()));

    }
    public String coordinates(){
        return "Coordinates: ("+upperLeft +"), ("+lowerRight+")";
    }
    public double length() {
        return (Math.round(abs((upperLeft.getX() - lowerRight.getX()))*100.0))/100.0;
    }
    public double width(){
        return (Math.round(abs((upperLeft.getY()- lowerRight.getY()))*100.0))/100.0;
    }
    public double area(){
        return (Math.round(length()*width()*100.0))/100.0;
    }
    double perimeter(){
        return (2*length())+(2*width());
    }
    public String toString()  {
        return coordinates() + "\nlength: "+length() +"\nwidth: " +width()+"\narea: "+area()+"\nperimeter: "+ perimeter();
    }
}