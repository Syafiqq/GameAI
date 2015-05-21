package model.world;

import model.world.type.BlockType;

import java.util.ArrayList;

/**
 * Created by Project on 5/14/2015.
 */
public abstract class World
{
    protected ArrayList<ArrayList<BlockType>> world;

    abstract public void generateWorld(int x, int y);

    public ArrayList<ArrayList<BlockType>> getWorld()
    {
        return this.world;
    }
}
