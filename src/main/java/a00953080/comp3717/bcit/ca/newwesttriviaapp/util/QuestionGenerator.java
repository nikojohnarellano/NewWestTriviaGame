package a00953080.comp3717.bcit.ca.newwesttriviaapp.util;

import android.content.Context;

import java.util.Random;
import java.util.Stack;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;

/**
 * Created by Owner on 2017-02-08.
 */

public class QuestionGenerator {

    private Context         context;
    private DatabaseHelper  helper;
    private static long     numOfQuestions;

    public QuestionGenerator(final Context context) {
        this.context       = context;
    }

    public Question generateQuestion() {
        final long     numOfquestions;
        final int      randomId;
        final Question question;
        final Random   random;

        random = new Random(System.currentTimeMillis());

        helper  = DatabaseHelper.getInstance(context).openDatabaseForReading(this.context);

        numOfquestions   = getNumOfQuestions();
        randomId         = random.nextInt((int) numOfquestions) + 1;
        question         = helper.getQuestionById(randomId);

        helper.close();

        return question;
    }

    public long getNumOfQuestions() {
        if(numOfQuestions == 0) {
            helper  = DatabaseHelper.getInstance(context).openDatabaseForReading(this.context);
            numOfQuestions   = helper.numOfQuestions();
            helper.close();
        }

        return numOfQuestions;
    }



}
