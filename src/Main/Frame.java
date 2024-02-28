/**
 * To create a GUI frame
 * Author: Xuran Feng
 */
package Main;
import javax.swing.*;

public class Frame extends JFrame {

    //create a game panel
    Panel gamePanel;

    public Frame(){
        this.gamePanel = new Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Bomberman Game");
        this.add(gamePanel);
        this.pack();
        //the screen will appear in the middle of screen
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //game starts when panel thread starts running
    public void gameStart(){
        gamePanel.threadStart();
    }
}
