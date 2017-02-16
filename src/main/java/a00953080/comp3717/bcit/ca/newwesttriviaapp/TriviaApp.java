package a00953080.comp3717.bcit.ca.newwesttriviaapp;

import android.app.Application;

import java.util.Stack;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.util.QuestionGenerator;

/**
 * Created by Owner on 2017-02-08.
 */

public class TriviaApp extends Application {

    private Stack<Question>   questionStack     = new Stack<>();
    private QuestionGenerator questionGenerator = new QuestionGenerator(this);

    public Question generateQuestion() {
        Question question;

        question = this.questionGenerator.generateQuestion();

        while(questionStack.contains(question)) {
            question = this.questionGenerator.generateQuestion();
        }

        questionStack.push(question);

        return question;
    }
}
