package resources;

import main.Handler;

import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que controla los elementos UI
 * @author Edgar Rubio
 */
public class UIManager {

	private Handler handler;
	private ArrayList<UIObject> objects;

	public UIManager(Handler handler){
		this.handler=handler;
		objects = new ArrayList<>();
	}

	public void tick(){
		for(UIObject o: objects){
			o.tick();
		}
	}

	public void Render(Graphics g){
		for(UIObject o: objects){
			o.render(g);
		}
	}

	public void addObjects (UIObject o){
		objects.add(o);
	}

	public void removeObsjects(UIObject o){
		objects.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public void isActive(ArrayList<UIObject> o, Boolean active){
		for(UIObject i: o){
			i.active=active;
		}
	}

}