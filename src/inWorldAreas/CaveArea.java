package inWorldAreas;

import main.GameSetUp;
import main.Handler;
import resources.Images;
import java.awt.*;
import java.util.ArrayList;

import entities.EnemyOne;
import entities.EnemyTwo;
import entities.EntityManager;
import walls.InWorldWalls;
import walls.OverWorldWalls;
/**
 * Clase que controla el área de la Cueva así como los enemigos en ella.
 * @author Edgar Rubio
 *
 */
public class CaveArea extends BaseArea {

    Rectangle playerRect;
    public static boolean InCave = false;

    private int imageWidth = 3680, imageHeight = 4000;
    public final static int playerXSpawn = -310, playerYSpawn = -3080;

    private Rectangle background = new Rectangle(3000, 3000);

    public static ArrayList<InWorldWalls> caveWalls;

    public CaveArea(Handler handler, EntityManager entityManager) {
        super(handler, entityManager);
        name="Cave";
        handler.setxInWorldDisplacement(playerXSpawn);
        handler.setyInWorldDisplacement(playerYSpawn);

        playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);
        

        this.entityManager = entityManager;
        
        this.entityManager.AddEntity(new EnemyOne(handler, 2780, 1770, "InWorldState", "Black Knight", "Cave"));
        this.entityManager.AddEntity(new EnemyTwo(handler, 100, 1690, "InWorldState", "Black Lancer", "Cave"));
        this.entityManager.AddEntity(new EnemyOne(handler, 100, 2500, "InWorldState", "Black knight", "Cave"));
        this.entityManager.AddEntity(new EnemyTwo(handler, 2200, 1770, "InWorldState", "Black Lancer", "Cave"));
        
        
        caveWalls = new ArrayList<>();
        AddWalls();

    }

    public void tick() {
        super.tick();

        for (InWorldWalls w : caveWalls) {
            w.tick();
        }
        if(!GameSetUp.LOADING) {
            entityManager.tick();
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);


        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);
        g2.fill(background);

        g.drawImage(Images.scaledCave, handler.getxInWorldDisplacement(), handler.getyInWorldDisplacement(), null);

        if (GameSetUp.DEBUGMODE) {
            for (OverWorldWalls w : caveWalls) {

                if (w.getType().equals("Wall"))
                    g2.setColor(Color.black);
                else
                    g2.setColor(Color.PINK);

                w.render(g2);
            }
        }


        entityManager.render(g);

    }

    private void AddWalls() {

    	//bordes
        caveWalls.add(new InWorldWalls(handler, 100, 0, 10, imageHeight, "Wall"));								
        caveWalls.add(new InWorldWalls(handler, 0, imageHeight-100, imageWidth/3, 50, "Wall"));					
        caveWalls.add(new InWorldWalls(handler, imageWidth/2-350, imageHeight-100, imageWidth/4, 50, "Wall"));	
        caveWalls.add(new InWorldWalls(handler, 0, 130, imageWidth, 10, "Wall"));								
        caveWalls.add(new InWorldWalls(handler, imageWidth - 130, 0, 10, imageHeight, "Wall"));					

        //pequeña parte de agua
        caveWalls.add(new InWorldWalls(handler, 200, 3400, 400, 400, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 500, 3075, 125, 100, "Wall"));									
        //lago
        caveWalls.add(new InWorldWalls(handler, 2440, 3355, 1, 500, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 1985, 3190, 500, 140, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 1665, 3030, 500, 140, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 1495, 2285, 1040, 700, "Wall"));								
        caveWalls.add(new InWorldWalls(handler, 1595, 2985, 100, 100, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 2520, 2750, 800, 1, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 3258, 2608, 400, 400, "Wall"));									
        //lava
        caveWalls.add(new InWorldWalls(handler, 216, 500, 1030, 1000, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 1246, 518, 300, 415, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 222, 1428, 1010, 130, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 184, 1640, 100, 100, "Wall"));									

        //parte de la antorcha
        caveWalls.add(new InWorldWalls(handler, 176, 140, 455, 345, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 661, 205, 120, 100, "Wall"));									

        //estatua
        caveWalls.add(new InWorldWalls(handler, 1940, 2130, 100, 100, "Wall"));	        
        //agujero al lado de la salida
        caveWalls.add(new InWorldWalls(handler, 3380, 510, 120, 100, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 2744, 140, 200, 300, "Wall"));									
        caveWalls.add(new InWorldWalls(handler, 3288, 140, 200, 300, "Wall"));									
        //entrada
        caveWalls.add(new InWorldWalls(handler, imageWidth/3, imageHeight, 300, 50, "Wall"));					
        //Salida del principio
        caveWalls.add(new InWorldWalls(handler, 2950, 340, 320, 100, "Start Exit"));
        //Salida del final
        caveWalls.add(new InWorldWalls(handler, 1230, 3900, 280, 100, "End Exit"));							



    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return caveWalls;
    }
}




