package Object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

//A bomb object that can be placed by player to kill other entities
public class bomb extends items {

    public bomb(int posX, int posY){
        super(posX,posY);
        try{
            this.image = ImageIO.read(new File("resources/objects/bomb.png"));
        } catch (IOException e){}
    }

}
