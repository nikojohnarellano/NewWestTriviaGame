package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.TriviaApp;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.HighScore;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.DatabaseHelper;

public class GameOverActivity extends AppCompatActivity {

    private TextView    gameOver;
    private TextView    name;
    private Button      quitBtn;
    private Button      saveScoreBtn;
    private ShareDialog shareDialog;
    private TextView    myscore;
    private Score       score;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        db = DatabaseHelper.getInstance(this);
        shareDialog = new ShareDialog(this);
        score       = ((TriviaApp) getApplication()).getScore();

        gameOver = (TextView) findViewById(R.id.gameOverText);
        quitBtn  = (Button) findViewById(R.id.quit);

        gameOver.setText("Game Over");

        myscore = (TextView) findViewById(R.id.score);
        myscore.setText("Final Score: " + score.getHighScore());

        name = (TextView) findViewById(R.id.name);


        saveScoreBtn = (Button)findViewById(R.id.saveHighscore);
        Button shareButton = (Button)findViewById(R.id.fb_share_button);

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
        HighScore myHighscore = new HighScore();
        myHighscore.setName(name.getText().toString());
        myHighscore.setScore((int)score.getHighScore());
        db.createHighScore(myHighscore);

        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
    }
    protected void facebookSDKInitialize() {
       //FacebookSdk.sd
    }

    public void quit(final View view) {
        finish();
    }
}
