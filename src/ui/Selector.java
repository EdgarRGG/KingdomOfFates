package ui;

import java.awt.event.KeyEvent;

import main.Handler;
import states.State;

/**
 * Clase para el control de selección de botones en los menús
 * @author Edgar Rubio
 *
 */
public class Selector {

	private Handler handler;
	private int startButtonXPos;
	private int startButtonYPos;
	private int quitButtonXPos;
	private int quitButtonYPos;
	private int retryButtonXPos;
	private int retryButtonYPos;
	private int exit2ButtonXPos;
	private int exit2ButtonYPos;
	private int confButtonXPos;
	private int confButtonYPos;
	private int howToButtonXPos;
	private int howToButtonYPos;
	private int muteButtonXPos;
	private int muteButtonYPos;
	private int veinticincoButtonXPos;
	private int veinticincoButtonYPos;
	private int cincuentaButtonXPos;
	private int cincuentaButtonYPos;
	private int setentaYCincoButtonXPos;
	private int setentaYCincoButtonYPos;
	private int cienButtonXPos;
	private int cienButtonYPos;
	private int novecientosButtonXPos;
	private int novecientosButtonYPos;
	private int milOchentaButtonXPos;
	private int milOchentaButtonYPos;
	private int screenButtonXPos;
	private int screenButtonYPos;
	private int defaultButtonXPos;
	private int defaultButtonYPos;
	private int applyButtonXPos;
	private int applyButtonYPos;
	private int resumeButtonXPos;
	private int resumeButtonYPos;
	private int exitButtonXPos;
	private int exitButtonYPos;
	private int titleButtonXPos;
	private int titleButtonYPos;
	private int instructionsButtonXPos;
	private int instructionsButtonYPos;
	private int statsButtonXPos;
	private int statsButtonYPos;
	public int[] menuXPositions;
	public int[] menuYPositions;
	public int [] menuConfXPositions;
	public int [] menuConfYPositions;
	public int [] menuPauseXPositions;
	public int [] menuPauseYPositions;
	public int [] menuGameOverXPositions;
	public int [] menuGameOverYPositions;
	private int menuSelectorIndex = 0;
	private int confSelectorIndex = 0;
	private int pauseSelectorIndex = 0;
	private int gameOverSelectorIndex = 0;
	private int menuX;
	private int menuY;
	private int menuConfX;
	private int menuConfY;
	private int menuPauseX;
	private int menuPauseY;
	private int menuGameOverX;
	private int menuGameOverY;

	public Selector(Handler handler){

		this.handler = handler;

		//menuState posiciones
		startButtonXPos = handler.getWidth()/2 + 80;
		startButtonYPos = handler.getHeight()/2 + 170;
		howToButtonXPos = handler.getWidth()/2 + 520;
		howToButtonYPos = handler.getHeight()/2 + 190;
		confButtonXPos = handler.getWidth()/2;
		confButtonYPos = handler.getHeight()/2 + 320;
		quitButtonXPos = handler.getWidth()/2 + 440;
		quitButtonYPos =  handler.getHeight()/2 + 340;
		//configurationState posiciones
		muteButtonXPos = handler.getWidth()/2 - 400;
		muteButtonYPos = handler.getHeight()/2 - 75;
		veinticincoButtonXPos = handler.getWidth()/2 - 220;
		veinticincoButtonYPos = handler.getHeight()/2 - 75;
		cincuentaButtonXPos = handler.getWidth()/2 - 40;
		cincuentaButtonYPos = handler.getHeight()/2 -75;
		setentaYCincoButtonXPos = handler.getWidth()/2 + 140;
		setentaYCincoButtonYPos = handler.getHeight()/2 - 75;
		cienButtonXPos = handler.getWidth()/2 + 320;
		cienButtonYPos = handler.getHeight()/2 - 75;
		novecientosButtonXPos = handler.getWidth()/2 - 400;
		novecientosButtonYPos = handler.getHeight()/2 + 75;
		milOchentaButtonXPos = handler.getWidth()/2 - 220;
		milOchentaButtonYPos = handler.getHeight()/2 + 75;
		screenButtonXPos = handler.getWidth()/2 - 40;
		screenButtonYPos = handler.getHeight()/2 + 75;
		defaultButtonXPos = handler.getWidth() - 300;
		defaultButtonYPos = handler.getHeight()/2 + 200;
		applyButtonXPos = handler.getWidth() - 300;
		applyButtonYPos = handler.getHeight()/2 + 300;
		//PauseState posiciones
		resumeButtonXPos = handler.getWidth()/2 - 800;
		resumeButtonYPos = handler.getHeight()/2 - 75;
		instructionsButtonXPos = handler.getWidth()/2 - 200;
		instructionsButtonYPos = handler.getHeight()/2 - 75;
		titleButtonXPos = handler.getWidth()/2 - 500;
		titleButtonYPos = handler.getHeight()/2 + 100;
		exitButtonXPos = handler.getWidth()/2 + 100;
		exitButtonYPos = handler.getHeight()/2 + 100;
		statsButtonXPos = handler.getWidth()/2 + 400;
		statsButtonYPos = handler.getHeight()/2 -75;
		//GameOverState posiciones
		retryButtonXPos = handler.getWidth()/2 - 200;
		retryButtonYPos = handler.getHeight()/2;
		exit2ButtonXPos = handler.getWidth()/2 - 200;
		exit2ButtonYPos = handler.getHeight()/2 + 200;
				
		//aquí es donde empezará el cursor
		menuX = this.startButtonXPos;
		menuY = this.startButtonYPos;
		menuConfX = this.muteButtonXPos;
		menuConfY = this.muteButtonYPos;
		menuPauseX = this.resumeButtonXPos;
		menuPauseY = this.resumeButtonYPos;
		menuGameOverX = this.retryButtonXPos;
		menuGameOverY = this.retryButtonYPos;

		this.menuXPositions = new int[4];
		this.menuYPositions = new int[4];
		this.menuConfXPositions = new int[10];
		this.menuConfYPositions = new int[10];
		this.menuPauseXPositions = new int[5];
		this.menuPauseYPositions = new int[5];
		this.menuGameOverXPositions = new int[2];
		this.menuGameOverYPositions = new int[2];

		this.menuXPositions[0] = this.startButtonXPos;
		this.menuXPositions[1] = this.howToButtonXPos;
		this.menuXPositions[2] = this.confButtonXPos;
		this.menuXPositions[3] = this.quitButtonXPos;
		this.menuConfXPositions[0] = this.muteButtonXPos;
		this.menuConfXPositions[1] = this.veinticincoButtonXPos;
		this.menuConfXPositions[2] = this.cincuentaButtonXPos;
		this.menuConfXPositions[3] = this.setentaYCincoButtonXPos;
		this.menuConfXPositions[4] = this.cienButtonXPos;
		this.menuConfXPositions[5] = this.novecientosButtonXPos;
		this.menuConfXPositions[6] = this.milOchentaButtonXPos;
		this.menuConfXPositions[7] = this.screenButtonXPos;
		this.menuConfXPositions[8] = this.defaultButtonXPos;
		this.menuConfXPositions[9] = this.applyButtonXPos;
		this.menuPauseXPositions[0] = this.resumeButtonXPos;
		this.menuPauseXPositions[1] = this.titleButtonXPos;
		this.menuPauseXPositions[2] = this.instructionsButtonXPos;
		this.menuPauseXPositions[3] = this.exitButtonXPos;
		this.menuPauseXPositions[4] = this.statsButtonXPos;
		this.menuGameOverXPositions[0] = this.retryButtonXPos;
		this.menuGameOverXPositions[1] = this.exit2ButtonXPos;

		

		this.menuYPositions[0] = this.startButtonYPos;
		this.menuYPositions[1] = this.howToButtonYPos;
		this.menuYPositions[2] = this.confButtonYPos;
		this.menuYPositions[3] = this.quitButtonYPos;
		this.menuConfYPositions[0] = this.muteButtonYPos;
		this.menuConfYPositions[1] = this.veinticincoButtonYPos;
		this.menuConfYPositions[2] = this.cincuentaButtonYPos;
		this.menuConfYPositions[3] = this.setentaYCincoButtonYPos;
		this.menuConfYPositions[4] = this.cienButtonYPos;
		this.menuConfYPositions[5] = this.novecientosButtonYPos;
		this.menuConfYPositions[6] = this.milOchentaButtonYPos;
		this.menuConfYPositions[7] = this.screenButtonYPos;
		this.menuConfYPositions[8] = this.defaultButtonYPos;
		this.menuConfYPositions[9] = this.applyButtonYPos;
		this.menuPauseYPositions[0] = this.resumeButtonYPos;
		this.menuPauseYPositions[1] = this.titleButtonYPos;
		this.menuPauseYPositions[2] = this.instructionsButtonYPos;
		this.menuPauseYPositions[3] = this.exitButtonYPos;
		this.menuPauseYPositions[4] = this.statsButtonYPos;
		this.menuGameOverYPositions[0] = this.retryButtonYPos;
		this.menuGameOverYPositions[1] = this.exit2ButtonYPos;

	}



	public void tick() {

		this.select();

	}
/**
 * Método que selecciona la posición cada vez que se pulsa una tecla
 */
	public void select() {
		//Si nos encontramos en el menú y si pulsamos w o d el índice cambiará a 2 y disminuirá 
		 if(State.getState().equals(handler.getGame().menuState)) {

			if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)||this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {

				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				if(this.menuSelectorIndex == 3) {
					this.menuSelectorIndex = 0;
				}
				else this.menuSelectorIndex++;

			}
			//Si nos encontramos en el menú y si pulsamos s o a el índice cambiará a 0 y aumentará
			else if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)||this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				if(this.menuSelectorIndex == 0) {
					this.menuSelectorIndex = 3;
				}
				else this.menuSelectorIndex--;

			}
			//colocamos la posición del cursor dependiendo del índice
			this.setMenuX(this.menuXPositions[this.menuSelectorIndex]);
			this.setMenuY(this.menuYPositions[this.menuSelectorIndex]);

		}else if(State.getState().equals(handler.getGame().gameOverState)) {
			
			if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {

				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				if(this.gameOverSelectorIndex == 1) {
					this.gameOverSelectorIndex = 0;
				}
				else this.gameOverSelectorIndex++;

			}
			//Si nos encontramos en el menú y si pulsamos s o a el índice cambiará a 0 y aumentará
			else if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				if(this.gameOverSelectorIndex == 0) {
					this.gameOverSelectorIndex = 1;
				}
				else this.gameOverSelectorIndex--;

			}
			//colocamos la posición del cursor dependiendo del índice
			this.setMenuGameOverX(this.menuGameOverXPositions[this.gameOverSelectorIndex]);
			this.setMenuGameOverY(this.menuGameOverYPositions[this.gameOverSelectorIndex]);

		}
		 else if(State.getState().equals(handler.getGame().confState)) {
			//nos encontramos en el state de configuración y pulsamos la tecla D
			if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {

				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				//si nos encontramos al final de la primera fila volverá al principio
				//Si no encontramos al final de la segunda fila volverá al principio de esa fila
				//Si no encontramos en las últimas filas no se modificará la posición
				if(confSelectorIndex == 4) {
					confSelectorIndex = 0;				
				}else if(confSelectorIndex == 7) {
					confSelectorIndex = 5;
				}else if(confSelectorIndex == 8) {
					confSelectorIndex = 8;
				}else if(confSelectorIndex == 9) {
					confSelectorIndex = 9;
				}
				else confSelectorIndex++;

			}
			else if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {

				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				//Al pulsar la tecla A se realizará lo mismo que con la D pero al revés
				if(confSelectorIndex == 0) {
					confSelectorIndex = 4;
				}else if(confSelectorIndex == 5) {
					confSelectorIndex = 7;
				}else if(confSelectorIndex == 8) {
					confSelectorIndex = 8;
				}else if(confSelectorIndex == 9) {
					confSelectorIndex = 9;
				}
				else confSelectorIndex--;

			}
			else if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
				
				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				//Si pulsamos la tecla S y nos encontramos en cualquiera de las posiciones de la primera fila cambiará a la de abajo
				//Si nos encontramos en cualquiera de las posiciones de la segunda fila cambiará a la de abajo
				//Y si nos encontramos en la última fila cambiará a la primera
				if(confSelectorIndex == 0||confSelectorIndex == 1||confSelectorIndex == 2||confSelectorIndex == 3||confSelectorIndex == 4) {
					confSelectorIndex = 5;
				}
				else if(confSelectorIndex == 5||confSelectorIndex == 6||confSelectorIndex == 7) {
					confSelectorIndex = 8;
				}
				else if(confSelectorIndex == 9) {
					confSelectorIndex = 0;
				}
				else {
					confSelectorIndex++;
				}
			}
			else if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
				
				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				//En el caso de la tecla W será parecida a la S pero al revés
				if(confSelectorIndex == 0||confSelectorIndex == 1||confSelectorIndex == 2||confSelectorIndex == 3||confSelectorIndex == 4) {
					confSelectorIndex = 9;
				}
				else if(confSelectorIndex == 5||confSelectorIndex == 6||confSelectorIndex == 7) {
					confSelectorIndex = 0;
				}
				else if(confSelectorIndex == 8) {
					confSelectorIndex = 5;
				}
				else {
					confSelectorIndex--;
				}
			}
			this.setMenuConfX(this.menuConfXPositions[this.confSelectorIndex]);
			this.setMenuConfY(this.menuConfYPositions[this.confSelectorIndex]);
		}else if(State.getState().equals(handler.getGame().pauseState)) {
			if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)||this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {

				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				if(this.pauseSelectorIndex == 4) {
					this.pauseSelectorIndex = 0;
				}
				else this.pauseSelectorIndex++;

			}
			//Si nos encontramos en el menú y si pulsamos s o a el índice cambiará a 0 y aumentará
			else if(this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)||this.handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
				handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",0);
				if(this.pauseSelectorIndex == 0) {
					this.pauseSelectorIndex = 4;
				}
				else this.pauseSelectorIndex--;

			}
			//colocamos la posición del cursor dependiendo del índice
			this.setMenuPauseX(this.menuPauseXPositions[this.pauseSelectorIndex]);
			this.setMenuPauseY(this.menuPauseYPositions[this.pauseSelectorIndex]);
		}
	}



	public Handler getHandler() {
		return handler;
	}



	public void setHandler(Handler handler) {
		this.handler = handler;
	}



	public int getStartButtonXPos() {
		return startButtonXPos;
	}



	public void setStartButtonXPos(int startButtonXPos) {
		this.startButtonXPos = startButtonXPos;
	}



	public int getStartButtonYPos() {
		return startButtonYPos;
	}



	public void setStartButtonYPos(int startButtonYPos) {
		this.startButtonYPos = startButtonYPos;
	}


	public int getConfButtonXPos() {
		return confButtonXPos;
	}



	public void setConfButtonXPos(int confButtonXPos) {
		this.confButtonXPos = confButtonXPos;
	}



	public int getConfButtonYPos() {
		return confButtonYPos;
	}



	public void setConfButtonYPos(int confButtonYPos) {
		this.confButtonYPos = confButtonYPos;
	}



	public int getQuitButtonYPos() {
		return quitButtonYPos;
	}



	public void setQuitButtonYPos(int quitButtonYPos) {
		this.quitButtonYPos = quitButtonYPos;
	}



	public int[] getMenuXPositions() {
		return menuXPositions;
	}



	public void setMenuXPositions(int[] menuXPositions) {
		this.menuXPositions = menuXPositions;
	}



	public int[] getMenuYPositions() {
		return menuYPositions;
	}



	public void setMenuYPositions(int[] menuYPositions) {
		this.menuYPositions = menuYPositions;
	}



	public int getMenuSelectorIndex() {
		return menuSelectorIndex;
	}



	public void setMenuSelectorIndex(int menuSelectorIndex) {
		this.menuSelectorIndex = menuSelectorIndex;
	}



	public int getQuitButtonXPos() {
		return quitButtonXPos;
	}



	public void setQuitButtonXPos(int quitButtonXPos) {
		this.quitButtonXPos = quitButtonXPos;
	}



	public int getMenuX() {
		return menuX;
	}



	public void setMenuX(int menuX) {
		this.menuX = menuX;
	}



	public int getMenuY() {
		return menuY;
	}



	public void setMenuY(int menuY) {
		this.menuY = menuY;
	}



	public int getMuteButtonXPos() {
		return muteButtonXPos;
	}



	public void setMuteButtonXPos(int muteButtonXPos) {
		this.muteButtonXPos = muteButtonXPos;
	}



	public int getMuteButtonYPos() {
		return muteButtonYPos;
	}



	public void setMuteButtonYPos(int muteButtonYPos) {
		this.muteButtonYPos = muteButtonYPos;
	}



	public int[] getMenuConfXPositions() {
		return menuConfXPositions;
	}



	public void setMenuConfXPositions(int[] menuConfXPositions) {
		this.menuConfXPositions = menuConfXPositions;
	}



	public int[] getMenuConfYPositions() {
		return menuConfYPositions;
	}



	public void setMenuConfYPositions(int[] menuConfYPositions) {
		this.menuConfYPositions = menuConfYPositions;
	}



	public int getMenuConfX() {
		return menuConfX;
	}



	public void setMenuConfX(int menuConfX) {
		this.menuConfX = menuConfX;
	}



	public int getMenuConfY() {
		return menuConfY;
	}



	public void setMenuConfY(int menuConfY) {
		this.menuConfY = menuConfY;
	}



	public int getVeinticincoButtonXPos() {
		return veinticincoButtonXPos;
	}



	public void setVeinticincoButtonXPos(int veinticincoButtonXPos) {
		this.veinticincoButtonXPos = veinticincoButtonXPos;
	}



	public int getVeinticincoButtonYPos() {
		return veinticincoButtonYPos;
	}



	public void setVeinticincoButtonYPos(int veinticincoButtonYPos) {
		this.veinticincoButtonYPos = veinticincoButtonYPos;
	}



	public int getCincuentaButtonXPos() {
		return cincuentaButtonXPos;
	}



	public void setCincuentaButtonXPos(int cincuentaButtonXPos) {
		this.cincuentaButtonXPos = cincuentaButtonXPos;
	}



	public int getCincuentaButtonYPos() {
		return cincuentaButtonYPos;
	}



	public void setCincuentaButtonYPos(int cincuentaButtonYPos) {
		this.cincuentaButtonYPos = cincuentaButtonYPos;
	}



	public int getSetentaYCincoButtonXPos() {
		return setentaYCincoButtonXPos;
	}



	public void setSetentaYCincoButtonXPos(int setentaYCincoButtonXPos) {
		this.setentaYCincoButtonXPos = setentaYCincoButtonXPos;
	}



	public int getSetentaYCincoButtonYPos() {
		return setentaYCincoButtonYPos;
	}



	public void setSetentaYCincoButtonYPos(int setentaYCincoButtonYPos) {
		this.setentaYCincoButtonYPos = setentaYCincoButtonYPos;
	}



	public int getCienButtonXPos() {
		return cienButtonXPos;
	}



	public void setCienButtonXPos(int cienButtonXPos) {
		this.cienButtonXPos = cienButtonXPos;
	}



	public int getCienButtonYPos() {
		return cienButtonYPos;
	}



	public void setCienButtonYPos(int cienButtonYPos) {
		this.cienButtonYPos = cienButtonYPos;
	}



	public int getNovecientosButtonXPos() {
		return novecientosButtonXPos;
	}



	public void setNovecientosButtonXPos(int novecientosButtonXPos) {
		this.novecientosButtonXPos = novecientosButtonXPos;
	}



	public int getNovecientosButtonYPos() {
		return novecientosButtonYPos;
	}



	public void setNovecientosButtonYPos(int novecientosButtonYPos) {
		this.novecientosButtonYPos = novecientosButtonYPos;
	}



	public int getMilOchentaButtonXPos() {
		return milOchentaButtonXPos;
	}



	public void setMilOchentaButtonXPos(int milOchentaButtonXPos) {
		this.milOchentaButtonXPos = milOchentaButtonXPos;
	}



	public int getMilOchentaButtonYPos() {
		return milOchentaButtonYPos;
	}



	public void setMilOchentaButtonYPos(int milOchentaButtonYPos) {
		this.milOchentaButtonYPos = milOchentaButtonYPos;
	}



	public int getScreenButtonXPos() {
		return screenButtonXPos;
	}



	public void setScreenButtonXPos(int screenButtonXPos) {
		this.screenButtonXPos = screenButtonXPos;
	}



	public int getScreenButtonYPos() {
		return screenButtonYPos;
	}



	public void setScreenButtonYPos(int screenButtonYPos) {
		this.screenButtonYPos = screenButtonYPos;
	}



	public int getDefaultButtonXPos() {
		return defaultButtonXPos;
	}



	public void setDefaultButtonXPos(int defaultButtonXPos) {
		this.defaultButtonXPos = defaultButtonXPos;
	}



	public int getDefaultButtonYPos() {
		return defaultButtonYPos;
	}



	public void setDefaultButtonYPos(int defaultButtonYPos) {
		this.defaultButtonYPos = defaultButtonYPos;
	}



	public int getConfSelectorIndex() {
		return confSelectorIndex;
	}



	public void setConfSelectorIndex(int confSelectorIndex) {
		this.confSelectorIndex = confSelectorIndex;
	}



	public int getApplyButtonXPos() {
		return applyButtonXPos;
	}



	public void setApplyButtonXPos(int applyButtonXPos) {
		this.applyButtonXPos = applyButtonXPos;
	}



	public int getApplyButtonYPos() {
		return applyButtonYPos;
	}



	public void setApplyButtonYPos(int applyButtonYPos) {
		this.applyButtonYPos = applyButtonYPos;
	}



	public int getHowToButtonXPos() {
		return howToButtonXPos;
	}



	public void setHowToButtonXPos(int howToButtonXPos) {
		this.howToButtonXPos = howToButtonXPos;
	}



	public int getHowToButtonYPos() {
		return howToButtonYPos;
	}



	public void setHowToButtonYPos(int howToButtonYPos) {
		this.howToButtonYPos = howToButtonYPos;
	}



	public int getResumeButtonXPos() {
		return resumeButtonXPos;
	}



	public void setResumeButtonXPos(int resumeButtonXPos) {
		this.resumeButtonXPos = resumeButtonXPos;
	}



	public int getResumeButtonYPos() {
		return resumeButtonYPos;
	}



	public void setResumeButtonYPos(int resumeButtonYPos) {
		this.resumeButtonYPos = resumeButtonYPos;
	}



	public int getExitButtonXPos() {
		return exitButtonXPos;
	}



	public void setExitButtonXPos(int exitButtonXPos) {
		this.exitButtonXPos = exitButtonXPos;
	}



	public int getExitButtonYPos() {
		return exitButtonYPos;
	}



	public void setExitButtonYPos(int exitButtonYPos) {
		this.exitButtonYPos = exitButtonYPos;
	}



	public int getTitleButtonXPos() {
		return titleButtonXPos;
	}



	public void setTitleButtonXPos(int titleButtonXPos) {
		this.titleButtonXPos = titleButtonXPos;
	}



	public int getTitleButtonYPos() {
		return titleButtonYPos;
	}



	public void setTitleButtonYPos(int titleButtonYPos) {
		this.titleButtonYPos = titleButtonYPos;
	}



	public int getInstructionsButtonXPos() {
		return instructionsButtonXPos;
	}



	public void setInstructionsButtonXPos(int instructionsButtonXPos) {
		this.instructionsButtonXPos = instructionsButtonXPos;
	}



	public int getInstructionsButtonYPos() {
		return instructionsButtonYPos;
	}



	public void setInstructionsButtonYPos(int instructionsButtonYPos) {
		this.instructionsButtonYPos = instructionsButtonYPos;
	}



	public int getStatsButtonXPos() {
		return statsButtonXPos;
	}



	public void setStatsButtonXPos(int statsButtonXPos) {
		this.statsButtonXPos = statsButtonXPos;
	}



	public int getStatsButtonYPos() {
		return statsButtonYPos;
	}



	public void setStatsButtonYPos(int statsButtonYPos) {
		this.statsButtonYPos = statsButtonYPos;
	}



	public int[] getMenuPauseXPositions() {
		return menuPauseXPositions;
	}



	public void setMenuPauseXPositions(int[] menuPauseXPositions) {
		this.menuPauseXPositions = menuPauseXPositions;
	}



	public int[] getMenuPauseYPositions() {
		return menuPauseYPositions;
	}



	public void setMenuPauseYPositions(int[] menuPauseYPositions) {
		this.menuPauseYPositions = menuPauseYPositions;
	}



	public int getMenuPauseX() {
		return menuPauseX;
	}



	public void setMenuPauseX(int menuPauseX) {
		this.menuPauseX = menuPauseX;
	}



	public int getMenuPauseY() {
		return menuPauseY;
	}



	public void setMenuPauseY(int menuPauseY) {
		this.menuPauseY = menuPauseY;
	}



	public int[] getMenuGameOverXPositions() {
		return menuGameOverXPositions;
	}



	public void setMenuGameOverXPositions(int[] menuGameOverXPositions) {
		this.menuGameOverXPositions = menuGameOverXPositions;
	}



	public int[] getMenuGameOverYPositions() {
		return menuGameOverYPositions;
	}



	public void setMenuGameOverYPositions(int[] menuGameOverYPositions) {
		this.menuGameOverYPositions = menuGameOverYPositions;
	}



	public int getPauseSelectorIndex() {
		return pauseSelectorIndex;
	}



	public void setPauseSelectorIndex(int pauseSelectorIndex) {
		this.pauseSelectorIndex = pauseSelectorIndex;
	}



	public int getGameOverSelectorIndex() {
		return gameOverSelectorIndex;
	}



	public void setGameOverSelectorIndex(int gameOverSelectorIndex) {
		this.gameOverSelectorIndex = gameOverSelectorIndex;
	}



	public int getMenuGameOverX() {
		return menuGameOverX;
	}



	public void setMenuGameOverX(int menuGameOverX) {
		this.menuGameOverX = menuGameOverX;
	}



	public int getMenuGameOverY() {
		return menuGameOverY;
	}



	public void setMenuGameOverY(int menuGameOverY) {
		this.menuGameOverY = menuGameOverY;
	}



	public int getRetryButtonXPos() {
		return retryButtonXPos;
	}



	public void setRetryButtonXPos(int retryButtonXPos) {
		this.retryButtonXPos = retryButtonXPos;
	}



	public int getRetryButtonYPos() {
		return retryButtonYPos;
	}



	public void setRetryButtonYPos(int retryButtonYPos) {
		this.retryButtonYPos = retryButtonYPos;
	}



	public int getExit2ButtonXPos() {
		return exit2ButtonXPos;
	}



	public void setExit2ButtonXPos(int exit2ButtonXPos) {
		this.exit2ButtonXPos = exit2ButtonXPos;
	}



	public int getExit2ButtonYPos() {
		return exit2ButtonYPos;
	}



	public void setExit2ButtonYPos(int exit2ButtonYPos) {
		this.exit2ButtonYPos = exit2ButtonYPos;
	}


	



}