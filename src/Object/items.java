/**
 * This is to create a super object class that will interact with players and tiles
 * Author: Xuran Feng
 */
package Object;

import Main.Panel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class items {
    //Basic features for object
    public BufferedImage image;
    public int posX, posY;

    //collision-related variables
    public Rectangle collisionArea;
    public boolean collisionDetected;
    //entity's collision needs to be reset each time after checking collision
    public int backTrackingCollisionX,backTrackingCollisionY;

    public items(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        collisionDetected = false;

        //set a default collision area for objects
        collisionArea = new Rectangle(0,0,Panel.tileSize,Panel.tileSize);
        backTrackingCollisionX = collisionArea.x;
        backTrackingCollisionY = collisionArea.y;
    }

    //draw entity's image
    public void drawImage(Graphics g){
        g.drawImage(this.image,this.posX,this.posY, Panel.tileSize, Panel.tileSize,null);
    }
}
