package states;

import main.Handler;
import resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

import input.WorldManager;
import main.GameSetUp;


/**
 * Clase que controla la interacción entre los personajes de la aldea
 * @author Edgar Rubio
 *
 */
public class TownState extends State {

   	private ConfState confState;
   	private int enter = 0;
   	private double volume;
	private ConfState confStateSave;
   	
	public TownState(Handler handler) {
		super(handler);
		confState = new ConfState(handler);
		confStateSave = new ConfState(handler);
	}
/**
 * Al pulsar escape vuelve al menú principal
 */
	@Override
	public void tick() {
		if(GameSetUp.LOADING){
	        if(GameSetUp.loadCounter>=90){
	            GameSetUp.loadCounter=0;
	            GameSetUp.LOADING=false;
	            return;
            }
            GameSetUp.loadCounter++;
        }else {
        	if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
        		GameSetUp.SWITCHING=true;
        		returnToGame();
        		enter = 0;
        	}
        	if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
        		enter++;
        	}
        }
	}
	
/**
 * Método que pinta por pantalla
 */
	@Override
	public void render(Graphics g) {
		if(!GameSetUp.LOADING) {
           switch(enter) {
           case 0:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
               try {
   				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Song Of Coronos.ttf.ttf")));
   			} catch (FontFormatException | IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town1,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
              break;
           case 1:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town2,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 2:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town3,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 3:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town4,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 4:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town5,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 5:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town6,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 6:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town7,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 7:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town8,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 8:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town9,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 9:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town10,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 10:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town11,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 11:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town12,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 12:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town13,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 13:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town14,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 14:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town15,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 15:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town16,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 16:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town17,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 17:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.town18,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue or Escape to skip", handler.getWidth() - 520, handler.getHeight()/2 + 500);
               break;
           case 18:
        	   returnToGame();
        	   enter = 0;
               break;
           }
		}
		else {
			g.drawImage(Images.loading,0,0,handler.getWidth(),handler.getHeight(),null);
		}
     }

/**
 * Método que devuelve al menú principal
 */
    private void returnToGame(){
    	WorldManager.townEntered=true;
    	//Colocamos al personaje al lado de la aldea 
    	handler.setXDisplacement(-800);
		handler.setYDisplacement(-600); 
		GameSetUp.LOADING = true;

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
