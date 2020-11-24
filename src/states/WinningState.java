package states;

import main.Handler;
import resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;


import main.GameSetUp;


/**
 * Clase que controla los dialogos al acabar el juego
 * @author Edgar Rubio
 *
 */
public class WinningState extends State {

   	private ConfState confState;
   	private int enter = 0;
   	private double volume;
	private ConfState confStateSave;
   	
	public WinningState(Handler handler) {
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
               g.drawImage(Images.winning1,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
              break;
           case 1:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning2,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 2:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning3,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 3:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning4,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 4:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning5,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 5:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning6,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 6:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning7,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 7:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning8,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 8:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning9,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 9:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning10,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 10:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning11,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;
           case 11:
        	   g.setColor(new Color(61, 68, 128));
               g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
               g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
               g.setColor(new Color(189,167,140));
               g.drawImage(Images.winning12,0,0, handler.getWidth(), handler.getHeight(),null);
               g.drawString("Press enter to continue", handler.getWidth() - 300, handler.getHeight()/2 + 500);
               break;       
           case 12:
        	   credits();
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
    private void credits(){

		handler.getGame().getMusicHandler().set_changeMusic("res/music/Credits.mp3");
		handler.getGame().getMusicHandler().play();
		if(confState.save.exists()) {
			this.loadSave();
			handler.getGame().getMusicHandler().setVolume(volume);
		}else {
		handler.getGame().getMusicHandler().setVolume(0.2);
		}
		handler.getGame().getMusicHandler().setLoop(true);

		State.setState(new CreditsState(handler));
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
