package main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileReader;

import org.json.JSONObject;
import input.WorldManager;
import resources.Animation;
import resources.Images;
import entities.Boss;
import entities.EnemyEntity;
import entities.EnemyOne;
import entities.EnemyTwo;
import entities.EntityManager;
import input.KeyManager;
import states.ConfState;



/**
 * Clase que manipula los elementos de la aplicación
 * @author Edgar Rubio
 *
 */

public class Handler {
	//Accede a tu entorno gráfico y devuelve la pantalla que estés usando, coge la altura
	//y anchura de tu pantalla para evitar problemas.
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int DEFAULTWIDTH = gd.getDisplayMode().getWidth();
	int DEFAULTHEIGHT = gd.getDisplayMode().getHeight();

	int width, height;
	ConfState confStateSave;

	private GameSetUp game;
	private EntityManager entityManager;
	private WorldManager worldManager;
	
	int xOverWorldDisplacement, yOverWorldDisplacement, xInWorldDisplacement, yInWorldDisplacement;
	
	private String Area="None";

	public Handler() {
		confStateSave = new ConfState(this);
    	if(confStateSave.getSave().exists()) {
    		this.loadSave();
    	}else {
		height = DEFAULTHEIGHT;
		width = DEFAULTWIDTH;
    	}
	}
/**
 * Método que carga la configuración de resolución guardada
 */
	private void loadSave() {
    	try (FileReader reader = new FileReader(confStateSave.getSave())) {
			StringBuilder builder = new StringBuilder();
			int temp;
			while ((temp = reader.read()) != -1)
				builder.append((char)temp);
			
			JSONObject object = new JSONObject(builder.toString());
			height = object.optInt("width", confStateSave.getWidthRes());
			width = object.optInt("height", confStateSave.getHeightRes());

		} catch (Exception ex) {
			System.out.println("Error");
		}
    }
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	public int getDEFAULTWIDTH() {
		return DEFAULTWIDTH;
	}


	public void setDEFAULTWIDTH(int dEFAULTWIDTH) {
		DEFAULTWIDTH = dEFAULTWIDTH;
	}


	public int getDEFAULTHEIGHT() {
		return DEFAULTHEIGHT;
	}


	public void setDEFAULTHEIGHT(int dEFAULTHEIGHT) {
		DEFAULTHEIGHT = dEFAULTHEIGHT;
	}


	public GameSetUp getGame() {
		return game;
	}

	public void setGame(GameSetUp game) {
		this.game = game;
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public WorldManager getWorldManager() {
		return worldManager;
	}
	public void setWorldManager(WorldManager worldManager) {
		this.worldManager = worldManager;
	}
	// para el movimiento por el mapa externo
	public void setXDisplacement(int xDis) {
		this.xOverWorldDisplacement = xDis;
	}

	public void setYDisplacement(int yDis) {
		this.yOverWorldDisplacement = yDis;
	}

	public int getXDisplacement() {
		return this.xOverWorldDisplacement;
	}

	public int getYDisplacement() {
		return this.yOverWorldDisplacement;
	}
	
	public int getxOverWorldDisplacement() {
		return xOverWorldDisplacement;
	}
	
	public void setxOverWorldDisplacement(int xOverWorldDisplacement) {
		this.xOverWorldDisplacement = xOverWorldDisplacement;
	}
	
	public int getyInWorldDisplacement() {
		return yInWorldDisplacement;
	}
	
	public void setyInWorldDisplacement(int yInWorldDisplacement) {
		this.yInWorldDisplacement = yInWorldDisplacement;
	}
	
	public int getyOverWorldDisplacement() {
		return yOverWorldDisplacement;
	}
	
	public void setyOverWorldDisplacement(int yOverWorldDisplacement) {
		this.yOverWorldDisplacement = yOverWorldDisplacement;
	}
	
	public int getxInWorldDisplacement() {
		return xInWorldDisplacement;
	}
	
	public void setxInWorldDisplacement(int xInWorldDisplacement) {
		this.xInWorldDisplacement = xInWorldDisplacement;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public String getArea() {
		return Area;
	}
	
	public void setArea(String area) {
		Area = area;
	}

	public EnemyEntity newEnemy(BufferedImage[] images,Handler handler, int xPosition, int yPosition, String state, String name, String area,
			String typeOfEnemy, double hp, double mana, double xp, double lvl, double str, double def,
			double intl, double mr, double cons, double evs, double initiative){
		if(typeOfEnemy.equals("EnemyOne")) {
			EnemyOne n = new EnemyOne(handler, xPosition, yPosition, state, name, area);
			n.setCons(cons);
			n.setDefense(def);
			n.setEvs(evs);
			n.setHealth(hp);
			n.setMaxHealth(hp);
			n.setInitiative(initiative);
			n.setIntl(intl);
			n.setMr(mr);
			n.setLvl(lvl);
			n.setMana(mana);
			n.setStr(str);
			n.setXp(xp);
			EnemyEntity.state = new Animation(150,Images.enemy1_idle);
			EnemyEntity.idle = new Animation(150,Images.enemy1_idle);
			EnemyEntity.attack = new Animation(150,Images.enemy1_attack);
			EnemyEntity.attacked = new Animation(150,Images.enemy1_attacked);
			EnemyEntity.defend = new Animation(150,Images.enemy1_defense);
			EnemyEntity.skill = new Animation(150,Images.enemy1_skill);
			EnemyEntity.heal = new Animation(150,Images.enemy1_heal);
			return n;
		}else if(typeOfEnemy.equals("EnemyTwo")){
			EnemyTwo n = new EnemyTwo(handler, yPosition, yPosition, state, name, area);
			n.setCons(cons);
			n.setDefense(def);
			n.setEvs(evs);
			n.setHealth(hp);
			n.setInitiative(initiative);
			n.setIntl(intl);
			n.setMr(mr);
			n.setLvl(lvl);
			n.setMana(mana);
			n.setStr(str);
			n.setXp(xp);
			EnemyEntity.state = new Animation(150,Images.enemy2_idle);
			EnemyEntity.idle = new Animation(150,Images.enemy2_idle);
			EnemyEntity.attack = new Animation(150,Images.enemy2_attack);
			EnemyEntity.attacked = new Animation(150,Images.enemy2_attacked);
			EnemyEntity.defend = new Animation(150,Images.enemy2_defense);
			EnemyEntity.skill = new Animation(150,Images.enemy2_skill);
			EnemyEntity.heal = new Animation(150,Images.enemy2_heal);
			return n;
		}else if(typeOfEnemy.equals("Boss")){
			Boss n = new Boss(handler, yPosition, yPosition, state, name, area);
			n.setCons(cons);
			n.setDefense(def);
			n.setEvs(evs);
			n.setHealth(hp);
			n.setInitiative(initiative);
			n.setIntl(intl);
			n.setMr(mr);
			n.setLvl(lvl);
			n.setMana(mana);
			n.setStr(str);
			n.setXp(xp);
			EnemyEntity.state = new Animation(150,Images.boss_idle);
			EnemyEntity.idle = new Animation(150,Images.boss_idle);
			EnemyEntity.attack = new Animation(150,Images.boss_attack);
			EnemyEntity.attacked = new Animation(150,Images.boss_attacked);
			EnemyEntity.defend = new Animation(150,Images.boss_defense);
			EnemyEntity.skill = new Animation(150,Images.boss_skill);
			EnemyEntity.heal = new Animation(150,Images.boss_heal);
			return n;
		}else{//default
			EnemyOne n = new EnemyOne(handler, xPosition, yPosition, state, name, area);
			n.setCons(cons);
			n.setDefense(def);
			n.setEvs(evs);
			n.setHealth(hp);
			n.setMaxHealth(hp);
			n.setInitiative(initiative);
			n.setIntl(intl);
			n.setMr(mr);
			n.setLvl(lvl);
			n.setMana(mana);
			n.setStr(str);
			n.setXp(xp);
			return n;
		}
	}
	
}