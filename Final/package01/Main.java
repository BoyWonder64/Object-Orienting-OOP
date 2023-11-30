package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {
	
	OptionHandler optionHandle = new OptionHandler();
	GUI gui = new GUI(); // From the GUI class, make a new gui object
	SwitchingScreens switchTo = new SwitchingScreens(gui);
	Story story = new Story(this, gui, switchTo);
	Music music = new Music();
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
	String sound = ".\\src\\Assests\\MythQuestTheme.wav";
	
	
	public static void main(String[] args) {
		
		new Main ();

	}

	public Main() {
		
		//Take object, and use the createGUI method to make the gui
		music.playMusic(sound);
		gui.createGUI(optionHandle); 
		story.defaultSetup();
		switchTo.showTitleScreen();
		
   }
	
	//Using this method moves our screens and then allows for options to 
	//move to other positions
	
	public class OptionHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String playerChoice = event.getActionCommand();
			switch(playerChoice) {
			case "Start"  : switchTo.titleToScreen1(); story.introduction(); break;
			case "option1": story.selectPosition(nextPosition1); break;
			case "option2": story.selectPosition(nextPosition2); break;
			case "option3": story.selectPosition(nextPosition3); break;
			case "option4": story.selectPosition(nextPosition4); break;
			}
			
		}
	}
	
}
