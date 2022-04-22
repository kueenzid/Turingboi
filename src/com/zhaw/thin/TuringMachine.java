package com.zhaw.thin;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

public class TuringMachine {
    private int currentState = 1;
    private int acceptedState = 2;
    private ArrayList<State> states;
    private Tape tape;
    private boolean stuck = false;

    public TuringMachine(String stateConfigs, int startState, int acceptedState) throws InvalidPropertiesFormatException {
        states = new ArrayList<>();
        this.currentState = startState;
        this.acceptedState = acceptedState;
        createStates(stateConfigs);
        printStates();
    }

    public void run(String input, boolean steps) {
        tape = new Tape(input);
        System.out.println("Start configuration:");
        System.out.println(this);
        while(!stuck) {
            transition(steps);
        }
        System.out.println("Final Result:");
        System.out.println(this);
        if(currentState == acceptedState) {
            System.out.println("Accepted status with result: " + tape.count0() + "!");
        } else {
            System.out.println("Not accepted status!");
        }
    }

    private void transition(boolean steps) {
        boolean foundState = false;
        for (State state : states) {
            if(state.getCurrentState() == currentState && tape.readSymbol() == state.getRead()) {
                foundState = true;
                applyState(state);
                if(steps) {
                    System.out.println("Using: " + state + "\n");
                    System.out.println(this);
                }
            }
        }
        if(!foundState) {
            stuck = true;
        }
    }

    private void applyState(State state) {
        currentState = state.getNextState();
        tape.writeSymbol(state.getWrite());
        tape.moveHead(state.getMovement());
    }

    private void createStates(String stateConfigs) throws InvalidPropertiesFormatException {
        String[] configs = stateConfigs.split("1");
        for (int i = 0; i < configs.length; i+=6) {
            int currentStateConfig = parseStateToInt(configs[i]);
            char readConfig = parseNumberToChar(configs[i+1]);
            int nextStateConfig = parseStateToInt(configs[i+2]);
            char writeConfig = parseNumberToChar(configs[i+3]);
            char movement = parseMovementToChar(configs[i+4]);
            states.add(new State(currentStateConfig, readConfig, nextStateConfig, writeConfig, movement));
        }
    }

    private int parseStateToInt(String input) {
        return input.length();
    }

    private char parseNumberToChar(String input) throws InvalidPropertiesFormatException {
        switch (input.length()){
            case 1:
                return '0';
            case 2:
                return '1';
            case 3:
                return '␣';
            case 4:
                return 'X';
            case 5:
                return 'Y';
            case 6:
                return 'Z';
            case 7:
                return 'A';
            case 8:
                return 'B';
            case 9:
                return 'C';
            default:
                throw new InvalidPropertiesFormatException("How many symbol do you need?!");
        }
    }

    private char parseMovementToChar(String input) {
        switch (input.length()) {
            case 1:
                return 'L';
            case 2:
                return 'R';
            default:
                System.out.println("WTF");
                return 'X';
        }
    }

    @Override
    public String toString() {
        return "Current state is q" + currentState + "\n" + tape.toString() + "\n";
    }

    private void printStates() {
        System.out.println("Turing machine has " + states.size() + " states!");
        for (State state : states) {
            System.out.println(state.toString());
        }
    }
}
