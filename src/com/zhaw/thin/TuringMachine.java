package com.zhaw.thin;

import java.util.ArrayList;

public class TuringMachine {
    private int currentState = 1;
    private ArrayList<State> states;
    private Tape tape;
    private boolean stuck = false;

    public TuringMachine(String stateConfigs) {
        states = new ArrayList<>();
        createStates(stateConfigs);
        printStates();
    }

    public void run(String input, boolean steps) {
        tape = new Tape(input);
        System.out.println(this);
        transition(steps);
        if(currentState == 2) {
            System.out.println("Accepted status!");
        } else {
            System.out.println("Not accepted status!");
        }
    }

    private void transition(boolean steps) {
        for (State state : states) {
            if(state.getCurrentState() == currentState && tape.readSymbol() == state.getRead()) {
                applyState(state);
                if(steps) {
                    System.out.println(this);
                }
                transition(steps);
                return;
            }
        }
        stuck = true;
    }

    private void applyState(State state) {
        currentState = state.getNextState();
        tape.writeSymbol(state.getWrite());
        tape.moveHead(state.getMovement());
    }

    private void createStates(String stateConfigs) {
        String[] configs = stateConfigs.split("1");
        for (int i = 0; i < configs.length; i+=6) {
            int currentStateConfig = parseStateToInt(configs[i]);
            int readConfig = parseNumberToInt(configs[i+1]);
            int nextStateConfig = parseStateToInt(configs[i+2]);
            int writeConfig = parseNumberToInt(configs[i+3]);
            char movement = parseMovementToChar(configs[i+4]);
            states.add(new State(currentStateConfig, readConfig, nextStateConfig, writeConfig, movement));
        }
    }

    private int parseStateToInt(String input) {
        return input.length();
    }

    private int parseNumberToInt(String input) {
        return input.length() - 1;
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
        return "Current state is q" + currentState + "\n" + tape.toString();
    }

    private void printStates() {
        System.out.println("Turing machine has " + states.size() + " states!");
        for (State state : states) {
            System.out.println(state.toString());
        }
    }
}
