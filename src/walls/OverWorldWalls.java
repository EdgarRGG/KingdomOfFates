package walls;

import main.Handler;

import java.awt.*;


/**
 * Clase que controla los muros del mapa principal: Muros de bloqueo y muros de entrada
 * @author Edgar Rubio
 *
 */
public class OverWorldWalls extends Rectangle {

    protected Handler handler;
    protected int originalX,originalY;
    protected String wallType;
    
    public OverWorldWalls(Handler handler, int x, int y, int width, int height, String wallType) {
        super(x, y, width, height);
        
        originalX = x;
        originalY = y;
        this.handler = handler;
        this.wallType = wallType;

    }
/**
 * controlamos que los muros se situen en todo momento en el mismo lugar aunque nos movamos
 */
    public void tick(){
        this.x = handler.getXDisplacement() + originalX;
        this.y = handler.getYDisplacement() + originalY;
    }

    public void render(Graphics2D g2){
        g2.draw(this);
    }

    public String getType() {
    	
    	return wallType;
    }
    
    
    
    
    
}
