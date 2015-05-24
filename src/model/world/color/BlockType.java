package model.world.color;

import java.awt.Color;

/**
 * Created by MuhammadSyafiq on 5/23/2015.
 */
public class BlockType
{
    public static Color getColor(model.world.type.BlockType type)
    {
        switch (type)
        {
            case PLAIN:
            {
                return Color.WHITE;
            }
            case WALL:
            {
                return Color.BLACK;
            }
            default:
            {
                return Color.WHITE;
            }
        }
    }
}
