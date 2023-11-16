package interfaces;

import java.io.BufferedinputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.Logging,Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public interface PlayerMusica {
 
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
            
            public void stop(){
                
                if(player  != null){
                    player.close();
                }
}

