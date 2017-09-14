package hello;

import hello.Enums.Play;

import javax.persistence.Entity;

/**
 * Created by jonathan.cournoyer on 13/09/17.
 */
@Entity
public class RandomOpponent extends Opponent {

    @Override
    public void makePlay() {
        int randomNumber = (int) Math.random() * 3;
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
}
