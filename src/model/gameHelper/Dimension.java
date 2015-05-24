package model.gameHelper;

/**
 * Created by project on 24/05/15.
 */
public class Dimension
{


    public Dimension()
    {
        this.x = this.y = 0;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    private int x;
    private int y;
}
