/*
 * Created by JFormDesigner on Mon May 25 23:41:00 WIB 2015
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author Muhammad Syafiq Syafiq
 */
public class Debugger extends JFrame {
    public Debugger() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(new Font("Inconsolata", Font.PLAIN, 12));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Muhammad Syafiq Syafiq
    public JScrollPane scrollPane1;
    public JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
