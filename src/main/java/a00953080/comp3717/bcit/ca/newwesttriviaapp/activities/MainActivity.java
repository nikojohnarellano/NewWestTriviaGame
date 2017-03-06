package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.TriviaApp;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        createQuestions();

    }

    public void toQuestion(final View view){
        final Intent intent;
        final Score score;

        intent = new Intent(this, QuestionActivity.class);
        score  = new Score(TriviaApp.STARTING_SCORE, false);

        ((TriviaApp) getApplication()).setScore(score);

        startActivity(intent);
    }

    public void toHelp(final View view){

    }

    public void createQuestions() {
        final DatabaseHelper dbHelper;

        dbHelper = DatabaseHelper.getInstance(this);

        if(dbHelper.numOfQuestions() == 0) {
            dbHelper.createQuestion(new Question()
                                        .setQuestion("What city is found at the northeast of New Westminster?")
                                        .setAnswer("Coquitlam")
                                        .setOption1("Maple Ridge")
                                        .setOption2("Surrey")
                                        .setOption3("Burnaby"));

            dbHelper.createQuestion(new Question()
                                        .setQuestion("Which of these bus numbers does not stop at Skytrain Columbia Station?")
                                        .setAnswer("112")
                                        .setOption1("C3")
                                        .setOption2("C4")
                                        .setOption3("321"));

            dbHelper.createQuestion(new Question()
                                        .setQuestion("What neighbourhood park is located beside the Provincial Court of British Columbia")
                                        .setAnswer("Begbie Square")
                                        .setOption1("Hyack Square")
                                        .setOption2("Eleventh Street Triangle")
                                        .setOption3("Tipperary Park"));

            dbHelper.createQuestion(new Question()
                                        .setQuestion("What cemetery is located at Eight Street?")
                                        .setAnswer("NWSS Memorial Grounds")
                                        .setOption1("BC Penitentiary Cemetery")
                                        .setOption2("Woodlands Memorial Garden")
                                        .setOption3("Vancouver Cemetery"));

            dbHelper.createQuestion(new Question()
                                        .setQuestion("How many Skytrain stations can be found in New Westminster?")
                                        .setAnswer("5")
                                        .setOption1("4")
                                        .setOption2("6")
                                        .setOption3("7"));

        }
    }

    public void deleteAllQuestions() {
        final DatabaseHelper dbHelper;

        dbHelper = DatabaseHelper.getInstance(this);

        dbHelper.close();
    }
}
