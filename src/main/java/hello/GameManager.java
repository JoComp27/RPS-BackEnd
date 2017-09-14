package hello;

import hello.Enums.Play;
import hello.Enums.WinState;


/**
 * Created by jonathan.cournoyer on 13/09/17.
 */
public class GameManager {


    private WinState gameState;

    private Player player;

    private Opponent opponent;

    public GameManager() {
        this.player = new Player();
        this.opponent = new RandomOpponent();
        this.gameState = null;
    }

    public void playGame(Play playerPlay) {
        player.setCurrentPlay(playerPlay);
        opponent.makePlay();
        setGameState(calculateResult(player, opponent));
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

    public Opponent getOpponent() {
        return opponent;
    }

    @Override
    public String toString() {
        return "hello.GameManager{" +
                "gameState=" + gameState +
                ", player=" + player +
                ", opponent=" + opponent +
                '}';
    }
}
