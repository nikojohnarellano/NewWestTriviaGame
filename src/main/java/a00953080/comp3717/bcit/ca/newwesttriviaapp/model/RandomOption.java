package a00953080.comp3717.bcit.ca.newwesttriviaapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Owner on 2017-02-08.
 */

public class RandomOption {

    private ArrayList<String> options;
    private Question          question;

    public RandomOption() {}

    public RandomOption(Question question) {
        this.question = question;
        this.randomize();
    }

    public String getFirstPosition() {
        return options.get(0);
    }

    public String getSecondPosition() {
        return options.get(1);
    }

    public String getThirdPosition() {
        return options.get(2);
    }

    public String getFourthPosition() {
        return options.get(3);
    }

    public void randomize() {
        options = new ArrayList<>();

        options.add(question.getAnswer());
        options.add(question.getOption1());
        options.add(question.getOption2());
        options.add(question.getOption3());

        Collections.shuffle(options);
    }
}
