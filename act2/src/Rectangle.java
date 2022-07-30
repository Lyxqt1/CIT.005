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
        return (Math.round(((2*length())+(2*width()))*100.0))/100.0;
    }
    public String toString()  {
        return coordinates() + "\nlength: "+length() +"\nwidth: " +width()+"\narea: "+area()+"\nperimeter: "+ perimeter();
    }
}