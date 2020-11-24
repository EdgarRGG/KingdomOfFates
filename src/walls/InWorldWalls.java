package walls;


import main.Handler;
/**
 * Clase que define los muros de las áreas del mapa
 * @author Edgar Rubio
 *
 */
public class InWorldWalls extends OverWorldWalls {
	
	
	public InWorldWalls(Handler handler, int x, int y, int width, int height, String wallType) {
		super(handler, x, y, width, height, wallType);

		this.originalX = x;
		this.originalY = y;
		this.handler = handler;
		this.wallType = wallType;
	}

	@Override
	public void tick() {
		this.x = handler.getxInWorldDisplacement() + originalX;
		this.y = handler.getyInWorldDisplacement() + originalY;
	}
}
