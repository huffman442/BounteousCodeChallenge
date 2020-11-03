package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String []args){
        int error = 0;

        List<Integer> intList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            try {
                int currentNum = Integer.parseInt(in.nextLine());
                if(currentNum >= 0) {
                    intList.add(currentNum);
                } else {
                    error++;
                }
            }
            catch(Exception e) {
                error++;
            }
        }
        in.close();
        avgCalc calc = new avgCalc(intList);
        printResults(calc, error);
    }

    private static void printResults(avgCalc calculator, int err){
        System.out.println("Count: " + calculator.getCount());
        System.out.println("Min: " + (calculator.getIsEmpty() ? "n/a" : calculator.getMin()));
        System.out.println("Max: " + (calculator.getIsEmpty() ? "n/a" : calculator.getMax()));
        System.out.println("Mean: " + (calculator.getIsEmpty() ? "n/a" : calculator.getMean()));
        System.out.println("Median: " + (calculator.getIsEmpty() ? "n/a" : calculator.getMedian()));
        System.out.println("Errors: " + err);
    }
}
