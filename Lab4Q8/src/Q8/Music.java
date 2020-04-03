/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import java.nio.file.Paths;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author RAVEN
 */
public class Music {
    private String title;
    private String folder = "D:\\Education\\UM COURSES\\Year 1Sem 2\\Data Structure\\Labs\\Lab4Q8\\";
    private String fileName;
    JFXPanel panel = new JFXPanel();         
    Media hit;         
    static MediaPlayer mediaPlayer;  
       

    public Music(String title, String fileName) {
        this.title = title;
        this.fileName = folder +  fileName;
        hit = new Media(Paths.get(fileName).toUri().toString());
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFileName(String fileName) {
        this.fileName = folder + fileName;
        hit = new Media(Paths.get(fileName).toUri().toString());
    }
    
    public void play(){
        mediaPlayer = new MediaPlayer(hit);       
        mediaPlayer.play();                
    }
    
    public void stop(){
        mediaPlayer.stop();    
    }
    
    public void exit(){
        System.exit(0);    
    }
    
    public String toString(){
        return this.title;
    }
}