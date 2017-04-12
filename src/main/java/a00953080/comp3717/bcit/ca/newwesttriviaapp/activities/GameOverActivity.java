package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import org.w3c.dom.Text;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.TriviaApp;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.HighScore;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;

public class GameOverActivity extends AppCompatActivity {

    private TextView    gameOver;
    private TextView    name;
    private Button      saveScoreBtn;
    private ShareDialog shareDialog;
    private TextView    myscore;
    private TextView    error;
    private Score       score;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        db = DatabaseHelper.getInstance(this);
        shareDialog = new ShareDialog(this);
        score       = ((TriviaApp) getApplication()).getScore();

        gameOver     = (TextView) findViewById(R.id.gameOverText);
        myscore      = (TextView) findViewById(R.id.score);
        error        = (TextView) findViewById(R.id.errorName);
        name         = (EditText) findViewById(R.id.name);
        saveScoreBtn = (Button)   findViewById(R.id.saveHighscore);

        gameOver.setText("Game Over");
        myscore.setText("Final Score: " + score.getHighScore());
    }

    public void share(final View view) {
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("New West Trivia App")
                    .setContentDescription("I scored " + score.getHighScore() + " in New West Trivia App")
                    .setImageUrl(Uri.parse("http://newwestchamber.com/wp-content/uploads/CNW_Logo_med-640x175.jpg"))
                    .setContentUrl(Uri.parse("http://opendata.newwestcity.ca/")).build();
            shareDialog.show(linkContent);
        }
    }

    public void saveHighscore(final View view) {
        final HighScore myHighscore;
        final String userName;

        userName = name.getText().toString().trim();

        if (userName.length() == 0) {
            error.setText("Please type a valid name.");
            return;
        }

        myHighscore = new HighScore();
        myHighscore.setName(name.getText().toString());
        myHighscore.setScore((int)score.getHighScore());
        db.createHighScore(myHighscore);
        db.close();

        name.setFocusable(false);
        saveScoreBtn.setEnabled(false);

        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
    }

    public void quit(final View view) {
        finish();
    }
}
