/**
 * This class is for collision check, bomb placing check, explosion check and thread stop check
 * Author: Xuran Feng
 */
package Main;

import Roles.Direction;
import Roles.*;
import Object.*;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class effectChecker {
    Panel panel;
    public effectChecker(Panel p){
        this.panel = p;
    }

    // tiles are walkable or not
    public void tileCheck(Role role){
        int roleLeftX = role.posX+role.collisionArea.x;
        int roleRightX = roleLeftX+role.collisionArea.width;
        int roleTopY = role.posY+role.collisionArea.y;
        int roleBottomY = roleTopY+role.collisionArea.height;

        int roleLeftCol = roleLeftX/Panel.tileSize;
        int roleRightCol = roleRightX/Panel.tileSize;
        int roleTopRow = roleTopY/Panel.tileSize;
        int roleBottomRow = roleBottomY/Panel.tileSize;

        int tileNum1, tileNum2;

        if(role.direction == Direction.UP){
            //predict the incoming tile situation by subtracting entity's speed
            roleTopRow = (roleTopY-role.speed)/Panel.tileSize;
            tileNum1 = panel.Map.canvas[roleTopRow][roleLeftCol];
            tileNum2 = panel.Map.canvas[roleTopRow][roleRightCol];
            if(panel.Map.tileCollision[tileNum1] || panel.Map.tileCollision[tileNum2])
                role.collisionDetected = true;
        }
        else if(role.direction == Direction.DOWN){
            //predict the incoming tile situation by adding entity's speed
            roleBottomRow = (roleBottomY+role.speed)/Panel.tileSize;
            tileNum1 = panel.Map.canvas[roleBottomRow][roleLeftCol];
            tileNum2 = panel.Map.canvas[roleBottomRow][roleRightCol];
            if(panel.Map.tileCollision[tileNum1] || panel.Map.tileCollision[tileNum2])
                role.collisionDetected = true;
        }
        else if(role.direction == Direction.LEFT){
            roleLeftCol = (roleLeftX-role.speed)/Panel.tileSize;
            tileNum1 = panel.Map.canvas[roleTopRow][roleLeftCol];
            tileNum2 = panel.Map.canvas[roleBottomRow][roleLeftCol];
            if(panel.Map.tileCollision[tileNum1] || panel.Map.tileCollision[tileNum2])
                role.collisionDetected = true;
        }
        else if(role.direction == Direction.RIGHT){
            roleRightCol = (roleRightX+role.speed)/Panel.tileSize;
            tileNum1 = panel.Map.canvas[roleTopRow][roleRightCol];
            tileNum2 = panel.Map.canvas[roleBottomRow][roleRightCol];
            if(panel.Map.tileCollision[tileNum1] || panel.Map.tileCollision[tileNum2])
                role.collisionDetected = true;
        }
    }

    // roles interact with props
    public void itemInteractCheck(Role role){
        for(items i: panel.itemsCopyOnWriteArrayList){
            //update role's and prop's position to detect collision
            role.collisionArea.x += role.posX;
            role.collisionArea.y += role.posY;
            i.collisionArea.x += i.posX;
            i.collisionArea.y += i.posY;
            if(i.collisionArea.intersects(role.collisionArea)){
                //if collision is detected, the prop will be removed
                panel.itemsCopyOnWriteArrayList.remove(i);
                //the props effects add up to role
                panel.itemSetter.interact(i,role);
            }

            //props' and role's collision area positions need to be reset to default
            role.collisionArea.x = role.backTrackingCollisionX;
            role.collisionArea.y = role.backTrackingCollisionY;
            i.collisionArea.x = i.backTrackingCollisionX;
            i.collisionArea.y = i.backTrackingCollisionY;
        }

    }

    // can place bomb or not, the bomb cannot be placed on wall and box tiles
    public void bombChecker(bomb b){
        int bombLeftX = b.posX;
        int bombTopY = b.posY;
        int bombLeftCol = bombLeftX/Panel.tileSize;
        int bombTopRow = bombTopY/Panel.tileSize;
        int tileNum1;
        tileNum1 = panel.Map.canvas[bombTopRow][bombLeftCol];
        if(panel.Map.tileCollision[tileNum1])
            b.collisionDetected = true;
    }

    // can show fire or not
    // if it's a wall tile, the fire will not show;
    // if it's a box tile, the tile will be modified into an earth tile,
    // and a random props will show up after box is destroyed
    public void fireExplosionCheck(fire f){
        int fireLeftX = f.posX;
        int fireTopY = f.posY;
        int fireLeftCol = fireLeftX/Panel.tileSize;
        int fireTopRow = fireTopY/Panel.tileSize;
        int tileNum1;
        tileNum1 = panel.Map.canvas[fireTopRow][fireLeftCol];

        //a wall tile is detected
        if(tileNum1 == 1)
            f.collisionDetected = true;

        //a box tile is detected
        else if(tileNum1 == 2) {
            //the box tile is displaced by a grass tile
            panel.Map.mapModify(fireTopRow,fireLeftCol,0);
            //set a timer for adding props after flame disappears
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    panel.itemSetter.addItemRandomly(f.posX,f.posY);
                }
            },new Date(System.currentTimeMillis()+1600));
        }

    }

    // check whether game ends or not
    public void threadStopCheck(fire f){
        Rectangle fireRectangle = new Rectangle(f.posX,f.posY,Panel.tileSize,Panel.tileSize);
        panel.player.collisionArea.x += panel.player.posX;
        panel.player.collisionArea.y += panel.player.posY;

        // if the player is intersected with fire, game ends
        if(panel.player.collisionArea.intersects(fireRectangle)){
            panel.setBackground(Color.BLACK);
            panel.ui.loseMessage();
            panel.thread = null;
        }
        panel.player.collisionArea.x = panel.player.backTrackingCollisionX;
        panel.player.collisionArea.y = panel.player.backTrackingCollisionY;

        // if all enemies are intersected with fire, game ends
        for(enemyAI e: panel.enemyCopyOnWriteArrayList){
            e.collisionArea.x += e.posX;
            e.collisionArea.y += e.posY;
            // if an enemy is killed, then it will be removed out of list
            if(e.collisionArea.intersects(fireRectangle))
                panel.enemyCopyOnWriteArrayList.remove(e);

            if(panel.enemyCopyOnWriteArrayList.size() == 0){
                panel.setBackground(Color.BLACK);
                panel.ui.winMessage();
                panel.thread = null;
            }
            e.collisionArea.x = e.backTrackingCollisionX;
            e.collisionArea.y = e.backTrackingCollisionY;
        }
    }
}
