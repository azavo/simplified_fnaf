package src;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class SFX {
    public static void boom(){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("freddyfivebear\\src\\sfx\\vineboom.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void light(){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("freddyfivebear\\src\\sfx\\lightsound.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void door(){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("freddyfivebear\\src\\sfx\\doorsound.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void stinger(){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("freddyfivebear\\src\\sfx\\stinger.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
