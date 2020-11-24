package resources;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.Handler;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que controla los sonidos, musica y efectos del juego
 * @author Edgar Rubio
 *
 */
public class MusicHandler {


	private Media media;
	private MediaPlayer player;
	private JFXPanel fxPanel;
	
	public boolean isPlaying = false;
	private String path;
	public boolean alreadyStarted = false;
	private boolean Loop = false;

	private ArrayList<MediaPlayer> playerE = new ArrayList<>();
	private Media mediaE;
	private String pathE;

	private Handler handler;

	public MusicHandler(Handler handler){
		this.handler = handler;
		fxPanel = new JFXPanel();

	}
/**
 * Método para activar la música
 */
	public void play(){
		if(!isPlaying){
			if(!alreadyStarted) {
				player = new MediaPlayer(media);
				player.play();
				isPlaying = true;
				alreadyStarted = true;
			}else{
				player.play();
			}
		}

	}
/**
 * Método para parar la música
 */
	public void stop() {
		player.stop();
	}
/**
 * Método para pausar la música	
 */
	public void pause(){
		if(isPlaying){
			player.pause();
			isPlaying = false;
		}
	}
/**
 * Método para cambiar la música
 * @param Path es el ruta del nuevo recurso
 */
	public void set_changeMusic(String Path){

		if(isPlaying){
			pause();
			alreadyStarted = false;
		}
		path= Path;
		media = new Media(new File(Path).toURI().toString());

	}
/**
 * Método para que suene un efecto
 * @param EPath ruta del efecto
 * @param index 
 */
	public void playEffect(String EPath,int index){

		pathE=EPath;
		mediaE = new Media(new File(EPath).toURI().toString());
		playerE.add(index, new MediaPlayer(mediaE));
		if(getPlayer().getVolume()>0) {
			playerE.get(index).setVolume(getPlayer().getVolume());
		}else{
			playerE.get(index).setVolume(0);
		}
		playerE.get(index).play();

	}
	
	public void stopEffect(int index){

		playerE.get(index).stop();

	}

	public MediaPlayer getEffect(int index){

		return playerE.get(index);

	}

	public ArrayList<MediaPlayer> getEPlayer(){
		return playerE;
	}

	public MediaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(MediaPlayer player) {
		this.player = player;
	}

	public void setLoop(boolean loop){
		Loop = loop;
		if(loop){
			player.setCycleCount(-1);
		}else{
			player.setCycleCount(1);
			player.setOnEndOfMedia(() -> {
				alreadyStarted = false;
				isPlaying = false;
			});
		}
	}

	// una vez ha empezado el sonido o musica
	public void setVolume (double volume){
		player.setVolume(volume);
	}

	public void setEffectVolume(int index, double volume) {
		playerE.get(index).setVolume(volume);
	}

}
