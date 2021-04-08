package sk.stuba.fei.uim.oop.Buttons;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpButton extends JButton implements ActionListener {
    private int[][]mazeA;
    public JButton UpButton(int [][]maze){
        mazeA=maze;
        JButton upButton = new JButton("↑");
        upButton.addActionListener(this);
        return upButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positionX=0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeA[x][y]==3)
                    positionX= x;
            }
        }
        int positionY = 0;
        for(int x=0;x<13;x++){
            for(int y=0;y<13;y++){
                if(mazeA[x][y]==3)
                    positionY= y;
            }
        }
        if (e.getActionCommand().equals("↑")) {
            if (positionY - 1 > 0) {
                if (mazeA[positionX - 1][positionY] == 1) {
                    mazeA[positionX][positionY] = 1;
                    mazeA[positionX - 1][positionY] = 3;

                }
                repaint();
            }
        }
    }
}
