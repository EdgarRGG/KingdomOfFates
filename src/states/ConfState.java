package states;

import main.Handler;
import resources.Images;
import ui.Selector;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONObject;


/**
 * Clase que configura el volumen de la música y la resolución de la pantalla.
 * @author Edgar Rubio
 *
 */
public class ConfState extends State {

	Selector selector = new Selector(this.handler);
	public File save = new File("config.json");
	double volume = 0.1;
	double volumeLoaded;
	int heightRes = handler.getDEFAULTHEIGHT();
	int widthRes = handler.getDEFAULTWIDTH();
	boolean apply = false;

	public ConfState(Handler handler) {
		super(handler);
	}
/**
 * Selecciona las posiciones y al pulsar escape vuelve al menú principal
 */
	@Override
	public void tick() {
		selector.tick();
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
             returnToMenu();
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
            g.drawImage(Images.confImage, 0, 0, handler.getWidth(), handler.getHeight(), null);
            g.drawImage(Images.volume,handler.getWidth()/2 - 780,handler.getHeight()/2 - 100,300,150,null);
            g.drawImage(Images.resolution,handler.getWidth()/2 - 780,handler.getHeight()/2 + 50,300,130,null);

            //Si la posición del selector es alguna de las posiones de las imágenes se pinta la imagen seleccionada
            //de la misma, y si no, la imagen normal
            if(selector.getMenuConfX() == selector.menuConfXPositions[0] && selector.getMenuConfY() == selector.menuConfYPositions[0]) {
    			g.drawImage(Images.muted[1],selector.getMuteButtonXPos(), selector.getMuteButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.muted[0],selector.getMuteButtonXPos(), selector.getMuteButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[1] && selector.getMenuConfY() == selector.menuConfYPositions[1]) {
    			g.drawImage(Images.veinticinco[1],selector.getVeinticincoButtonXPos(), selector.getVeinticincoButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.veinticinco[0],selector.getVeinticincoButtonXPos(), selector.getVeinticincoButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[2] && selector.getMenuConfY() == selector.menuConfYPositions[2]) {
    			g.drawImage(Images.cincuenta[1],selector.getCincuentaButtonXPos(), selector.getCincuentaButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.cincuenta[0],selector.getCincuentaButtonXPos(), selector.getCincuentaButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[3] && selector.getMenuConfY() == selector.menuConfYPositions[3]) {
    			g.drawImage(Images.setentaycinco[1],selector.getSetentaYCincoButtonXPos(), selector.getSetentaYCincoButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.setentaycinco[0],selector.getSetentaYCincoButtonXPos(), selector.getSetentaYCincoButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[4] && selector.getMenuConfY() == selector.menuConfYPositions[4]) {
    			g.drawImage(Images.cien[1],selector.getCienButtonXPos(), selector.getCienButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.cien[0],selector.getCienButtonXPos(), selector.getCienButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[5] && selector.getMenuConfY() == selector.menuConfYPositions[5]) {
    			g.drawImage(Images.novecientos[1],selector.getNovecientosButtonXPos(), selector.getNovecientosButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.novecientos[0],selector.getNovecientosButtonXPos(), selector.getNovecientosButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[6] && selector.getMenuConfY() == selector.menuConfYPositions[6]) {
    			g.drawImage(Images.milOchenta[1],selector.getMilOchentaButtonXPos(), selector.getMilOchentaButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.milOchenta[0],selector.getMilOchentaButtonXPos(), selector.getMilOchentaButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[7] && selector.getMenuConfY() == selector.menuConfYPositions[7]) {
    			g.drawImage(Images.screen[1],selector.getScreenButtonXPos(), selector.getScreenButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.screen[0],selector.getScreenButtonXPos(), selector.getScreenButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[8] && selector.getMenuConfY() == selector.menuConfYPositions[8]) {
    			g.drawImage(Images.def[1],selector.getDefaultButtonXPos(), selector.getDefaultButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.def[0],selector.getDefaultButtonXPos(), selector.getDefaultButtonYPos(), 120, 100, null);
    		}
            if(selector.getMenuConfX() == selector.menuConfXPositions[9] && selector.getMenuConfY() == selector.menuConfYPositions[9]) {
    			g.drawImage(Images.apply[1],selector.getApplyButtonXPos(), selector.getApplyButtonYPos(), 120, 100, null);
    		}

    		else {
    			g.drawImage(Images.apply[0],selector.getApplyButtonXPos(), selector.getApplyButtonYPos(), 120, 100, null);
    		}
        }

/**
 * Método que devuelve al menú principal y si los cambios no se han aplicado carga los últimos realizados
 */
    private void returnToMenu(){
    	if(apply == false) {
    		if(save.exists()) {
    		loadSave();
    		handler.getGame().getMusicHandler().setVolume(volumeLoaded);
    		}else {
    			handler.getGame().getMusicHandler().setVolume(0.1);
    		}
    	}
    	State.setState(handler.getGame().menuState);
	}
	/**
	 * Método que controla los casos de modificar el volumen, la resolución y el guardado de la configuración
	 */
    private void choose() {
		//Si el effect player no está vacío y el efecto no es igual a null, paramos el sonido y reproducimos uno nuevo
		if(!handler.getGame().getMusicHandler().getEPlayer().isEmpty()&&!handler.getGame().getMusicHandler().getEffect(0).equals(null)) {
			handler.getGame().getMusicHandler().stopEffect(0);
		}
		handler.getGame().getMusicHandler().playEffect("res/music/enterSelect.wav",0);

		if(selector.getMenuConfX() == selector.menuConfXPositions[0] && selector.getMenuConfY() == selector.menuConfYPositions[0]) {
			handler.getGame().getMusicHandler().setVolume(0.0);
			volume = 0.0;
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[1] && selector.getMenuConfY() == selector.menuConfYPositions[1]) {
			handler.getGame().getMusicHandler().setVolume(0.025);
			volume = 0.025;
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[2] && selector.getMenuConfY() == selector.menuConfYPositions[2]) {
			handler.getGame().getMusicHandler().setVolume(0.05);
			volume = 0.05;
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[3] && selector.getMenuConfY() == selector.menuConfYPositions[3]) {
			handler.getGame().getMusicHandler().setVolume(0.075);
			volume = 0.075;
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[4] && selector.getMenuConfY() == selector.menuConfYPositions[4]) {
			handler.getGame().getMusicHandler().setVolume(0.1);
			volume = 0.1;
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[5] && selector.getMenuConfY() == selector.menuConfYPositions[5]) {
			heightRes = 900;
			widthRes = 1920;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[6] && selector.getMenuConfY() == selector.menuConfYPositions[6]) {
			heightRes = 1080;
			widthRes = 1720;
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[7] && selector.getMenuConfY() == selector.menuConfYPositions[7]) {
			heightRes = handler.getDEFAULTHEIGHT();
			widthRes = handler.getDEFAULTWIDTH();
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[8] && selector.getMenuConfY() == selector.menuConfYPositions[8]) {
			handler.getGame().getMusicHandler().setVolume(0.1);
			volume = 0.1;
			heightRes = handler.getDEFAULTHEIGHT();
			widthRes = handler.getDEFAULTWIDTH();
			apply = false;
		}
		else if(selector.getMenuConfX() == selector.menuConfXPositions[9] && selector.getMenuConfY() == selector.menuConfYPositions[9]) {
			this.saveConf(volume, heightRes, widthRes);
			apply = true;
		}
	}
    /**
     * Método que guarda en un fichero la configuración seleccionada
     * @param volume volumen de la música
     * @param width anchura de la pantalla
     * @param height altura de la pantalla
     */
    private void saveConf(double volume, int width, int height) {
    	JSONObject object = new JSONObject();
		object.put("volumen",volume);
		object.put("height", height);
		object.put("width", width);
    		try (FileWriter writer = new FileWriter(save)) {
    			writer.write(object.toString());
    		} catch (Exception ex) {
    			System.out.println("Error");
    		}
    }
    /**
     * Método que carga el volumen guardado
     */
    private void loadSave() {
    	try (FileReader reader = new FileReader(save)) {
			StringBuilder builder = new StringBuilder();
			int temp;
			while ((temp = reader.read()) != -1)
				builder.append((char)temp);
			
			JSONObject object = new JSONObject(builder.toString());
			volumeLoaded= object.optDouble("volumen", volume);

		} catch (Exception ex) {
			System.out.println("Error");
		}
    }
	public File getSave() {
		return save;
	}
	public void setSave(File save) {
		this.save = save;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public int getHeightRes() {
		return heightRes;
	}
	public void setHeightRes(int heightRes) {
		this.heightRes = heightRes;
	}
	public int getWidthRes() {
		return widthRes;
	}
	public void setWidthRes(int widthRes) {
		this.widthRes = widthRes;
	}
    
}
