package dump;

/**
 * Created by Project on 5/15/2015.
 */

import java.util.Arrays;
import java.util.Collections;

/*
 * recursive backtracking algorithm
 * shamelessly borrowed from the ruby at
 * http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
 */
public class Maze
{
    public static String string = "";
    private final int x;
    private final int y;
    private final int[][] maze;
    private boolean[][] maze1;

    public Maze(int x, int y)
    {
        this.x = x / 2 + 1;
        this.y = y / 2 + 1;
        maze = new int[this.x][this.y];
        maze1 = new boolean[this.y * 2 + 1][this.y * 2 + 1];
        generateMazes(0, 0);
    }

    private static boolean between(int v, int upper)
    {
        return (v >= 0) && (v < upper);
    }

    public static boolean[][] generateMaze(int row)
    {
        Maze maze = new Maze(row, row);
        maze.display();
        maze.display1();
        return maze.getmaze();
    }

    public static void main(String[] args)
    {
        Maze a = new Maze(7, 7);
        a.display1();
        boolean[][] tmp = a.getmaze();
        for (boolean[] tmp11 : tmp)
        {
            for (boolean tmp22 : tmp11)
            {
                System.out.printf("%c", tmp22 ? ' ' : 'X');
            }
            System.out.printf("\n");
        }
    }

    private void display()
    {
        for (int i = 0; i < y; i++)
        {
            // draw the north edge
            for (int j = 0; j < x; j++)
            {
                string += ((maze[j][i] & 1) == 0 ? "+---" : "+   ");
            }
            string += ("+") + "\n";
            // draw the west edge
            for (int j = 0; j < x; j++)
            {
                if (i == 0 && j == 0)
                {
                    string += "| O ";
                }
                else
                {
                    string += ((maze[j][i] & 8) == 0 ? "|   " : "    ");
                }
            }
            string += ("|") + "\n";
        }
        // draw the bottom line
        for (int j = 0; j < x; j++)
        {
            string += ("+---");
        }
        string += ("+");
    }

    private void display1()
    {
        //System.out.println(this.maze1.length + " " + this.maze1[0].length);
        for (int i = 0; i < y; i++)
        {
            // draw the north edge
            for (int j = 0; j < x; j++)
            {
                //System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
                if ((maze[j][i] & 1) == 0)
                {
                    //System.out.println((i*2+0) + " " + (j*2+0)+ " " + (j*2+1));
                    maze1[i * 2 + 0][j * 2 + 0] = false;
                    maze1[i * 2 + 0][j * 2 + 1] = false;
                }
                else
                {
                    maze1[i * 2 + 0][j * 2 + 0] = false;
                    maze1[i * 2 + 0][j * 2 + 1] = true;
                }
                //System.out.print((maze[j][i] & 1) == 0 ? "I" : "O");
            }
            maze1[i * 2 + 0][x * 2] = false;
            //System.out.println("+");
            // draw the west edge
            for (int j = 0; j < x; j++)
            {
                //System.out.print((maze[j][i] & 8) == 0 ? "I" : "O");
                if ((maze[j][i] & 8) == 0)
                {
                    maze1[i * 2 + 1][j * 2 + 0] = false;
                    maze1[i * 2 + 1][j * 2 + 1] = true;
                }
                else
                {
                    maze1[i * 2 + 1][j * 2 + 0] = true;
                    maze1[i * 2 + 1][j * 2 + 1] = true;
                }

            }
            maze1[i * 2 + 1][x * 2] = false;
            //System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++)
        {
            maze1[y * 2][j * 2 + 0] = false;
            maze1[y * 2][j * 2 + 1] = false;
            //System.out.print("+---");
        }
        maze1[y * 2][x * 2] = false;
        //jjSystem.out.println("X");
    }

    private void generateMazes(int cx, int cy)
    {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs)
        {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y)
                    && (maze[nx][ny] == 0))
            {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMazes(nx, ny);
            }
        }
    }

    private boolean[][] getmaze()
    {
        return this.maze1;
    }

    private int[][] getmaze1()
    {
        return this.maze;
    }

    private enum DIR
    {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);

        // use the static initializer to resolve forward references
        static
        {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        DIR(int bit, int dx, int dy)
        {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    }

}