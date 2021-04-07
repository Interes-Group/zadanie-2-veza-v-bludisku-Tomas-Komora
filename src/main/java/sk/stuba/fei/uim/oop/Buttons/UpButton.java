package sk.stuba.fei.uim.oop.Buttons;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpButton extends JButton implements ActionListener {
    public JButton UpButton(){
        JButton upButton = new JButton("↑");
        upButton.addActionListener(this);
        return upButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("↑")){
        }
    }
}
