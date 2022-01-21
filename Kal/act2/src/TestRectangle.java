import java.util.Arrays;

public class TestRectangle {
    public static void main(String args[]) {
        Rectangle[] rects = new Rectangle[1];
        Rectangle enclosing;
        int x1 = 1;
        int x2 = 4;
        int y1 = 1;
        int y2 = 3;
        int rectWidth;
        // Initialize the rectangles as arbitrary sizes and at arbitrary positions:
        for(int i = 0 ; i < rects.length ; ++i) {
            rects[i] = new Rectangle(Math.random()*100, Math.random()*100, Math.random()*100, Math.random()*100);
            System.out.println("This program generates a random rectangle\n");
            System.out.println(rects[i]);
        }

        // Initialize the enclosing rectangle to be first rectangle
        enclosing = rects[0];

        // Combine it with each the other rectangles in turn.
        // This will result in the rectangle that encloses them all.
        for(Rectangle rect : rects)  {
            enclosing = enclosing.encloses(rect);
        }
    }
}