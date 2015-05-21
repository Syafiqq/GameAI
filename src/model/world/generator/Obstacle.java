package model.world.generator;

import model.world.type.BlockType;
import model.world.type.ObstacleSpread;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Project on 5/13/2015.
 */
public class Obstacle extends model.world.World
{
    private int obstacle;

    public Obstacle()
    {
    }

    private static ArrayList<BlockType> KnuthShuffle(ArrayList<BlockType> list)
    {
        Random generator = new Random();
        int length = list.size();

        while (length > 1)
        {
            int index = generator.nextInt(length--);
            BlockType type = list.get(length);
            list.set(length, list.get(index));
            list.set(index, type);
        }

        return list;
    }

    public void generateWorld(int row, int column, ObstacleSpread type, int total)
    {
        if (type == ObstacleSpread.PERCENTAGE)
        {
            total = total < 0 ? 0 : total;
            this.obstacle = (int) Math.floor(row * column * total / 100f);
        }
        else
        {
            total = total < 0 ? 0 : total > (row * column) ? (row * column) : total;
            this.obstacle = total;
        }
        generateWorld(row, column);
    }

    @Override
    public void generateWorld(int row, int column)
    {
        int size = row * column;
        ArrayList<BlockType> tile = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
        {
            tile.add(i, i < this.obstacle ? BlockType.WALL : BlockType.PLAIN);
        }

        tile = KnuthShuffle(tile);

        super.world = new ArrayList<>(row);
        for (int i = 0; i < row; ++i)
        {
            super.world.add(i, new ArrayList<>(column));
            for (int j = 0; j < column; ++j)
            {
                super.world.get(i).add(j, tile.remove(0));
            }
        }
        tile.clear();
    }
}
