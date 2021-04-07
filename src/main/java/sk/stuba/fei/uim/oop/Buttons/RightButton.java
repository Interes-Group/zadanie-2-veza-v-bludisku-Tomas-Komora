package sk.stuba.fei.uim.oop.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightButton extends JFrame implements ActionListener {
    public JButton rightButton(){
        JButton generate = new JButton("→");
        generate.addActionListener(this);
        return generate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("→")){
        }
    }
}
