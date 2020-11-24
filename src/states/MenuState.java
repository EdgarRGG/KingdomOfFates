package states;



import main.GameSetUp;
import main.Handler;
import resources.Images;
import ui.Selector;

import java.awt.*;
import java.io.FileReader;

import org.json.JSONObject;

import com.sun.glass.events.KeyEvent;

/**
 * Clase que actúa como el state del menú principal y que pinta los elementos
 * @author Edgar Rubio
 *
 */
public class MenuState extends State {



	public int xPos;
	public int yPos;
	public int width;
	public int height;
	public int titleXPos;
	public int titleYPos;
	Selector selector = new Selector(this.handler);
	private ConfState confStateSave;
	private double volume;

    public MenuState(Handler handler) {
		super(handler);

		this.xPos = 0;
		this.yPos = 0;
		this.width = handler.getWidth();
		this.height = handler.getHeight();
		this.titleXPos =  20;
		this.titleYPos =  70;
		confStateSave = new ConfState(handler);
		

		
		

	}
//Realizamos la selección y pulsamos enter para confirmar la elección.
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
		g.drawImage(Images.menuImage,this.xPos, this.yPos, this.width, this.height, null);
		g.drawImage(Images.gameTitle, this.titleXPos, this.titleYPos, 1050, 200, null);
		g.drawImage(Images.gamecredits, handler.getWidth()/2 - 250, handler.getHeight()/2 + 490,1200,50,null);


		//Si la selección se encuentra en la posición x e y del botón pintamos la imagen del botón seleccionado y si no 
		//la del botón normal
		if(selector.getMenuX() == selector.menuXPositions[0] && selector.getMenuY() == selector.menuYPositions[0]) {

			g.drawImage(Images.butstart[0], selector.getStartButtonXPos(), selector.getStartButtonYPos(), 400, 95, null);

		}

		else {

			g.drawImage(Images.butstart[1], selector.getStartButtonXPos(), selector.getStartButtonYPos(), 400, 95, null);

		}
		if(selector.getMenuX() == selector.menuXPositions[1] && selector.getMenuY() == selector.menuYPositions[1]) {

			g.drawImage(Images.howToPlay[0], selector.getHowToButtonXPos(), selector.getHowToButtonYPos(), 400, 95, null);

		}

		else {

			g.drawImage(Images.howToPlay[1], selector.getHowToButtonXPos(), selector.getHowToButtonYPos(), 400, 95, null);

		}
		
		if(selector.getMenuX() == selector.menuXPositions[2] && selector.getMenuY() == selector.menuYPositions[2]) {

			g.drawImage(Images.Options[0], selector.getConfButtonXPos(), selector.getConfButtonYPos(), 400, 95, null);

		}

		else {

			g.drawImage(Images.Options[1], selector.getConfButtonXPos(), selector.getConfButtonYPos(), 400, 95, null);

		}

		if(selector.getMenuX() == selector.menuXPositions[3] && selector.getMenuY() == selector.menuYPositions[3]) {

			g.drawImage(Images.Quit[0],selector.getQuitButtonXPos(), selector.getQuitButtonYPos(), 400, 95, null);

		}

		else {

			g.drawImage(Images.Quit[1],selector.getQuitButtonXPos(), selector.getQuitButtonYPos(), 400, 95, null);

		}
	}

/**
 * Método que selecciona la opción elegida
 */
	public void choose() {
		ConfState confState = new ConfState(handler);
		handler.getGame().getMusicHandler().playEffect("res/music/enterSelect.wav",0);
		//Si elegimos la opción de Start
		if(selector.getMenuX() == selector.menuXPositions[0] && selector.getMenuY() == selector.menuYPositions[0]) {
			//Activamos la carga durante unos segundos
			GameSetUp.LOADING=true;
			handler.getGame().getMusicHandler().set_changeMusic("res/music/Overworld.mp3");
			handler.getGame().getMusicHandler().play();
			if(confState.save.exists()) {
				this.loadSave();
				handler.getGame().getMusicHandler().setVolume(volume);
			}else {
			handler.getGame().getMusicHandler().setVolume(0.2);
			}
			handler.getGame().getMusicHandler().setLoop(true);
			//Cambiamos al state del juego
			State.setState(handler.getGame().overWorldState);
		}
		//Si elegimos las instrucciones
		else if(selector.getMenuX() == selector.menuXPositions[1] && selector.getMenuY() == selector.menuYPositions[1]) {
			State.setState(handler.getGame().instructionMenuState);
		}
		//si elegimos opciones
		else if(selector.getMenuX() == selector.menuXPositions[2] && selector.getMenuY() == selector.menuYPositions[2]) {
			State.setState(handler.getGame().confState);
		}
		//Si es la de salir salimos del juego
		else {
			System.exit(0);
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

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getTitleXPos() {
		return titleXPos;
	}

	public void setTitleXPos(int titleXPos) {
		this.titleXPos = titleXPos;
	}

	public int getTitleYPos() {
		return titleYPos;
	}

	public void setTitleYPos(int titleYPos) {
		this.titleYPos = titleYPos;
	}

}
