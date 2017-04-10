package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.HighScore;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;

public class HighscoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        DatabaseHelper db = DatabaseHelper.getInstance(this);
        List<HighScore>  highestScores = db.getTopHighScores();

        TextView highscore1 = (TextView) findViewById(R.id.highscore1);
        TextView highscore2 = (TextView) findViewById(R.id.highscore2);
        TextView highscore3 = (TextView) findViewById(R.id.highscore3);
        TextView highscore4 = (TextView) findViewById(R.id.highscore4);
        TextView highscore5 = (TextView) findViewById(R.id.highscore5);

        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView score2 = (TextView) findViewById(R.id.score2);
        TextView score3 = (TextView) findViewById(R.id.score3);
        TextView score4 = (TextView) findViewById(R.id.score4);
        TextView score5 = (TextView) findViewById(R.id.score5);


        if(highestScores.size() > 0) {
            highscore1.setText(highestScores.get(0).getName());
            score1.setText("" +highestScores.get(0).getScore());
        } else {
            highscore1.setText(getString(R.string.no_highscore_available));
            score1.setText(getString(R.string.na));
        }

        if(highestScores.size() > 1) {
            highscore2.setText(highestScores.get(1).getName());
            score2.setText("" +highestScores.get(1).getScore());
        }else {
            highscore2.setText(getString(R.string.no_highscore_available));
            score2.setText(getString(R.string.na));
        }

        if(highestScores.size() > 2) {
            highscore3.setText(highestScores.get(2).getName());
            score3.setText("" +highestScores.get(2).getScore());
        } else {
            highscore3.setText(getString(R.string.no_highscore_available));
            score3.setText(getString(R.string.na));
        }

        if(highestScores.size() > 3) {
            highscore4.setText(highestScores.get(3).getName());
            score4.setText("" +highestScores.get(3).getScore());
        } else {
            highscore4.setText(getString(R.string.no_highscore_available));
            score4.setText(getString(R.string.na));
        }

        if(highestScores.size() > 4) {
            highscore5.setText(highestScores.get(4).getName());
            score5.setText("" + highestScores.get(4).getScore());
        } else {
            highscore5.setText(getString(R.string.no_highscore_available));
            score5.setText(getString(R.string.na));
        }
    }

    public void Back(final View view) {
        finish();
    }
}
