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
 * Segundo tipo de enemigo
 * @author Edgar Rubio
 *
 */
public class EnemyTwo extends EnemyEntity{

    Rectangle enemyTwo;
    int width, height;
    
    private Animation animDown, animUp, animLeft, animRight;
	private int animWalkingSpeed = 50;
	public static double lvl = 1;
	
	double health=125,mana=35,xp=100,defense=15,str=9,intl=22, mr = 13,cons=20,acc=10,evs=2,initiative=10, maxHealth = 125, maxMana = 35;

    public EnemyTwo(Handler handler, int xPosition, int yPosition, String state, String name, String area) {
        super(handler, yPosition, yPosition,state,name,area,null);
        width = 250;
        height = 250;
        speed = 2;
        type="EnemyTwo";
        this.setXOffset(xPosition);
        this.setYOffset(yPosition);

        animDown = new Animation(animWalkingSpeed, Images.enemy2_front);
		animLeft = new Animation(animWalkingSpeed, Images.enemy2_left);
		animRight = new Animation(animWalkingSpeed, Images.enemy2_right);
		animUp = new Animation(animWalkingSpeed, Images.enemy2_back);
        
        this.foundState = state;
        enemyTwo = new Rectangle();
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
           
            enemyTwo = new Rectangle((int) (handler.getxInWorldDisplacement() + getXOffset()),
                    (int) (handler.getyInWorldDisplacement() + getYOffset()), 70, 70);

            
            g2.setColor(Color.black);

            g.drawImage(getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.enemy2_front, Images.enemy2_back,
					Images.enemy2_left, Images.enemy2_right),enemyTwo.x,enemyTwo.y,width,height,null);
        }
        if (enemyTwo.intersects(handler.getEntityManager().getPlayer().getCollision())) {
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
        return enemyTwo;
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
