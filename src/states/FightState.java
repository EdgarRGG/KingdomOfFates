package states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Random;

import org.json.JSONObject;

import entities.Boss;
import entities.EnemyEntity;
import entities.Player;
import main.GameSetUp;
import main.Handler;
import resources.Animation;
import resources.ClickListlener;
import resources.Images;
import resources.UIImageButton;
import resources.UIManager;
import ui.Selector;
/**
 * Clase que controla toda la batalla entre jugador y enemigos
 * @author Edgar Rubio
 *
 */
public class FightState extends InWorldState{
	private UIManager uiManager;
	private int entityY;
	private ConfState confState;
	private ConfState confStateSave;
	private double volume;

	EnemyEntity enemy;
	Rectangle enemyRect, playerRect;
	Selector selector = new Selector(this.handler);

	public int wordHeight = 150;
	public int stringSpeed = 40;

	private int optionSelect, inputCoolDown;
	private int[] entityInfoX;
	Image background;

	public int turn=0,numOfEnemies=1;
	private boolean attacking=false,defense=false,skill=false,endTurn=false,attacked=false,isDefense=false;


	private Animation playerSkill;
	private Animation playerDefenceMode;
	private Animation playerAttackMode;
	private Animation playerAttackedMode;
	private Animation playerIdle;
	private Animation playerState;

	private boolean Eattacking=false,Edefense=false,Eskill=false,Eheal=false,EendTurn=false,Eattacked=false,EisDefense=false,battleOver =false;

	private String dmg = "",Edmg = "";
	private double lvlUp = 0;

	private int alpha=0;

	private String prevState;

	private EnemyEntity inStateEnemy;
	private long eWait = 0;



	public FightState(Handler handler ,EnemyEntity enemy, String prevState) {
		super(handler);
		this.prevState=prevState;
		confState = new ConfState(handler);
		confStateSave = new ConfState(handler);
		entityY = (int) handler.getHeight() * 2/3;
		entityInfoX = new int[2];
		//player info square coordinate
		entityInfoX[0] = handler.getWidth() * 3/20;
		//enemy info square coordinate
		entityInfoX[1] = handler.getWidth() * 14/20 + 4;

		if(enemy.type.equals("Boss")) {
			handler.getGame().getMusicHandler().set_changeMusic("res/music/Boss.mp3");
			handler.getGame().getMusicHandler().play();
			if(confState.save.exists()) {
				this.loadSave();
				handler.getGame().getMusicHandler().setVolume(volume);
			}else {
				handler.getGame().getMusicHandler().setVolume(0.2);
			}
			handler.getGame().getMusicHandler().setLoop(true);
		}else {
			handler.getGame().getMusicHandler().set_changeMusic("res/music/Combat.mp3");
			handler.getGame().getMusicHandler().play();
			if(confState.save.exists()) {
				this.loadSave();
				handler.getGame().getMusicHandler().setVolume(volume);
			}else {
				handler.getGame().getMusicHandler().setVolume(0.2);
			}
			handler.getGame().getMusicHandler().setLoop(true);
		}

		inStateEnemy=enemy;

		this.enemy = (handler.newEnemy(enemy.frames,handler,handler.getWidth() * 4/ 5, entityY,enemy.foundState,enemy.name,enemy.Area,
				enemy.type,enemy.getHealth(),enemy.getMana(),enemy.getXp(),enemy.getLvl(),enemy.getStr(),enemy.getDefense(),
				enemy.getIntl(),enemy.getMr(),enemy.getCons(),enemy.getEvs(),enemy.getInitiative()));

		this.enemy.lvlAdjust();
		playerRect = new Rectangle( (int) handler.getWidth() / 5, entityY, 100, 100);

		enemyRect = new Rectangle((int) handler.getWidth() * 4/ 5 - 70,entityY - 80, 120, 160);


		setUiManager();
		backgroundSelect(prevState);

		optionSelect = 0;
		inputCoolDown = 0;
		dmg = "";
		lvlUp = handler.getEntityManager().getPlayer().getLvlUpXp();

		playerIdle = new Animation(150, Images.player_idle);
		playerAttackMode = new Animation(150, Images.player_attack);
		playerAttackedMode = new Animation(150, Images.player_attacked);
		playerDefenceMode = new Animation(150, Images.player_defense);
		playerState = new Animation(150, Images.player_idle);
		playerSkill = new Animation(150, Images.player_skill);


		chooseTurn();

	}
/**
 * Método que selecciona el turno en base a la iniciativa
 */
	private void chooseTurn() {
		if(handler.getEntityManager().getPlayer().getInitiative()>=enemy.getInitiative()){
			turn = 0;
		}else{
			turn = 1;
		}

	}

	@Override
	public void tick() {
		if(turn>numOfEnemies){
			turn=0;
		}
		
		playerState.tick();
		EnemyEntity.state.tick();
		selector.tick();

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
			handler.getGame().pauseState.lastState = State.getState();
			GameSetUp.SWITCHING=true;
			State.setState(handler.getGame().pauseState);
		}

		else {
			//si la vida del enemigo llega a 0
			if(!attacking&&!defense&&!skill&&turn>0&&enemy.getHealth()<=0&&!battleOver){
				battleOver=true;
				handler.getGame().getMusicHandler().set_changeMusic("res/music/Victory.mp3");
				handler.getGame().getMusicHandler().play();
				if(confState.save.exists()) {
					this.loadSave();
					handler.getGame().getMusicHandler().setVolume(volume);
				}else {
					handler.getGame().getMusicHandler().setVolume(0.2);
				}
				handler.getGame().getMusicHandler().setLoop(true);

			}
			//si la vida del jugador llega a 0
			if(!Eattacking&&!Edefense&&!Eskill&&turn==0&&handler.getEntityManager().getPlayer().getHealth()<=0&&!battleOver){
				battleOver=true;
			}
			if (!battleOver) {
				if (!attacking&&!defense&&!skill&&turn == 0) {
					PlayerInput();
					uiManager.tick();

				}else if(!Eattacking&&!Edefense&&!Eskill&&!Eheal&&turn > 0){
					if(System.currentTimeMillis() > eWait) {
						enemyTurn();
					}
				}

			}

		}

		if(handler.getKeyManager().debugCollisions) {
			handler.getGame().DEBUGMODE = !handler.getGame().DEBUGMODE;
		} 


	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		drawInfoSquare(g2);

		g.setFont(new Font("Song Of Coronos", Font.BOLD, 20));
		g2.setStroke(new BasicStroke(1));
		drawCharacterInfo(g2);

		drawEntities(g2);
		//Turno del jugador
		if (turn == 0) {
			if(skill && handler.getEntityManager().getPlayer().getMana()>=25){
				callSkill(g);
			}else if (attacking) {
				attack(g);
			} else if (defense) {
				defend(g);
			}
		}
		//Turno del enemigo
		else if (turn > 0){
			if(Eheal && enemy.getMana()>=25){				
				Eheal(g);				
			}else if(Eskill && enemy.getMana()>=25){
				EcallSkill(g);
			}else if(Eattacking){
				Eattack(g);
			}else if(Edefense){
				Edefend(g);
			}
		}

		if(battleOver){

			g2.setFont(new Font("IMPACT", 3, this.wordHeight));
			//Vida del jugador 0 
			if(handler.getEntityManager().getPlayer().getHealth()==0){
				g.setColor(new Color(0,0,0,alpha+=2));
				g.fillRect(0,0,handler.getWidth(),handler.getHeight());
				g2.setColor(Color.RED);
				g.drawString("DEFEAT!",handler.getWidth()/3 - 50,handler.getHeight()/2);

			}else{
				g.setColor(new Color(255,255,255,alpha+=1));
				g.fillRect(0,0,handler.getWidth(),handler.getHeight());
				g2.setColor(Color.GREEN);
				g.drawString("VICTORY!",handler.getWidth()/3 - 50,handler.getHeight()/2);
				g2.setFont(new Font("IMPACT", 3, this.wordHeight/3));
				g.drawString("Experience gained: " + (int) enemy.getXp(),handler.getWidth()/3 + 10,handler.getHeight()/2 + 70);
				//Si sube de nivel
				if(handler.getEntityManager().getPlayer().getXp() + enemy.getXp() >= lvlUp) {
					g2.setFont(new Font("IMPACT", 3, this.wordHeight/2));
					g.drawString("LEVEL UP!",handler.getWidth()/3 + 100,handler.getHeight()/2 + 155);
					g2.setFont(new Font("IMPACT", 3, this.wordHeight/3));
					g.drawString( handler.getEntityManager().getPlayer().getLvl() + "  -> " + (handler.getEntityManager().getPlayer().getLvl()+1),handler.getWidth()/3 + 150,handler.getHeight()/2 + 230);
				}
				if(enemy.type.equals("Boss")) {
					Boss.isDead = true;
				}
				enemy.kill();

				inStateEnemy.kill();
			}
			//Si he llegado al color blanco puro
			if(alpha>=254){
				//Vida jugador 0 reinicia el juego y cambio a game over
				if(handler.getEntityManager().getPlayer().getHealth()==0){

					handler.getGame().reStart();
					handler.getGame().getMusicHandler().set_changeMusic("res/music/GameOver.mp3");
					handler.getGame().getMusicHandler().play();
					if(confState.save.exists()) {
						this.loadSave();
						handler.getGame().getMusicHandler().setVolume(volume);
					}else {
						handler.getGame().getMusicHandler().setVolume(0.2);
					}
					handler.getGame().getMusicHandler().setLoop(true);
					State.setState(handler.getGame().gameOverState);
				}
					else {
						//Si el boss ha muerto pantalla de victoria
						if(Boss.isDead) {
							handler.getGame().getMusicHandler().set_changeMusic("res/music/Town.mp3");
							handler.getGame().getMusicHandler().play();
							if(confState.save.exists()) {
								this.loadSave();
								handler.getGame().getMusicHandler().setVolume(volume);
							}else {
								handler.getGame().getMusicHandler().setVolume(0.2);
							}
							handler.getGame().getMusicHandler().setLoop(true);
							State.setState(new WinningState(handler));
						}else {
						//recupera algo de vida
						handler.getEntityManager().getPlayer().setHealth((int)(handler.getEntityManager().getPlayer().getHealth()+ ((handler.getEntityManager().getPlayer().getMaxHealth() - 
								handler.getEntityManager().getPlayer().getHealth())* handler.getEntityManager().getPlayer().getCons()/100)));
						if(handler.getEntityManager().getPlayer().getHealth() > handler.getEntityManager().getPlayer().getMaxHealth())
							handler.getEntityManager().getPlayer().setHealth(handler.getEntityManager().getPlayer().getMaxHealth());
						//recupera algo de mana
						handler.getEntityManager().getPlayer().setMana((int)(handler.getEntityManager().getPlayer().getMana()+ ((handler.getEntityManager().getPlayer().getMaxMana() - 
								handler.getEntityManager().getPlayer().getMana())* handler.getEntityManager().getPlayer().getIntl()/100)));
						if(handler.getEntityManager().getPlayer().getMana() > handler.getEntityManager().getPlayer().getMaxMana())
							handler.getEntityManager().getPlayer().setMana(handler.getEntityManager().getPlayer().getMaxMana());
						//le da la experiencia
						handler.getEntityManager().getPlayer().addXp(enemy.getXp());
	
						//Si el state anterior es la cueva vuelve a la cueva, si no al castillo
						if(prevState.equals("Cave")){
							handler.setxInWorldDisplacement((int)Player.oldx);
							handler.setyInWorldDisplacement((int)Player.oldy);
							handler.setArea(InWorldState.currentArea.name);
							handler.getGame().getMusicHandler().set_changeMusic("res/music/Cave.mp3");
							handler.getGame().getMusicHandler().play();
							if(confState.save.exists()) {
								this.loadSave();
								handler.getGame().getMusicHandler().setVolume(volume);
							}else {
								handler.getGame().getMusicHandler().setVolume(0.2);
							}
							handler.getGame().getMusicHandler().setLoop(true);
	
							State.setState(handler.getGame().inWorldState);
						}else{
							handler.setxInWorldDisplacement((int)Player.oldx);
							handler.setyInWorldDisplacement((int)Player.oldy);
							handler.setArea(InWorldState.currentArea.name);
							handler.getGame().getMusicHandler().set_changeMusic("res/music/Castle.mp3");
							handler.getGame().getMusicHandler().play();
							if(confState.save.exists()) {
								this.loadSave();
								handler.getGame().getMusicHandler().setVolume(volume);
							}else {
								handler.getGame().getMusicHandler().setVolume(0.2);
							}
							handler.getGame().getMusicHandler().setLoop(true);
	
							State.setState(handler.getGame().inWorldState);
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
/**
 * Método que pinta las entidades
 * @param g2
 */
	private void drawEntities(Graphics2D g2) {

		g2.drawImage(playerState.getCurrentFrame(), playerRect.x - 400, playerRect.y -490, 600, 600, null);
		g2.setColor(Color.BLACK);
		if(enemy.type == "Boss") {
			g2.drawImage(EnemyEntity.state.getCurrentFrame(), enemyRect.x - 450, enemyRect.y - 800, 1200, 1200, null);
		}else {
			g2.drawImage(EnemyEntity.state.getCurrentFrame(), enemyRect.x - 110, enemyRect.y - 410, 600, 600, null);
		}
		
	}

/**
 * Método que muestra la información de las entidades en combate como su vida y su mana
 * @param g2
 */
	private void drawCharacterInfo(Graphics2D g2) {
		for(int i = 0; i < 2;i++) {
			//Si es el enemigo
			if(i==1) {
				g2.setFont(new Font("Song Of Coronos", Font.BOLD, 40));
				g2.drawString(enemy.name, entityInfoX[i] + 190, (handler.getHeight() * 4 / 5) - 55);

				g2.setFont(new Font("Bank Gothic", Font.BOLD, 22));
				//cambia de color dependiendo del porcentaje de vida
				if(enemy.getHealth()>=enemy.getMaxHealth() * 1/2){
					g2.setColor(Color.GREEN);
				}else if(enemy.getHealth()>= enemy.getMaxHealth() * 1/4){
					g2.setColor(Color.YELLOW);
				}else{
					g2.setColor(Color.RED);
				}
				//rectangulo de vida 
				g2.fillRect(entityInfoX[i] + 152, (handler.getHeight() * 4 / 5), (int)((handler.getWidth() * 2 / 20)*(enemy.getHealth()/enemy.getMaxHealth())), 23);
				g2.setColor(Color.WHITE);
				g2.drawRect(entityInfoX[i] + 152, (handler.getHeight() * 4 / 5), handler.getWidth() * 2 / 20 , 23);
				//vida dentro del rectangulo
				g2.drawString("Health: ", entityInfoX[i] + 152, (handler.getHeight() * 4 / 5) - 7);
				g2.drawString(String.valueOf(enemy.getHealth()), entityInfoX[i] + 225, (handler.getHeight() * 4 / 5) - 7);
				
				//rectangulo de mana
				g2.setColor(Color.BLUE);
				g2.fillRect(entityInfoX[i] + 152, (handler.getHeight() * 4 / 5) + 56, (int)((handler.getWidth() * 2 / 20)*(enemy.getMana()/enemy.getMaxMana())), 23);
				g2.setColor(Color.WHITE);
				g2.drawRect(entityInfoX[i] + 152, (handler.getHeight() * 4 / 5) + 56, handler.getWidth() * 2 / 20 , 23);
				//Mana dentro del rectángulo
				g2.drawString("Mana: ", entityInfoX[i] + 152, (handler.getHeight() * 4 / 5) + 50);
				g2.drawString(String.valueOf(enemy.getMana()), entityInfoX[i] + 215 , (handler.getHeight() * 4 / 5) + 50);

			//Si es el jugador
			}else{
				g2.setFont(new Font("Song Of Coronos", Font.BOLD, 40));
				g2.setColor(Color.WHITE);
				g2.drawString("Gareth ", entityInfoX[i] - 60, (handler.getHeight() * 4 / 5) - 50);

				g2.setFont(new Font("Bank Gothic", Font.BOLD, 22));
				//cambia de color dependiendo del porcentaje de vida
				if(handler.getEntityManager().getPlayer().getHealth()>= handler.getEntityManager().getPlayer().getMaxHealth() * 1/2){
					g2.setColor(Color.GREEN);
				}else if(handler.getEntityManager().getPlayer().getHealth()>=handler.getEntityManager().getPlayer().getMaxHealth() * 1/4){
					g2.setColor(Color.YELLOW);
				}else{
					g2.setColor(Color.RED);
				}
				//rectangulo de la vida
				g2.fillRect(entityInfoX[i] - 150, (handler.getHeight() * 4 / 5), (int)((handler.getWidth() * 2 / 20)*(handler.getEntityManager().getPlayer().getHealth()/handler.getEntityManager().getPlayer().getMaxHealth())), 23);
				g2.setColor(Color.WHITE);
				g2.drawRect(entityInfoX[i] - 150, (handler.getHeight() * 4 / 5), handler.getWidth() * 2 / 20 , 23);
				//vida dentro del rectángulo
				g2.drawString("Health: ", entityInfoX[i]- 150, (handler.getHeight() * 4 / 5) - 7);
				g2.drawString(String.valueOf(handler.getEntityManager().getPlayer().getHealth()), entityInfoX[i]- 78, (handler.getHeight() * 4 / 5) + -7);

				//rectangulo de mana
				g2.setColor(Color.BLUE);
				g2.fillRect(entityInfoX[i] - 150, (handler.getHeight() * 4 / 5) + 56, (int)((handler.getWidth() * 2 / 20)*(handler.getEntityManager().getPlayer().getMana()/handler.getEntityManager().getPlayer().getMaxMana()) ), 23);
				g2.setColor(Color.WHITE);
				g2.drawRect(entityInfoX[i] - 150, (handler.getHeight() * 4 / 5) + 56, handler.getWidth() * 2 / 20 , 23);
				//Mana dentro del rectángulo
				g2.drawString("Mana: ", entityInfoX[i] - 150, (handler.getHeight() * 4 / 5) + 50);
				g2.drawString(String.valueOf(handler.getEntityManager().getPlayer().getMana()), entityInfoX[i] - 87 , (handler.getHeight() * 4 / 5) + 50);

				g2.drawString("Skill: " + String.valueOf(handler.getEntityManager().getPlayer().getSkill()), entityInfoX[i] - 150, (handler.getHeight() * 4 / 5) + 100);
				g2.drawString("Mana Cost: " + "25 MP", entityInfoX[i] - 150, (handler.getHeight() * 4 / 5) + 125);
			}

		}
	}
/**
 * Método que pinta los rectángulos de información
 * @param g2
 */
	private void drawInfoSquare(Graphics2D g2) {

		g2.setBackground(new Color(61,68,128));
		g2.drawImage(background, 0, 0,handler.getWidth(),handler.getHeight(), null);
		g2.drawImage(Images.battleInterface,handler.getWidth()/2 - 890,handler.getHeight()/2 + 200,handler.getWidth() - 140, 300,null);
		
		uiManager.Render(g2);

	}

/**
 * Método que permite moverte entre las opciones con A y D
 */
	private void PlayerInput() {

		if(inputCoolDown <= 15){
			inputCoolDown++;
		}
		if (handler.getKeyManager().down || handler.getKeyManager().up) {}
		if (handler.getKeyManager().right && inputCoolDown > 15){
			//elegimos hacia la derecha
			if(!handler.getGame().getMusicHandler().getEPlayer().isEmpty()&&!handler.getGame().getMusicHandler().getEffect(0).equals(null)) {
				handler.getGame().getMusicHandler().stopEffect(0);
			}

			handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);

			if(optionSelect < uiManager.getObjects().size()-1 ) {
				optionSelect++;
				uiManager.getObjects().get(optionSelect - 1).setActive(false);
				inputCoolDown = 0;
			}
			if(optionSelect > uiManager.getObjects().size()-1){
				optionSelect = 0;
				uiManager.getObjects().get(optionSelect).setActive(false);
				inputCoolDown = 0;
			}

		}
		if (handler.getKeyManager().left && inputCoolDown > 15){
			//elegimos hacia la izquierda

			if(!handler.getGame().getMusicHandler().getEPlayer().isEmpty()&&!handler.getGame().getMusicHandler().getEffect(0).equals(null)) {
				handler.getGame().getMusicHandler().stopEffect(0);
			}

			handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);

			if(optionSelect > 0){
				optionSelect--;
				uiManager.getObjects().get(optionSelect + 1).setActive(false);
				inputCoolDown = 0;
			}
			if(optionSelect < 0){
				optionSelect = uiManager.getObjects().size()-1;
				uiManager.getObjects().get(optionSelect).setActive(false);
				inputCoolDown = 0;
			}

		}

		uiManager.getObjects().get(optionSelect).setActive(true);

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
			if(!handler.getGame().getMusicHandler().getEPlayer().isEmpty()&&!handler.getGame().getMusicHandler().getEffect(0).equals(null)) {
				handler.getGame().getMusicHandler().stopEffect(0);
			}
			handler.getGame().getMusicHandler().playEffect("res/music/enterSelect.wav",0);
			uiManager.getObjects().get(optionSelect).onClick();}

		eWait = System.currentTimeMillis() + 3500;

	}


	private void setUiManager() {
		uiManager = new UIManager(handler);

		//Attack
		uiManager.addObjects(new UIImageButton(handler.getWidth() * 22/60 - 160, 5*handler.getHeight()/6 - 30, 250, 80, Images.attack, new ClickListlener() {
			@Override
			public void onClick() {
				attacking=true;

			}
		}));

		//Defend
		uiManager.addObjects(new UIImageButton(handler.getWidth() * 30/60 - 130, 5*handler.getHeight()/6 - 30, 250, 80, Images.defend, new ClickListlener() {
			@Override
			public void onClick() {
				defense=true;
			}
		}));

		//Skills
		uiManager.addObjects(new UIImageButton(handler.getWidth() * 38/60 - 100, 5*handler.getHeight()/6 - 30, 250, 80, Images.skill, new ClickListlener() {
			@Override
			public void onClick() {
				if(handler.getEntityManager().getPlayer().getMana()>=25 && handler.getEntityManager().getPlayer().getSkill() != "none") {
					skill = true;
				} 

			}
		}));



	}


/**
 * Método que coloca una imagen de fondo dependiendo de donde se produzca la batalla
 * @param prev state anterior
 */
	private void backgroundSelect(String prev) {
		if(prev.equals("Castle")) {
			if(enemy.type.equals("Boss")) {
				background = Images.castleBackground;
				return;
			}
			background = Images.castleBackground;
		} else if (prev.equals("Cave"))
			background = Images.caveBackground;


	}
/**
 * Método de ataque del jugador
 * @param g
 */
	private void attack(Graphics g) {

		if(!playerAttackMode.end){
			playerAttackMode.tick();
			playerState = playerAttackMode;
		}
		else{
			playerState = playerIdle;
			
			int ev=(int)enemy.getEvs();
			int evade=new Random().nextInt(100);

			int atk = (int) handler.getEntityManager().getPlayer().getStr() * 3;
			for(int i = 0; i < 3;i++) {
				if(new Random().nextInt(20) <= (int)handler.getEntityManager().getPlayer().getAcc())
					atk+= (int) handler.getEntityManager().getPlayer().getStr();
			}
			//cantidad que recibirá el enemigo
			atk = (int) (atk* (1-(enemy.getDefense()/100))); 

			//Si no esquiva, no ha sido atacado y su vida es mayor o igual a 0 pierde la cantidad de daño recibido
			if(evade>ev &&!attacked && enemy.getHealth()-atk>=0) {
				enemy.setHealth(enemy.getHealth() - atk);
				attacked=true;
				dmg = String.valueOf(atk);
			//Si no esquiva, no ha sido atacado y su vida es menor que 0 su vida no baja de 0
			}else  if(evade>ev &&!attacked && enemy.getHealth()-atk <0){
				enemy.setHealth(0);
				attacked = true;
				dmg = String.valueOf(atk);
			//Si esquiva
			}else if( !(evade>ev) && !attacked)
				dmg = "";
			
			//Pintamos el daño 
			g.setColor(Color.RED);			
			if(enemy.type == "Boss") {
				g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
				g.drawString(dmg ,enemyRect.x + 90, enemyRect.y - 400);
			}else {
				g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
				g.drawString(dmg ,1600, 425);
			}
			
			if(!EnemyEntity.attacked.end) {
				EnemyEntity.attacked.tick();
				EnemyEntity.state = EnemyEntity.attacked;
			}
			else {
				attacking = false;
				endTurn = true;
				EnemyEntity.state = EnemyEntity.idle;
			}
			
			if (endTurn || battleOver) {
				//recuperamos algo de mana
				if(handler.getEntityManager().getPlayer().getMana() <= handler.getEntityManager().getPlayer().getMaxMana()- 5)
					handler.getEntityManager().getPlayer().setMana(handler.getEntityManager().getPlayer().getMana() + (int)(10 * (handler.getEntityManager().getPlayer().getIntl()/100)));
				attacking = false;
				endTurn = false;
				turn++;
				attacked = false;
				playerAttackMode.reset();
				EnemyEntity.attacked.reset();
				EnemyEntity.idle.reset();
				//Si el enemigo se estaba defendiendo devolvemos sus valores a normales
				if (EisDefense) {
					enemy.setDefense(enemy.getDefense() - 15);
					enemy.setMr(enemy.getMr()-4);
					EisDefense = false;
				}
			}

		}



	}
/**
 * Método de defensa del jugador
 * @param g
 */
	private void defend(Graphics g) {

		playerDefenceMode.tick();

		playerState = playerDefenceMode;

		isDefense = true;

		if(playerDefenceMode.getIndex()>=Images.player_defense.length-1){
			handler.getEntityManager().getPlayer().setDefense(handler.getEntityManager().getPlayer().getDefense()+15);
			handler.getEntityManager().getPlayer().setMr(handler.getEntityManager().getPlayer().getMr()+ 4);
			//recuperamos algo de mana
			if(handler.getEntityManager().getPlayer().getMana() <= handler.getEntityManager().getPlayer().getMaxMana()- 10)
				handler.getEntityManager().getPlayer().setMana(handler.getEntityManager().getPlayer().getMana() + (int)(10 * (handler.getEntityManager().getPlayer().getIntl()* 2/100)));
			defense=false;
			endTurn=false;
			turn++;
			playerDefenceMode.reset();
			playerState = playerIdle;
			if(EisDefense){
				enemy.setDefense(enemy.getDefense()-15);
				enemy.setMr(enemy.getMr()-4);
				EisDefense = false;
			}

		}


	}
/**
 * Método de habilidad del jugador
 * @param g
 */
	private void callSkill(Graphics g) {

		if(!playerSkill.end) {
			playerSkill.tick();
			playerState = playerSkill;
		}else {
			playerState = playerIdle;
			int ev=(int)enemy.getEvs();
			int evade=new Random().nextInt(125);
			int skillAtk = (int) handler.getEntityManager().getPlayer().getIntl() * 2; //raw skillAtk
	
			skillAtk = (int) (skillAtk*(1-(enemy.getMr()/100)));
	
			if(evade>ev &&!attacked && enemy.getHealth()-skillAtk>=0) {
				enemy.setHealth(enemy.getHealth() - skillAtk);
				attacked=true;
				dmg = String.valueOf(skillAtk);
			}else  if(evade>ev &&!attacked && enemy.getHealth()-skillAtk<0){
				enemy.setHealth(0);
				attacked = true;
				dmg = String.valueOf(skillAtk);
			}else if( !(evade>ev) && !attacked)
				dmg = "";
			
			g.setColor(Color.RED);
			if(enemy.type == "Boss") {
				g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
				g.drawString(dmg ,enemyRect.x + 90, enemyRect.y - 400);
			}else {
				g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
				g.drawString(dmg ,1600, 425);
			}
			
			if(!EnemyEntity.attacked.end) {
				EnemyEntity.attacked.tick();
				EnemyEntity.state = EnemyEntity.attacked;
			}
			else {
			endTurn=true;
			EnemyEntity.state = EnemyEntity.idle;
			}
	
			if(endTurn|| battleOver){
				attacked=false;
				skill=false;
				endTurn=false;
				turn++;
				playerSkill.reset();
				EnemyEntity.attacked.reset();
				handler.getEntityManager().getPlayer().setMana(handler.getEntityManager().getPlayer().getMana()-25);
				//Si el enemigo se ha defendido volvemos a poner los parámetros como estaban
				if(EisDefense){
					enemy.setDefense(enemy.getDefense()-15);
					enemy.setMr(enemy.getMr()-4);
					EisDefense = false;
				}
			}
		}
	}
/**
 * Método que controla como actúa el enemigo en su turno
 */
	private void enemyTurn() {  

		if(!Eskill&&!Edefense&&!Eattacking && enemy.getMana()>=25) {
			int choice = new Random().nextInt(5);
			switch (choice) {
			case 0:
				Eattacking = true;
				System.out.println("Attacked");
				break;
			case 1:
				Eattacking = true;
				System.out.println("Attacked");
				break;
			case 2:
				System.out.println("Defense");
				Edefense = true;
				break;
			case 3:
				System.out.println("Skill");
				if(enemy.type == "Boss") {
					double vida  = enemy.getHealth() + enemy.getMaxHealth()*0.1;
					if(vida < enemy.getMaxHealth()) {
						Eheal = true;	
					}else {
						Eskill = true;
					}
				}else {
					Eskill = true;
				}
				break;
			case 4:
				System.out.println("Skill");
					Eskill = true;				
				break;
			}
		}else  if(!Eskill&&!Edefense&&!Eattacking) {
			int choice = new Random().nextInt(3);
			switch (choice) {
			case 0:
				Eattacking = true;
				System.out.println("Attacked");
				break;
			case 1:
				Eattacking = true;
				System.out.println("Attacked");
				break;
			case 2:
				System.out.println("Defense");
				Edefense = true;
				break;
			}
		}
	}
/**
 * Método de ataque del enemigo
 * @param g
 */
	private void Eattack(Graphics g) {

		if(!EnemyEntity.attack.end){
			EnemyEntity.attack.tick();
			EnemyEntity.state = EnemyEntity.attack;
		}
		else {

			EnemyEntity.state = EnemyEntity.idle;

			int ev=(int)handler.getEntityManager().getPlayer().getEvs();
			int evade=new Random().nextInt(100);

			int atk = (int) enemy.getStr() * 3;
			for(int i = 0; i < 3;i++) {
				if(new Random().nextInt(20) <= (int)enemy.getAcc())
					atk+= (int) enemy.getStr();
			}

			atk = (int) (atk *(1- (handler.getEntityManager().getPlayer().getDefense()/100)));

			if(evade >ev &&!Eattacked && handler.getEntityManager().getPlayer().getHealth()-atk>=0) {
				handler.getEntityManager().getPlayer().setHealth(handler.getEntityManager().getPlayer().getHealth() - atk);
				Eattacked=true;
				Edmg = String.valueOf(atk);
			}else  if(evade>ev &&!Eattacked && handler.getEntityManager().getPlayer().getHealth()-atk<0){
				handler.getEntityManager().getPlayer().setHealth(0);
				Eattacked=true;
				Edmg = String.valueOf(atk);
			}else if( !(evade>ev) && !Eattacked)
				Edmg = "";

			g.setColor(Color.RED);
			g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
			g.drawString(Edmg , playerRect.x - 160, playerRect.y - 300);

			if(!playerAttackedMode.end) {
				playerAttackedMode.tick();
				playerState = playerAttackedMode;
			}
			else {
				Eattacking = false;
				EendTurn = true;
			}
			

			if (EendTurn || battleOver) {
				Eattacking = false;
				EendTurn = false;
				turn++;
				Eattacked = false;
				EnemyEntity.attack.reset();
				playerAttackedMode.reset();
				playerState = playerIdle;
				if (isDefense) {
					handler.getEntityManager().getPlayer().setDefense(handler.getEntityManager().getPlayer().getDefense() - 15);
					handler.getEntityManager().getPlayer().setMr(handler.getEntityManager().getPlayer().getMr()- 4);
					isDefense = false;
				}
			}
		}
	}
/**
 * Método de defensa del enemigo
 * @param g
 */
	private void Edefend(Graphics g) {

		EnemyEntity.defend.tick();
		EnemyEntity.state = EnemyEntity.defend;

		EisDefense = true;
		if(EnemyEntity.defend.getIndex()>=Images.enemy1_defense.length-1 || EnemyEntity.defend.getIndex()>=Images.enemy2_defense.length-1 ){
			enemy.setDefense(enemy.getDefense()+15);
			enemy.setMr(enemy.getMr()+4);
			//addMana
			if(enemy.getMana() <= enemy.getMaxMana() - 10)
				enemy.setMana(enemy.getMana() + (int)(10 * (enemy.getIntl() * 2/100)));
			Edefense=false;
			EendTurn=false;
			turn++;
			EnemyEntity.state = EnemyEntity.idle;
			if(isDefense){
				handler.getEntityManager().getPlayer().setDefense(handler.getEntityManager().getPlayer().getDefense()- 15);
				handler.getEntityManager().getPlayer().setMr(handler.getEntityManager().getPlayer().getMr()- 4);
				isDefense = false;
			}
		}
	}
/**
 * Método de habilidad del enemigo
 * @param g
 */
	private void EcallSkill(Graphics g) {
		if(!EnemyEntity.skill.end){
			EnemyEntity.skill.tick();
			EnemyEntity.state = EnemyEntity.skill;
		}
		else {
			EnemyEntity.state = EnemyEntity.idle;

			int ev=(int)handler.getEntityManager().getPlayer().getEvs();
			int evade=new Random().nextInt(125);
			int skillAtk = (int) enemy.getIntl() * 2; 
	
			skillAtk = (int) (skillAtk * ( 1- (handler.getEntityManager().getPlayer().getMr()/100)));
	
			if(evade>ev &&!Eattacked && handler.getEntityManager().getPlayer().getHealth()-skillAtk>=0) {
				handler.getEntityManager().getPlayer().setHealth(handler.getEntityManager().getPlayer().getHealth() - skillAtk);
				Eattacked=true;
				Edmg = String.valueOf(skillAtk);
			}else  if(evade>ev &&!Eattacked && handler.getEntityManager().getPlayer().getHealth()-skillAtk<0){
				handler.getEntityManager().getPlayer().setHealth(0);
				Eattacked=true;
				Edmg = String.valueOf(skillAtk);
			}else if( !(evade>ev) && !Eattacked)
				Edmg = "";
	
			g.setColor(Color.RED);
			g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
			g.drawString(Edmg , playerRect.x - 160, playerRect.y - 300);
	
			if(!playerAttackedMode.end) {
				playerAttackedMode.tick();
				playerState = playerAttackedMode;
			}else {
				
				EendTurn=true;
			}
	
			if(EendTurn || battleOver){
				Eattacked=false;
				Eskill=false;
				EendTurn=false;
				turn++;
				enemy.setMana(enemy.getMana()-25);
				EnemyEntity.skill.reset();
				playerAttackedMode.reset();
				playerState = playerIdle;
				if(isDefense){
					handler.getEntityManager().getPlayer().setDefense(handler.getEntityManager().getPlayer().getDefense()-15);
					handler.getEntityManager().getPlayer().setMr(handler.getEntityManager().getPlayer().getMr()- 4);
					isDefense = false;
				}
			}
		}
	}
	/**
	 * Método de curación del boss
	 * @param g
	 */
	private void Eheal(Graphics g) {
		if(!EnemyEntity.heal.end) {
			EnemyEntity.heal.tick();
			EnemyEntity.state = EnemyEntity.heal;
			g.setColor(Color.GREEN);
			g.setFont((new Font("IMPACT", Font.ITALIC, 100)));
			g.drawString(String.valueOf((int)enemy.getMaxHealth()*0.1) ,enemyRect.x + 90, enemyRect.y - 400);
		}else {
			
			EnemyEntity.state = EnemyEntity.idle;
			
			
			EendTurn=true;
		
		if(EendTurn || battleOver){
			Eheal=false;
			EendTurn=false;
			turn++;
			enemy.setHealth(enemy.getHealth()+enemy.getMaxHealth()*0.1);
			enemy.setMana(enemy.getMana()-25);
			EnemyEntity.heal.reset();
			if(isDefense){
				handler.getEntityManager().getPlayer().setDefense(handler.getEntityManager().getPlayer().getDefense()- 15);
				handler.getEntityManager().getPlayer().setMr(handler.getEntityManager().getPlayer().getMr()- 4);
				isDefense = false;
			}
		}
	}
	}

	public int getWordHeight() {
		return wordHeight;
	}

	public void setWordHeight(int wordHeight) {
		this.wordHeight = wordHeight;
	}

	public int getStringSpeed() {
		return stringSpeed;
	}

	public void setStringSpeed(int stringSpeed) {
		this.stringSpeed = stringSpeed;
	}



}
