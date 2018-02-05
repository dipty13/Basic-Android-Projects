package com.dnerd.dipty.crystalBall;

import java.util.Random;

/**
 * Created by Dipty on 6/19/2017.
 */

public class MagicBall {
    //member variable(properties about the object)
    public String[] mAnswers = {
            "It is certatin",
            "It is decidedly so",
            "All stars are not alligned",
            "My reply is no",
            "It is doughtful",
            "Better not to tell you now",
            "Concntrate and ask again",
            "Unable to answer now" ,
            "It is hard to say"};

    //methods (abilities: things it can do)
    public String getAnAnswer(){


        String answer = "";

        //Randomely select one of three answers: yes, no or may be
        Random randomGenerator = new Random(); //construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mAnswers.length);


        answer = mAnswers[randomNumber];
        return answer;
    }
}
