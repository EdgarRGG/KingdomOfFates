package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import main.Handler;
import resources.Images;
import states.FightState;
import states.State;
/**
 * Boss del juego
 * @author Edgar Rubio
 *
 */
public class Boss extends EnemyEntity{

    Rectangle boss;
    int width, height;
    public static boolean isDead;
	
	double health=20,mana=75,xp=500,defense=15,str=9,intl=22, mr = 13,cons=20,acc=10,evs=2,initiative=10, maxHealth = 350, maxMana = 75;

    public Boss(Handler handler, int xPosition, int yPosition, String state, String name, String area) {
        super(handler, yPosition, yPosition,state,name,area,null);
        width = 500;
        height = 500;
        type="Boss";
        this.setXOffset(xPosition);
        this.setYOffset(yPosition);
        
        this.foundState = state;
        boss = new Rectangle();
    }

    @Override
    public void tick() {
    	super.tick();
    	canMove = false;
        
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        Graphics2D g2 = (Graphics2D) g;


        if(handler.getArea().equals(this.Area)) {
           
            boss = new Rectangle((int) (handler.getxInWorldDisplacement() + getXOffset() + 50),
                    (int) (handler.getyInWorldDisplacement() + getYOffset() - 100), 200, 200);

            
            g2.setColor(Color.black);

            g.drawImage(Images.boss_front,(int)(handler.getxInWorldDisplacement() + getXOffset() - 110),(int)(handler.getyInWorldDisplacement() + getYOffset() - 320),width,height,null);
        }
        if (boss.intersects(handler.getEntityManager().getPlayer().getCollision())) {
            handler.getEntityManager().getPlayer().facing = "Left";
            State.setState(new FightState(handler, this, this.Area));
        }

    }

    @Override
    public Rectangle getCollision() {
        return boss;
    }
    
    public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public double getLvl() {
		return lvl;
	}

	public void setLvl(double lvl) {
		this.lvl = lvl;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getStr() {
		return str;
	}

	public void setStr(double str) {
		this.str = str;
	}

	public double getIntl() {
		return intl;
	}

	public void setIntl(double intl) {
		this.intl = intl;
	}

	public double getMr() {
		return mr;
	}

	public void setMr(double mr) {
		this.mr = mr;
	}

	public double getCons() {
		return cons;
	}

	public void setCons(double cons) {
		this.cons = cons;
	}

	public double getEvs() {
		return evs;
	}

	public void setEvs(double evs) {
		this.evs = evs;
	}

	public double getInitiative() {
		return initiative;
	}

	public void setInitiative(double initiative) {
		this.initiative = initiative;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public double getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(double maxMana) {
		this.maxMana = maxMana;
	}

}
