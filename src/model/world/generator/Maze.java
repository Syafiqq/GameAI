package model.world.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import model.world.World;
import model.world.type.BlockType;

/**
 * Created by Project on 5/13/2015.
 */
public class Maze extends World
{
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
        row = row / 2 + 1;
        column = column / 2 + 1;

        char maze[][] = new char[row][column];
        maze = this.generateMaze(maze, 0, 0);
        this.generateWorld(maze);
    }

    private void generateWorld(char[][] maze)
    {
        super.world = new ArrayList<>(maze[0].length * 2 + 1);
        for (int i = 0; i < maze[0].length; i++)
        {
            super.world.add(i * 2 + 0, new ArrayList<>(maze.length * 2 + 1));
            super.world.add(i * 2 + 1, new ArrayList<>(maze.length * 2 + 1));
            for (int j = 0; j < maze.length; j++)
            {
                if ((maze[j][i] & 1) == 0)
                {
                    super.world.get(i * 2 + 0).add(j * 2 + 0, BlockType.WALL);//[i * 2 + 0][j * 2 + 0] = false;
                    super.world.get(i * 2 + 0).add(j * 2 + 1, BlockType.WALL);//[i * 2 + 0][j * 2 + 1] = false;
                }
                else
                {
                    super.world.get(i * 2 + 0).add(j * 2 + 0, BlockType.WALL);//[i * 2 + 0][j * 2 + 0] = false;
                    super.world.get(i * 2 + 0).add(j * 2 + 1, BlockType.PLAIN);//[i * 2 + 0][j * 2 + 1] = true;
                }
            }
            super.world.get(i * 2 + 0).add(maze.length * 2 + 0, BlockType.WALL);//[i * 2 + 0][x * 2 + 0] = false;
            for (int j = 0; j < maze.length; j++)
            {
                if ((maze[j][i] & 8) == 0)
                {
                    super.world.get(i * 2 + 1).add(j * 2 + 0, BlockType.WALL);//[i * 2 + 1][j * 2 + 0] = false;
                    super.world.get(i * 2 + 1).add(j * 2 + 1, BlockType.PLAIN);//[i * 2 + 1][j * 2 + 1] = true;
                }
                else
                {
                    super.world.get(i * 2 + 1).add(j * 2 + 0, BlockType.PLAIN);//[i * 2 + 1][j * 2 + 0] = true;
                    super.world.get(i * 2 + 1).add(j * 2 + 1, BlockType.PLAIN);//[i * 2 + 1][j * 2 + 1] = true;
                }
            }
            super.world.get(i * 2 + 1).add(maze.length * 2 + 0, BlockType.WALL);//[i * 2 + 1][x * 2 + 0] = false;
        }
        super.world.add(maze[0].length * 2 + 0, new ArrayList<>(maze.length * 2 + 1));
        for (int j = 0; j < maze.length; j++)
        {
            super.world.get(maze[0].length * 2 + 0).add(j * 2 + 0, BlockType.WALL);//[y * 2 + 0][j * 2 + 0] = false;
            super.world.get(maze[0].length * 2 + 0).add(j * 2 + 0, BlockType.WALL);//[y * 2 + 0][j * 2 + 1] = false;
        }
        super.world.get(maze[0].length * 2 + 0).add(maze.length * 2 + 0, BlockType.WALL);//[y * 2 + 0][x * 2 + 0] =
        // false;
    }

    private char[][] generateMaze(char[][] maze, int cx, int cy)
    {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs)
        {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, maze.length) && between(ny, maze[0].length) && (maze[nx][ny] == 0))
            {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(maze, nx, ny);
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
