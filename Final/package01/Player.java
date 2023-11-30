package package01;

import package02.Weapon;

public class Player {
	
	public int hp;
	public Weapon choosenWeapon;
	public int score;
	public boolean stolenWeapon; //Used for Orc after barfight. If set to True, Orc takes knife from you
	public boolean oremirAbility;
}
