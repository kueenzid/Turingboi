package com.zhaw.thin;

import java.util.ArrayList;

/**
 * The tape consist of 2 arrayList. Each representing an infinite long tape in one direction.
 */
public class Tape {
    private int headPosition = 0;
    private int counter = 0;

    private ArrayList<Character> leftPart;
    private ArrayList<Character> rightPart;

    public Tape(String input) {
        leftPart = new ArrayList<>();
        rightPart = new ArrayList<>();
        initializeTape(input);
    }

    public void moveHead(char side) {
        counter++;
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

    public int count0() {
        int zeros = 0;
        for (char symbol : leftPart) {
            if(symbol == '0') {
                zeros++;
            }
        }
        for (char symbol : rightPart) {
            if(symbol == '0') {
                zeros++;
            }
        }
        return zeros;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Head at " + (headPosition + 1) + " with " + counter +  " movements\n| ");
        if(headPosition < 15) {
            if(headPosition < 0) {
                for (int i = 0; i < Math.abs(headPosition) + 15 - leftPart.size(); i++) {
                    string.append("␣ | ");
                }
            } else {
                for (int i = 0; i < 15 + leftPart.size() - headPosition; i++) {
                    string.append("␣ | ");
                }
            }
        }
        for (int i = leftPart.size()-1; i >= 0 ; i--) {
            string.append(leftPart.get(i) + " | ");
        }
        for (char symbol : rightPart) {
            string.append(symbol + " | ");
        }
        if(headPosition >= 0) {
            for (int i = 0; i < headPosition + 15 - (rightPart.size() - 1); i++) {
                string.append("␣ | ");
            }
        }
        return string.toString();
    }
}
