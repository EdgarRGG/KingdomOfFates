package main;

import input.KeyManager;
import resources.Images;
import resources.MusicHandler;
import states.*;
import ui.DisplayScreen;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.FileReader;

import org.json.JSONObject;

import entities.Boss;
import entities.EnemyOne;
import entities.EnemyTwo;
import states.InWorldState;


/**
 * Clase que inicializa la aplicación
 * @author Edgar Rubio
 *
 */

public class GameSetUp implements Runnable {
    private DisplayScreen display;
    public String title;

    public static boolean LOADING = false;//cuando es true espera 1 segundo para que cargue todo
    public static int loadCounter=0;//reaches 60 = loaded

    public static boolean SWITCHING = false;
    public static boolean DEBUGMODE = false;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //Input
    private KeyManager keyManager;
    

    //Handler
    private Handler handler;

    //States
    
    public State menuState;
    public State confState;
    public State statsState;
    public State gameOverState;
    public State instructionMenuState;
    public State overWorldState;
    public PauseState pauseState;
    public State townState;
    public InWorldState inWorldState;
    
    //saves
    public ConfState confStateSave;
    double volume;
    int width;
    int height;
    

    //music
    private MusicHandler musicHandler;


    public GameSetUp(String title,Handler handler){

        this.handler = handler;

        this.title = title;
        keyManager = new KeyManager();
        
        musicHandler = new MusicHandler(handler);

    }

    private void init(){
    	confStateSave = new ConfState(handler);
    	if(confStateSave.getSave().exists()) {
    		this.loadSave();
    		display = new DisplayScreen(title, height, width);
            display.getFrame().addKeyListener(keyManager);
            Images img = new Images();
            
            menuState = new MenuState(handler);
            confState = new ConfState(handler);
            instructionMenuState = new InstructionsState(handler);
            overWorldState = new OverWorld(handler);
            pauseState = new PauseState(handler);
            statsState = new StatsState(handler);
            townState = new TownState(handler);
            inWorldState = new InWorldState(handler);
            gameOverState = new GameOverState(handler);
            

            State.setState(menuState);

            musicHandler.set_changeMusic("res/music/Overture.mp3");
            musicHandler.play();
            musicHandler.setLoop(true);
            musicHandler.setVolume(volume);
    	}else {
    		display = new DisplayScreen(title, handler.width, handler.height);
            display.getFrame().addKeyListener(keyManager);
            Images img = new Images();
            
            menuState = new MenuState(handler);
            confState = new ConfState(handler);
            instructionMenuState = new InstructionsState(handler);
            overWorldState = new OverWorld(handler);
            pauseState = new PauseState(handler);
            statsState = new StatsState(handler);
            townState = new TownState(handler);
            inWorldState = new InWorldState(handler);
            gameOverState = new GameOverState(handler);
            

            State.setState(menuState);

            musicHandler.set_changeMusic("res/music/Overture.mp3");
            musicHandler.play();
            musicHandler.setLoop(true);
            musicHandler.setVolume(0.10);
    	}
    }
    
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
      //ejecuta el método run de la clase
        thread = new Thread(this);
        thread.start();
    }
/**
 * Método sacado de stackoverflow gracias a Pablo Lozano.
 */
    public void run(){

    	//inicializa todo para evitar problemas al arrancar
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
        	//se asegura de que el juego vaya a 60 FPS
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
            	//re-reenderiza alrededor de 60 veces por segundo
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    private void tick(){
    	//busca los tipos de teclas y las controla
        keyManager.tick();

      //el game state principal es el menu
        if(State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //limpiamos la pantalla
        g.clearRect(0, 0,  handler.width, handler.height);

        //pintamos el state principal que en este caso es el menú

        if(State.getState() != null)
            State.getState().render(g);


        //terminamos de pintar
        bs.show();
        g.dispose();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
			width = object.optInt("width", confStateSave.getWidthRes());
			height = object.optInt("height", confStateSave.getHeightRes());

		} catch (Exception ex) {
			System.out.println("Error");
		}
    }
  /**
   * Método que reinicia el mundo y los enemigos  
   */
    public void reStart() {
        this.overWorldState = new OverWorld(handler);
        this.inWorldState = new InWorldState(handler);
        EnemyOne.lvl = 1;
        EnemyTwo.lvl = 2;
        Boss.isDead = false;
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MusicHandler getMusicHandler() {
        return musicHandler;
    }

    public DisplayScreen getDisplay() {
        return display;
    }

    public void setDisplay(DisplayScreen display) {
        this.display = display;
    }

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
    
}

