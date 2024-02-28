package Object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

//A kind of props that can help entity move faster.
public class speedUp extends items {
    public speedUp(int posX, int posY){
        super(posX,posY);
        try{
            this.image = ImageIO.read(new File("resources/objects/boots.png"));
        } catch (IOException e){}
    }

}
