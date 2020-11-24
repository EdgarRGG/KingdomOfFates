package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import states.InWorldState;
import walls.InWorldWalls;
import main.GameSetUp;
import main.Handler;
import resources.Animation;
/**
 * Clase que controla las entidades enemigas 
 * @author Edgar Rubio
 *
 */
public class EnemyEntity extends LivingEntity{

	private Random rand;
	private boolean chasingPlayer;
	private Rectangle detector;

	private int count;
	private int enemyDirection;
	double chaseSpeed = 1;
	boolean canMove = true;
	public String foundState;
	public String name="Enemy";
	public String Area;
    public String type; 
    public static Animation state;
    public static Animation idle;
    public static Animation attack;
    public static Animation attacked;
    public static Animation defend;
    public static Animation skill;
    public static Animation heal;
    
    double health=100,mana=25,xp=0l,lvl=1,defense=12,str=8,intl=20, mr = 10,cons=20,acc=10,evs=2,initiative=10, maxHealth = 100, maxMana = 25;
    public double getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(double maxMana) {
		this.maxMana = maxMana;
	}

	boolean isDead = false;

	public EnemyEntity(Handler handler, int xPosition, int yPosition, String state,String name,String area, BufferedImage[] animFrames) {
		super(handler, xPosition, yPosition,animFrames);
		this.foundState = state;
		chasingPlayer = false;
		Area=area;
		count = 0;
		enemyDirection = 4;
		this.name = name;
		nextArea = new Rectangle();
		rand = new Random();
		detector = new Rectangle();

	}

	@Override
	public void tick() {
			super.tick();
			//Si se encuentra en el area prepara el cuadrado de colisión y mira si ha colisionado con algo
			if(handler.getArea().equals(this.Area)) {
	            UpdateNextRec();
	            CheckCollision();
	
	            //si se puede mover genera aleatoriamente un número para moverse en las posibles direcciones o quedarse quieto 
	            if (canMove) {
	                count++;
	                if (count >= 100 + rand.nextInt(350)) {
	                	//0: quieto, 1: abajo, 2: arriba, 3: izquierda, 4: derecha
	                	enemyDirection = rand.nextInt(5);
	
	                    count = 0;
	                }
	                //detecta si el jugador ha entrado en su area
	                PlayerDetector();
	                //Si el jugador no ha entrado en su area se mueve libremente y si ha entrado lo persigue
	                if (!chasingPlayer) {
	                    Move();
	                } else {
	                    Chase();
	                }
	            }
	            canMove = true;
	        }
	}
/**
 * Método que controla las colisiones de los enemigos con el mapa interno
 */
    private void CheckCollision() {
    	//Si nos encontramos en los mapas internos
    	if(foundState.equals("InWorldState")){
            for(InWorldWalls w:InWorldState.currentArea.getWalls()){
            	//Si el enemigo colisiona con un muro se deja de mover y cambia su dirección aleatoriamente
                if(w.intersects(nextArea)) {
                    canMove = false;
                    switch (enemyDirection) {
                        case 1://abajo
                            this.setYOffset(this.getYOffset() - speed);
                            break;
                        case 2://arriba
                            this.setYOffset(this.getYOffset() + speed);
                            break;

                        case 3://izquierda
                            this.setXOffset(this.getXOffset() + speed);
                            break;

                        case 4://derecha
                            this.setXOffset(this.getXOffset() - speed);
                            break;
                    }
                }
            }
        }
    }
/**
 * Método que controla si se encuentra los mapas internos y crea un rectángulo de colisión para los enemigos.
 */
    private void UpdateNextRec() {
		if(foundState.equals("InWorldState")){
			switch (facing) {
				case "Up":
					nextArea = new Rectangle((int) getXOffset() + handler.getxInWorldDisplacement() + 100, (int) getYOffset() + handler.getyInWorldDisplacement() + 50, getCollision().width, getCollision().height / 2);

					break;
				case "Down":
					nextArea = new Rectangle((int) getXOffset() + handler.getxInWorldDisplacement() + 100 , (int) getYOffset() + handler.getyInWorldDisplacement() + getCollision().height + 120, getCollision().width, 10);

					break;
				case "Left":
					nextArea = new Rectangle((int) getXOffset() + handler.getxInWorldDisplacement() + 70, (int) getYOffset() + handler.getyInWorldDisplacement() + 100, 10, getCollision().height);

					break;
				case "Right":
					nextArea = new Rectangle((int) getXOffset() + handler.getxInWorldDisplacement() + getCollision().width + 100, (int) getYOffset() + handler.getyInWorldDisplacement() + 70, 10, getCollision().height);

					break;
			}
		}
	}
/**
 * Método que crea un rectangulo para detectar al jugador si entra dentro
 */
	private void PlayerDetector() {

		detector = this.getCollision();

		detector.setRect(detector.getX() - detector.getWidth() * 4.5, detector.getY() - detector.getHeight() * 4.5,
				detector.getWidth() * 10, detector.getHeight() * 10);
		//true si entra dentro del detector
		chasingPlayer = handler.getEntityManager().getPlayer().getCollision().intersects(detector);
		
		chaseSpeed = 5;
	}

	@Override
	public void render(Graphics g) {
		if (GameSetUp.DEBUGMODE) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(detector);
			g2.draw(nextArea);
		}

	}
/**
 * Método que mueve al enemigo hacia el jugador
 */
	protected void Chase() {
		isMoving = true;
		//Si la x del jugador + la anchura de su colision entre 2 es mayor a la x de la entidad enemiga y la entidad se puede mover, se moverá persiguiendo hacia la derecha
		if (this.handler.getEntityManager().getPlayer().getXOffset()+(handler.getEntityManager().getPlayer().getCollision().width/2) > this.getXOffset() && canMove) {
			facing = "Right";
			this.setXOffset(this.getXOffset() + chaseSpeed);
		}
		//Si la x del jugador + la anchura de su colision entre 2 es menor a la x de la entidad enemiga y la entidad se puede mover, se moverá persiguiendo hacia la izquierda
		if (this.handler.getEntityManager().getPlayer().getXOffset()+(handler.getEntityManager().getPlayer().getCollision().width/2) < this.getXOffset() && canMove) {
			facing = "Left";
			this.setXOffset(this.getXOffset() - chaseSpeed);
		}
		//Si la y del jugador + la altura de su colision es menor a la y de la entidad enemiga y la entidad se puede mover, se moverá persiguiendo hacia arriba
		if (this.handler.getEntityManager().getPlayer().getYOffset()+(handler.getEntityManager().getPlayer().getCollision().height) < this.getYOffset() && canMove) {
			facing = "Up";
			this.setYOffset(this.getYOffset() - chaseSpeed);
		}
		//Si la y del jugador + la altura de su colision es mayor a la y de la entidad enemiga y la entidad se puede mover, se moverá persiguiendo hacia abajo
		if (this.handler.getEntityManager().getPlayer().getYOffset()+(handler.getEntityManager().getPlayer().getCollision().height) > this.getYOffset() && canMove) {
			facing = "Down";
			this.setYOffset(this.getYOffset() + chaseSpeed);
		}

	}
/**
 * Método que mueve al enemigo dependiendo de su dirección
 */
	private void Move() {
		
		switch (enemyDirection) {
			case 0: 
				isMoving = false;
				break;
			case 1:
				isMoving = true;
				facing = "Down";
				this.setYOffset(this.getYOffset() + speed);
				break;

			case 2:
				isMoving = true;
				facing = "Up";
				this.setYOffset(this.getYOffset() - speed);
				break;

			case 3:
				isMoving = true;
				facing = "Left";
				this.setXOffset(this.getXOffset() - speed);
				break;

			case 4:
				isMoving = true;
				facing = "Right";
				this.setXOffset(this.getXOffset() + speed);
				break;
		}
	}
/**
 * Método que ajusta las estadísticas en base al nivel	
 */
	public void lvlAdjust() {
		if(lvl > 1) {
			health += 10 + 5*(lvl-1);
			maxHealth = health;
			mana += 10 + 5*(lvl-1);
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
 
    public boolean isDead() {
    	return isDead;
    }
    
    public void kill() {
    	isDead = true;
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

	public double getAcc() {
		return acc;
	}

	public void setAcc(double acc) {
		this.acc = acc;
	}
	
    
}
