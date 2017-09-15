package hello;

import hello.Enums.Play;
import hello.Enums.WinState;
import hello.Enums.aiType;

/**
 * Created by jonathan.cournoyer on 15/09/17.
 */
public class History {

    private Game[] history;
    private int currentGame;

    public History(){
        this.history = new Game[10];
        this.currentGame = 0;
    }

    public Game[] getHistory() {
        return history;
    }

    public void setHistory(Game[] history) {
        this.history = history;
    }

    public void addGame(Play playerPlay, Play opponentPlay, WinState gameState, aiType type, int currentGame){
        history[currentGame] = new Game(playerPlay, opponentPlay, gameState, type);
        currentGame++;
        if(currentGame >= (int)(history.length-3)){
            Game[] temp = new Game[(history.length)*2];
            for(int i = 0; i < history.length; i++){
                temp[i] = history[i];
            }
            history = temp;
        }
    }

    public int getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(int currentGame) {
        this.currentGame = currentGame;
    }
}
