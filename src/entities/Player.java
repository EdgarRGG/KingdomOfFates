package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileReader;

import org.json.JSONObject;

import walls.InWorldWalls;
import inWorldAreas.CastleArea;
import inWorldAreas.CaveArea;
import input.WorldManager;
import main.GameSetUp;
import main.Handler;
import resources.Animation;
import resources.Images;
import states.ConfState;
import states.InWorldState;
import states.State;
import walls.OverWorldWalls;
/**
 * Clase del jugador principal
 * @author Edgar Rubio
 *
 */
public class Player extends LivingEntity {

	private Rectangle playerRec;
	private boolean canMove;
	public static boolean inWorld;
	public static boolean inArea;
	public static double oldx,oldy;
	private double volume;
	ConfState confState;
	ConfState confStateSave;

	//alturas y anchuras para las diferentes posiciones en el mapa principal y en los mapas internos
	public static final int InMapWidthFrontAndBack = 15 * 3, InMapHeightFront = 27 * 3, InMapHeightBack = 23 * 3,
			InMapWidthSideways = 13 * 3, InMapHeightSideways = 22 * 3,
			InAreaWidthFrontAndBack = 15 * 5, InAreaHeightFront = 27 * 5, InAreaHeightBack = 23 * 5,
			InAreaWidthSideways = 13 * 5, InAreaHeightSideways = 22 * 5;
	//Estadísticas del personaje
	double health = 250, mana = 100, xp = 0, lvl = 1, defense = 16, str = 10, intl = 25, mr = 12, cons = 20, acc = 12, evs = 4,
			initiative = 13, maxHealth = 250, maxMana = 100, lvlUpExp = 175;

	String skill = "Deadly Dance";

	private int currentWidth, currentHeight, playerWidth, playerHeight;
	private int switchingCoolDown = 0;

	// animaciones
	private Animation animDown, animUp, animLeft, animRight;
	private int animWalkingSpeed = 50;

	public Player(Handler handler, int xPosition, int yPosition) {
		super(handler, yPosition, yPosition, null);

		this.xPosition = xPosition;
		this.yPosition = yPosition;

		currentWidth = InMapWidthFrontAndBack;
		currentHeight = InMapHeightFront;
		playerWidth = 150;//original 100
		playerHeight = 150;//original 120

		animDown = new Animation(animWalkingSpeed, Images.player_front);
		animLeft = new Animation(animWalkingSpeed, Images.player_left);
		animRight = new Animation(animWalkingSpeed, Images.player_right);
		animUp = new Animation(animWalkingSpeed, Images.player_back);

		speed = 15;
		playerRec = new Rectangle();
		confState = new ConfState(handler);
		confStateSave = new ConfState(handler);

	}

	@Override
	public void tick() {
		//Si no está cargando controlamos el subir de nivel
		if (!GameSetUp.LOADING) {
			levelUP();
			// recargamos animaciones
			animDown.tick();
			animUp.tick();
			animRight.tick();
			animLeft.tick();
			oldx = handler.getxInWorldDisplacement();
			oldy = handler.getyInWorldDisplacement();
			// controlamos los rectangulos de movimiento
			UpdateNextRec();
			//controlamos el movimiento
			PlayerMove();

			if (GameSetUp.SWITCHING) {
				switchingCoolDown++;
			}
			if (switchingCoolDown >= 30) {
				GameSetUp.SWITCHING = false;
				switchingCoolDown = 0;

			}
			
			if (State.getState().equals(handler.getGame().inWorldState)) {
				inWorld = true;
			} else {
				inWorld = false;
			}

		}

		if(handler.getKeyManager().debugCollisions) {
			handler.getGame().DEBUGMODE = true;
		}else {
			handler.getGame().DEBUGMODE = false;
		}
	}


	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(
				getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.player_front, Images.player_back,
						Images.player_left, Images.player_right),
				(int) xPosition, (int) yPosition, playerWidth, playerHeight, null);

		playerRec = new Rectangle((int) xPosition, (int) yPosition+(currentHeight/2)+5, playerWidth/2-5, playerHeight/2-20);

		//Si está activado el debug muestra las colisiones y el cuadrado de colisión
		if (GameSetUp.DEBUGMODE) {
			g2.draw(nextArea);
			g2.draw(getCollision());
		}
	}
/**
 * Método que crea un rectangulo delante del jugador para cada movimiento
 */
	private void UpdateNextRec() {
		switch (facing) {
		case "Up":
			nextArea = new Rectangle( playerRec.x, playerRec.y - speed, playerRec.width, speed);
			break;
		case "Down":
			nextArea = new Rectangle(playerRec.x , playerRec.y+playerRec.height-20 , playerRec.width, speed);

			break;
		case "Left":
			nextArea = new Rectangle(playerRec.x - speed, playerRec.y, speed, playerRec.height);

			break;
		case "Right":
			nextArea = new Rectangle(playerRec.x + playerRec.width, playerRec.y, speed, playerRec.height);

			break;
		}
	}
/**
 * Método que controla el movimiento del jugador
 */
	private void PlayerMove() {

		canMove = true;
		
			if(GameSetUp.DEBUGMODE){
				speed = 18;
			}else{
				speed = 8;
			}
		
		//Comprobamos las colisiones
		CheckForWalls();
			//hacia abajo es Y negativa
			//hacia arriba es y positiva
			//hacia la derecha es x negativa
			//hacia la izquierda es x positiva
		if (handler.getKeyManager().down & canMove) {
			Move(false, -speed);
			facing = "Down";
		} else if (handler.getKeyManager().up & canMove) {
			Move(false, speed);
			facing = "Up";
		} else if (handler.getKeyManager().right & canMove) {
			Move(true, -speed);
			facing = "Right";
		} else if (handler.getKeyManager().left & canMove) {
			Move(true, speed);
			facing = "Left";
		} else {
			isMoving = false;
		}

	}
	
	/**
	 *
	 * @param X o Y  true es X y false es Y
	 * @param speed velocidad de movimiento
	 */
	private void Move(boolean XorY, int speed) {

		isMoving = true;
		//movimiento mapa principal
		if(!inWorld) {
			//Si se mueve en las X
			if (XorY) {
				setWidthAndHeight(InMapWidthSideways, InMapHeightSideways);
				handler.setXDisplacement(handler.getXDisplacement() + speed);
			} 
			//Si se mueve en las Y
			else {
				if (facing.equals("Up")) {
					setWidthAndHeight(InMapWidthFrontAndBack, InMapHeightBack);
				} else {
					setWidthAndHeight(InMapWidthFrontAndBack, InMapHeightFront);
				}
				handler.setYDisplacement(handler.getYDisplacement() + speed);
			}
			//movimiento mapas internos
		}else {
			//Si se mueve en las X
			if (XorY) {
				setWidthAndHeight(InAreaWidthSideways, InAreaHeightSideways);
				handler.setxInWorldDisplacement((handler.getxInWorldDisplacement() + speed));
			}
			//Si se mueve en las Y
			else {
				if (facing.equals("Up")) {
					setWidthAndHeight(InAreaWidthFrontAndBack, InAreaHeightBack);
				} else {
					setWidthAndHeight(InAreaWidthFrontAndBack, InAreaHeightFront);
				}

				handler.setyInWorldDisplacement(handler.getyInWorldDisplacement() + speed);
			}
		}
	}
	
	
	
/**
 * Método que mueve al jugador hacia atrás 
 */
	public void PushPlayerBack() {

		canMove = false;
		switch (facing) {
		case "Down":
			Move(false, 1);
			break;
		case "Up":
			Move(false, -1);
			break;
		case "Right":
			Move(true, 1);
			break;
		case "Left":
			Move(true, -1);
			break;
		}
	}
/**
 * Método que comprueba las colisiones del jugador con el entorno
 */
	private void CheckForWalls() {
		if(!inWorld) {
			for (OverWorldWalls w : handler.getWorldManager().getWalls()) {
				//Si el rectangulo colisiona con un muro
				if (nextArea.intersects(w)) {
					//Si es tipo "Wall" movemos al jugador hacia atrás
					if (w.getType().equals("Wall")) {
						PushPlayerBack();
					}
	
					else if (w.getType().startsWith("Door")) {
						canMove = true;
						}
					//Colisionamos con la entrada de la aldea
						if (w.getType().equals("Door Town")) {
							//Si ya hemos entrado en la aldea no permitimos la entrada de nuevo
							if(WorldManager.townEntered) {
								PushPlayerBack();
							}else {
							GameSetUp.LOADING = true;
							handler.getGame().getMusicHandler().set_changeMusic("res/music/Town.mp3");
							handler.getGame().getMusicHandler().play();
							if(confState.save.exists()) {
								this.loadSave();
								handler.getGame().getMusicHandler().setVolume(volume);
							}else {
							handler.getGame().getMusicHandler().setVolume(0.2);
							}
							handler.getGame().getMusicHandler().setLoop(true);
	
							State.setState(handler.getGame().townState);
							}
						}
						//Si colisionamos con la entrada de la cueva
						if (w.getType().equals("Door Cave")) {
							//Si no hemos entrado en la aldea no permitimos la entrada
							if(!WorldManager.townEntered) {
								PushPlayerBack();
							}else {
								inWorld = true;
								//guardamos unas coodernadas antiguas
								InWorldState.caveArea.oldPlayerXCoord = (int) (handler.getXDisplacement());
								InWorldState.caveArea.oldPlayerYCoord = (int) (handler.getYDisplacement());
								CaveArea.InCave = true;
								setWidthAndHeight(InAreaWidthFrontAndBack, InAreaHeightFront);
								setPlayerHeight(250);
								setPlayerWidth(250);
								//colocamos al jugador en unas coordenadas determinadas
								handler.setxInWorldDisplacement(CaveArea.playerXSpawn);
								handler.setyInWorldDisplacement(CaveArea.playerYSpawn);
								GameSetUp.LOADING = true;
								handler.setArea("Cave");
	
								handler.getGame().getMusicHandler().set_changeMusic("res/music/Cave.mp3");
								handler.getGame().getMusicHandler().play();
								if(confState.save.exists()) {
									this.loadSave();
									handler.getGame().getMusicHandler().setVolume(volume);
								}else {
									handler.getGame().getMusicHandler().setVolume(0.2);
								}
								handler.getGame().getMusicHandler().setLoop(true);
	
								State.setState(handler.getGame().inWorldState.setArea(InWorldState.caveArea));
							}
						}
						//Si colisionamos con la entrada del castillo
						if (w.getType().equals("Door Castle")) {
							//Si no hemos entrado en la aldea no permitimos la entrada
							if(!WorldManager.townEntered) {
								PushPlayerBack();
							}
							else {
								inWorld = true;
								//guardamos unas coodernadas antiguas
								InWorldState.castleArea.oldPlayerXCoord = (int) (handler.getXDisplacement());
								InWorldState.castleArea.oldPlayerYCoord = (int) (handler.getYDisplacement());
								CastleArea.InCastle = true;
								setWidthAndHeight(InAreaWidthFrontAndBack, InAreaHeightFront);
								setPlayerHeight(250);
								setPlayerWidth(250);
								//colocamos al jugador en unas coordenadas determinadas
								handler.setxInWorldDisplacement(CastleArea.playerXSpawn);
								handler.setyInWorldDisplacement(CastleArea.playerYSpawn);
								GameSetUp.LOADING = true;
								handler.setArea("Castle");
	
								handler.getGame().getMusicHandler().set_changeMusic("res/music/Castle.mp3");
								handler.getGame().getMusicHandler().play();
								if(confState.save.exists()) {
									this.loadSave();
									handler.getGame().getMusicHandler().setVolume(volume);
								}else {
									handler.getGame().getMusicHandler().setVolume(0.2);
								}
								handler.getGame().getMusicHandler().setLoop(true);
	
								State.setState(handler.getGame().inWorldState.setArea(InWorldState.castleArea));
							}
						}
					}
				}
			}
		 else{
			 	//Si estamos en la cueva
				if (CaveArea.InCave) {
					for (InWorldWalls iw : CaveArea.caveWalls) {
						if (nextArea.intersects(iw)) {
							if (iw.getType().equals("Wall"))
								PushPlayerBack();
							else {
								//Si colisiona con la salida del principio o la del final
								if (iw.getType().equals("End Exit")||iw.getType().equals("Start Exit")) {
									handler.setXDisplacement(-1000);
									handler.setYDisplacement(-340); 
									GameSetUp.LOADING = true;
									handler.setArea("None");

									handler.getGame().getMusicHandler().set_changeMusic("res/music/Overworld.mp3");
									handler.getGame().getMusicHandler().play();
									if(confState.save.exists()) {
										this.loadSave();
										handler.getGame().getMusicHandler().setVolume(volume);
									}else {
										handler.getGame().getMusicHandler().setVolume(0.2);
									}
									handler.getGame().getMusicHandler().setLoop(true);

									State.setState(handler.getGame().overWorldState);
									CaveArea.InCave = false;
									inWorld = false;
									setWidthAndHeight(InMapWidthFrontAndBack, InMapHeightFront);
									setPlayerHeight(150);
									setPlayerWidth(150);	
									facing = "Down";
									EnemyOne.lvl = lvl;
									EnemyTwo.lvl = lvl;
									
								}
							}
						}
					}
				}
				//Si estamos en el castillo
				if (CastleArea.InCastle) {
					for (InWorldWalls iw : CastleArea.castleWalls) {
						if (nextArea.intersects(iw)) {
							if (iw.getType().equals("Wall"))
								PushPlayerBack();
							else {
								//Si colisiona con la salida
								if (iw.getType().equals("Exit")) {
									handler.setXDisplacement(-400);
									handler.setYDisplacement(150); 
									GameSetUp.LOADING = true;
									handler.setArea("None");

									handler.getGame().getMusicHandler().set_changeMusic("res/music/Overworld.mp3");
									handler.getGame().getMusicHandler().play();
									if(confState.save.exists()) {
										this.loadSave();
										handler.getGame().getMusicHandler().setVolume(volume);
									}else {
										handler.getGame().getMusicHandler().setVolume(0.2);
									}
									handler.getGame().getMusicHandler().setLoop(true);

									State.setState(handler.getGame().overWorldState);
									CastleArea.InCastle = false;
									inWorld = false;
									setWidthAndHeight(InMapWidthFrontAndBack, InMapHeightFront);
									setPlayerHeight(150);
									setPlayerWidth(150);
									EnemyOne.lvl = lvl;
									EnemyTwo.lvl = lvl;
									
								}
							}
						}
					}
				}
			}
		}
	
	/**
     * Método que carga la configuración guardada
     */
    private void loadSave() {
    	try (FileReader reader = new FileReader(confStateSave.getSave())) {
			StringBuilder builder = new StringBuilder();
			int temp;
			while ((temp = reader.read()) != -1)
				builder.append((char)temp);
			
			JSONObject object = new JSONObject(builder.toString());
			volume = object.optDouble("volumen", confStateSave.getVolume());

		} catch (Exception ex) {
			System.out.println("Error");
		}
    }

	public void addXp(double xp) {
		this.xp += xp;
	}
	
	public double getLvlUpXp() {
		return lvlUpExp;
	}
	/**
	 * Método que sube de nivel	
	 */
	private void levelUP() {
		if(xp >= lvlUpExp) {
			xp-= lvlUpExp;
			lvlUpExp *= 1.3;
			maxHealth += 15 + 5*(lvl-1);
			maxMana += 5 + 5*(lvl-1);
			health = maxHealth;
			mana = maxMana;
			str += 1 + 1 *(int)((lvl - 1)/2);
			acc += 1 + 1 *(int)((lvl - 1)/2);
			defense += 1 + 1 *(int)((lvl - 1)/2);
			intl += 1 + 1 *(int)((lvl - 1)/2);
			mr += 1 + 1 *(int)((lvl - 1)/2);
			cons += 1 + 1 *(int)((lvl - 1)/2);
			if(lvl%4 ==0)
				evs++;

			lvl++;


		}

	}
	
	public BufferedImage getIdle() {
		return Images.player_right[0];
	}

	@Override
	public Rectangle getCollision() {
		return playerRec;
	}


	/*
	 * Aunque la posición del jugador es en medio del mapa, usamos estos dos métodos 
	 * para considerar al jugador como parte del mundo
	 */
	@Override
	public double getXOffset() {

		if (!inWorld)
			return -this.handler.getXDisplacement() + xPosition;
		else
			return -this.handler.getxInWorldDisplacement() + xPosition;
	}

	@Override
	public double getYOffset() {

		if (!inWorld)
			return -this.handler.getYDisplacement() + yPosition;
		else
			return -this.handler.getyInWorldDisplacement() + yPosition;
	}

	public void setWidthAndHeight(int newWidth, int newHeight) {
		this.currentWidth = newWidth;
		this.currentHeight = newHeight;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public double getMaxMana() {
		return maxMana;
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
		return this.str;
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

	public double getAcc() {
		return this.acc;
	}

	public void setAcc(double acc) {
		this.acc = acc;
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

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getPlayerWidth() {
		return playerWidth;
	}

	public void setPlayerWidth(int playerWidth) {
		this.playerWidth = playerWidth;
	}

	public int getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(int playerHeight) {
		this.playerHeight = playerHeight;
	}

}
