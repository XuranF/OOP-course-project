package Roles;
import Main.Panel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Player extends Role{

    //link the panel(JPanel) with the player
    Panel panel;
    public Player(Panel panel){
        //initiate player's position around the top left of the canvas
        super(3*Panel.tileSize,4*Panel.tileSize,2);
        this.panel = panel;

        //player shows a default direction and image
        image = down1;
        direction = Direction.DOWN;

        //read in 2 default images for each direction
        readImages();
    }

    private void readImages(){
        try{
            this.down1 = ImageIO.read(new File("resources/player/boy_down_1.png"));
            this.down2 = ImageIO.read(new File("resources/player/boy_down_2.png"));
            this.up1 = ImageIO.read(new File("resources/player/boy_up_1.png"));
            this.up2 = ImageIO.read(new File("resources/player/boy_up_2.png"));
            this.left1 = ImageIO.read(new File("resources/player/boy_left_1.png"));
            this.left2 = ImageIO.read(new File("resources/player/boy_left_2.png"));
            this.right1 = ImageIO.read(new File("resources/player/boy_right_1.png"));
            this.right2 = ImageIO.read(new File("resources/player/boy_right_2.png"));
        }catch (IOException e){}
    }

    //update player's position based on the keyboard inputs and simulate the walking animation
    public void update(Boolean imageAdjust){
        //get direction from panel's key listener
        direction = panel.listener.dir;

        this.collisionDetected = false;
        //update whether the player's collision is detected or not
        panel.effectChecker.tileCheck(this);

        //the player needs to interact with props
        panel.effectChecker.itemInteractCheck(this);

        //main function part, player's position is updated in different ways based on different keyboard inputs.
        if(direction == Direction.DOWN) {
            directionSet = "down";
            if(!collisionDetected){
                posY += speed;
                //simulating the walking animation based on the variable passed from panel
                if(imageAdjust) image = down1;
                else image = down2;
            }
        }
        else if(direction == Direction.UP ) {
            directionSet = "up";
            if(!collisionDetected){
                posY -= speed;
                if(imageAdjust) image = up1;
                else image = up2;
            }
        }
        else if(direction == Direction.LEFT ) {
            directionSet = "left";
            if(!collisionDetected){
                posX -= speed;
                if(imageAdjust) image = left1;
                else image = left2;
            }
        }
        else if(direction == Direction.RIGHT ) {
            directionSet = "right";
            if(!collisionDetected){
                posX += speed;
                if(imageAdjust) image = right1;
                else image = right2;
            }
        }
        //the player's last direction needs to be recorded, so the player's face orientation is correct when standing still
        else {
            if(directionSet.equals("up")) image = up1;
            else if(directionSet.equals("left")) image = left1;
            else if(directionSet.equals("right")) image = right1;
            else image = down1;
        }
    }
}
