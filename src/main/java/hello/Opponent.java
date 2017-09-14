package hello;

import javax.persistence.Entity;

/**
 * Created by jonathan.cournoyer on 13/09/17.
 */

@Entity
public abstract class Opponent extends Player {

    public abstract void makePlay();

    @Override
    public String toString() {
        return "hello.Opponent{" + "currentPlay=" + getCurrentPlay() + '}';
    }
}
