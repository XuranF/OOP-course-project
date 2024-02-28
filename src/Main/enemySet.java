/**
 * Simple AI, only make enemies randomly move and drop bombs
 * The AI can be improved in the future since it's a strategy pattern design
 */
package Main;
import Roles.*;
import java.util.*;

public class enemySet {

    public Panel panel;
    //create 4 AI enemies to play against player
    public enemyAI enemy1,enemy2,enemy3,enemy4;
    //to obtain a random direction
    public Random random;

    public enemySet(Panel panel){
        this.panel = panel;
        random = new Random();

        //initiate 4 enemies
        enemy1 = new enemyAI(this.panel);
        enemy1.posX = 7*Panel.tileSize; enemy1.posY = 5*Panel.tileSize;
        this.panel.enemyCopyOnWriteArrayList.add(enemy1);
        enemy1.setEnemySetter(this);

        enemy2 = new enemyAI(this.panel);
        enemy2.posX = 7*Panel.tileSize; enemy2.posY = 8*Panel.tileSize;
        this.panel.enemyCopyOnWriteArrayList.add(enemy2);
        enemy2.setEnemySetter(this);

        enemy3 = new enemyAI(this.panel);
        enemy3.posX = 19*Panel.tileSize; enemy3.posY = 8*Panel.tileSize;
        this.panel.enemyCopyOnWriteArrayList.add(enemy3);
        enemy3.setEnemySetter(this);

        enemy4 = new enemyAI(this.panel);
        enemy4.posX = 19*Panel.tileSize; enemy4.posY = 5*Panel.tileSize;
        this.panel.enemyCopyOnWriteArrayList.add(enemy4);
        enemy4.setEnemySetter(this);

    }

    //get a random direction and each direction will be given equal probability
    public void getDirection(enemyAI e){
        int next = random.nextInt(99)+1;
        if(next<=25 && e.direction != Direction.UP){
            e.direction = Direction.UP;
            e.directionSet = "up";
        }
        else if(next<=50&& e.direction != Direction.LEFT){
            e.direction = Direction.LEFT;
            e.directionSet = "left";
        }
        else if(next<=75 && e.direction != Direction.DOWN){
            e.direction = Direction.DOWN;
            e.directionSet = "down";
        }
        else{
            e.direction = Direction.RIGHT;
            e.directionSet = "right";;
        }
    }

    //enemyAI will place bomb when they are intersecting with player
    public void placeBombWhenInteractWithPlayer(enemyAI e){
        e.collisionArea.x += e.posX;
        e.collisionArea.y += e.posY;
        panel.player.collisionArea.x += panel.player.posX;
        panel.player.collisionArea.y += panel.player.posY;
        if(e.collisionArea.intersects(panel.player.collisionArea)) panel.bombSetter.addBomb(e);

        e.collisionArea.x = e.backTrackingCollisionX;
        e.collisionArea.y = e.backTrackingCollisionY;
        panel.player.collisionArea.x = panel.player.backTrackingCollisionX;
        panel.player.collisionArea.y = panel.player.backTrackingCollisionY;
    }

    //update method that will be called again and again in Panel's thread loop
    public void update(Boolean imageAdjust){
        for(enemyAI e: panel.enemyCopyOnWriteArrayList){
            e.update(imageAdjust);
        }
    }
}

