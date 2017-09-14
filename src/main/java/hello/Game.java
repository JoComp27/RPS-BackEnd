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
