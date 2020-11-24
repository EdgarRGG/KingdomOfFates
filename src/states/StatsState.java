package states;

import main.Handler;
import resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;



/**
 * Clase que muestra los stats del jugador
 * @author Edgar Rubio
 *
 */
public class StatsState extends State {
	
	String[] statList = {"Level","Health","Mana","Experience","Xp To lvlUp","Defense","Strength","Intelligence", "Magic Res.","Constitution","Max Mana","Max Health","Skill"};


	public StatsState(Handler handler) {
		super(handler);
	}
/**
 * Al pulsar escape vuelve al menú principal
 */
	@Override
	public void tick() {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
       	 returnToPause();
        }
	}
	
/**
 * Método que pinta por pantalla
 */
	@Override
	public void render(Graphics g) {
            g.setColor(new Color(189, 167, 140));
            g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
            g.drawImage(Images.statsImage, 0, 0, handler.getWidth(), handler.getHeight(), null);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            try {
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Song Of Coronos.ttf.ttf")));
			} catch (FontFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            g.setFont(new Font("Song Of Coronos", Font.BOLD, 35));
            g.drawString(statList[0]+": "+handler.getEntityManager().getPlayer().getLvl(),handler.getWidth()/2 - 120, handler.getHeight()/2 - 125);
            g.drawString(statList[1]+": "+handler.getEntityManager().getPlayer().getHealth(),handler.getWidth()/2 - 300, handler.getHeight()/2 - 50);
            g.drawString(statList[11]+": "+handler.getEntityManager().getPlayer().getMaxHealth(),handler.getWidth()/2, handler.getHeight()/2 - 50);
            g.drawString(statList[2]+": "+handler.getEntityManager().getPlayer().getMana(),handler.getWidth()/2 - 300, handler.getHeight()/2 + 25);
            g.drawString(statList[10]+": "+handler.getEntityManager().getPlayer().getMaxMana(),handler.getWidth()/2, handler.getHeight()/2 + 25 );
            g.drawString(statList[3]+": "+handler.getEntityManager().getPlayer().getXp(),handler.getWidth()/2 - 300, handler.getHeight()/2 + 100);
            g.drawString(statList[4]+": "+handler.getEntityManager().getPlayer().getLvlUpXp(),handler.getWidth()/2, handler.getHeight()/2 + 100);
            g.drawString(statList[6]+": "+handler.getEntityManager().getPlayer().getStr(),handler.getWidth()/2 - 300, handler.getHeight()/2 + 175);
            g.drawString(statList[5]+": "+handler.getEntityManager().getPlayer().getDefense(),handler.getWidth()/2, handler.getHeight()/2 + 175);
            g.drawString(statList[7]+": "+handler.getEntityManager().getPlayer().getIntl(),handler.getWidth()/2 - 300, handler.getHeight()/2 + 250);
            g.drawString(statList[8]+": "+handler.getEntityManager().getPlayer().getMr(),handler.getWidth()/2, handler.getHeight()/2 + 250);
            g.drawString(statList[9]+": "+handler.getEntityManager().getPlayer().getCons(),handler.getWidth()/2 - 300, handler.getHeight()/2 + 325);
            g.drawString(statList[12]+": "+handler.getEntityManager().getPlayer().getSkill(),handler.getWidth()/2, handler.getHeight()/2 + 325);
        }
	


/**
 * Método que devuelve al menú principal
 */
    private void returnToPause(){
    	State.setState(handler.getGame().pauseState);
	}
    
}
