package sk.stuba.fei.uim.oop.Buttons;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButton extends JButton implements ActionListener {

    public GenerateButton(){
        super("Generate");
        addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Generate")){

        }

        }
}

