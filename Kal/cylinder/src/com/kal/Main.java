package com.kal;

public class Main{
    static int[] x = new int[2];
    static int[] y = new int[2];
    static float[] r = new float[2];
    static float[] h = new float[2];
    public static void main(String[] args) {
        Cylinder[] cylins = new Cylinder[2];
        Circle[] circs = new Circle[2];
        Cylinder enclosing;
        System.out.println("This program generates a random Cylinder");
        // Initialize the Cylinders as arbitrary sizes and at arbitrary positions:
        for(int i = 0 ; i < cylins.length ; ++i) {
            x[i]= (int) (Math.random()*100);
            y[i]= (int) (Math.random()*100);
            r[i]= (float) (Math.random()*100);
            h[i]=(float)(Math.random()*100);
            cylins[i] = new Cylinder(x[i],y[i],r[i],h[i]);
            circs[i] = new Circle(x[i],y[i],r[i]);
            System.out.println("\nCylinder "+(i+1)+"\n"+cylins[i]);
        }
        System.out.println("\ncylinder 1 & cylinder 2 equal: "+equals());
        // Initialize the enclosing Cylinder to be first Cylinder
        enclosing = cylins[0];

        // Combine it with each the other Cylinders in turn.
        // This will result in the Cylinder that encloses them all.
        for(Cylinder cylin : cylins)  {
            enclosing = enclosing.encloses(cylin);
        }
    }
    //override
    public static boolean equals(){
        if(x[0]==x[1]){
            if(y[0]==y[1]){
                return r[0] == r[1];
            }
        }
        return false;
    }
}
