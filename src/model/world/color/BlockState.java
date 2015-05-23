package model.world.color;

import java.awt.Color;

/**
 * Created by MuhammadSyafiq on 5/23/2015.
 */
public class BlockState
{
    public static Color getColor(model.world.type.BlockState state)
    {
        switch (state)
        {
            case CHECKED:
            {
                return Color.LIGHT_GRAY;
            }
            case TRANSVERSED:
            {
                return Color.GRAY;
            }
            default:
            {
                return Color.WHITE;
            }
        }
    }
}
