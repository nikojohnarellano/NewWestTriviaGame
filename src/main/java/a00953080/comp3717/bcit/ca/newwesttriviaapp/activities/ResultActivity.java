package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.TriviaApp;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Score;

public class ResultActivity extends AppCompatActivity {
    private TextView feedback;
    private TextView scoreView;
    private Button   nextQuestion;

    private Score    score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        feedback      = (TextView)findViewById(R.id.feedBack);
        scoreView     = (TextView)findViewById(R.id.currentScore);
        nextQuestion  = (Button) findViewById(R.id.nextQuestionBtn);

        score         = ((TriviaApp) getApplication()).getScore();

        Intent intent        = getIntent();
        String feedBackValue = intent.getStringExtra("feedback");

        update();
    }

    public void update() {
        final String feedbackValue;

        if(this.score.isGameOver()) {
            scoreView.setText("Game Over");
            feedback.setVisibility(View.GONE);
            nextQuestion.setVisibility(View.GONE);
            changeBackGroundColor("");
            return;
        }

        if(this.score.isPreviousAnswerCorrect()) {
            feedbackValue = "Correct";
        } else {
            feedbackValue = "Incorrect";
        }

        scoreView.setText    (Long.toString(this.score.getScore()));
        feedback.setText     (feedbackValue);
        changeBackGroundColor(feedbackValue);
    }

    public void goToNextQuestion(final View view){
        Intent nextQuestionIntent = new Intent(this, QuestionActivity.class);
        startActivity(nextQuestionIntent);
        finish();
        //close current activity
    }

    public void changeBackGroundColor(String feedBackValue){
        RelativeLayout bg = (RelativeLayout)findViewById(R.id.activity_result);
        int color = feedBackValue.contentEquals("Correct") ? Color.GREEN : Color.RED;
        System.out.println(feedBackValue);
        bg.setBackgroundColor(color);
    }

    public void quit(final View view) {
        finish();
    }
}
