package accessories;

import Main.Panel;

import java.awt.*;

//To display information in text format
public class UI {

    public Main.Panel panel;
    public String message;
    public Font messageFont;

    public UI(Main.Panel panel){
        this.panel = panel;
        message = "";
        //initiate the font format
        messageFont = new Font("Arial",Font.PLAIN, 35);
    }

    //message when entity interacting with different props
    public void showMessage(String message){
        this.message = message;
    }
    public void closeMessage(){
        this.message = "";
    }

    //message when player wins or loses
    public void winMessage(){ message = "You win!"; }
    public void loseMessage(){
        message = "You are killed!";
    }

    //draw information on canvas
    public void drawImage(Graphics g){
        g.setFont(messageFont);
        g.setColor(Color.WHITE);
        g.drawString(message, Main.Panel.tileSize* Main.Panel.numberOfColumn/3, Main.Panel.tileSize* Panel.numberOfRow/2);
    }
}
