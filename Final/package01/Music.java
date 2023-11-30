package package01;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	
	void playMusic(String musicLocation) 
	{
		
		try 
		{
			File musicPath = new File(musicLocation);
			if (musicPath.exists()) 
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
			} else {
				System.out.println("Not Found");
			}
		} 
		catch(Exception ex) 
		{	
			ex.printStackTrace();
		}
	}

	
}
