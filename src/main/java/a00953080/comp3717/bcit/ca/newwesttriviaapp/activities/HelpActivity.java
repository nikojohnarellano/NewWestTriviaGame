package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView rules = (TextView) findViewById(R.id.rules);

        rules.setText(
                "Welcome to the New Westminster Trivia App!\n\n" +
                        "The rules are simple: \n" +
                        "1. A new game always starts at 100 points\n" +
                        "2. You must place a wager before you start the next question\n" +
                        "3. The first question is automatically a 25 point wager\n" +
                        "4. You must wager at least 25 points, and you can’t wager more points than you have\n" +
                        "5. Your high score is the highest amount of points you have at any point in a game.\n" +
                        "6. The game ends when you run out of points, so make sure you place high wagers!\n" +
                        "7. Have Fun!\n");
    }

    public void back(final View view) { finish();}
}
