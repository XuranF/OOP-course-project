/**
 * This class is not for running JUnit test
 * It just uses command outputs to check effects such as collisions successfully detected or props successfully interacted
 * all the codes are commented and the same as formal codes but with some 'System.out.println' added
 */
package Test;

import Main.Panel;
import Roles.Direction;
import Roles.enemyAI;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test {
    //Check if key listener1 work
//    public void keyPressed(KeyEvent keyEvent){
//        int keyInput = keyEvent.getKeyCode();
//        if(keyInput == KeyEvent.VK_UP){
//            System.out.println("direction up detected from keyboard");
//            dir = Direction.UP;
//        }
//        else if(keyInput == KeyEvent.VK_DOWN){
//            System.out.println("direction down detected from keyboard");
//            dir = Direction.DOWN;
//        }
//        else if(keyInput == KeyEvent.VK_LEFT){
//            System.out.println("direction left detected from keyboard");
//            dir = Direction.LEFT;
//        }
//        else if(keyInput == KeyEvent.VK_RIGHT){
//            System.out.println("direction right detected from keyboard");
//            dir = Direction.RIGHT;
//        }
//    }

    //Check if key listener2 work
//    public void keyPressed(KeyEvent keyEvent){
//        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE){
//            System.out.println("bomb dropping detected from keyboard");
//            bombDrop = true;
//        }
//    }

    //Check if bomb dropping successfully
//    if(role.directionSet.equals("up") ) {
//        //32-36 lines are to make tile-based bombs
//        bomb b;
//        //should the bomb be placed up left or up right
//        if((roleLeftCol+1)* Panel.tileSize-roleLeftX <= Panel.tileSize/2)
//            b = new bomb(Panel.tileSize*roleRightCol,roleTopRow*Panel.tileSize);
//        else b = new bomb(Panel.tileSize*roleLeftCol,roleTopRow*Panel.tileSize);
//
//        System.out.println("new bomb successfully created");
//
//        //check if that tile is a valid tile
//        b.collisionDetected = false;
//        panel.effectChecker.bombChecker(b);
//        if(!b.collisionDetected){
//
//            if(role instanceof enemyAI)  System.out.println("enemyAI successfully dropped a bomb");
//            else System.out.println("you successfully dropped a bomb");
//
//
//            panel.bombCopyOnWriteArrayList.add(b);
//            //set a timer for each bomb, so the bomb will explode after some time
//            setBombTimer(b);
//        }
//    }

    //Check if entity collides with unpassable tile
//    if(role.direction == Direction.UP){
//        //predict the incoming tile situation by subtracting entity's speed
//        roleTopRow = (roleTopY-role.speed)/Panel.tileSize;
//        tileNum1 = panel.Map.canvas[roleTopRow][roleLeftCol];
//        tileNum2 = panel.Map.canvas[roleTopRow][roleRightCol];
//        if(panel.Map.tileCollision[tileNum1] || panel.Map.tileCollision[tileNum2]){
//            role.collisionDetected = true;
//            System.out.println("collision with tile detected");
//        }
//    }

    //Check if enemy places bomb when intersecting with player
//    public void placeBombWhenInteractWithPlayer(enemyAI e){
//        e.collisionArea.x += e.posX;
//        e.collisionArea.y += e.posY;
//        panel.player.collisionArea.x += panel.player.posX;
//        panel.player.collisionArea.y += panel.player.posY;
//        if(e.collisionArea.intersects(panel.player.collisionArea)){
//            System.out.println("enemy is interacting with player!");
//            panel.bombSetter.addBomb(e);
//        }
//
//        e.collisionArea.x = e.backTrackingCollisionX;
//        e.collisionArea.y = e.backTrackingCollisionY;
//        panel.player.collisionArea.x = panel.player.backTrackingCollisionX;
//        panel.player.collisionArea.y = panel.player.backTrackingCollisionY;
//    }

    //Check if thread stopped
//    public void threadStopCheck(fire f){
//        Rectangle fireRectangle = new Rectangle(f.posX,f.posY,Panel.tileSize,Panel.tileSize);
//        panel.player.collisionArea.x += panel.player.posX;
//        panel.player.collisionArea.y += panel.player.posY;
//
//        // if the player is intersected with fire, game ends
//        if(panel.player.collisionArea.intersects(fireRectangle)){
//            panel.ui.loseMessage();
//            System.out.println("game over");
//            panel.thread = null;
//        }
//        panel.player.collisionArea.x = panel.player.backTrackingCollisionX;
//        panel.player.collisionArea.y = panel.player.backTrackingCollisionY;
//
//        // if all enemies are intersected with fire, game ends
//        for(enemyAI e: panel.enemyCopyOnWriteArrayList){
//            e.collisionArea.x += e.posX;
//            e.collisionArea.y += e.posY;
//            // if an enemy is killed, then it will be removed out of list
//            if(e.collisionArea.intersects(fireRectangle))
//                panel.enemyCopyOnWriteArrayList.remove(e);
//
//            if(panel.enemyCopyOnWriteArrayList.size() == 0){
//                panel.ui.winMessage();
//                System.out.println("game over");
//                panel.thread = null;
//            }
//            e.collisionArea.x = e.backTrackingCollisionX;
//            e.collisionArea.y = e.backTrackingCollisionY;
//        }
//    }
}
