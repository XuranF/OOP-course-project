package accessories;

import Roles.Direction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//key listeners for player's movement including up, down, left and right
public class keyListener1 implements KeyListener {

    //dir variable value is linked to player's direction
    public Direction dir;

    public keyListener1(){
        dir = null;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent){}

    //if the keyboard input is UP key, player's direction is set to up, etc...
    @Override
    public void keyPressed(KeyEvent keyEvent){
        int keyInput = keyEvent.getKeyCode();
        if(keyInput == KeyEvent.VK_W){ dir = Direction.UP; }
        else if(keyInput == KeyEvent.VK_S){ dir = Direction.DOWN; }
        else if(keyInput == KeyEvent.VK_A){ dir = Direction.LEFT; }
        else if(keyInput == KeyEvent.VK_D){ dir = Direction.RIGHT; }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent){
        dir = null;
    }

}
