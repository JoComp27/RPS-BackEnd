package hello;

import hello.Enums.Play;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;

/**
 * Created by jonathan.cournoyer on 13/09/17.
 */
@Entity
public class Player {
    @Value("${null}")
    private Play currentPlay;

    public Player() {
        this.currentPlay = null;
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
