package com.jdbccom.jdbc.connection;
import java.util.*;

public class Main {

    public static int MathChallenge(int num) {
        char[] numArray = Integer.toString(num).toCharArray();

        // Find the rightmost digit that is smaller than the digit to its right
        int i = numArray.length - 2;
        while (i >= 0 && numArray[i] >= numArray[i + 1]) {
            i--;
        }

        if (i == -1) {
            // No such digit found, meaning the number is the largest possible permutation
            return -1;
        }

        // Find the smallest digit to the right of numArray[i] that is larger than numArray[i]
        int j = numArray.length - 1;
        while (numArray[j] <= numArray[i]) {
            j--;
        }

        // Swap numArray[i] and numArray[j]
        char temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;

        // Reverse the portion of the array to the right of numArray[i]
        reverse(numArray, i + 1, numArray.length - 1);

        // Convert the modified array back to an integer
        int result = Integer.parseInt(new String(numArray));

        return result;
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int inputNum = s.nextInt();

        int outputNum = MathChallenge(inputNum);
        System.out.println("Output: " + outputNum);

        String challengeToken = "ol1mz5ebp24";
        String finalOutput = new StringBuilder(Integer.toString(outputNum)).reverse().toString() + ":" + challengeToken;
        System.out.println("Final Output: " + finalOutput);
    }
}