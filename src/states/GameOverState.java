package states;

import main.Handler;
import resources.Images;
import ui.Selector;

import java.awt.*;
import java.io.FileReader;

import org.json.JSONObject;

import com.sun.glass.events.KeyEvent;

/**
 * Clase que controla la pantalla de GameOver
 * @author Edgar Rubio
 *
 */
public class GameOverState extends State {



	public int xPos;
	public int yPos;
	public int width;
	public int height;
	public int titleXPos;
	public int titleYPos;
	Selector selector = new Selector(this.handler);
	private ConfState confStateSave;
	private double volume;

    public GameOverState(Handler handler) {
		super(handler);

		this.xPos = 0;
		this.yPos = 0;
		this.width = handler.getWidth();
		this.height = handler.getHeight();
		this.titleXPos =  20;
		this.titleYPos =  70;
		confStateSave = new ConfState(handler);
		

		
		

	}
//Realizamos la selecci�n y pulsamos enter para confirmar la elecci�n.
	@Override
	public void tick() {

		
		selector.tick();
		


		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {

			this.choose();

		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.darkGray);

		g.fillRect(0,0,handler.getWidth(),handler.getHeight());

		//pintamos los elementos
		g.drawImage(Images.gameover,this.xPos, this.yPos, this.width, this.height, null);

		//Si la selecci�n se encuentra en la posici�n x e y del bot�n pintamos la imagen del bot�n seleccionado y si no 
		//la del bot�n normal
		if(selector.getMenuGameOverX() == selector.menuGameOverXPositions[1] && selector.getMenuGameOverY() == selector.menuGameOverYPositions[1]) {

			g.drawImage(Images.retry[0], selector.getRetryButtonXPos(), selector.getRetryButtonYPos(), 400, 95, null);

		}

		else {

			g.drawImage(Images.retry[1], selector.getRetryButtonXPos(), selector.getRetryButtonYPos(), 400, 95, null);

		}
		
		if(selector.getMenuGameOverX() == selector.menuGameOverXPositions[0] && selector.getMenuGameOverY() == selector.menuGameOverYPositions[0]) {

			g.drawImage(Images.exit[0], selector.getExit2ButtonXPos(), selector.getExit2ButtonYPos(), 400, 95, null);

		}

		else {

			g.drawImage(Images.exit[1], selector.getExit2ButtonXPos(), selector.getExit2ButtonYPos(), 400, 95, null);

		}
	}

/**
 * M�todo que selecciona la opci�n elegida
 */
	public void choose() {
		ConfState confState = new ConfState(handler);
		handler.getGame().getMusicHandler().playEffect("res/music/enterSelect.wav",0);
		//Si elegimos la opci�n de Retry
		if(selector.getMenuGameOverX() == selector.menuGameOverXPositions[0] && selector.getMenuGameOverY() == selector.menuGameOverYPositions[0]) {
			handler.getGame().reStart();
			handler.getGame().getMusicHandler().set_changeMusic("res/music/Overture.mp3");
			handler.getGame().getMusicHandler().play();
			if(confState.save.exists()) {
				this.loadSave();
				handler.getGame().getMusicHandler().setVolume(volume);
			}else {
			handler.getGame().getMusicHandler().setVolume(0.2);
			}
			handler.getGame().getMusicHandler().setLoop(true);
			State.setState(handler.getGame().menuState);
		}
		//Si elegimos la opci�n de Salir
		else if(selector.getMenuGameOverX() == selector.menuGameOverXPositions[1] && selector.getMenuGameOverY() == selector.menuGameOverYPositions[1]) {
			System.exit(0);
		}
	}
	
	/**
     * M�todo que carga la configuraci�n de las opciones guardadas
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


}
