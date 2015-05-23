/*
 * Created by JFormDesigner on Sat May 23 12:38:29 ICT 2015
 */

package view;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * @author Muhammad Syafiq Syafiq
 */
public class Tile extends JPanel
{
    private model.world.type.BlockType type;
    private model.world.type.BlockState state;

    public Tile(GameBoard parent)
    {
        initComponents();
        this.setSize(parent.getTileSize(), parent.getTileSize());
        this.setPreferredSize(this.getSize());
        this.setBackground(model.world.color.BlockType.getColor(null));
    }

    public Tile(model.world.type.BlockType type, GameBoard parent)
    {
        initComponents();
        this.setSize(parent.getTileSize(), parent.getTileSize());
        this.setPreferredSize(this.getSize());
        this.setBackground(model.world.color.BlockType.getColor(type));
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent e)
            {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(null);

        setPreferredSize(new Dimension(30, 30));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

