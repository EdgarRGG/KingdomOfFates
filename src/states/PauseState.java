package states;

import main.Handler;
import resources.Images;
import ui.Selector;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileReader;

import org.json.JSONObject;
import main.GameSetUp;


/**
 * Clase que configura el menú de pausa del juego
 * @author Edgar Rubio
 *
 */
public class PauseState extends State {

	Selector selector = new Selector(this.handler);
	public State lastState;
	private ConfState confState;
	private ConfState confStateSave;
	private double volume;

	public PauseState(Handler handler) {
		super(handler);
		lastState = handler.getGame().menuState;
		confState = new ConfState(handler);
		confStateSave = new ConfState(handler);
	}
/**
 * Selecciona las posiciones y al pulsar escape vuelve al juego
 */
	@Override
	public void tick() {
		selector.tick();
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
             returnToGame();
            }else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
            	this.choose();
            }

        }

	
/**
 * Método que pinta por pantalla
 */
	@Override
	public void render(Graphics g) {
            g.setColor(new Color(61, 68, 128));
            g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
            g.drawImage(Images.pauseMenuImage, 0, 0, handler.getWidth(), handler.getHeight(), null);

            //Si la posición del selector es alguna de las posiones de las imágenes se pinta la imagen seleccionada
            //de la misma, y si no, la imagen normal
            if(selector.getMenuPauseX() == selector.menuPauseXPositions[0] && selector.getMenuPauseY() == selector.menuPauseYPositions[0]) {
    			g.drawImage(Images.resume[1],selector.getResumeButtonXPos(), selector.getResumeButtonYPos(), 400, 150, null);
    		}

    		else {
    			g.drawImage(Images.resume[0],selector.getResumeButtonXPos(), selector.getResumeButtonYPos(), 400, 150, null);
    		}
            if(selector.getMenuPauseX() == selector.menuPauseXPositions[1] && selector.getMenuPauseY() == selector.menuPauseYPositions[1]) {
    			g.drawImage(Images.back[1],selector.getTitleButtonXPos(), selector.getTitleButtonYPos(), 400, 130, null);
    		}

    		else {
    			g.drawImage(Images.back[0],selector.getTitleButtonXPos(), selector.getTitleButtonYPos(), 400, 130, null);
    		}
            if(selector.getMenuPauseX() == selector.menuPauseXPositions[2] && selector.getMenuPauseY() == selector.menuPauseYPositions[2]) {
    			g.drawImage(Images.howToPlay[0],selector.getInstructionsButtonXPos(), selector.getInstructionsButtonYPos(), 400, 130, null);
    		}

    		else {
    			g.drawImage(Images.howToPlay[1],selector.getInstructionsButtonXPos(), selector.getInstructionsButtonYPos(), 400, 130, null);
    		}
            if(selector.getMenuPauseX() == selector.menuPauseXPositions[3] && selector.getMenuPauseY() == selector.menuPauseYPositions[3]) {
    			g.drawImage(Images.exit[1],selector.getExitButtonXPos(), selector.getExitButtonYPos(), 400, 130, null);
    		}

    		else {
    			g.drawImage(Images.exit[0],selector.getExitButtonXPos(), selector.getExitButtonYPos(), 400, 130, null);
    		}
            if(selector.getMenuPauseX() == selector.menuPauseXPositions[4] && selector.getMenuPauseY() == selector.menuPauseYPositions[4]) {
    			g.drawImage(Images.stats[1],selector.getStatsButtonXPos(), selector.getStatsButtonYPos(), 400, 130, null);
    		}

    		else {
    			g.drawImage(Images.stats[0],selector.getStatsButtonXPos(), selector.getStatsButtonYPos(), 400, 130, null);
    		}
            
        }

/**
 * Método que devuelve al juego
 */
    private void returnToGame(){
		GameSetUp.SWITCHING=true;
		State.setState(lastState);
	}
	/**
	 * Método que controla los casos de volver al juego, volver al menú principal, ver las estadísticas,
	 * salir del juego y ver las instrucciones
	 */
    private void choose() {
		//Si el effect player no está vacío y el efecto no es igual a null, paramos el sonido y reproducimos uno nuevo
		if(!handler.getGame().getMusicHandler().getEPlayer().isEmpty()&&!handler.getGame().getMusicHandler().getEffect(0).equals(null)) {
			handler.getGame().getMusicHandler().stopEffect(0);
		}
		handler.getGame().getMusicHandler().playEffect("res/music/enterSelect.wav",0);

		if(selector.getMenuPauseX() == selector.menuPauseXPositions[0] && selector.getMenuPauseY() == selector.menuPauseYPositions[0]) {
			returnToGame();
		}else if(selector.getMenuPauseX() == selector.menuPauseXPositions[1] && selector.getMenuPauseY() == selector.menuPauseYPositions[1]) {
			lastState = handler.getGame().menuState;
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
		}else if(selector.getMenuPauseX() == selector.menuPauseXPositions[2] && selector.getMenuPauseY() == selector.menuPauseYPositions[2]) {
			State.setState(handler.getGame().instructionMenuState);
		}else if(selector.getMenuPauseX() == selector.menuPauseXPositions[3] && selector.getMenuPauseY() == selector.menuPauseYPositions[3]) {
			System.exit(0);
		}else if(selector.getMenuPauseX() == selector.menuPauseXPositions[4] && selector.getMenuPauseY() == selector.menuPauseYPositions[4]) {
			State.setState(handler.getGame().statsState);
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
    
}
