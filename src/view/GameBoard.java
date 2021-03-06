/*
 * Created by JFormDesigner on Sat May 23 12:15:32 ICT 2015
 */

package view;

import controller.Main;
import java.awt.Dimension;
import javax.swing.JPanel;
import model.gameHelper.GameState;

/**
 * @author Muhammad Syafiq Syafiq
 */
public class GameBoard extends JPanel
{
    private int tileSize;

    public GameBoard()
    {
        Main.state = GameState.PLACEPION;
        this.tileSize = 25;
        initComponents();
    }

    public GameBoard(int tileSize)
    {
        Main.state = GameState.PLACEPION;
        this.tileSize = tileSize;
        initComponents();
    }

    public int getTileSize()
    {
        return this.tileSize;
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq

        //======== this ========

        // JFormDesigner evaluation mark
/*
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
*/

        setLayout(null);

        setPreferredSize(new Dimension(400, 300));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
