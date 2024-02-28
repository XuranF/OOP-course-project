package Object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

//simulate how explosion looks like after bomb exploding
public class fire extends items {
    public fire(int posX, int posY){
        super(posX, posY);
        try{
            this.image = ImageIO.read(new File("resources/fire/fire_middle.png"));
        } catch (IOException e){}
    }

    // To make the explosion looks more realistic, creating simulated graphs for up, down, left and right flames
    public void rightFlameSet(){
        try{
            this.image = ImageIO.read(new File("resources/fire/fire_right.png"));
        } catch (IOException e){}
    }
    public void leftFlameSet(){
        try{
            this.image = ImageIO.read(new File("resources/fire/fire_left.png"));
        } catch (IOException e){}
    }
    public void upFlameSet(){
        try{
            this.image = ImageIO.read(new File("resources/fire/fire_up.png"));
        } catch (IOException e){}
    }
    public void downFlameSet(){
        try{
            this.image = ImageIO.read(new File("resources/fire/fire_down.png"));
        } catch (IOException e){}
    }
}

