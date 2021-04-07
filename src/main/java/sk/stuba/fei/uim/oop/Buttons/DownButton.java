package sk.stuba.fei.uim.oop.Buttons;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownButton extends JButton implements ActionListener {

    public JButton DownButton() {
        JButton downButton = new JButton("↓");
        downButton.addActionListener(this);
        return downButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("↓")) {

        }
    }

}