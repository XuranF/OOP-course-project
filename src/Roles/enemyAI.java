/**
 * This is to create an enemy class that is doing random walks and placing random bombs.
 */
package Roles;

import Main.Panel;
import Main.enemySet;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class enemyAI extends Role{

    public Panel panel;
    //enemyAI needs to has an automatic direction getter
    public int directionAdjustCounter;
    //adopt strategy pattern to facilitate the change of AI algorithm
    public enemySet enemySetter;

    public enemyAI(Panel panel){
        super(16*Panel.tileSize,3*Panel.tileSize,3);
        this.panel = panel;

        //default set up for enemy
        image = up1;
        direction = Direction.UP;
        directionAdjustCounter = 0;
        readImages();
    }

    private void readImages(){
        try{
            this.down1 = ImageIO.read(new File("resources/enemy1/enemy1_down_1.png"));
            this.down2 = ImageIO.read(new File("resources/enemy1/enemy1_down_2.png"));
            this.up1 = ImageIO.read(new File("resources/enemy1/enemy1_down_1.png"));
            this.up2 = ImageIO.read(new File("resources/enemy1/enemy1_down_2.png"));
            this.left1 = ImageIO.read(new File("resources/enemy1/enemy1_down_1.png"));
            this.left2 = ImageIO.read(new File("resources/enemy1/enemy1_down_2.png"));
            this.right1 = ImageIO.read(new File("resources/enemy1/enemy1_down_1.png"));
            this.right2 = ImageIO.read(new File("resources/enemy1/enemy1_down_2.png"));
        }catch (IOException e){}
    }

    public void setEnemySetter(enemySet enemySetter){
        this.enemySetter = enemySetter;
    }

    public void update(Boolean imageAdjust){
        //this is to enable enemy to follow a direction for a while
        //instead of getting a new direction each millisecond after canvas repainting
        directionAdjustCounter++;
        if(directionAdjustCounter>80){
            enemySetter.getDirection(this);
            directionAdjustCounter = 0;
        }
        enemySetter.placeBombWhenInteractWithPlayer(this);

        this.collisionDetected = false;
        //update whether the player's collision is detected or not
        panel.effectChecker.tileCheck(this);
        //the player also needs to interact with props
        panel.effectChecker.itemInteractCheck(this);

        //main function part, enemy's position is updated in different ways based on different keyboard inputs.
        if(!this.collisionDetected){
            if(this.direction == Direction.DOWN) {
                this.posY += this.speed;
                if(imageAdjust) this.image = this.down1;
                else this.image = this.down2;
            }
            else if(this.direction == Direction.UP ) {
                this.posY -= this.speed;
                if(imageAdjust) this.image = this.up1;
                else this.image = this.up2;
            }
            else if(this.direction == Direction.LEFT ) {
                this.posX -= this.speed;
                if(imageAdjust) this.image = this.left1;
                else this.image = this.left2;
            }
            else if(this.direction == Direction.RIGHT ) {
                this.posX += this.speed;
                if(imageAdjust) this.image = this.right1;
                else this.image = this.right2;
            }
        }
    }
}
