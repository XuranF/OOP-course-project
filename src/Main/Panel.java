/**
 * A panel class that draws tiles, entities and props.
 */
package Main;
import Map.*;
import Roles.*;
import Object.*;
import accessories.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//panel class needs to implement Runnable to use thread
public class Panel extends JPanel implements Runnable {
    //create variables that are intrinsic to the panel
    public final static int tileSize = 48;
    public final static int numberOfColumn = 24;
    public final static int numberOfRow = 12;
    final int width = tileSize*numberOfColumn;
    final int height = tileSize*numberOfRow;

    //create player-related variables
    public Player player;
    Boolean imageAdjust = false;
    int imageAdjustCounter = 0;

    //create a tile map
    public map Map;

    //create a checker for all effects
    public effectChecker effectChecker;

    //create 4 lists of objects and AI enemies
    public List<bomb> bombCopyOnWriteArrayList;
    public bombSet bombSetter;

    public List<fire> fireCopyOnWriteArrayList;
    public fireSet fireSetter;

    public List<items> itemsCopyOnWriteArrayList;
    public itemSet itemSetter;

    public List<enemyAI> enemyCopyOnWriteArrayList;
    public enemySet enemySetter;


    public keyListener1 listener; public keyListener2 listener2;
    public UI ui;
    public music music;


    //initiate all variables
    public Panel(){
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);

        player = new Player(this);
        Map = new map();
        effectChecker = new effectChecker(this);

        bombCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        fireCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        itemsCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        enemyCopyOnWriteArrayList = new CopyOnWriteArrayList<>();

        bombSetter = new bombSet(this);
        fireSetter = new fireSet(this);
        itemSetter = new itemSet(this);
        enemySetter = new enemySet(this);

        ui = new UI(this);
        music = new music();
        this.setKeyListener();
        this.setFocusable(true);
        playMusic();
    }

    public void setKeyListener(){
        listener = new keyListener1();
        listener2 = new keyListener2();
        this.addKeyListener(listener);
        this.addKeyListener(listener2);
    }

    //thread part
    Thread thread;
    public void threadStart(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run(){
        //loop core functions: update positions and repaint all
        while(thread != null){
            update();
            repaint();
            //thread will sleep for 8 milliseconds so human can see it
            try{
                thread.sleep(6);
            }catch (InterruptedException e){}
        }
        stopMusic();
    }

    //update player, enemy and bomb
    public void update(){
        //to simulate walking animation
        imageAdjustCounter++;
        if(imageAdjustCounter > 30) {
            imageAdjust = !imageAdjust;
            imageAdjustCounter = 0;
        }
        player.update(imageAdjust);
        enemySetter.update(imageAdjust);
        bombSetter.addBomb(player);
    }

    //paint everything
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Map.drawImage(g);
        player.drawImage(g);
        for(items i: itemsCopyOnWriteArrayList)
            i.drawImage(g);
        for(enemyAI e: enemyCopyOnWriteArrayList)
            e.drawImage(g);
        for(bomb b: bombCopyOnWriteArrayList)
            b.drawImage(g);
        for(fire f: fireCopyOnWriteArrayList)
            f.drawImage(g);

        ui.drawImage(g);
    }

    //background-music related
    public void playMusic(){
        music.setFile();
        music.play();
        music.loop();;
    }
    public void stopMusic(){
        music.stop();
    }
}
