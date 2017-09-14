package hello;

import hello.Enums.Play;
import hello.Enums.WinState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by erin.benderoff on 14/09/17.
 */
@RestController
public class GameController {

    @RequestMapping("/games")
    public Game game(@RequestParam(value="play") Play play) {
        GameManager manager = new GameManager();
        manager.playGame(play);
        return new Game(manager.getPlayer().getCurrentPlay(), manager.getOpponent().getCurrentPlay(), manager.getGameState());
    }

}
