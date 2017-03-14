package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;

public class GameOverActivity extends AppCompatActivity {

    private TextView gameOver;
    private Button   quitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        gameOver = (TextView) findViewById(R.id.gameOverText);
        quitBtn  = (Button) findViewById(R.id.quit);

        gameOver.setText("Game Over");
    }

    public void quit(final View view) {
        finish();
    }
}
