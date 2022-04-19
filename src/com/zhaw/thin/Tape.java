package com.zhaw.thin;

import java.util.ArrayList;

/**
 * The tape consist of 2 arrayList. Each representing an infinite long tape in one direction.
 */
public class Tape {
    private int headPosition = 0;

    private ArrayList<Character> leftPart;
    private ArrayList<Character> rightPart;

    public Tape(String input) {
        initializeTape(input);
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public void moveHead(char side) {
        switch (side) {
            case 'R':
                headPosition++;
            case 'L':
                headPosition--;
            default:
                System.out.println("WTF");
        }
    }

    private void initializeTape(String inputs) {
        for (char input : inputs.toCharArray()) {
            rightPart.add(input);
        }
    }

    public char readSymbol() {
        if(headPosition >= 0) {
            return rightPart.get(headPosition);
        } else {
            return leftPart.get(Math.abs(headPosition));
        }
    }

    public void writeSymbol(char symbol) {
        if(headPosition >= 0) {
            rightPart.set(headPosition, symbol);
        } else {
            leftPart.set(Math.abs(headPosition), symbol);
        }
    }
}
