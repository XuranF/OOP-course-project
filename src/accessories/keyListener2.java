package accessories;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//key listener for placing bomb
public class keyListener2 implements KeyListener {
    //the bomb dropping signal will be passed using a boolean value
    public Boolean bombDrop;

    public keyListener2(){
        bombDrop = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent){}

    //a bomb will be dropped if the keyboard input is SPACE key
    @Override
    public void keyPressed(KeyEvent keyEvent){
        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
            bombDrop = true;
    }
    @Override
    public void keyReleased(KeyEvent keyEvent){
        bombDrop = false;
    }
}
