/**
 * To create a class that records canvas information.
 * Author: Xuran Feng
 */
package Map;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Main.Panel;
import javax.imageio.ImageIO;

public class map {
    //this map has three kinds of tiles and each tile has its own collision feature
    public BufferedImage[] tileCollection = new BufferedImage[3];
    public Boolean[] tileCollision = new Boolean[3];
    //initiate the original map information, different number represents different kind of tile
    private final int[][] info = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,2,0,0,2,0,0,0,0,2,0,0,2,0,0,0,1,0,0,0,2,1},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1},
            {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
            {1,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
            {1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,2,0,0,0,0,0,0,1},
            {1,0,0,0,2,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,2,0,0,0,0,0,1,0,0,0,0,0,0,0,0,2,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    //canvas variable is the copy of map info
    public int[][] canvas  = new int[Panel.numberOfRow][Panel.numberOfColumn];

    public map(){
        setMap();
        setTileCollection();
    }

    //set up the copy of original info
    public void setMap(){
        for(int i = 0;i<Panel.numberOfRow;i++){
            for(int j = 0;j<Panel.numberOfColumn;j++){
                canvas[i][j] = info[i][j];
            }
        }
    }

    //read in tile graphics information and tile collision features
    public void setTileCollection(){
        try{
            tileCollection[0] = ImageIO.read(new File("resources/tile/earth.png"));
            tileCollection[1] = ImageIO.read(new File("resources/tile/wall.png"));
            tileCollection[2] = ImageIO.read(new File("resources/tile/box.png"));
            tileCollision[0] = false;
            tileCollision[1] = true;
            tileCollision[2] = true;
        } catch(IOException e){}
    }

    //explosion will change the box tile into the earth tile, so map will be modified
    public void mapModify(int i, int j, int newInfo){
        this.canvas[i][j] = newInfo;
    }

    //draw the map on the panel
    public void drawImage(Graphics g){
        for(int i = 0;i<Panel.numberOfRow;i++){
            for(int j = 0;j<Panel.numberOfColumn;j++)
                g.drawImage(tileCollection[canvas[i][j]],j*Panel.tileSize,i*Panel.tileSize,Panel.tileSize,Panel.tileSize,null);
        }
    }
}
