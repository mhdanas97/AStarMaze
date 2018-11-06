package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class AStar {

    public static final int GOAL_X = 8;
    public static final int GOAL_Y = 11;


    public static Comparator<Cell> costComparator = new Comparator<Cell>() {

        @Override
        public int compare(Cell c1, Cell c2) {

            int distanceFromC1 = c1.cost + manhattanDistance(c1, new Cell(GOAL_X, GOAL_Y, null));
            int distanceFromC2 = c2.cost + manhattanDistance(c2, new Cell(GOAL_X, GOAL_Y, null));


            if (distanceFromC1 > distanceFromC2) return 1;

            if (distanceFromC2 > distanceFromC1) return -1;

            return 0;// Write your code here!
        }
    };

    public static int manhattanDistance(Cell c1, Cell c2) {

        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }


    public static Queue<Cell> pq = new PriorityQueue<>(costComparator);

    public static Cell getPathAStar(int[][] arr, int x, int y, int cost) {

        // To pop from the queue use 'pq.remove();'
        // To push into the queue use 'pq.add(cell);'

        // Write your code here!
        pq.add(new Cell(x, y, cost, null)); //Start cell

        while (!pq.isEmpty()) {
            Cell c = pq.remove();
            if (arr[c.x][c.y] == 9) return c;
            arr[c.x][c.y] = 2;
            //Add valid children
            if (isFree(c.x - 1, c.y, arr)) pq.add(new Cell(c.x - 1, c.y, c.cost + 1, c));
            if (isFree(c.x + 1, c.y, arr)) pq.add(new Cell(c.x + 1, c.y, c.cost + 1, c));
            if (isFree(c.x, c.y + 1, arr)) pq.add(new Cell(c.x, c.y + 1, c.cost + 1, c));
            if (isFree(c.x, c.y - 1, arr)) pq.add(new Cell(c.x, c.y - 1, c.cost + 1, c));

        }

        return null;
    }

    public static boolean isFree(int x, int y, int[][] arr) {

        if ((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0 || arr[x][y] == 9)) {
            return true;
        }
        return false;
    }

}
