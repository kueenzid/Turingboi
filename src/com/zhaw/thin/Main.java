package com.zhaw.thin;

import java.util.Scanner;

public class Main {
    // Multiplication turing machine with input 2*2
    // 1010100100010011010010000000000010010110010100101001100100100000000000010010011000000000000101000010010011000000000000100010000000010001011000010100001010011000010001000001000100110000010100000101001100000100010000001010110000001010000001010110000001000100000001000101100000001010000000101011000000010010000000000001010011000000001010000000010101100000000100100000000010010110000000001010000000001010110000000001000101000100110000000000101000000000010101100000000001001000000000001001001100000000000100010001000100110001001000100010011000101000100010011100100
    public static void main(String[] args) {
        int choice;
        String binaryInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input type:\n1: Binary\n2: Decimal");
        choice = scanner.nextInt();

        switch (choice){
            case 1 -> {
                System.out.println("Enter your input: ");
                binaryInput = scanner.next();
                System.out.println(binaryInput);
            }
            case 2 -> {
                System.out.println("Enter your input: ");
                binaryInput = scanner.nextBigInteger().toString(2);
                System.out.println(binaryInput);
            }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        String[] parts = binaryInput.split("111", 2);
        String coding = parts[0];
        if(parts.length > 1){
            String word = parts[1];
            System.out.println(coding + " / " + word);
            TuringMachine turingMachine = new TuringMachine(coding.substring(1), 1, 2);
            System.out.println("Choose mode:\n1: Stepmode\n2: Runmode");
            choice = scanner.nextInt();
            turingMachine.run(word, choice == 1);
        }
    }
}
