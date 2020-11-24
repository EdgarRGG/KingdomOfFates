package states;

import main.GameSetUp;
import main.Handler;
import resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;

import entities.EntityManager;
import entities.Player;
import input.WorldManager;

/**
 * Clase que controla el mapa externo del juego
 * @author Edgar Rubio
 *
 */
public class OverWorld extends State {

	int xDisplacement, yDisplacement;

	WorldManager worldManager;
	EntityManager entityManager;
	Player player;

	Rectangle background = new Rectangle(3000, 3000);
	Color backgroundColor = new Color(17, 15, 12);

	public OverWorld(Handler handler) {
		super(handler);
		//valores para situar la imagen del mapa
		xDisplacement = -400;
		yDisplacement = -400;
		this.handler.setXDisplacement(xDisplacement);
		this.handler.setYDisplacement(yDisplacement);
		//donde aparece el jugador en la pantalla
		player = new Player(handler, (int) handler.getWidth() / 2 - 5, (int) handler.getHeight() / 2);
	

		entityManager = new EntityManager(handler, player);
		this.handler.setEntityManager(entityManager);
		worldManager = new WorldManager(handler);
		this.handler.setWorldManager(worldManager);
		WorldManager.townEntered = false;

	}

	@Override
	public void tick() {

	    if(GameSetUp.LOADING){
	        if(GameSetUp.loadCounter>=90){
	            GameSetUp.loadCounter=0;
	            GameSetUp.LOADING=false;
	            return;
            }
            worldManager.tick();
            GameSetUp.loadCounter++;
        }else {

            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
               handler.getGame().pauseState.lastState = State.getState();
				GameSetUp.SWITCHING=true;
				State.setState(handler.getGame().pauseState);
            } else {

                worldManager.tick();
                entityManager.tick();
            }
        }
	}

	@Override
	public void render(Graphics g) {

	    if(!GameSetUp.LOADING) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(backgroundColor);
            g2.fill(background);

            g2.drawImage(Images.scaledOverWorld, handler.getXDisplacement()  , handler.getYDisplacement() , null);

            worldManager.render(g);
            entityManager.render(g);
        }else{
	        g.drawImage(Images.loading,0,0,handler.getWidth(),handler.getHeight(),null);
        }
	}

}
