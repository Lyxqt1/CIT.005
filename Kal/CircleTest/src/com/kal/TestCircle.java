package com.kal;

public class TestCircle{
    static int[] x = new int[2];
    static int[] y = new int[2];
    static float[] r = new float[2];
    public static void main(String[] args) {
        Circle[] circs = new Circle[2];

        Circle enclosing;
        System.out.println("This program generates a random Circle");
        // Initialize the Circles as arbitrary sizes and at arbitrary positions:
        for(int i = 0 ; i < circs.length ; ++i) {
           x[i]= (int) (Math.random()*100);
           y[i]= (int) (Math.random()*100);
           r[i]= (float) (Math.random()*100);
            circs[i] = new Circle(x[i],y[i],r[i]);
            System.out.println("\nCircle "+(i+1)+"\n"+circs[i]);
        }
        System.out.println("\ncircle 1 & circle 2 equal: "+equals());
        // Initialize the enclosing Circle to be first Circle
        enclosing = circs[0];

        // Combine it with each the other Circles in turn.
        // This will result in the Circle that encloses them all.
        for(Circle circ : circs)  {
            enclosing = enclosing.encloses(circ);
        }
    }
    //override
    public static boolean equals(){
        if(x[0]==x[1]){
            if(y[0]==y[1]){
                if(r[0]==r[1]){
                    return true;
                }
            }
        }
        return false;
    }
}
