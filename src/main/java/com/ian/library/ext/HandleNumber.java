package com.ian.library.ext;

import java.util.Arrays;
import java.util.Scanner;

public class HandleNumber {

    public static void main(String[] args) {

        int[] ints = new int[10];
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("Please input 10 integers: ");
        int i = 0;
        while(sc.hasNextInt()){
            ints[i] = sc.nextInt();
            i++;
            if(i == 10){
                break;
            }
        }
        int sum = 0;
        for (int j = 0; j < ints.length; j++) {
            sum += ints[j];
        }

        Arrays.sort(ints);

        System.out.println("The total is " + sum);
        System.out.println("The average is " + sum / ints.length);
        System.out.println("The max value is " + ints[ints.length - 1]);
        System.out.println("The min value is " + ints[0]);

    }
}
