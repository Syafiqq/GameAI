/*
 * Created by JFormDesigner on Mon May 25 16:28:36 WIB 2015
 */

package view;

import javax.swing.event.*;
import controller.Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;
import model.gameHelper.GameState;
import model.world.generator.Maze;
import model.world.generator.Obstacle;
import model.world.generator.Plain;
import model.world.generator.WorldType;
import model.world.type.ObstacleSpread;
import org.jdesktop.swingx.*;

/**
 * @author Muhammad Syafiq Syafiq
 */
public class Controller extends JPanel {
    public Controller() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void comboBox1ActionPerformed(ActionEvent e)
    {
        switch (((JComboBox) e.getSource()).getSelectedItem().toString())
        {
            case "PLAINWORLD" :
            {
                this.plainWorldPanel.setEnabled(true);
                this.plainWorldPanel.setVisible(true);
                this.obstacleWorldPanel.setEnabled(false);
                this.obstacleWorldPanel.setVisible(false);
                this.mazeWorldPanel.setEnabled(false);
                this.mazeWorldPanel.setVisible(false);
                break;
            }
            case "OBSTACLEWORLD":
            {
                this.plainWorldPanel.setEnabled(false);
                this.plainWorldPanel.setVisible(false);
                this.obstacleWorldPanel.setEnabled(true);
                this.obstacleWorldPanel.setVisible(true);
                this.mazeWorldPanel.setEnabled(false);
                this.mazeWorldPanel.setVisible(false);
                break;
            }
            case "MAZEWORLD":
            {
                this.plainWorldPanel.setEnabled(false);
                this.plainWorldPanel.setVisible(false);
                this.obstacleWorldPanel.setEnabled(false);
                this.obstacleWorldPanel.setVisible(false);
                this.mazeWorldPanel.setEnabled(true);
                this.mazeWorldPanel.setVisible(true);
                break;
            }

        }
        this.controller.setEnabled(true);
        this.controller.setVisible(true);


    }

    private void textField1CaretUpdate(CaretEvent e) {
        if(this.textField1.getText().equalsIgnoreCase("") || this.textField2.getText().equalsIgnoreCase(""))
        {
            button1.setEnabled(false);
        }
        else
        {
            button1.setEnabled(true);
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        Plain maze = new Plain();
        int x, y;
        try
        {
            x = Integer.parseInt(this.textField1.getText());
        }
        catch (NumberFormatException ignore)
        {
            x = 5;
        }
        try
        {
            y = Integer.parseInt(this.textField2.getText());
        } catch (NumberFormatException ignore)
        {
            y = 5;
        }
        maze.generateWorld(y, x);
        Main.initGame(Main.board, maze.getWorld());
        radioButton1.setEnabled(true);
        radioButton2.setEnabled(true);
    }

    private void textField3CaretUpdate(CaretEvent e) {
        if(this.textField3.getText().equalsIgnoreCase("") || this.textField4.getText().equalsIgnoreCase("") || this.textField5.getText().equalsIgnoreCase(""))
        {
            button2.setEnabled(false);
        }
        else
        {
            button2.setEnabled(true);
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Obstacle maze = new Obstacle();
        int x, y, count;
        try
        {
            x = Integer.parseInt(this.textField3.getText());
        }
        catch (NumberFormatException ignore)
        {
            x = 5;
        }

        try
        {
            y = Integer.parseInt(this.textField4.getText());
        } catch (NumberFormatException ignore)
        {
            y = 5;
        }

        try
        {
            count = Integer.parseInt(this.textField5.getText());
        } catch (NumberFormatException ignore)
        {
            count = 50;
        }
        maze.generateWorld(y, x, this.comboBox2.getSelectedItem().toString().equalsIgnoreCase("TOTAL") ? ObstacleSpread.TOTAL : ObstacleSpread.PERCENTAGE,count);
        Main.initGame(Main.board, maze.getWorld());

        radioButton1.setEnabled(true);
        radioButton2.setEnabled(true);
    }

    private void textField6CaretUpdate(CaretEvent e) {
        // TODO add your code here
        if(this.textField6.getText().equalsIgnoreCase("") || this.textField7.getText().equalsIgnoreCase(""))
        {
            button3.setEnabled(false);
        }
        else
        {
            button3.setEnabled(true);
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Maze maze = new Maze();
        int x, y;
        try
        {
            x = Integer.parseInt(this.textField6.getText());
        }
        catch (NumberFormatException ignore)
        {
            x = 5;
        }
        try
        {
            y = Integer.parseInt(this.textField7.getText());
        } catch (NumberFormatException ignore)
        {
            y = 5;
        }
        maze.generateWorld(y, x);
        Main.initGame(Main.board, maze.getWorld());
        radioButton1.setEnabled(true);
        radioButton2.setEnabled(true);
    }

    private void radioButton1ItemStateChanged(ItemEvent e) {
        if(radioButton1.isSelected())
        {
            Main.state = GameState.PLACEOBSTACLE;
        }
        else if(radioButton2.isSelected())
        {
            Main.state = GameState.PLACEPION;
        }
    }

    private void radioButton2ItemStateChanged(ItemEvent e) {
        if(radioButton2.isSelected())
        {
            Main.state = GameState.PLACEPION;
        }
        else if(radioButton1.isSelected())
        {
            Main.state = GameState.PLACEOBSTACLE;
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        Main.state = GameState.PROGRESS;
        comboBox1.setEnabled(false);
        plainWorldPanel.setEnabled(false);
        textField1.setEnabled(false);
        textField2.setEnabled(false);
        button1.setEnabled(false);
        obstacleWorldPanel.setEnabled(false);
        textField3.setEnabled(false);
        textField4.setEnabled(false);
        comboBox2.setEnabled(false);
        textField5.setEnabled(false);
        button2.setEnabled(false);
        mazeWorldPanel.setEnabled(false);
        textField6.setEnabled(false);
        textField7.setEnabled(false);
        button3.setEnabled(false);
        controller.setEnabled(false);
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
        vSpacer1 = new JPanel(null);
        label9 = new JLabel();
        comboBox1 = new JComboBox(model.world.generator.WorldType.values());
        vSpacer2 = new JPanel(null);
        plainWorldPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        vSpacer3 = new JPanel(null);
        label2 = new JLabel();
        textField2 = new JTextField();
        vSpacer4 = new JPanel(null);
        button1 = new JButton();
        obstacleWorldPanel = new JPanel();
        label3 = new JLabel();
        textField3 = new JTextField();
        vSpacer5 = new JPanel(null);
        label4 = new JLabel();
        textField4 = new JTextField();
        vSpacer6 = new JPanel(null);
        label5 = new JLabel();
        comboBox2 = new JComboBox(model.world.type.ObstacleSpread.values());
        vSpacer7 = new JPanel(null);
        label6 = new JLabel();
        textField5 = new JTextField();
        vSpacer8 = new JPanel(null);
        button2 = new JButton();
        mazeWorldPanel = new JPanel();
        label7 = new JLabel();
        textField6 = new JTextField();
        vSpacer9 = new JPanel(null);
        label8 = new JLabel();
        textField7 = new JTextField();
        vSpacer10 = new JPanel(null);
        button3 = new JButton();
        controller = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button4 = new JButton();

        //======== this ========
        setFont(new Font("Source Code Pro", Font.PLAIN, 12));
        setMinimumSize(new Dimension(150, 350));
        setPreferredSize(new Dimension(150, 350));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new VerticalLayout(5));

        //---- vSpacer1 ----
        vSpacer1.setMinimumSize(new Dimension(15, 10));
        vSpacer1.setPreferredSize(new Dimension(15, 10));
        vSpacer1.setMaximumSize(new Dimension(15, 10));
        add(vSpacer1);

        //---- label9 ----
        label9.setText("Mode");
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        add(label9);

        //---- comboBox1 ----
        comboBox1.addActionListener(e -> comboBox1ActionPerformed(e));
        add(comboBox1);

        //---- vSpacer2 ----
        vSpacer2.setMinimumSize(new Dimension(30, 30));
        vSpacer2.setPreferredSize(new Dimension(30, 30));
        vSpacer2.setMaximumSize(new Dimension(30, 30));
        add(vSpacer2);

        //======== plainWorldPanel ========
        {
            plainWorldPanel.setEnabled(false);
            plainWorldPanel.setVisible(false);
            plainWorldPanel.setLayout(new VerticalLayout());

            //---- label1 ----
            label1.setText("Width");
            plainWorldPanel.add(label1);

            //---- textField1 ----
            textField1.addCaretListener(e -> textField1CaretUpdate(e));
            plainWorldPanel.add(textField1);

            //---- vSpacer3 ----
            vSpacer3.setMinimumSize(new Dimension(15, 10));
            vSpacer3.setPreferredSize(new Dimension(15, 10));
            vSpacer3.setMaximumSize(new Dimension(15, 10));
            plainWorldPanel.add(vSpacer3);

            //---- label2 ----
            label2.setText("Height");
            plainWorldPanel.add(label2);

            //---- textField2 ----
            textField2.addCaretListener(e -> textField1CaretUpdate(e));
            plainWorldPanel.add(textField2);

            //---- vSpacer4 ----
            vSpacer4.setMinimumSize(new Dimension(15, 10));
            vSpacer4.setPreferredSize(new Dimension(15, 10));
            vSpacer4.setMaximumSize(new Dimension(15, 10));
            plainWorldPanel.add(vSpacer4);

            //---- button1 ----
            button1.setText("Generate");
            button1.setEnabled(false);
            button1.addActionListener(e -> button1ActionPerformed(e));
            plainWorldPanel.add(button1);
        }
        add(plainWorldPanel);

        //======== obstacleWorldPanel ========
        {
            obstacleWorldPanel.setEnabled(false);
            obstacleWorldPanel.setVisible(false);
            obstacleWorldPanel.setLayout(new VerticalLayout());

            //---- label3 ----
            label3.setText("Width");
            obstacleWorldPanel.add(label3);

            //---- textField3 ----
            textField3.addCaretListener(e -> textField3CaretUpdate(e));
            obstacleWorldPanel.add(textField3);

            //---- vSpacer5 ----
            vSpacer5.setMinimumSize(new Dimension(15, 10));
            vSpacer5.setPreferredSize(new Dimension(15, 10));
            vSpacer5.setMaximumSize(new Dimension(15, 10));
            obstacleWorldPanel.add(vSpacer5);

            //---- label4 ----
            label4.setText("Height");
            obstacleWorldPanel.add(label4);

            //---- textField4 ----
            textField4.addCaretListener(e -> textField3CaretUpdate(e));
            obstacleWorldPanel.add(textField4);

            //---- vSpacer6 ----
            vSpacer6.setMinimumSize(new Dimension(15, 10));
            vSpacer6.setPreferredSize(new Dimension(15, 10));
            vSpacer6.setMaximumSize(new Dimension(15, 10));
            obstacleWorldPanel.add(vSpacer6);

            //---- label5 ----
            label5.setText("Type");
            obstacleWorldPanel.add(label5);
            obstacleWorldPanel.add(comboBox2);

            //---- vSpacer7 ----
            vSpacer7.setMinimumSize(new Dimension(15, 10));
            vSpacer7.setPreferredSize(new Dimension(15, 10));
            vSpacer7.setMaximumSize(new Dimension(15, 10));
            obstacleWorldPanel.add(vSpacer7);

            //---- label6 ----
            label6.setText("Total");
            obstacleWorldPanel.add(label6);

            //---- textField5 ----
            textField5.addCaretListener(e -> textField3CaretUpdate(e));
            obstacleWorldPanel.add(textField5);

            //---- vSpacer8 ----
            vSpacer8.setMinimumSize(new Dimension(15, 10));
            vSpacer8.setPreferredSize(new Dimension(15, 10));
            vSpacer8.setMaximumSize(new Dimension(15, 10));
            obstacleWorldPanel.add(vSpacer8);

            //---- button2 ----
            button2.setText("Generate");
            button2.addActionListener(e -> button2ActionPerformed(e));
            obstacleWorldPanel.add(button2);
        }
        add(obstacleWorldPanel);

        //======== mazeWorldPanel ========
        {
            mazeWorldPanel.setEnabled(false);
            mazeWorldPanel.setVisible(false);
            mazeWorldPanel.setLayout(new VerticalLayout());

            //---- label7 ----
            label7.setText("Width");
            mazeWorldPanel.add(label7);

            //---- textField6 ----
            textField6.addCaretListener(e -> textField6CaretUpdate(e));
            mazeWorldPanel.add(textField6);

            //---- vSpacer9 ----
            vSpacer9.setMinimumSize(new Dimension(15, 10));
            vSpacer9.setPreferredSize(new Dimension(15, 10));
            vSpacer9.setMaximumSize(new Dimension(15, 10));
            mazeWorldPanel.add(vSpacer9);

            //---- label8 ----
            label8.setText("Height");
            mazeWorldPanel.add(label8);

            //---- textField7 ----
            textField7.addCaretListener(e -> textField6CaretUpdate(e));
            mazeWorldPanel.add(textField7);

            //---- vSpacer10 ----
            vSpacer10.setMinimumSize(new Dimension(15, 10));
            vSpacer10.setPreferredSize(new Dimension(15, 10));
            vSpacer10.setMaximumSize(new Dimension(15, 10));
            mazeWorldPanel.add(vSpacer10);

            //---- button3 ----
            button3.setText("Generate");
            button3.setEnabled(false);
            button3.addActionListener(e -> button3ActionPerformed(e));
            mazeWorldPanel.add(button3);
        }
        add(mazeWorldPanel);

        //======== controller ========
        {
            controller.setEnabled(false);
            controller.setVisible(false);
            controller.setLayout(new VerticalLayout(5));

            //---- radioButton1 ----
            radioButton1.setText("<html>Change <br>Obstacle</html>");
            radioButton1.setEnabled(false);
            radioButton1.setSelected(true);
            radioButton1.addItemListener(e -> radioButton1ItemStateChanged(e));
            controller.add(radioButton1);

            //---- radioButton2 ----
            radioButton2.setText("<html>Change Start <br>Stop Position</html>");
            radioButton2.setEnabled(false);
            radioButton2.addItemListener(e -> radioButton2ItemStateChanged(e));
            controller.add(radioButton2);

            //---- button4 ----
            button4.setText("Start");
            button4.setEnabled(false);
            button4.addActionListener(e -> button4ActionPerformed(e));
            controller.add(button4);
        }
        add(controller);

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
    private JPanel vSpacer1;
    private JLabel label9;
    private JComboBox comboBox1;
    private JPanel vSpacer2;
    private JPanel plainWorldPanel;
    private JLabel label1;
    private JTextField textField1;
    private JPanel vSpacer3;
    private JLabel label2;
    private JTextField textField2;
    private JPanel vSpacer4;
    private JButton button1;
    private JPanel obstacleWorldPanel;
    private JLabel label3;
    private JTextField textField3;
    private JPanel vSpacer5;
    private JLabel label4;
    private JTextField textField4;
    private JPanel vSpacer6;
    private JLabel label5;
    private JComboBox comboBox2;
    private JPanel vSpacer7;
    private JLabel label6;
    private JTextField textField5;
    private JPanel vSpacer8;
    private JButton button2;
    private JPanel mazeWorldPanel;
    private JLabel label7;
    private JTextField textField6;
    private JPanel vSpacer9;
    private JLabel label8;
    private JTextField textField7;
    private JPanel vSpacer10;
    private JButton button3;
    private JPanel controller;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button4;

    public void enableStart()
    {
        button4.setEnabled(true);
    }

    public void disableStart()
    {
        button4.setEnabled(false);
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
