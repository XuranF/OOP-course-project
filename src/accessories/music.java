package accessories;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

//To play the looping background music
//Most codes are adopted from https://www.youtube.com/watch?v=nUHh_J2Acy8&list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq&index=20
public class music {
    Clip clip;
    File soundURL;

    public music(){
        try{
            soundURL = new File("resources/Music/Juhani Junkala [Retro Game Music Pack] Level 3.wav");
        } catch (Exception e){}
    }


    public void setFile(){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundURL));

        } catch (Exception e){}
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }

}
