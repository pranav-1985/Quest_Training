package com.quest.practice_vars;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchFinally {

    public static void main(String[] args) {
        try {
            divideNum();
            accessArray();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("Exception handling complete.");
        }
    }

    public static void divideNum() throws ArithmeticException, InputMismatchException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        try {
            int result = num1 / num2;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error: Division by zero.");

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error: Input mismatch.");

        } finally {
            System.out.println("divison complete");
        }
    }

    public static void accessArray() throws InputMismatchException, ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.print("Enter an index: ");
        int i = scanner.nextInt();

        try {
            System.out.println("Array element at index " + i + ": " + numbers[i]);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Invalid array index.");

        } catch (NullPointerException e) {
            throw new NullPointerException("null value.");

        } finally {
            System.out.println("array accessed");
        }
    }

}

