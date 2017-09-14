package hello;

import hello.Enums.Play;
import hello.Enums.WinState;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jonathan.cournoyer on 14/09/17.
 */
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Play playerPlay;
    private Play opponentPlay;
    private WinState gameState;

    protected Game(){}

    public Game(Play playerPlay, Play opponentPlay, WinState gameState) {
        this.playerPlay = playerPlay;
        this.opponentPlay = opponentPlay;
        this.gameState = gameState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Play getPlayerPlay() {
        return playerPlay;
    }

    public void setPlayerPlay(Play playerPlay) {
        this.playerPlay = playerPlay;
    }

    public Play getOpponentPlay() {
        return opponentPlay;
    }

    public void setOpponentPlay(Play opponentPlay) {
        this.opponentPlay = opponentPlay;
    }

    public WinState getGameState() {
        return gameState;
    }

    public void setGameState(WinState gameState) {
        this.gameState = gameState;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", playerPlay=" + playerPlay +
                ", opponentPlay=" + opponentPlay +
                ", gameState=" + gameState +
                '}';
    }
}
