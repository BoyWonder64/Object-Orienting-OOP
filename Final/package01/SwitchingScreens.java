package package01;

public class SwitchingScreens {
	
	GUI gui;
	
	public SwitchingScreens(GUI userInterface) {
	
		gui = userInterface;
		
	}

	public void showTitleScreen() {
		
		//Show Title Screen
		gui.titleNamePanel.setVisible(true);
		gui.startButtonPanel.setVisible(true);

		
		//Hide Player Options
		gui.mainTextArea.setVisible(false);
		gui.optionPanel.setVisible(false);
		gui.playerPanel.setVisible(false);
		gui.npcPanel.setVisible(false);
		gui.logoPanel.setVisible(false);
	}

	public void titleToScreen1() {
		//Hide Title Screen
		gui.titleNamePanel.setVisible(false);
		gui.startButtonPanel.setVisible(false);

		
		//Show Player Options
		gui.mainTextArea.setVisible(true);
		gui.optionPanel.setVisible(true);
		gui.playerPanel.setVisible(true);
		gui.logoPanel.setVisible(true);
	}
	
}
