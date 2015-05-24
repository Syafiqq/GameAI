package model.world.color;

import java.awt.Color;

/**
 * Created by MuhammadSyafiq on 5/24/2015.
 */
public class BlockPion
{
    public static Color getColor(model.world.type.BlockPion state)
    {
        switch (state)
        {
            case START:
            {
                return Color.RED;
            }
            case FINISH:
            {
                return Color.BLUE;
            }
            default:
            {
                return Color.WHITE;
            }
        }
    }
}
