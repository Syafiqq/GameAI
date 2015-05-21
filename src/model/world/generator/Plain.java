package model.world.generator;

import model.world.type.BlockType;

import java.util.ArrayList;

/**
 * Created by Project on 5/13/2015.
 */
public class Plain extends model.world.World
{
    public Plain()
    {

    }

    @Override
    public void generateWorld(int row, int column)
    {
        super.world = new ArrayList<>(row);
        for (int i = 0; i < row; ++i)
        {
            super.world.add(i, new ArrayList<>(column));
            for (int j = 0; j < column; ++j)
            {
                super.world.get(i).add(j, BlockType.PLAIN);
            }
        }
    }
}
