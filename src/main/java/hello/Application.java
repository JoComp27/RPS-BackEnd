package hello;

import hello.Enums.Play;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by jonathan.cournoyer on 13/09/17.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String []args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(GameRepository repository){

        return (args) -> {
            GameManager manager = new GameManager();

            for (int i = 0; i < 10; i++) {
                manager.playGame(Play.ROCK);
                repository.save(new Game(manager.getPlayer().getCurrentPlay(), manager.getOpponent().getCurrentPlay(), manager.getGameState()));
                log.info(manager.toString());
            }

            log.info("Games in which the player played Rock: ");
            log.info("________________________________________");
            for(Game game : repository.findByPlayerPlay(Play.ROCK)){
                log.info(game.toString());
            }
            log.info("");

        };
    }

}
