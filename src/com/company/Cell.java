package com.company;

public class Cell {
    int x;
    int y;
    int cost;
    Cell parent;

    public Cell(int x, int y, Cell parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public Cell(int x, int y, int cost, Cell parent) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.parent = parent;
    }

    public Cell getParent() {
        return this.parent;
    }

    public String toString() {
        return "x = " + x + " y = " + y + " cost = " + cost;
    }
}