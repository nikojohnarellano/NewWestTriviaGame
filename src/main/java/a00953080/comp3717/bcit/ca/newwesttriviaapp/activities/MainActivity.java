package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.TriviaApp;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private ImageView title;
    private Button start;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        title   = (ImageView) findViewById(R.id.titleLogo);
        start   = (Button) findViewById(R.id.start_button);
        help    = (Button) findViewById(R.id.help_button);

        title.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.movetitle));

        // Prepare the View for the animation
        start.setAlpha(0.0f);
        help.setAlpha(0.0f);

        // Start the animation
        start.animate().setStartDelay(3500).alpha(1.0f);
        help.animate().setStartDelay(3500).alpha(1.0f);

        //deleteAllQuestions();
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

            dbHelper.createQuestion(new Question()
                    .setQuestion("Which city has the highest population density per square kilometer?")
                    .setAnswer("New Westminster")
                    .setOption1("North Vancouver")
                    .setOption2("Langley")
                    .setOption3("Surrey"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("What is the population of New Westminster?")
                    .setAnswer("71,000")
                    .setOption1("66,000")
                    .setOption2("75,000")
                    .setOption3("68,000"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("Which city has the highest population?")
                    .setAnswer("New Westminster")
                    .setOption1("Port Coquitlam")
                    .setOption2("West Vancouver")
                    .setOption3("White Rock"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("Which pf thse cities has the highest population?")
                    .setAnswer("Maple Ridge")
                    .setOption1("New Westminster")
                    .setOption2("Port Moody")
                    .setOption3("Pitt Meadows"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("How much has the population of New Westminster grown since 2011?\n")
                    .setAnswer("5,000")
                    .setOption1("3,000")
                    .setOption2("7,500")
                    .setOption3("10,000"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("Who is the current mayor of New Westminster?")
                    .setAnswer("Jonathan Cote")
                    .setOption1("Wayne Wright")
                    .setOption2("James Crosty")
                    .setOption3("Vladimir Krasnogor"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("Who was the last mayor of New Westminster? (2011-2014)")
                    .setAnswer("Wayne Wright")
                    .setOption1("Jonathan Cote")
                    .setOption2("James Crosty")
                    .setOption3("Vance McFayden"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("How many electric vehicle charging stations are in New Westminster?\n")
                    .setAnswer("6")
                    .setOption1("0")
                    .setOption2("1")
                    .setOption3("3"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("Which location does not have an electric vehicle charging station?\n")
                    .setAnswer("Douglas College")
                    .setOption1("Royal Columbian Hospital")
                    .setOption2("Anvil Centre")
                    .setOption3("City Hall"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("Where in New Westminster are car collisions most likely to happen?")
                    .setAnswer("Brunette Ave & Trans Canada Highway ramps")
                    .setOption1("Pattullo Bridge")
                    .setOption2("Braid St & Brunnette Ave")
                    .setOption3("Canada Way (8th st) & 10th Ave"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("In total, how many car crashes happened in 2015 in New Westminster?")
                    .setAnswer("2,961")
                    .setOption1("3,016")
                    .setOption2("2,657")
                    .setOption3("1,896"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("How many fires did the New Westminster Fire & Rescue Services fight in 2016?")
                    .setAnswer("140")
                    .setOption1("100")
                    .setOption2("175")
                    .setOption3("127"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("What is the average number of fires that the  Fire & Rescue Services fight per year?")
                    .setAnswer("125")
                    .setOption1("100")
                    .setOption2("150")
                    .setOption3("200"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("How many calls did the Emergency Services respond to last year? (Fire & Rescue Services)")
                    .setAnswer("6,000")
                    .setOption1("5,000")
                    .setOption2("7,000")
                    .setOption3("4,000"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("What is the average number of calls that the Emergency Services responds to, per year? (Fire & Rescue Services)\n")
                    .setAnswer("5,500")
                    .setOption1("6,000")
                    .setOption2("4,000")
                    .setOption3("5,000"));

            dbHelper.createQuestion(new Question()
                    .setQuestion("How many people are employed by the City of New Westminster?\n")
                    .setAnswer("1,122")
                    .setOption1("952")
                    .setOption2("1,048")
                    .setOption3("1,203"));
            
            dbHelper.createQuestion(new Question()
                    .setQuestion("Which is not a real Skytrain station in New Westminster?")
                    .setAnswer("Brunette Station")
                    .setOption1("Braid Station")
                    .setOption2("New Westminster Station")
                    .setOption3("22nd St Station"));

        }
    }

    public void deleteAllQuestions() {
        final DatabaseHelper dbHelper;

        dbHelper = DatabaseHelper.getInstance(this);
        dbHelper.deleteAll();
        dbHelper.close();
    }
}
