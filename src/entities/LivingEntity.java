package entities;

import main.Handler;
import resources.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Clase para una entidad viva con movimiento
 * @author Edgar Rubio
 *
 */
public class LivingEntity extends Entity {

	public BufferedImage[] frames;

	int speed = 2;
	protected boolean isMoving;


	//como empezará el jugador
	protected Rectangle nextArea;
	public String facing = "Down";

    public LivingEntity(Handler handler, int xPosition, int yPosition, BufferedImage[] animFrames) {
		super(handler, xPosition, yPosition);
        nextArea = new Rectangle();
		frames = animFrames;

	}
	
/**
 * Método que controla las animaciones en movimiento y paradas
 * @param animDown animación movimiento hacia abajo
 * @param animUp animación movimiento hacia arriba
 * @param animLeft animación movimiento hacia izquierda
 * @param animRight animación movimiento hacia derecha
 * @param front imagen parado hacia abajo
 * @param back imagen parado hacia arriba
 * @param left imagen parado hacia la izquierda
 * @param right imagen parado hacia la derecha
 * @return la imagen en cada caso
 */
	 public BufferedImage getCurrentAnimationFrame( Animation animDown, Animation animUp, Animation animLeft, Animation animRight, BufferedImage[] front,BufferedImage[] back,BufferedImage[] left,BufferedImage[] right) {
		BufferedImage frame = null;
		 if(isMoving) {
				switch (facing) {
				case "Down":
					frame =  animDown.getCurrentFrame();
					break;
				case "Up":
					frame =  animUp.getCurrentFrame();
					break;
				case "Right":
					frame = animRight.getCurrentFrame();
					break;
				case "Left":
					frame = animLeft.getCurrentFrame();
					break;
				}
			}
			else {
				switch (facing) {
				case "Down":
					frame =  front[0];
					break;
				case "Up":
					frame =  back[0];
					break;
				case "Right":
					frame = right[0];
					break;
				case "Left":
					frame = left[0];
					break;
				}
			}
		 return frame;
	 }

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
