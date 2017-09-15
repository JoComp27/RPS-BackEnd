package hello;

import hello.Enums.Play;

/**
 * Created by jonathan.cournoyer on 15/09/17.
 */
public class Tools {

    public static Play Win(Play play){
        if(play == Play.ROCK){
            return Play.PAPER;
        }
        else if(play == Play.PAPER){
            return Play.SCISSORS;
        }
        else{
            return Play.ROCK;
        }
    }

    public static Play Loss(Play play){
        if(play == Play.ROCK){
            return Play.SCISSORS;
        }
        else if(play == Play.PAPER){
            return Play.ROCK;
        }
        else{
            return Play.SCISSORS;
        }
    }

    public static double max(double a, double b, double c){
        double max = a;
        if(max < b){
            max = b;
        }
        if(max < c){
            max = c;
        }
        return max;
    }

}
