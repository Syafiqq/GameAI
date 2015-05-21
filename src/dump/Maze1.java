package dump;

/**
 * Created by Project on 5/15/2015.
 */

import java.util.Random;

/**
 * The Maze1 class represents a Maze1 in a rectangular grid.  There is exactly
 * one path between any two points.
 **/

public class Maze1
{

    // Constants used in depth-first search (which checks for cycles in the
    // Maze1).
    private static final int STARTHERE = 0;
    private static final int FROMLEFT = 1;
    private static final int FROMRIGHT = 2;
    private static final int FROMABOVE = 3;
    private static final int FROMBELOW = 4;
    // Object for generting random numbers.
    private static Random random;
    // Horizontal and vertical dimensions of the Maze1.
    protected int horiz;
    protected int vert;
    // Horizontal and vertical interior walls; each is true if the wall exists.
    protected boolean[][] hWalls;
    protected boolean[][] vWalls;

    /**
     * Maze1() creates a rectangular Maze1 having "horizontalSize" cells in the
     * horizontal direction, and "verticalSize" cells in the vertical direction.
     * There is a path between any two cells of the Maze1.  A disjoint set data
     * structure is used to ensure that there is only one path between any two
     * cells.
     **/
    public Maze1(int horizontalSize, int verticalSize)
    {
        int i, j;

        horiz = horizontalSize;
        vert = verticalSize;
        if ((horiz < 1) || (vert < 1) || ((horiz == 1) && (vert == 1)))
        {
            return;                                    // There are no interior walls
        }

        // Create all of the horizontal interior walls.  Initially, every
        // horizontal wall exists; they will be removed later by the Maze1
        // generation algorithm.
        if (vert > 1)
        {
            hWalls = new boolean[horiz][vert - 1];
            for (j = 0; j < vert - 1; j++)
            {
                for (i = 0; i < horiz; i++)
                {
                    hWalls[i][j] = true;
                }
            }
        }
        // Create all of the vertical interior walls.
        if (horiz > 1)
        {
            vWalls = new boolean[horiz - 1][vert];
            for (i = 0; i < horiz - 1; i++)
            {
                for (j = 0; j < vert; j++)
                {
                    vWalls[i][j] = true;
                }
            }
        }


        /**
         * Fill in the rest of this method.  You should go through all the walls of
         * the Maze1 in random order, and remove any wall whose removal will not
         * create a cycle.  Use the implementation of disjoint sets provided in the
         * set package to avoid creating any cycles.
         *
         * Note the method randInt() further below, which generates a random
         * integer.  randInt() generates different numbers every time the program
         * is run, so that you can make lots of different Maze1s.
         **/


    }

    /**
     * randInt() returns a random integer from 0 to choices - 1.
     **/
    private static int randInt(int choices)
    {
        if (random == null)
        {       // Only executed first time randInt() is called
            random = new Random();       // Create a "Random" object with random seed
        }
        int r = random.nextInt() % choices;      // From 1 - choices to choices - 1
        if (r < 0)
        {
            r = -r;                                          // From 0 to choices - 1
        }
        return r;
    }

    /**
     * main() creates a Maze1 of dimensions specified on the command line, prints
     * the Maze1, and runs the diagnostic method to see if the Maze1 is good.
     */
    public static void main(String[] args)
    {
        int x = 39;
        int y = 15;

        /**
         *  Read the input parameters.
         */

        if (args.length > 0)
        {
            try
            {
                x = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("First argument to Simulation is not an number.");
            }
        }

        if (args.length > 1)
        {
            try
            {
                y = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Second argument to Simulation is not an number.");
            }
        }

        Maze1 Maze1 = new Maze1(x, y);
        System.out.print(Maze1);
        Maze1.diagnose();
    }

    /**
     * toString() returns a string representation of the Maze1.
     **/
    public String toString()
    {
        int i, j;
        String s = "";

        // Print the top exterior wall.
        for (i = 0; i < horiz; i++)
        {
            s = s + "--";
        }
        s = s + "-\n|";

        // Print the Maze1 interior.
        for (j = 0; j < vert; j++)
        {
            // Print a row of cells and vertical walls.
            for (i = 0; i < horiz - 1; i++)
            {
                if (vWalls[i][j])
                {
                    s = s + " |";
                }
                else
                {
                    s = s + "  ";
                }
            }
            s = s + " |\n+";
            if (j < vert - 1)
            {
                // Print a row of horizontal walls and wall corners.
                for (i = 0; i < horiz; i++)
                {
                    if (hWalls[i][j])
                    {
                        s = s + "-+";
                    }
                    else
                    {
                        s = s + " +";
                    }
                }
                s = s + "\n|";
            }
        }

        // Print the bottom exterior wall.  (Note that the first corner has
        // already been printed.)
        for (i = 0; i < horiz; i++)
        {
            s = s + "--";
        }
        return s + "\n";
    }

    /**
     * horizontalWall() determines whether the horizontal wall on the bottom
     * edge of cell (x, y) exists.  If the coordinates (x, y) do not correspond
     * to an interior wall, true is returned.
     **/
    public boolean horizontalWall(int x, int y)
    {
        if ((x < 0) || (y < 0) || (x > horiz - 1) || (y > vert - 2))
        {
            return true;
        }
        return hWalls[x][y];
    }

    /**
     * verticalWall() determines whether the vertical wall on the right edge of
     * cell (x, y) exists. If the coordinates (x, y) do not correspond to an
     * interior wall, true is returned.
     **/
    public boolean verticalWall(int x, int y)
    {
        if ((x < 0) || (y < 0) || (x > horiz - 2) || (y > vert - 1))
        {
            return true;
        }
        return vWalls[x][y];
    }

    /**
     * diagnose() checks the Maze1 and prints a warning if not every cell can be
     * reached from the upper left corner cell, or if there is a cycle reachable
     * from the upper left cell.
     * <p>
     * DO NOT CHANGE THIS METHOD.  Your code is expected to work with our copy
     * of this method.
     **/
    protected void diagnose()
    {
        if ((horiz < 1) || (vert < 1) || ((horiz == 1) && (vert == 1)))
        {
            return;                                    // There are no interior walls
        }

        boolean Maze1Fine = true;

        // Create an array that indicates whether each cell has been visited during
        // a depth-first traversal.
        boolean[][] cellVisited = new boolean[horiz][vert];
        // Do a depth-first traversal.
        if (depthFirstSearch(0, 0, STARTHERE, cellVisited))
        {
            System.out.println("Your Maze1 has a cycle.");
            Maze1Fine = false;
        }

        // Check to be sure that every cell of the Maze1 was visited.
        outerLoop:
        for (int j = 0; j < vert; j++)
        {
            for (int i = 0; i < horiz; i++)
            {
                if (!cellVisited[i][j])
                {
                    System.out.println("Not every cell in your Maze1 is reachable from " +
                            "every other cell.");
                    Maze1Fine = false;
                    break outerLoop;
                }
            }
        }

        if (Maze1Fine)
        {
            System.out.println("What a fine Maze1 you've created!");
        }
    }

    /**
     * depthFirstSearch() does a depth-first traversal of the Maze1, marking each
     * visited cell.  Returns true if a cycle is found.
     * <p>
     * DO NOT CHANGE THIS METHOD.  Your code is expected to work with our copy
     * of this method.
     */
    protected boolean depthFirstSearch(int x, int y, int fromWhere,
            boolean[][] cellVisited)
    {
        boolean cycleDetected = false;
        cellVisited[x][y] = true;

        // Visit the cell to the right?
        if ((fromWhere != FROMRIGHT) && !verticalWall(x, y))
        {
            if (cellVisited[x + 1][y])
            {
                cycleDetected = true;
            }
            else
            {
                cycleDetected = depthFirstSearch(x + 1, y, FROMLEFT, cellVisited) ||
                        cycleDetected;
            }
        }

        // Visit the cell below?
        if ((fromWhere != FROMBELOW) && !horizontalWall(x, y))
        {
            if (cellVisited[x][y + 1])
            {
                cycleDetected = true;
            }
            else
            {
                cycleDetected = depthFirstSearch(x, y + 1, FROMABOVE, cellVisited) ||
                        cycleDetected;
            }
        }

        // Visit the cell to the left?
        if ((fromWhere != FROMLEFT) && !verticalWall(x - 1, y))
        {
            if (cellVisited[x - 1][y])
            {
                cycleDetected = true;
            }
            else
            {
                cycleDetected = depthFirstSearch(x - 1, y, FROMRIGHT, cellVisited) ||
                        cycleDetected;
            }
        }

        // Visit the cell above?
        if ((fromWhere != FROMABOVE) && !horizontalWall(x, y - 1))
        {
            if (cellVisited[x][y - 1])
            {
                cycleDetected = true;
            }
            else
            {
                cycleDetected = depthFirstSearch(x, y - 1, FROMBELOW, cellVisited) ||
                        cycleDetected;
            }
        }

        return cycleDetected;
    }

}