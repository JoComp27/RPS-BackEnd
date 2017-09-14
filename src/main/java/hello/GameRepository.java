package hello;

import hello.Enums.Play;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jonathan.cournoyer on 14/09/17.
 */
public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findByPlayerPlay(Play playerPlay);

    List<Game> findByOpponentPlay(Play opponentPlay);

}
