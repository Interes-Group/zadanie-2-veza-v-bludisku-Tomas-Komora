package sk.stuba.fei.uim.oop.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftButton extends JButton implements ActionListener {
    public JButton LeftButton(){
        JButton leftButton = new JButton("←");
        leftButton.addActionListener(this);
        return leftButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("←")){
        }
    }
}
