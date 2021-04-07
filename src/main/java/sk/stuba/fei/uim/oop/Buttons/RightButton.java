package sk.stuba.fei.uim.oop.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightButton extends JButton implements ActionListener {
    public JButton rightButton(){
        JButton rightButton = new JButton("→");
        rightButton.addActionListener(this);
        return rightButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("→")){
        }
    }
}
