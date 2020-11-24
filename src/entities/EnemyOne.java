package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Handler;
import resources.Animation;
import resources.Images;
import states.FightState;
import states.State;
/**
 * Primer tipo de enemigo
 * @author Edgar Rubio
 *
 */
public class EnemyOne extends EnemyEntity{

    Rectangle enemyOne;
    int width, height;
    
    private Animation animDown, animUp, animLeft, animRight;
	private int animWalkingSpeed = 50;
	public static double lvl = 1;
	
	double health=100,mana=25,xp=75,defense=12,str=8,intl=20, mr = 10,cons=20,acc=10,evs=2,initiative=10, maxHealth = 100, maxMana =25;

    public EnemyOne(Handler handler, int xPosition, int yPosition, String state, String name, String area) {
        super(handler, yPosition, yPosition,state,name,area,null);
        width = 250;
        height = 250;
        speed = 1;
        type="EnemyOne";
        this.setXOffset(xPosition);
        this.setYOffset(yPosition);

        animDown = new Animation(animWalkingSpeed, Images.enemy1_front);
		animLeft = new Animation(animWalkingSpeed, Images.enemy1_left);
		animRight = new Animation(animWalkingSpeed, Images.enemy1_right);
		animUp = new Animation(animWalkingSpeed, Images.enemy1_back);
        
        this.foundState = state;
        enemyOne = new Rectangle();
    }

    @Override
    public void tick() {
    	super.tick();
        // recargamos animaciones
       	animDown.tick();
      	animUp.tick();
       	animRight.tick();
       	animLeft.tick();
        

    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        Graphics2D g2 = (Graphics2D) g;


        if(handler.getArea().equals(this.Area)) {
           
            enemyOne = new Rectangle((int) (handler.getxInWorldDisplacement() + getXOffset()),
                    (int) (handler.getyInWorldDisplacement() + getYOffset()), 70, 70);

            
            g2.setColor(Color.black);

            g.drawImage(getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.enemy1_front, Images.enemy1_back,
					Images.enemy1_left, Images.enemy1_right),enemyOne.x,enemyOne.y,width,height,null);
        }
        if (enemyOne.intersects(handler.getEntityManager().getPlayer().getCollision())) {
            handler.getEntityManager().getPlayer().facing = "Left";
            State.setState(new FightState(handler, this, this.Area));
        }

    }
    /**
     * Método que ajusta las estadísticas en base al nivel	
     */   
    public void lvlAdjust() {
		if(lvl > 1) {
			health += 10 + 5*(lvl-1);
			mana += 10 + 5*(lvl-1);
			maxMana = mana;
			maxHealth = health;	
			if(mana > 100)
				mana = 100;
			str += 1 + 1 *(int)((lvl - 1)/2);
			acc += 1 + 1 *(int)((lvl - 1)/2);
			defense += 1 + 1 *(int)((lvl - 1)/2);
			intl += 1 + 1 *(int)((lvl - 1)/2);
			mr += 1 + 1 *(int)((lvl - 1)/2);
			cons += 1 + 1 *(int)((lvl - 1)/2);
			if(lvl%4 ==0)
				evs += (lvl -lvl%4)/4;
			xp += 20 *(lvl);
		}
	}
    

    @Override
    public Rectangle getCollision() {
        return enemyOne;
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
