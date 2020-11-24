package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Clase que controla las teclas y como son pulsadas
 * @author Edgar Rubio
 *
 */

public class KeyManager implements KeyListener {

	private boolean[] keys,justPressed,cantPress;
	public boolean up=false, down=false, left=false, right=false;
	public boolean debugCollisions = false;

	public KeyManager(){

		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];

	}

	//metodo que se asegura que las teclas estén bien pulsadas y las define
		public void tick(){
			for(int i =0; i < keys.length;i++){
				//si no puedes pulsar ni hay una tecla pulsada
				if(cantPress[i] && !keys[i]){
					//puedes pulsar
					cantPress[i]=false;
					//si acabas de pulsar no puedes pulsar de nuevo
				}else if(justPressed[i]){
					cantPress[i]=true;
					justPressed[i] =false;
				}
				//si no puedes pulsar pero hay una tecla pulsada acabas de pulsar
				if(!cantPress[i] && keys[i]){
					justPressed[i]=true;
				}
			}

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		debugCollisions = keys[KeyEvent.VK_H];

	} 

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	
}
