
interface Animal {
    public void move();

    public void eat();

    public void sleep();
}

class Fish implements Animal {
    String waterType;
    int depth;

    public Fish(String water, int depth) {
        this.depth = depth;
        this.waterType = water;
    }

    public void move() {
        System.out.println("The fish swims in the " + waterType + " water");
    }

    public void eat() {
    }

    public void sleep() {

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Fish isda = new Fish("fresh", 10);
        isda.move();
        Fish animal = new Fish("salt",1000);
        animal.move();
    }
}