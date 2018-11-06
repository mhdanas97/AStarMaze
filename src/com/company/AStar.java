package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class AStar {

    private static final int GOAL_X = 8;
    private static final int GOAL_Y = 11;


    private static Comparator<Cell> costComparator = new Comparator<Cell>() {

        @Override
        public int compare(Cell c1, Cell c2) {

            int distanceFromC1 = c1.getCost() + manhattanDistance(c1, new Cell(GOAL_X, GOAL_Y, null));
            int distanceFromC2 = c2.getCost() + manhattanDistance(c2, new Cell(GOAL_X, GOAL_Y, null));


            if (distanceFromC1 > distanceFromC2) return 1;

            if (distanceFromC2 > distanceFromC1) return -1;

            return 0;// Write your code here!
        }
    };

    private static int manhattanDistance(Cell c1, Cell c2) {

        return Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY());
    }


    private static Queue<Cell> pq = new PriorityQueue<>(costComparator);

    public static Cell getPathAStar(int[][] arr, int x, int y, int cost) {

        // To pop from the queue use 'pq.remove();'
        // To push into the queue use 'pq.add(cell);'

        // Write your code here!
        pq.add(new Cell(x, y, cost, null)); //Start cell

        while (!pq.isEmpty()) {
            Cell c = pq.remove();
            if (arr[c.getX()][c.getY()] == 9) return c;
            arr[c.getX()][c.getY()] = 2;
            //Add valid children
            if (isFree(c.getX() - 1, c.getY(), arr)) pq.add(new Cell(c.getX() - 1, c.getY(), c.getCost() + 1, c));
            if (isFree(c.getX() + 1, c.getY(), arr)) pq.add(new Cell(c.getX() + 1, c.getY(), c.getCost() + 1, c));
            if (isFree(c.getX(), c.getY() + 1, arr)) pq.add(new Cell(c.getX(), c.getY() + 1, c.getCost() + 1, c));
            if (isFree(c.getX(), c.getY() - 1, arr)) pq.add(new Cell(c.getX(), c.getY() - 1, c.getCost() + 1, c));

        }

        return null;
    }

    private static boolean isFree(int x, int y, int[][] arr) {

        return (x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0 || arr[x][y] == 9);
    }

}
