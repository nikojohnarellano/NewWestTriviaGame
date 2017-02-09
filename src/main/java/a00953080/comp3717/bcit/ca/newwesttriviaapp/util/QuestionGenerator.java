package a00953080.comp3717.bcit.ca.newwesttriviaapp.util;

import android.content.Context;

import java.util.Random;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;

/**
 * Created by Owner on 2017-02-08.
 */

public class QuestionGenerator {

    private Context        context;
    private DatabaseHelper helper;

    private Random random;

    public QuestionGenerator(final Context context) {
        this.random  = new Random();
        this.context = context;
        this.helper  = DatabaseHelper.getInstance(context);
    }

    public Question generateQuestion() {
        final long     numOfquestions;
        final int      randomId;
        final Question question;

        helper.openDatabaseForReading(this.context);

        numOfquestions   = helper.numOfQuestions();
        randomId         = random.nextInt((int) numOfquestions) + 1;

        question         = helper.getQuestionById(randomId);

        helper.close();

        return question;
    }

}
