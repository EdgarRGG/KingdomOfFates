package states;

import main.Handler;
import resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Clase que explica como jugar
 * @author Edgar Rubio
 *
 */
public class InstructionsState extends State {

	public InstructionsState(Handler handler) {
		super(handler);
	}
/**
 * Al pulsar escape vuelve al menú principal
 */
	@Override
	public void tick() {
		if(handler.getGame().pauseState.lastState.equals(handler.getGame().menuState)) {
        	if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
        		returnToMenu();
            }
        }
		else {
        	if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
        		State.setState(handler.getGame().pauseState);
        	}
        }
	}
	
/**
 * Método que pinta por pantalla
 */
	@Override
	public void render(Graphics g) {
            g.setColor(new Color(61, 68, 128));
            g.fillRect(0, 0, this.handler.getWidth(), this.handler.getHeight());
            g.drawImage(Images.instructionMenuImage, 0, 0, handler.getWidth(), handler.getHeight(), null);

        }

/**
 * Método que devuelve al menú principal
 */
    private void returnToMenu(){
    	State.setState(handler.getGame().menuState);
	}
    
}
