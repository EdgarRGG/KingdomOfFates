package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import main.Handler;

/**
 * Clase que controla la adición y eliminación de entidades 
 * @author Edgar Rubio
 *
 */
public class EntityManager {
	
	protected Handler handler;
	protected Player player;
	ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<>();
	}
	
	public void tick() {
			
			for (Entity e : entities) {
				//instanceof compara si es una instancia de la clase, devuelve true o false
				if(e instanceof  EnemyEntity){
					if(!((EnemyEntity) e).isDead()) {
						if(((EnemyEntity) e).Area.equals(handler.getArea())){
							e.tick();
						}
					}
				}else {
					e.tick();
				}
			}		
			
			player.tick();
			
		}
		
	

	public void render(Graphics g){
		player.render(g);
		
		for (Entity e : entities) {
			if(e instanceof EnemyEntity) {
				if(!((EnemyEntity) e).isDead()) e.render(g);
			}
			else {
				e.render(g);
			}
		}
	}
	
	
	public void AddEntity(Entity e) {
		entities.add(e);
	}


	public void RemoveEntity(Entity e) {
		entities.remove(e);
	}
	
	

	public Player getPlayer() {
		return player;
	}
}
