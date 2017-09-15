package hello;

import hello.Enums.Play;
import hello.Enums.WinState;
import hello.Enums.aiType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by erin.benderoff on 14/09/17.
 */
@RestController
public class GameController {

    public GameManager manager = new GameManager();

    @RequestMapping("/games")
    public Game game(@RequestParam(value = "play") Play play,@RequestParam(value = "type") aiType type) {
        manager.playGame(play, type);
        Opponent temp = new RandomOpponent();
        switch(manager.getType()){
            case RANDOM:
                temp.setCurrentPlay(manager.getRandomOpponent().getCurrentPlay());
                break;
            case ANTIHUMAN:
                temp.setCurrentPlay(manager.getAntiHumanOpponent().getCurrentPlay());
                break;
            default:
                temp.setCurrentPlay(null);
        }
        return new Game(manager.getPlayer().getCurrentPlay(), temp.getCurrentPlay(), manager.getGameState(), manager.getType());
    }

}
