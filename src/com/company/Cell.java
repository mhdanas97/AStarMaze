package com.company;

public class Cell {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final int x;
    private final int y;
    private final int cost;
    private final Cell parent;

    public int getCost() {
        return cost;
    }

    public Cell(int x, int y, Cell parent) {
        this.x = x;
        this.y = y;
        this.cost = 0;
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

    public void printPath() {
        if (this.parent != null)
            this.parent.printPath();
        System.out.println(this);
    }
}