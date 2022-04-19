package com.zhaw.thin;

import java.util.ArrayList;

public class TuringMachine {
    private int currentState = 0;
    private ArrayList<State> states;
    private Tape tape;

    public TuringMachine(String stateConfigs) {
        states = new ArrayList<>();
        createStates(stateConfigs);
    }

    public void run(String input) {
        tape = new Tape(input);

        //TODO
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
}
