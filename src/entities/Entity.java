package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.Handler;
/**
 * Clase de la que extienden el resto de entidades
 * @author Usuario
 *
 */
public class Entity {

	protected Handler handler;
	
	public double xPosition;
	public double yPosition;
	
	public Entity(Handler handler, double xPosition, double yPosition) {
		this.handler = handler;
	}
	
	public void tick() {
		
	}
	public void render(Graphics g){
		
	}
	
	public Rectangle getCollision() {
		return new Rectangle(); // marcador de posición
	}
	public double getXOffset() {
		return this.xPosition;
	}
	public double getYOffset() {
		return this.yPosition;
	}
	public void setXOffset(double xPosition) {
		this.xPosition = xPosition;
	}
	public void setYOffset(double yPosition) {
		this.yPosition = yPosition;
	}
	
}
