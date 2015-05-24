/*
 * Created by JFormDesigner on Sat May 23 12:38:29 ICT 2015
 */

package view;

import controller.Main;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.world.type.BlockPion;
import model.world.type.BlockType;

/**
 * @author Muhammad Syafiq Syafiq
 */
public class Tile extends JPanel
{
    private model.world.type.BlockPion pion;
    private model.world.type.BlockType type;
    private model.world.type.BlockState state;
    private int id;

    public Tile(GameBoard parent, int id)
    {
        initComponents();
        this.id = id;
        this.type = null;
        this.pion = null;
        this.state = null;
        this.setSize(parent.getTileSize(), parent.getTileSize());
        this.setPreferredSize(this.getSize());
        this.setBackground(model.world.color.BlockType.getColor(null));
    }

    public Tile(model.world.type.BlockType type, GameBoard parent, int id)
    {
        initComponents();
        this.id = id;
        this.type = type;
        this.pion = null;
        this.state = null;
        this.setSize(parent.getTileSize(), parent.getTileSize());
        this.setPreferredSize(this.getSize());
        this.setBackground(model.world.color.BlockType.getColor(type));
    }

    public void setBlockTypeState(model.world.type.BlockType state)
    {
        this.type = state;
        this.setBackground(model.world.color.BlockType.getColor(type));
    }

    public int getId()
    {
        return this.id;
    }

    private void setColor()
    {
        if (this.pion != null)
        {
            this.setBackground(model.world.color.BlockPion.getColor(this.pion));
        }
        else if (this.state != null)
        {
            this.setBackground(model.world.color.BlockState.getColor(this.state));
        }
        else
        {
            this.setBackground(model.world.color.BlockType.getColor(this.type));
        }
    }

    private void thisMouseClicked(MouseEvent e)
    {
        System.out.println(whoIsLeft(Main.dimension, this.id));
        System.out.println(whoIsRight(Main.dimension, this.id));
/*        switch (Main.state)
        {
            case PLACEPION:
            {
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    if (this.type == BlockType.PLAIN && this.pion == null)
                    {
                        if (Main.pionCounter == 3 || Main.pionCounter == 1)
                        {
                            this.pion = BlockPion.START;
                            this.setColor();
                            Main.pionCounter -= 1;
                            Main.rootID = this.id;
                        }
                        else if (Main.pionCounter == 2)
                        {
                            this.pion = BlockPion.FINISH;
                            this.setColor();
                            Main.pionCounter -= 2;
                        }
                    }
                }
                else
                {
                    if (this.pion == BlockPion.START)
                    {
                        this.pion = null;
                        this.setColor();
                        Main.pionCounter += 1;
                        Main.rootID = -1;
                    }
                    else if (this.pion == BlockPion.FINISH)
                    {
                        this.pion = null;
                        this.setColor();
                        Main.pionCounter += 2;
                    }
                }
                break;
            }
            case PROGRESS:
            {
                break;
            }
            case FINISH:
            {
                break;
            }
        }*/
    }

    public static int whoIsLeft(model.gameHelper.Dimension dimension, int nodeID)
    {
        if(nodeID % dimension.getX() == 0)
        {
            return -1;
        }
        else
        {
            return nodeID - 1;
        }
    }

    public static int whoIsRight(model.gameHelper.Dimension dimension, int nodeID)
    {
        if((nodeID + 1) % dimension.getX() == 0 )
        {
            return -1;
        }
        else
        {
            return nodeID + 1;
        }
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq

        //======== this ========
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                thisMouseClicked(e);
            }
        });

        // JFormDesigner evaluation mark
/*
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener()
                {public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName())
                )throw new RuntimeException();}});
*/

        setLayout(null);

        setPreferredSize(new Dimension(30, 30));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

