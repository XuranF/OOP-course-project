/**
 * Set fire after bomb explosion
 */
package Main;
import Object.bomb;
import Object.*;
import java.util.*;

public class fireSet {
    Panel panel;
    public fireSet(Panel panel){
        this.panel = panel;
    }

    //the bomb will explode horizontally and vertically
    //There are four kinds of flame surrounding the core explosion
    public void addFire(bomb b){
        //core flame
        fire f1 = new fire(b.posX,b.posY);
        f1.collisionDetected = false;
        //needs to check the explosion effects
        panel.effectChecker.fireExplosionCheck(f1);
        if(!f1.collisionDetected){
            //if flame can show, then add the flame and set a timer so flame will disappear after some time
            panel.fireCopyOnWriteArrayList.add(f1);
            fireVanish(f1);
            //flame can kill entity so need to check
            panel.effectChecker.threadStopCheck(f1);
        }

        //flame to the right
        fire f2 = new fire(b.posX+Panel.tileSize,b.posY);
        //the corresponding picture is read in
        f2.rightFlameSet();
        f2.collisionDetected = false;
        panel.effectChecker.fireExplosionCheck(f2);
        if(!f2.collisionDetected){
            panel.fireCopyOnWriteArrayList.add(f2);
            fireVanish(f2);
            panel.effectChecker.threadStopCheck(f2);
        }

        //flame to the left
        fire f3 = new fire(b.posX-Panel.tileSize,b.posY);
        f3.leftFlameSet();
        f3.collisionDetected = false;
        panel.effectChecker.fireExplosionCheck(f3);
        if(!f3.collisionDetected){
            panel.fireCopyOnWriteArrayList.add(f3);
            fireVanish(f3);
            panel.effectChecker.threadStopCheck(f3);

        }

        //flame to the down
        fire f4 = new fire(b.posX,b.posY+Panel.tileSize);
        f4.downFlameSet();
        f4.collisionDetected = false;
        panel.effectChecker.fireExplosionCheck(f4);
        if(!f4.collisionDetected){
            panel.fireCopyOnWriteArrayList.add(f4);
            fireVanish(f4);
            panel.effectChecker.threadStopCheck(f4);
        }

        //flame to the up
        fire f5 = new fire(b.posX,b.posY-Panel.tileSize);
        f5.upFlameSet();
        f5.collisionDetected = false;
        panel.effectChecker.fireExplosionCheck(f5);
        if(!f5.collisionDetected){
            panel.fireCopyOnWriteArrayList.add(f5);
            fireVanish(f5);
            panel.effectChecker.threadStopCheck(f5);
        }
    }

    //a helper function helping setting timer for a flame
    private void fireVanish(fire f){
        Timer timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                panel.fireCopyOnWriteArrayList.remove(f);
            }
        },new Date(System.currentTimeMillis()+1500));
    }

}
