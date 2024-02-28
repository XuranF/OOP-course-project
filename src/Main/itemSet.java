/**
 * Set random item after explosion and interacting with entities
 */
package Main;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Object.*;
import Roles.Player;
import Roles.Role;

public class itemSet {
    Panel panel;
    Random rd;
    public itemSet(Panel panel){
        this.panel = panel;
        rd = new Random();
    }

    //generate a random number between 1 and 10, and set 30% possibility a speedUp props will appear
    public void addItemRandomly(int posX, int posY){
        if(rd.nextInt(9)+1<=5) panel.itemsCopyOnWriteArrayList.add(new speedUp(posX, posY));
    }

    //when entities interact with props
    public void interact(items i, Role role){
        //speedUp props will increase entity's speed by 1
        if(i instanceof speedUp) {
            role.speed += 1;
            //'Speed up' message will only display when player interacts with props
            if(role instanceof Player )
                panel.ui.showMessage("Now speeding up!");
            //set an effect timer for props and reset entity's speed
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    panel.ui.closeMessage();
                    role.speed = 2;
                }
            },new Date(System.currentTimeMillis()+7000));
        }

    }

}
