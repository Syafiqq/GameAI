/*
 * Created by JFormDesigner on Sat May 23 11:49:09 ICT 2015
 */

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author Muhammad Syafiq Syafiq
 */
public class GameFrame extends JFrame
{
    public GameFrame()
    {
        initComponents();
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
        scrollGame = new JScrollPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setMinimumSize(new Dimension(800, 600));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));
        contentPane.add(scrollGame, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
    private JScrollPane scrollGame;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
