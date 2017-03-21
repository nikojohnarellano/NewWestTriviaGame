package a00953080.comp3717.bcit.ca.newwesttriviaapp;

import android.app.Application;

import java.util.Stack;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.util.QuestionGenerator;

/**
 * Created by Owner on 2017-02-08.
 */

public class TriviaApp extends Application {

    private Stack<Question>   questionStack     = new Stack<>();
    private QuestionGenerator questionGenerator = new QuestionGenerator(this);
    private Score             score;

    public static final long  STARTING_SCORE       = 100;
    public static final long  CORRECT_SCORE_ADD    = 25;
    public static final long  WRONG_SCORE_ADD      = -25;

    public Question generateQuestion() {
        Question question;

        question = this.questionGenerator.generateQuestion();

        // If player is really good that he's able to survive a hundred questions
        // Just reset the stack and repeat the questions
        if(questionGenerator.getNumOfQuestions() == questionStack.size()) {
            questionStack.clear();
        }

        while(questionStack.search(question) != -1) {
            question = this.questionGenerator.generateQuestion();
        }

        questionStack.push(question);

        return question;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
