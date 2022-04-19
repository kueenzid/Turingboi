package com.zhaw.thin;

public class State {
    private int currentState;
    private int read;
    private int nextState;
    private int write;
    private char movement;

    public State(int currentState, int read,  int nextState, int write, char movement) {
        this.currentState = currentState;
        this.read = read;
        this.nextState = nextState;
        this.write = write;
        this.movement = movement;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getRead() {
        return read;
    }

    public int getWrite() {
        return write;
    }

    public int getMovement() {
        return movement;
    }

    public int getNextState() {
        return nextState;
    }

    public String toString() {
        return "δ(q" + currentState + ", " + read + ") = (q" + nextState + ", " + write + ", " + movement + ")";
    }
}
