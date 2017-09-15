package hello;

import hello.Enums.Play;
import hello.Enums.WinState;
import hello.Enums.aiType;


/**
 * Created by jonathan.cournoyer on 13/09/17.
 */
public class GameManager {
    private int currentGame;

    private History history;

    private aiType type;
    private WinState gameState;
    private Player player;

    private RandomOpponent randomOpponent;
    private AntiHumanOpponent antiHumanOpponent;

    public GameManager() {
        this.player = new Player();
        this.gameState = null;
        this.type = aiType.ANTIHUMAN;
        this.currentGame = 0;

        this.antiHumanOpponent = new AntiHumanOpponent();
        this.randomOpponent = new RandomOpponent();

        this.history = new History();
    }

    public void playGame(Play playerPlay, aiType type) {
        player.setCurrentPlay(playerPlay);
        this.type = type;
        switch (type) {
            case RANDOM:
                randomOpponent.makePlay(history, currentGame);
                setGameState(calculateResult(player, randomOpponent));
                history.addGame(player.getCurrentPlay(), randomOpponent.getCurrentPlay(), gameState, type, currentGame);
                break;
            case ANTIHUMAN:
                antiHumanOpponent.makePlay(history, currentGame);
                setGameState(calculateResult(player, antiHumanOpponent));
                history.addGame(player.getCurrentPlay(), antiHumanOpponent.getCurrentPlay(), gameState, type, currentGame);
                break;
            default:
                System.out.println("Something went wrong in the playGame opponent switch");
        }

        ++currentGame;
    }

    public WinState getGameState() {
        return gameState;
    }

    public void setGameState(WinState gameState) {
        this.gameState = gameState;
    }

    public static WinState calculateResult(Player player, Opponent opponent) {
        if (player.getCurrentPlay() == Play.PAPER) {
            if (opponent.getCurrentPlay() == Play.ROCK) {
                return WinState.WIN;
            } else if (opponent.getCurrentPlay() == Play.SCISSORS) {
                return WinState.LOSS;
            } else {
                return WinState.DRAW;
            }
        } else if (player.getCurrentPlay() == Play.ROCK) {
            if (opponent.getCurrentPlay() == Play.SCISSORS) {
                return WinState.WIN;
            } else if (opponent.getCurrentPlay() == Play.PAPER) {
                return WinState.LOSS;
            } else {
                return WinState.DRAW;
            }
        } else {
            if (opponent.getCurrentPlay() == Play.PAPER) {
                return WinState.WIN;
            } else if (opponent.getCurrentPlay() == Play.ROCK) {
                return WinState.LOSS;
            } else {
                return WinState.DRAW;
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setType(aiType type) {
        this.type = type;
    }

    public aiType getType() {
        return type;
    }



    public RandomOpponent getRandomOpponent() {
        return randomOpponent;
    }

    public AntiHumanOpponent getAntiHumanOpponent() {
        return antiHumanOpponent;
    }


    @Override
    public String toString() {
        String message = "GameManager{" + "type=" + type + ", gameState=" + gameState + ", player=" + player.toString();

        switch(type){
            case ANTIHUMAN:
                message+=", opponent=" + antiHumanOpponent.toString() + '}';
                break;
            case RANDOM:
                message+=", opponent=" + randomOpponent.toString() + '}';
                break;
            default:message += "Type ERROR FOUND!";
        }



        return message;
    }
}
