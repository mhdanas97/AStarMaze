package com.company;

public class Maze {
    /*
         0 = Not Visited Cell
       1 = Wall
       2 = Visited Cell
       9 = Target Cell
    */
    public static int[][] arr = new int[][]
            {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    public static void main(String[] args) {
        //Write your code here!
        Cell endCell = AStar.getPathAStar(arr, 1, 1, 0);
        if (endCell != null) {
            System.out.println("End cell is " + endCell);
            Cell temp = endCell;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.parent;
            }
        } else {
            System.out.println("No path found");
        }
    }
}
