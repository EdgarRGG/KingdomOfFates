package input;
import main.GameSetUp;
import main.Handler;
import walls.OverWorldWalls;

import java.awt.*;
import java.util.ArrayList;
/**
 * Clase que controla los muros del mapa principal
 * @author Edgar Rubio
 *
 */
public class WorldManager {

	protected Handler handler;
	Rectangle rectangle;
	public static boolean townEntered = false;
	ArrayList<OverWorldWalls> worldWalls;

	public WorldManager(Handler handler) {
		this.handler = handler;

		rectangle = new Rectangle();

		AddWalls();
		

	}

	public void tick() {
		for (OverWorldWalls w: this.worldWalls) {
			w.tick();
		}

	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(GameSetUp.DEBUGMODE){

			g2.setColor(Color.BLACK);
			g2.draw(rectangle);
			for (OverWorldWalls w: this.worldWalls) {

				if (w.getType().equals("Wall"))
					g2.setColor(Color.black);
				else
					g2.setColor(Color.PINK);

				w.render(g2);
			}
		}
	}

	// añade los muros del mapa principal
	private void AddWalls() {
		worldWalls = new ArrayList<>();
		//muros externos
		worldWalls.add(new OverWorldWalls(handler, 1660, 1650, 300, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1430, 1250, 20, 200, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1430, 1450, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1500, 1550, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1600, 1630, 60, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2210, 1250, 20, 200, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2130, 1450, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2060, 1520, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1960, 1630, 60, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2000, 1600, 60, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1230, 1240, 200, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1130, 1190, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1130, 1130, 20, 60, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1010, 1080, 100, 50, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 960, 920, 20, 160, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 820, 880, 150, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 800, 680, 20, 200, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 800, 660, 120, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 930, 620, 120, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1030, 620, 100, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1150, 520, 20, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1030, 500, 120, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1060, 350, 20, 150, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1080, 310, 60, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1140, 270, 60, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1180, 230, 60, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2240, 1240, 300, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2500, 1180, 20, 70, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2520, 1130, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2620, 530, 20, 600, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2420, 530, 200, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2420, 480, 20, 50, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2440, 430, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2490, 360, 20, 70, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2300, 310, 150, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2450, 310, 50, 50, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2180, 280, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 2080, 310, 100, 100, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1950, 430, 150, 20, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1930, 230, 20, 200, "Wall"));
		worldWalls.add(new OverWorldWalls(handler, 1680, 210, 250, 20, "Wall"));
		//todo el castillo
		worldWalls.add(new OverWorldWalls(handler, 1260, 75, 400, 300, "Wall"));
		//toda la cueva
		worldWalls.add(new OverWorldWalls(handler, 1920, 680, 430, 200, "Wall"));
		//entrada de la aldea
		worldWalls.add(new OverWorldWalls(handler,1760, 1250, 170, 140, "Door Town"));
		//entrada al castillo
		worldWalls.add(new OverWorldWalls(handler, 1430, 350, 50, 50, "Door Castle"));
		//entrada a la cueva
		worldWalls.add(new OverWorldWalls(handler, 2015, 855, 50, 50, "Door Cave"));
		

		
		
	}
	public ArrayList<OverWorldWalls> getWalls() {
		return worldWalls;
	}

}
