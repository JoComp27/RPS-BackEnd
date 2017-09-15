package hello;

import hello.Enums.Play;
import hello.Enums.aiType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    GameManager manager = new GameManager();
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(GameRepository repository) {
//
//        return (args) -> {
//
//
//            for (int i = 0; i < 30; i++) {
//                manager.playGame(Play.ROCK, aiType.ANTIHUMAN);
//                //repository.save(new Game(manager.getPlayer().getCurrentPlay(), manager.getOpponent().getCurrentPlay(), manager.getGameState(), manager.getType()));
//                log.info(manager.toString());
//              //  log.info(manager.getManagerOpponent().getCurrentSchemeLogger()); WHEN PLAYING MANAGER OPPONENT
//            }
//
//            log.info("");
//
//        };
//    }
}
