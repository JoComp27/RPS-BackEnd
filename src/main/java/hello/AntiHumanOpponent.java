package hello;

import hello.Enums.Play;
import hello.Enums.WinState;

/**
 * Created by jonathan.cournoyer on 15/09/17.
 */
public class AntiHumanOpponent extends Opponent {


    @Override
    public void makePlay(History history, int currentGame) {
        if (currentGame == 0) {
            randomGame();
        } else {
            if (history.getHistory()[currentGame - 1].getGameState() == WinState.LOSS) {
                //If you just won, play what your opponent just played
                setCurrentPlay(history.getHistory()[currentGame - 1].getPlayerPlay());
            } else if (history.getHistory()[currentGame - 1].getGameState() == WinState.WIN) {
                // If you just lost, play what would lose against what you just played
                setCurrentPlay(Tools.Win(history.getHistory()[currentGame - 1].getPlayerPlay()));
            } else {//If its a draw, play something else randomly
                randomGame(history.getHistory()[currentGame - 1].getPlayerPlay());
            }
        }
    }

    public void randomGame() {
        int randomNumber = (int) (Math.random() * 3);
        switch (randomNumber) {
            case 0:
                setCurrentPlay(Play.ROCK);
                break;
            case 1:
                setCurrentPlay(Play.PAPER);
                break;
            case 2:
                setCurrentPlay(Play.SCISSORS);
                break;
            default:
                System.out.println("Error : Something is wrong with randomNumber; Not supposed to be here");
        }

    }

    public void randomGame(Play excludedPlay) {
        int randomNumber = (int) (Math.random() * 2);
        if(excludedPlay == Play.ROCK){
            switch (randomNumber) {
                case 0:
                    setCurrentPlay(Play.SCISSORS);
                    break;
                case 1:
                    setCurrentPlay(Play.PAPER);
                    break;
            }
        }
        else if(excludedPlay == Play.PAPER){
            switch (randomNumber) {
                case 0:
                    setCurrentPlay(Play.SCISSORS);
                    break;
                case 1:
                    setCurrentPlay(Play.ROCK);
                    break;
            }
        }
        else{
            switch (randomNumber) {
                case 0:
                    setCurrentPlay(Play.PAPER);
                    break;
                case 1:
                    setCurrentPlay(Play.ROCK);
                    break;
            }
        }

    }
}
