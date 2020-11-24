package states;

import entities.EntityManager;
import inWorldAreas.BaseArea;
import inWorldAreas.CastleArea;
import inWorldAreas.CaveArea;
import main.GameSetUp;
import main.Handler;
import java.awt.*;
import java.awt.event.KeyEvent;

import resources.Images;
/**
 * Clase que prepara las áreas del mapa
 * @author Edgar Rubio
 *
 */
public class InWorldState extends State{


    public EntityManager entityManager;	
    public static BaseArea currentArea;
    public static BaseArea caveArea;
    public static BaseArea castleArea;

    public InWorldState(Handler handler) {
        super(handler);
        entityManager = new EntityManager(handler, handler.getEntityManager().getPlayer());

        caveArea = new CaveArea(handler, entityManager);
        castleArea = new CastleArea(handler, entityManager);

    }

    @Override
    public void tick() {
        if(GameSetUp.LOADING){
            if(GameSetUp.loadCounter>=90){
                GameSetUp.loadCounter=0;
                GameSetUp.LOADING=false;
                return;
            }
            if (currentArea != null) {
                currentArea.tick();
            }
            GameSetUp.loadCounter++;
        }else {
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
                handler.getGame().pauseState.lastState = State.getState();
                GameSetUp.SWITCHING=true;
                State.setState(handler.getGame().pauseState);
            }else {
                if (currentArea != null) {
                    currentArea.tick();
                }
            }
        }

    }

    @Override
    public void render(Graphics g) {

        if(!GameSetUp.LOADING) {
            Graphics2D g2 = (Graphics2D) g;
            if (currentArea != null) {
                currentArea.render(g);
            }
        }else{
            g.drawImage(Images.loading,0,0,handler.getWidth(),handler.getHeight(),null);
        }

    }

    public State setArea(BaseArea area){
        currentArea = area;
        return this;
    }

}