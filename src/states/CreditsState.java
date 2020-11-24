package states;

import main.Handler;
import resources.Images;
import java.awt.*;
import java.io.FileReader;

import org.json.JSONObject;


/**
 * Clase que controla los creditos del juego
 * @author Edgar Rubio
 *
 */
public class CreditsState extends State {

   	private ConfState confState;
   	int statX=handler.getWidth()/6,statY=handler.getHeight(),statY2=handler.getHeight();;
   	private double volume;
	private ConfState confStateSave;
   	
	public CreditsState(Handler handler) {
		super(handler);
		confState = new ConfState(handler);
		confStateSave = new ConfState(handler);
	}
/**
 * Al pulsar escape vuelve al menú principal
 */
	@Override
	public void tick() {
		statY-=3;
		statY2-=3;
		if(statY2 <= handler.getHeight() - 3000 ) {
			GameOver();
		}
	}
	
/**
 * Método que pinta por pantalla
 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Images.edgar, statX, statY, 2*(handler.getWidth()/3), 50, null);
		g.drawImage(Images.miriam, statX, statY + 100, 2*(handler.getWidth()/3), 50, null);
		g.drawImage(Images.music, statX, statY + 200, 2*(handler.getWidth()/3), 50, null);
		g.drawImage(Images.thanks, statX, statY2 + 1000, 2*(handler.getWidth()/3), 200, null);
     }
    /**
     * Método que te devuelve al menú principal
     */
    private void GameOver() {
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
