package model.world.generator;

import model.world.World;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Project on 5/13/2015.
 */
public class Maze extends World
{
    private int x;
    private int y;

    public Maze()
    {
    }

    private static boolean between(int v, int upper)
    {
        return (v >= 0) && (v < upper);
    }

    @Override
    public void generateWorld(int row, int column)
    {
        this.x = row / 2 + 1;
        this.y = column / 2 + 1;

        char maze[][] = new char[row][column];
        maze = this.generateMaze(maze, 0, 0);
        this.generateWorld(maze);
    }

    private void generateWorld(char[][] maze)
    {

    }

    private char[][] generateMaze(char[][] maze, int cx, int cy)
    {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs)
        {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0))
            {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                return generateMaze(maze, nx, ny);
            }
        }
        return maze;
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
