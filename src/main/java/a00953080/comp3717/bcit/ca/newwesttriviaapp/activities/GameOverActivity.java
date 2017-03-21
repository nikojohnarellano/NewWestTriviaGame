package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.TriviaApp;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;

public class GameOverActivity extends AppCompatActivity {

    private TextView    gameOver;
    private Button      quitBtn;
    private ShareDialog shareDialog;

    private Score       score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        shareDialog = new ShareDialog(this);
        score       = ((TriviaApp) getApplication()).getScore();

        gameOver = (TextView) findViewById(R.id.gameOverText);
        quitBtn  = (Button) findViewById(R.id.quit);

        gameOver.setText("Game Over");

        Button shareButton = (Button)findViewById(R.id.fb_share_button);

    }

    public void share(final View view) {
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("New West Trivia App")
                    .setContentDescription("I scored " + score.getScore() + " in New West Trivia App")
                    .setImageUrl(Uri.parse("http://newwestchamber.com/wp-content/uploads/CNW_Logo_med-640x175.jpg"))
                    .setContentUrl(Uri.parse("http://opendata.newwestcity.ca/")).build();
            shareDialog.show(linkContent);
        }
    }


    protected void facebookSDKInitialize() {
       //FacebookSdk.sd
    }

    public void quit(final View view) {
        finish();
    }
}
