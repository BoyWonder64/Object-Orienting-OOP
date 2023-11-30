package package01;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import package01.Main.OptionHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;





public class GUI {

	Story story;
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, optionPanel, playerPanel, npcPanel, logoPanel, titlePicturePanel; 
	JLabel titleNameLabel, healthLabel, healthNumLabel, weaponLabel, weaponNameLabel,heroClassLabel, heroClassNameLabel, npcHealth, npcHealthLabel, npcClass, npcClassLabel, npcWeapon, npcWeaponLabel;
	JButton startButton, option1, option2, option3, option4;
	JTextArea mainTextArea;
	Font titleFont;
	Font gameFont;
	
	
	int i = 0;
	String text;
	
	
	public void createGUI(OptionHandler optionHandle) {
		
		//Setting up Custom Font. Font must be a true type font. the .deriveFont function allows you to set the size
		
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new File(".\\src\\Assests\\Alkhemikal.ttf")).deriveFont(90f);
			GraphicsEnvironment te = GraphicsEnvironment.getLocalGraphicsEnvironment();
			te.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".\\src\\Assests\\Alkhemikal.ttf")));
			
			gameFont = Font.createFont(Font.TRUETYPE_FONT, new File(".\\src\\Assests\\Alkhemikal.ttf")).deriveFont(26f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".\\src\\Assests\\Alkhemikal.ttf")));
			
		}catch(IOException | FontFormatException e) {
			
		}
	
		//Creating background window
	window = new JFrame();
	window.setSize(800, 600);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.getContentPane().setBackground(new Color(46, 163, 201));
	window.setLayout(null);

	
		//Title
	titleNamePanel = new JPanel();
	titleNamePanel.setBounds(50, 100, 700, 800);
	titleNamePanel.setBackground(new Color(46, 163, 201));
	titleNameLabel = new JLabel("Myth Quest");
	titleNameLabel.setForeground(Color.white);
	titleNameLabel.setFont(titleFont);
	
	titleNamePanel.add(titleNameLabel);
		//Start Button
	
	startButtonPanel = new JPanel();
	startButtonPanel.setFocusable(true);
	startButtonPanel.requestFocusInWindow();
	startButtonPanel.setBounds(300, 400, 200, 100);
	startButtonPanel.setBackground(Color.black);
	startButton = new JButton("START");
	startButton.setBackground(Color.black);
	startButton.setForeground(Color.white);
	startButton.setFont(gameFont);
	startButton.setFocusPainted(false);
	startButton.addActionListener(optionHandle);
	startButton.setActionCommand("Start");
	startButtonPanel.add(startButton);


	window.add(titleNamePanel);
	window.add(startButtonPanel);
	
	window.setVisible(true);
	
	//Story Screen
	mainTextPanel = new JPanel(); //creating main text panel as a jpanel
	mainTextPanel.setBounds(95, 115, 600, 250); //setting where it is
	mainTextPanel.setBackground(Color.black); //setting color
	window.add(mainTextPanel);
	
	//Text Area for Story
	mainTextArea = new JTextArea();
	mainTextArea.setBackground(Color.black);
	mainTextArea.setForeground(Color.white);
	mainTextArea.setFont(gameFont);
	mainTextArea.setWrapStyleWord(true);
	mainTextArea.setEditable(false);
	mainTextPanel.add(mainTextArea);
	
	optionPanel = new JPanel();
	optionPanel.setBounds(270, 375, 250, 150);
	optionPanel.setBackground(Color.black);
	optionPanel.setLayout(new GridLayout(4,1));
	window.add(optionPanel);
	
	//Button 1 2 3 4
	option1 = new JButton("option1");
	option1.setBackground(Color.DARK_GRAY);
	option1.setForeground(Color.white);
	option1.setFont(gameFont);
	option1.setFocusable(false);
	option1.addActionListener(optionHandle);
	option1.setActionCommand("option1");
	optionPanel.add(option1);
	
	
	option2 = new JButton("option2");
	option2.setBackground(Color.DARK_GRAY);
	option2.setForeground(Color.white);
	option2.setFont(gameFont);
	option2.setFocusable(false);
	option2.addActionListener(optionHandle);
	option2.setActionCommand("option2");
	optionPanel.add(option2);
	
	option3 = new JButton("option3");
	option3.setBackground(Color.DARK_GRAY);
	option3.setForeground(Color.white);
	option3.setFont(gameFont);
	option3.addActionListener(optionHandle);
	option3.setActionCommand("option3");
	option3.setFocusable(false);
	
	optionPanel.add(option3);
	
	option4 = new JButton("option4");
	option4.setBackground(Color.DARK_GRAY);
	option4.setForeground(Color.white);
	option4.setFont(gameFont);
	option4.setFocusable(false);
	option4.addActionListener(optionHandle);
	option4.setActionCommand("option4");
	optionPanel.add(option4);
	
	
	
	//Setting player info: Health, Weapon, Class
	playerPanel = new JPanel();
	playerPanel.setBounds(0, 0, 280, 115);
	playerPanel.setBackground(new Color(46, 201, 103));
	playerPanel.setLayout(new GridLayout(3,2));
	window.add(playerPanel);
	
	healthLabel = new JLabel("  HP:");
	healthLabel.setFont(gameFont);
	healthLabel.setForeground(Color.white);
	playerPanel.add(healthLabel);

	healthNumLabel = new JLabel();
	healthNumLabel.setFont(gameFont);
	healthNumLabel.setForeground(Color.white);
	playerPanel.add(healthNumLabel);
	
	weaponLabel = new JLabel("  Weapon:");
	weaponLabel.setFont(gameFont);
	weaponLabel.setForeground(Color.white);
	playerPanel.add(weaponLabel);
	
	weaponNameLabel = new JLabel();
	weaponNameLabel.setFont(gameFont);
	weaponNameLabel.setForeground(Color.white);
	playerPanel.add(weaponNameLabel);
	
	heroClassLabel = new JLabel("  Class:");
	heroClassLabel.setFont(gameFont);
	heroClassLabel.setForeground(Color.white);
	playerPanel.add(heroClassLabel);
	
	heroClassNameLabel = new JLabel();
	heroClassNameLabel.setFont(gameFont);
	heroClassNameLabel.setForeground(Color.white);
	playerPanel.add(heroClassNameLabel);
	
	//NPC Panel and info
	npcPanel = new JPanel();
	npcPanel.setBounds(475, 0, 400, 115);
	npcPanel.setBackground(new Color(46, 201, 103));
	npcPanel.setLayout(new GridLayout(3,3));
	window.add(npcPanel);
	
	//npcName, npcNameLabel, npcClass, npcClassLabel, npcWeapon, npcWeaponLabel;
	npcHealth = new JLabel("  Enemy HP: ");
	npcHealth.setFont(gameFont);
	npcHealth.setForeground(Color.white);
	npcPanel.add(npcHealth);
	
	npcHealthLabel = new JLabel();
	npcHealthLabel.setFont(gameFont);
	npcHealthLabel.setForeground(Color.white);
	npcPanel.add(npcHealthLabel);
	
	npcClass = new JLabel("  Enemy Race: ");
	npcClass.setFont(gameFont);
    npcClass.setForeground(Color.white);
	npcPanel.add(npcClass);
	
	npcClassLabel = new JLabel();
	npcClassLabel.setFont(gameFont);
	npcClassLabel.setForeground(Color.white);
	npcPanel.add(npcClassLabel);
	
	npcWeapon = new JLabel("  Enemy Weapon: ");
	npcWeapon.setFont(gameFont);
	npcWeapon.setForeground(Color.white);
	npcPanel.add(npcWeapon);
	
	npcWeaponLabel = new JLabel();
	npcWeaponLabel.setFont(gameFont);
	npcWeaponLabel.setForeground(Color.white);
	npcPanel.add(npcWeaponLabel);

	
	//Logo Panels
	logoPanel = new JPanel();
	logoPanel.setBounds(180, 0, 410, 150);
	ImageIcon swordPic = new ImageIcon(".//src//Assests//Game.png");
	JLabel picture = new JLabel(swordPic);
	logoPanel.add(picture);
	window.add(logoPanel);
	
	
	//setting all visable here
	window.setVisible(true);

	}


	
}//End of Class
