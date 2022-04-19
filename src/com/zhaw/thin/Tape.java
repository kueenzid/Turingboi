package com.zhaw.thin;

import java.util.ArrayList;

/**
 * The tape consist of 2 arrayList. Each representing an infinite long tape in one direction.
 */
public class Tape {
    private int headPosition = 0;

    private ArrayList<Integer> leftPart;
    private ArrayList<Integer> rightPart;

    public Tape(String input) {
        leftPart = new ArrayList<>();
        rightPart = new ArrayList<>();
        initializeTape(input);
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public void moveHead(char side) {
        if(side == 'R') {
            headPosition++;
        } else if(side == 'L') {

        } else {
            System.out.println("WTF");
        }
    }

    private void initializeTape(String inputs) {
        for (char input : inputs.toCharArray()) {
            rightPart.add(Character.getNumericValue(input));
        }
    }

    public int readSymbol() {
        if(headPosition >= 0) {
            return rightPart.get(headPosition);
        } else {
            return leftPart.get(Math.abs(headPosition));
        }
    }

    public void writeSymbol(int symbol) {
        if(headPosition >= 0) {
            rightPart.set(headPosition, symbol);
        } else {
            leftPart.set(Math.abs(headPosition), symbol);
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("---Tape---\n");
        string.append("Head at " + headPosition + "\n| ");
        for (int i = leftPart.size()-1; i >= 0 ; i--) {
            string.append(leftPart.get(i) + " | ");
        }
        for (int symbol : rightPart) {
            string.append(symbol + " | ");
        }
        return string.toString();
    }
}
