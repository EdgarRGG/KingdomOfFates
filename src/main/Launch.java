package main;


/**
 * Clase que inicializa el juego
 * @author Edgar Rubio
 */

public class Launch {

    public static void main(String[] args) {
        Handler handler = new Handler();
        GameSetUp game = new GameSetUp("Kingdom of Fates",handler);
        handler.setGame(game);
        game.start();
    }
}
