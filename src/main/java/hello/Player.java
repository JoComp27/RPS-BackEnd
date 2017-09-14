package hello;

import hello.Enums.Play;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jonathan.cournoyer on 13/09/17.
 */
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Value("${null}")
    private Play currentPlay;

    public Player() {
        this.currentPlay = null;
    }

    public Player(Play currentPlay) {
        this.currentPlay = currentPlay;
    }

    public Player(String currentPlay) {
        if (currentPlay.equals("ROCK")) {
            this.currentPlay = Play.ROCK;
        } else if (currentPlay.equals("PAPER")) {
            this.currentPlay = Play.PAPER;
        } else if (currentPlay.equals("SCISSORS")) {
            this.currentPlay = Play.SCISSORS;
        } else {
            System.out.println("Error in Player String constructor : Input doesn't match any type : currentPlay set to null");
            this.currentPlay = null;
        }
    }


    public Play getCurrentPlay() {
        return currentPlay;
    }

    public void setCurrentPlay(Play currentPlay) {
        this.currentPlay = currentPlay;
    }

    @Override
    public String toString() {
        return "hello.Player{" +
                "currentPlay=" + currentPlay +
                '}';
    }
}
