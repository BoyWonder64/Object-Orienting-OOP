package package01;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Timer;

import package02.StolenKnife;
import package02.Axe_Oremir;
import package02.Knife;
import package04.Goblin;
import package04.Monster;


public class Story {
	
	Main main;
	GUI gui;
	SwitchingScreens switchTo;
	Player player = new Player();
	Monster monster;
	String text;
	int i =0;


	
	public Story(Main g, GUI userInterface, SwitchingScreens switcher) {
		
		main = g;
		gui = userInterface;
		switchTo = switcher;
		
		
	}

	
	public void defaultSetup() {
		player.score = player.score + 10;
		player.choosenWeapon = new Knife();
		gui.weaponNameLabel.setText("" + player.choosenWeapon.name);
		player.hp = 20;
		gui.healthNumLabel.setText("" + player.hp);

	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		//Setting Class
		case "Elf": gui.heroClassNameLabel.setText(" Elf"); firstTavern(); break;
		case "Human" : gui.heroClassNameLabel.setText(" Human"); firstTavern(); break;
		case "Dwarf" : gui.heroClassNameLabel.setText(" Dwarf"); firstTavern(); break;
		case "Orc" : gui.heroClassNameLabel.setText(" Orc"); firstTavern(); break;
		
		//inside Tavern
		case "talkKeeper" : talkKeeper(); break;
		case "keeperTooBusy" : keeperTooBusy(); break;
		
		case "sitTable" : sitTable(); break;
		case "barStrangerGift" : barStrangerGift(); break;
		
		
		case "buyDrink" : buyDrink(); break;
		case "buyExtraDrink": buyExtaDrink(); break;
		case "lastDrink" : lastDrink(); break;
		case "KeeperSaysNo" : KeeperSaysNo(); break;
		
		//end of act 1
		
		case "outsideTavern" : outsideTavern(); break;
		
		
		//outside brawl
		case "breakFightUp": breakFightUp(); break;
		case "fightOrc" : fistFightOrc(); break;
		case "fightDwarf" : fistFightDwarf(); break;
		
		case "DwarfGivesGift" : DwarfGivesGift(); break;
		case "DwarfSaysThanks" : DwarfSaysThanks(); break;
		
		case "orcGivesGift": orcGivesGift(); break;
		case "orcExplainsGift":orcExplainsGift(); break;
		case "OrcTakesKnife": OrcTakesKnife(); break;
		
		//end of act 2
		case "leaveFirstTown" : leaveFirstTown(); break;
		case "goblinGang" : goblinGang(); break;
		case "leaveGoblinBattle" : leaveGoblinBattle(); break;
		case "goblinsRunAway" : goblinsRunAway(); break;
		
		case "fight":fight();break;
		case "playerFight" : playerFight(); break;
		case "monsterAttack": monsterAttack(); break;
		case "score" : score(); break;
		
		case "toTitleScreen": toTitleScreen(); break;
		
		case "win": win(); break;
		case "lose": lose(); break;
		case "ending" : ending(); break;
	
		}
		
	}
	
	
	
	
	public void introduction() {
		text = ("\nI don't believe we have met before. \n\nWhat race are you?");
		prepareText();
		gui.option1.setText("Elf");
		gui.option2.setText("Human");
		gui.option3.setText("Dwarf");
		gui.option4.setText("Orc");
		
		
		main.nextPosition1 = "Elf";
		main.nextPosition2 = "Human";
		main.nextPosition3 = "Dwarf";
		main.nextPosition4 = "Orc";
			
	}
	
	
	//Print out final score
	public void score() {
		
	    try {
	      FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Documents\\Eclipse Projects\\Final Text Adventure\\finalScore.txt");
	      myWriter.write("Thanks for playing!" +
	     "\nYour final score is: "  + player.score);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	
	
	//Always happens after class is picked
	public void firstTavern() {
		
		text =("\nYour inside a Tavern \n\nWhat do you do?");
		prepareText();
		gui.option1.setText("Talk to Inn Keeper");
		gui.option2.setText("Find Table");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		
		main.nextPosition1 = "talkKeeper";
		main.nextPosition2 = "sitTable";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
	}
	
	public void talkKeeper() {
		text = ("\nThe Tavern Keeper comes to you  \nHe looks busy \n\n What do you do?");
		prepareText();
		if (player.hp == 20) {
		gui.option1.setText("Ask if he needs help");
		gui.option2.setText("Buy a Drink");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		
		main.nextPosition1 = "keeperTooBusy";
		main.nextPosition2 = "buyDrink";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
		
		}else{
			
			gui.option1.setText("Ask if he needs help");
			gui.option2.setText("");
			gui.option3.setText("Leave");
			gui.option4.setText("");
			
			main.nextPosition1 = "keeperTooBusy";
			main.nextPosition2 = "";
			main.nextPosition3 = "outsideTavern";
			main.nextPosition4 = "";
			
		}
	}
	

	public void keeperTooBusy() {
		
		text = ("\nKEEPER: Can't you see I have orders to fill? \nare you going to buy something or not!?!");
		prepareText();
		gui.option1.setText("Buy a Drink");
		gui.option2.setText("Find Table");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		
		main.nextPosition1 = "buyDrink";
		main.nextPosition2 = "sitTable";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
	}
		
	public void buyDrink() {
		text = ("\nThe keeper hands you a mug of ale\nYou gain 5 extra health! \n\n What do you do?");
		prepareText();
		player.hp = player.hp + 5;
		gui.healthNumLabel.setText("" + player.hp);
		
		gui.option1.setText("Buy another Drink");
		gui.option2.setText("Find a Table");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		player.score = player.score + 5;
		
		main.nextPosition1 = "buyExtraDrink";
		main.nextPosition2 = "sitTable";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
	
	}
	
	public void buyExtaDrink() {
		text = ("\nThe keeper hands you another mug of ale\nYou take a few sips \n\n What do you do?");
		prepareText();		
		gui.option1.setText("Buy another Drink");
		gui.option2.setText("Find a Table");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		player.score = player.score + 5;
		
		main.nextPosition1 = "lastDrink";
		main.nextPosition2 = "sitTable";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
	}
	
	public void lastDrink() {
		text = ("\nThe keeper hands you another mug of ale\nKEEPER: This is your last one!");
		prepareText();	
		gui.option1.setText("Buy another Drink");
		gui.option2.setText("Find a Table");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		player.score = player.score + 5;
		
		main.nextPosition1 = "KeeperSaysNo";
		main.nextPosition2 = "sitTable";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
	}
	
	public void KeeperSaysNo() {
		text = ("\nThe keeper shakes his head \nKEEPER: You've had enough! Leave me alone!?");
		prepareText();		
		gui.option1.setText("");
		gui.option2.setText("Find a Table");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		player.score = player.score + 5;
		
		main.nextPosition1 = "";
		main.nextPosition2 = "sitTable";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
	}
	
	
	public void sitTable() {
		
		if (player.hp == 20) {
			text = ("\nYou search for a table and find one \nin corner of the room\nsitting to the right of you is a mysterous stranger"
					+ "\n\n                    he's staring at you");
			prepareText();
			gui.option1.setText("Talk to Stranger");
			gui.option2.setText("Buy a Drink");
			gui.option3.setText("Leave");
			gui.option4.setText("Talk to Inn Keeper");
			player.score = player.score + 7;
			
			main.nextPosition1 = "barStrangerGift";
			main.nextPosition2 = "buyDrink";
			main.nextPosition3 = "outsideTavern";
			main.nextPosition4 = "talkKeeper";
			
		}
		else
		{
			text = ("\nYou search for a table and find one \nin corner of the room\nsitting to the right of you is a mysterous stranger"
					+ "\n\n                    he's staring at you");
			prepareText();
			gui.option1.setText("Talk to Stranger");
			gui.option2.setText("Buy a Drink");
			gui.option3.setText("Leave");
			gui.option4.setText("");
			player.score = player.score + 7;
			
			main.nextPosition1 = "barStrangerGift";
			main.nextPosition2 = "buyDrink";
			main.nextPosition3 = "outsideTavern";
			main.nextPosition4 = "";
		}
	
	}
	
	public void barStrangerGift() {
		text = ("\nThe Stranger brandishes a beautiful knife\n\n STRANGER: I just stole this from a drunk Orc and \nfeel bad, take it, its yours!\n\n                  You now have a Stolen Knife");
		player.choosenWeapon = new StolenKnife();
		gui.weaponNameLabel.setText("" + player.choosenWeapon.name);
		prepareText();
		
		player.stolenWeapon = true;
		
		player.score = player.score + 5;
		
		gui.option1.setText("Talk to Inn Keeper");
		gui.option2.setText("Buy a Drink");
		gui.option3.setText("Leave");
		gui.option4.setText("");
		
		main.nextPosition1 = "talkKeeper";
		main.nextPosition2 = "buyDrink";
		main.nextPosition3 = "outsideTavern";
		main.nextPosition4 = "";
		
	}
	
	
	public void outsideTavern() {
		text = ("\nYou walk outside the tavern and see a fight taking place \n A Dwaft and an Orc are boxing \nWhat do you do?");
		prepareText();
		gui.option1.setText("Break up the fight");
		gui.option2.setText("Help the Dwarf");
		gui.option3.setText("Help the Orc");
		gui.option4.setText("Leave");
		
		player.score = player.score + 5;
		
		main.nextPosition1 = "breakFightUp";
		main.nextPosition2 = "fightOrc";
		main.nextPosition3 = "fightDwarf";
		main.nextPosition4 = "leaveFirstTown";
		
	}
	
	public void breakFightUp() {
		text = ("\nYou get between the two and you end up getting hurt! \n you take -5 points of health");
		prepareText();
		player.hp = player.hp - 5;
		gui.healthNumLabel.setText("" + player.hp);
		gui.option1.setText("");
		gui.option2.setText("Help the Dwarf");
		gui.option3.setText("Help the Orc");
		gui.option4.setText("Leave Town");

		player.score = player.score - 5;
		
		main.nextPosition1 = "";
		main.nextPosition2 = "fightOrc";
		main.nextPosition3 = "fightDwarf";
		main.nextPosition4 = "leaveFirstTown";
	
	}
	
	public void fistFightOrc() {
		text =("\nYou and the Dwarf uppercut the Orc, knocking him out\nDWARF: Thank you for the help! Heres a gift!"); 
		prepareText();
		gui.weaponNameLabel.setVisible(false);
		gui.option1.setText(">");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		player.score = player.score + 5;
		
		main.nextPosition1 = "DwarfGivesGift";
		main.nextPosition2 = "DwarfGivesGift";
		main.nextPosition3 = "DwarfGivesGift";
		main.nextPosition4 = "DwarfGivesGift";
		
	}
	
	public void DwarfGivesGift() {
		text = ("\nThe Dwarf hands you an Axe named Orenmir!\nIt seems to place fear into the heart of Goblins");
		prepareText();
		player.choosenWeapon = new Axe_Oremir();
		player.oremirAbility = true;
		gui.weaponNameLabel.setText("" + player.choosenWeapon.name);
		gui.option1.setText("Leave Town");
		gui.option2.setText("Talk to Dwarf");
		gui.option3.setText("");
		gui.option4.setText("");
		
		player.score = player.score + 5;
		
		main.nextPosition1 = "leaveFirstTown";
		main.nextPosition2 = "DwarfSaysThanks";
		main.nextPosition3 = "DwarfSaysThanks";
		main.nextPosition4 = "DwarfSaysThanks";
		gui.weaponNameLabel.setVisible(true);
		
	}
	
	public void DwarfSaysThanks() {
		
		text = ("\nDWARF: Thanks for helping me fight that stupid Orc!\nhe'll think twice before he tries to fight me again!");
		prepareText();
		
		gui.option1.setText("Leave Town");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		player.score = player.score + 10;
		
		main.nextPosition1 = "leaveFirstTown";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "";
		
	}
	
	
	public void fistFightDwarf(){
		
		text =("\nYou and the Orc swing fists\ntogether and uppercut the Dwarf, knocking him out!");
		prepareText();
		
		gui.option1.setText("Talk to Orc");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("Leave");

		player.score = player.score + 5;
		
		main.nextPosition1 = "orcGivesGift";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "leaveFirstTown";
		
	}
	
	public void orcGivesGift() {
		if (player.stolenWeapon == true ) {
			OrcTakesKnife();
		}
		else
		{
			text =("\nORC: Thanks for helping me fight that stupid Dwarf!\nThis is for helping me\nThe Orc has given you a gift! ");
			prepareText();
			
			gui.option1.setText(">");
			gui.option2.setText("");
			gui.option3.setText("");
			gui.option4.setText("Leave");

			player.score = player.score + 5;
			
			main.nextPosition1 = "orcExplainsGift";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
			main.nextPosition4 = "";
			
		}
		
	}
	public void orcExplainsGift() {
		text = ("\nThe Orc hands you an Knife named Venombite!\nIt seems to do +5 damage to Goblins");
		prepareText();
		player.choosenWeapon = new Axe_Oremir();
		gui.weaponNameLabel.setText("" + player.choosenWeapon.name);
		gui.option1.setText("Leave Town");
		gui.option2.setText("Talk to Dwarf");
		gui.option3.setText("");
		gui.option4.setText("");
		
		player.score = player.score + 5;
		
		main.nextPosition1 = "LeaveFirstTown";
		main.nextPosition2 = "DwarfSaysThanks";
		main.nextPosition3 = "DwarfSaysThanks";
		main.nextPosition4 = "DwarfSaysThanks";
		gui.weaponNameLabel.setVisible(true);
		
	}
	
	public void OrcTakesKnife() {
		text =("\nBefore you can say anything,\nthe Orc spots the knife you have\nORC: I've been looking for this!\nThe Orc takes your Stolen Knife");
		prepareText();
		player.choosenWeapon = new Knife();
		gui.weaponNameLabel.setText("" + player.choosenWeapon.name);
		gui.option1.setText("");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("Leave Town");

		player.score = player.score + 5;
		
		main.nextPosition1 = "";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "leaveFirstTown";
		
	}
	
	
	public void leaveFirstTown() {
		
		text =("\nYou walk out the gates into the nearby forest\nthe leaves begin to rustle");
		prepareText();

		gui.option1.setText("...");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		main.nextPosition1 = "goblinGang";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "";
		
		
	}
	
	public void leaveGoblinBattle() {	
		text =("\nYou try to run . . . \nbut a few goblins get in the way\nLooks like your trapped");
		prepareText();

		gui.option1.setText("Fight");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		main.nextPosition1 = "fight";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "";
		
	}
	
	public void goblinGang() {
		text =("\nA gang of goblins jump out of the bushes \nThe Leader wants to duel\nWhat do you do?");
		prepareText();
		monster = new Goblin();
		if (player.oremirAbility == true) {
		
			gui.option1.setText("...");
			gui.option2.setText("");
			gui.option3.setText("");
			gui.option4.setText("");
			
			player.score = player.score + 15;
			
			main.nextPosition1 = "goblinsRunAway";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
			main.nextPosition4 = "";
			
		}else{
			
		gui.option1.setText("Fight Him");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("Run away");
		
		player.score = player.score + 15;
		
		main.nextPosition1 = "fight";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "leaveGoblinBattle";
		}
	}
	
	public void goblinsRunAway(){
		text =("\nThe Leader notices your Axe\nGOBLIN LEADER: I Know that Axe! We must RUN!\nThe Goblins disappear into the forest...");
		prepareText();
		gui.option1.setText("...");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		player.score = player.score + 20;
		
		main.nextPosition1 = "ending";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "";
	}
	
	public void fight() {
		gui.npcPanel.setVisible(true);	
		gui.npcWeaponLabel.setText(" Knives");
		gui.npcHealthLabel.setText("" + monster.hp);
		gui.npcClassLabel.setText(" Goblin");
		gui.mainTextArea.setText("");
		
		gui.option1.setText("Fight");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("Run away");
		
		main.nextPosition1 = "playerFight";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "leaveGoblinBattle";
		
	}
	
	public void playerFight() {
		int playerDamage = new java.util.Random().nextInt(player.choosenWeapon.damage);
		gui.npcHealthLabel.setText(""+ monster.hp);
		text =("\nYou attacked the "+ monster.name + " and gave "+ playerDamage +" damage!" );
		prepareText();
		
		monster.hp = monster.hp - playerDamage;
		gui.npcHealthLabel.setText(""+ monster.hp);
		gui.option1.setText("Their Turn");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		if (monster.hp>0) {
			main.nextPosition1 = "monsterAttack";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
			main.nextPosition4 = "";
		}else if(monster.hp<1){
			
			main.nextPosition1 = "win";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
			main.nextPosition4 = "";
		
		}
	}
	
	public void monsterAttack() {
		
		int monsterDamage = new java.util.Random().nextInt(monster.attack);
		
		player.hp = player.hp - monsterDamage;
		gui.healthNumLabel.setText("" +player.hp);
		
		gui.option1.setText("Your Turn");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
	
		if (player.hp>0) {
			
			main.nextPosition1 = "playerFight";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
			main.nextPosition4 = "";
			
		}else if(player.hp<1) {
			main.nextPosition1 = "lose";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
			main.nextPosition4 = "";
		}
	}
	
	public void win() {
		text = ("\nYou defeated the " + monster.name);
		prepareText();
		gui.npcPanel.setVisible(false);
		
		gui.option1.setText("End Game");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		main.nextPosition1 = "ending";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "";
	}
	
	
	
	public void lose() {
		text = ("\n"+monster.name +" defeated you\n\n You have died");
		prepareText();
		gui.option1.setText("End Game");
		gui.option2.setText("");
		gui.option3.setText("");
		gui.option4.setText("");
		
		main.nextPosition1 = "toTitleScreen";
		main.nextPosition2 = "";
		main.nextPosition3 = "";
		main.nextPosition4 = "";
	}
	
	public void ending() {
		
		text = ("Congrats! You have beaten the game!\n\nYour total score is: "+ player.score);
		prepareText();
		
		score();
		gui.optionPanel.setVisible(false);
		gui.option1.setVisible(false);
		gui.option2.setVisible(false);
		gui.option3.setVisible(false);
		gui.option4.setVisible(false);

				
	}

	public void toTitleScreen() {
		defaultSetup();
		switchTo.showTitleScreen();
	}
	
	//Sets text to display char 1 at a time
	Timer timer = new Timer(20, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Create Char Array and then taking the text and putting it into the array
			char character[] = text.toCharArray();
			//Finding the length of the array
			int arrayNumber = character.length;
			
			String addedCharacter = "";
			String blank = "";
			//I am unable to use the setText function because it only will display one letter
			//at a time. So I am turning it back into a string so that I can use the append
			addedCharacter = blank + character[i]; 
			gui.mainTextArea.append(addedCharacter);
			
			i++;
			if (i==arrayNumber) {
				i=0;
				timer.stop();
			}
		}
	});
	//resets the text for further use
	public void prepareText() {
		i = 0;
		gui.mainTextArea.setText("");
		timer.start();
	}

}//End of Class

