package com.zhaw.thin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        long input;
        String binaryInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input type:\n1: Binary\n2: Decimal");
        choice = scanner.nextInt();

        switch (choice){
            case 1 -> {
                System.out.println("Enter your input: ");
                binaryInput = Long.toString(scanner.nextLong());
                System.out.println(binaryInput);
            }
            case 2 -> {
                System.out.println("Enter your input: ");
                binaryInput = Long.toBinaryString(scanner.nextLong());
                System.out.println(binaryInput);
            }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        String[] parts = binaryInput.split("111");
        String coding = parts[0];
        if(parts.length > 1){
            String word = parts[1];
            System.out.println(coding + " / " + word);
        }
    }
}
