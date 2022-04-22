package com.zhaw.thin;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Main {
    // TODO rewrite multiplication so accepted state is at 2 and not 3
    // Multiplication turing machine with input 2*2
    // 101010001000100110100100000000000100101100010100010100110001001000000000000100100110000000000001010000100100110000000000001000100000000100010110000101000010100110000100010000010001001100000101000001010011000001000100000010101100000010100000010101100000010001000000010001011000000010100000001010110000000100100000000000010100110000000010100000000101011000000001001000000000100101100000000010100000000010101100000000010001010001001100000000001010000000000101011000000000010010000000000010010011000000000001000100100010011001001001000100110010100100010011100100
    public static void main(String[] args) throws InvalidPropertiesFormatException {
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
