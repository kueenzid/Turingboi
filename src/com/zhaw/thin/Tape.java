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
        leftPart = new ArrayList<>();
        rightPart = new ArrayList<>();
        initializeTape(input);
    }

    public void moveHead(char side) {
        if(side == 'R') {
            headPosition++;
            addCell();
        } else if(side == 'L') {
            headPosition--;
            addCell();
        } else {
            System.out.println("WTF");
        }
    }

    private void addCell() {
        if(headPosition >= 0) {
            if(headPosition + 1 > rightPart.size()) {
                rightPart.add('␣');
            }
        } else if(headPosition < 0) {
            if(Math.abs(headPosition) > leftPart.size()) {
                leftPart.add('␣');
            }
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
            return leftPart.get(Math.abs(headPosition) - 1);
        }
    }

    public void writeSymbol(char symbol) {
        if(headPosition >= 0) {
            rightPart.set(headPosition, symbol);
        } else {
            leftPart.set(Math.abs(headPosition) - 1, symbol);
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("---Tape---\n");
        string.append("Head at " + (headPosition + 1) + "\n| ");
        for (int i = leftPart.size()-1; i >= 0 ; i--) {
            string.append(leftPart.get(i) + " | ");
        }
        for (char symbol : rightPart) {
            string.append(symbol + " | ");
        }
        return string.toString();
    }
}
