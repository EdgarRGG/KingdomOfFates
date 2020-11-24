package inWorldAreas;

import main.GameSetUp;
import main.Handler;
import resources.Images;
import java.awt.*;
import java.util.ArrayList;

import entities.Boss;
import entities.EnemyOne;
import entities.EnemyTwo;
import entities.EntityManager;
import walls.InWorldWalls;
/**
 * Clase que controla el área del castillo así como los enemigos en ella.
 * @author Edgar Rubio
 *
 */
public class CastleArea extends BaseArea {

    Rectangle playerRect;
    public static boolean InCastle = false;

    public final static int playerXSpawn = -800, playerYSpawn = -3080;

    private Rectangle background = new Rectangle(3000, 3000);

    public static ArrayList<InWorldWalls> castleWalls;

    public CastleArea(Handler handler, EntityManager entityManager) {
        super(handler, entityManager);
        name="Castle";
        handler.setxInWorldDisplacement(playerXSpawn);
        handler.setyInWorldDisplacement(playerYSpawn);

        playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);
        

        this.entityManager = entityManager;
        
        this.entityManager.AddEntity(new EnemyOne(handler, 1000, 2000, "InWorldState", "Black Knight", "Castle"));
        this.entityManager.AddEntity(new EnemyOne(handler, 2400, 2000, "InWorldState", "Black Knight", "Castle"));
        this.entityManager.AddEntity(new EnemyOne(handler, 1000, 3000, "InWorldState", "Black Knight", "Castle"));
        this.entityManager.AddEntity(new EnemyOne(handler, 2400, 3000, "InWorldState", "Black Knight", "Castle"));
        this.entityManager.AddEntity(new EnemyTwo(handler, 1000, 850, "InWorldState", "Black Lancer", "Castle"));
        this.entityManager.AddEntity(new EnemyTwo(handler, 2400, 850, "InWorldState", "Black Lancer", "Castle"));
        this.entityManager.AddEntity(new Boss(handler, 1700, 420, "InWorldState", "Modred", "Castle"));
        
        castleWalls = new ArrayList<>();
        AddWalls();

    }

    public void tick() {
        super.tick();

        for (InWorldWalls w : castleWalls) {
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

        g2.setColor(new Color(17, 15, 12));
        g2.fill(background);

        g.drawImage(Images.scaledCastle, handler.getxInWorldDisplacement(), handler.getyInWorldDisplacement(), null);

        if (GameSetUp.DEBUGMODE) {
            for (InWorldWalls w : castleWalls) {

                if (w.getType().equals("Wall"))
                    g2.setColor(Color.black);
                else
                    g2.setColor(Color.PINK);

                w.render(g2);
            }
        }


        entityManager.render(g);

    }
/**
 * Método que añade muros al mapa del castillo
 */
    private void AddWalls() {
    	//zona sur
    	castleWalls.add(new InWorldWalls(handler, 980, 3780, 400, 30, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 1350, 3810, 30, 150, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 1380, 3920, 150, 30, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 2150, 3920, 150, 30, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 2300, 3810, 30, 150, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 2300, 3780, 400, 30, "Wall"));
    	//Salida del castillo
    	castleWalls.add(new InWorldWalls(handler, 1530, 3870, 620, 50, "Exit"));
    	//bordes izquierdos
    	castleWalls.add(new InWorldWalls(handler, 980, 1580, 30, 2200, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 1000, 1580, 490, 30, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 1300, 1610, 70, 60, "Wall"));
    	//bordes derechos
    	castleWalls.add(new InWorldWalls(handler, 2670, 1580, 30, 2200, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 2200, 1580, 490, 30, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 2310, 1610, 70, 60, "Wall"));
    	//escaleras izquierda
    	castleWalls.add(new InWorldWalls(handler, 1490, 1130, 20, 660, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 800, 1130, 690, 20, "Wall"));
    	//escaleras derecha
    	castleWalls.add(new InWorldWalls(handler, 2170, 1130, 20, 660, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 2170, 1130, 690, 20, "Wall"));
    	//bordes trono
    	castleWalls.add(new InWorldWalls(handler, 2790, -70, 30, 1200, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 860, -70, 30, 1200, "Wall"));
    	castleWalls.add(new InWorldWalls(handler, 860, 390, 2000, 20, "Wall"));
    	//planta trono
    	castleWalls.add(new InWorldWalls(handler, 2010, 420, 70, 80, "Wall"));


    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return castleWalls;
    }
}




