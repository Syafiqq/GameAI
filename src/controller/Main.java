package controller;

import model.world.World;
import model.world.generator.Obstacle;
import model.world.type.BlockType;
import model.world.type.ObstacleSpread;

import java.util.ArrayList;

/**
 * Created by Project on 5/14/2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        Obstacle a = new Obstacle();
        a.generateWorld(5, 5, ObstacleSpread.TOTAL, 20);
        printWorld(a);

    }

    public static void printWorld(World world)
    {
        ArrayList<ArrayList<BlockType>> dimension = world.getWorld();
        for (ArrayList<BlockType> row : dimension)
        {
            for (BlockType column : row)
            {
                char tile;
                switch (column)
                {
                    case PLAIN:
                    {
                        tile = 'O';
                        break;
                    }
                    case WALL:
                    {
                        tile = 'X';
                        break;
                    }
                    case START:
                    {
                        tile = 'S';
                        break;
                    }
                    case FINISH:
                    {
                        tile = 'F';
                        break;
                    }
                    default:
                    {
                        tile = '-';
                        break;
                    }
                }
                System.out.printf("%c", tile);
            }
            System.out.printf("\n");
        }
    }
}
