package Main;
import Object.bomb;
import Roles.*;
import java.util.*;

public class bombSet {

    Panel panel;
    public bombSet(Panel panel){
        this.panel = panel;
    }

    public void addBomb(Role role){
        //player only drops bomb when keyboard inputs detected but enemyAI will automatically drop bombs
        if(panel.listener2.bombDrop || role instanceof enemyAI){
            int roleLeftX = role.posX;
            int roleRightX = roleLeftX+Panel.tileSize;
            int roleTopY = role.posY;
            int roleBottomY = roleTopY+Panel.tileSize;

            int roleLeftCol = roleLeftX/Panel.tileSize;
            int roleRightCol = roleRightX/Panel.tileSize;
            int roleTopRow = roleTopY/Panel.tileSize;
            int roleBottomRow = roleBottomY/Panel.tileSize;

            //drops bomb upwards when entity faces upwards
            if(role.directionSet.equals("up") ) {
                //32-36 lines are to make tile-based bombs
                bomb b;
                //should the bomb be placed up left or up right
                if((roleLeftCol+1)*Panel.tileSize-roleLeftX <= Panel.tileSize/2)
                    b = new bomb(Panel.tileSize*roleRightCol,roleTopRow*Panel.tileSize);
                else b = new bomb(Panel.tileSize*roleLeftCol,roleTopRow*Panel.tileSize);

                //check if that tile is a valid tile
                b.collisionDetected = false;
                panel.effectChecker.bombChecker(b);
                if(!b.collisionDetected){
                    panel.bombCopyOnWriteArrayList.add(b);
                    //set a timer for each bomb, so the bomb will explode after some time
                    setBombTimer(b);
                }
            }

            //drops bomb downwards when entity faces downwards
            else if(role.directionSet.equals("down")) {
                bomb b;
                //should the bomb be placed down left or down right
                if((roleLeftCol+1)*Panel.tileSize-roleLeftX <= Panel.tileSize/2)
                    b = new bomb(Panel.tileSize*roleRightCol,roleBottomRow*Panel.tileSize);
                else b = new bomb(Panel.tileSize*roleLeftCol,roleBottomRow*Panel.tileSize);

                b.collisionDetected = false;
                panel.effectChecker.bombChecker(b);
                if(!b.collisionDetected){
                    panel.bombCopyOnWriteArrayList.add(b);
                    setBombTimer(b);
                }
            }

            //drops bomb leftwards when entity faces leftwards
            else if(role.directionSet.equals("left")) {
                bomb b;
                //should the bomb be placed down left or up right
                if((roleTopRow+1)*Panel.tileSize-roleTopY<= Panel.tileSize/2)
                    b = new bomb(Panel.tileSize*roleLeftCol,roleBottomRow*Panel.tileSize);
                else b = new bomb(Panel.tileSize*roleLeftCol,roleTopRow*Panel.tileSize);

                b.collisionDetected = false;
                panel.effectChecker.bombChecker(b);
                if(!b.collisionDetected){
                    panel.bombCopyOnWriteArrayList.add(b);
                    setBombTimer(b);
                }
            }
            //drops bomb rightwards when entity faces rightwards
            else if(role.directionSet.equals("right")) {
                bomb b;
                //should the bomb be placed down right or up right
                if((roleTopRow+1)*Panel.tileSize-roleTopY<= Panel.tileSize/2)
                    b = new bomb(Panel.tileSize*roleRightCol,roleBottomRow*Panel.tileSize);
                else b = new bomb(Panel.tileSize*roleRightCol,roleTopRow*Panel.tileSize);

                b.collisionDetected = false;
                panel.effectChecker.bombChecker(b);
                if(!b.collisionDetected){
                    panel.bombCopyOnWriteArrayList.add(b);
                    setBombTimer(b);
                }
            }
        }
    }

    private void setBombTimer(bomb b){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                panel.fireSetter.addFire(b);
                panel.bombCopyOnWriteArrayList.remove(b);
            }
        },new Date(System.currentTimeMillis()+1500));
    }

}
