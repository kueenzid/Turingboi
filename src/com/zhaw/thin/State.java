package com.zhaw.thin;

public class State {
    private int currentState;
    private char read;
    private int nextState;
    private char write;
    private char movement;

    public State(int currentState, char read,  int nextState, char write, char movement) {
        this.currentState = currentState;
        this.read = read;
        this.nextState = nextState;
        this.write = write;
        this.movement = movement;
    }

    public int getCurrentState() {
        return currentState;
    }

    public char getRead() {
        return read;
    }

    public char getWrite() {
        return write;
    }

    public char getMovement() {
        return movement;
    }

    public int getNextState() {
        return nextState;
    }

    public String toString() {
        return "δ(q" + currentState + ", " + read + ") = (q" + nextState + ", " + write + ", " + movement + ")";
    }
}
