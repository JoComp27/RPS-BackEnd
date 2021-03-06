package hello;

import hello.Enums.Play;
import hello.Enums.WinState;
import hello.Enums.aiType;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Play playerPlay;
    private Play opponentPlay;
    private WinState gameState;
    private aiType type;

    protected Game() {}

    public Game(Play playerPlay, Play opponentPlay, WinState gameState, aiType type) {
        this.playerPlay = playerPlay;
        this.opponentPlay = opponentPlay;
        this.gameState = gameState;
        this.type = type;
    }

    //for some reason the id on the returned JSON game object shows as null
    //we don't really need id though so i just commented out its getter
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

    public aiType getType() {
        return type;
    }

    public void setType(aiType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Game{" +
                ", playerPlay=" + playerPlay +
                ", opponentPlay=" + opponentPlay +
                ", gameState=" + gameState +
                ", type=" + type +
                '}';
    }
}
