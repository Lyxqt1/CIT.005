package com.kal;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<Integer> vec_tor = new Vector<Integer>();

        // Use add() method to add elements in the vector
        vec_tor.add(12);
        vec_tor.add(23);
        vec_tor.add(22);
        vec_tor.add(10);
        vec_tor.add(20);
        System.out.println(vec_tor.size());
        int sum = vec_tor.stream()
                .mapToInt(Integer::valueOf) // or .map(i -> i)
                .sum();
        System.out.println(sum);

        System.out.println(packs.totalCost);
        Vector<Float> totalCostVec = new Vector<Float>();
        totalCostVec.add(packs.totalCost);
        System.out.println(totalCostVec.get(0));
        float sum = (float) totalCostVec.stream()
                .mapToDouble(Float::valueOf) // or .map(i -> i)
                .sum();
        System.out.println(sum);
    }
}
