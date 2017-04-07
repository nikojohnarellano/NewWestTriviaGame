package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.HighScore;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;

public class HighscoreActivity extends AppCompatActivity {

    private List<HighScore>    highestScores;
    private DatabaseHelper     db;
    private Button             backBtn;

    private TextView highscore1;
    private TextView highscore2;
    private TextView highscore3;
    private TextView highscore4;
    private TextView highscore5;

    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;
    private TextView score5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        backBtn  = (Button) findViewById(R.id.backBtn);

        db = DatabaseHelper.getInstance(this);
        highestScores = db.getTopHighScores();

        highscore1 = (TextView) findViewById(R.id.highscore1);
        highscore2 = (TextView) findViewById(R.id.highscore2);
        highscore3 = (TextView) findViewById(R.id.highscore3);
        highscore4 = (TextView) findViewById(R.id.highscore4);
        highscore5 = (TextView) findViewById(R.id.highscore5);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        score5 = (TextView) findViewById(R.id.score5);


        if(highestScores.size() > 0) {
            highscore1.setText(highestScores.get(0).getName());
            score1.setText("" +highestScores.get(0).getScore());
        } else {
            highscore1.setText("No score available");
            score1.setText("N/A");
        }

        if(highestScores.size() > 1) {
            highscore2.setText(highestScores.get(1).getName());
            score2.setText("" +highestScores.get(1).getScore());
        }else {
            highscore2.setText("No score available");
            score2.setText("N/A");
        }

        if(highestScores.size() > 2) {
            highscore3.setText(highestScores.get(2).getName());
            score3.setText("" +highestScores.get(2).getScore());
        } else {
            highscore3.setText("No score available");
            score3.setText("N/A");
        }

        if(highestScores.size() > 3) {
            highscore4.setText(highestScores.get(3).getName());
            score4.setText("" +highestScores.get(3).getScore());
        } else {
            highscore4.setText("No score available");
            score4.setText("N/A");
        }

        if(highestScores.size() > 4) {
            highscore5.setText(highestScores.get(4).getName());
            score5.setText("" + highestScores.get(4).getScore());
        } else {
            highscore5.setText("No score available");
            score5.setText("N/A");
        }
    }

    public void Back(final View view) {
        finish();
    }
}
