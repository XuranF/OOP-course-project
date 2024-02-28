/**
 * To create a general entity class.
 * Author: Xuran Feng
 */
package Roles;
import Main.Panel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Role {
    //Basic features for entity
    public int posX, posY,speed;
    public BufferedImage image;

    //Entity has a direction that is controlled by keyboard inputs.
    public Direction direction;

    //Entity has 2 images to simulate walking animation for each direction.
    public BufferedImage up1,up2,down1, down2,left1,left2,right1,right2;

    //This String variable is to keep record of entity's last direction after keys are released
    public String directionSet;

    //collision-related variables
    public Rectangle collisionArea;
    public boolean collisionDetected;
        //entity's collision needs to be reset each time after checking collision
    public int backTrackingCollisionX,backTrackingCollisionY;

    //initialize the entity
    public Role(int posX, int posY,int speed){
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        collisionDetected = false;

        //set a default collision area for entity, so the entity collision with tiles shows more naturally.
        collisionArea = new Rectangle();
        collisionArea.x = 8;
        collisionArea.y = 12;
        collisionArea.width = Panel.tileSize-2*collisionArea.x;
        collisionArea.height = Panel.tileSize-collisionArea.y;

        directionSet = "";
        backTrackingCollisionX = collisionArea.x;
        backTrackingCollisionY = collisionArea.y;
    }

    //draw entity's image
    public void drawImage(Graphics g){
        g.drawImage(image,posX,posY,Panel.tileSize,Panel.tileSize,null);
    }

}
