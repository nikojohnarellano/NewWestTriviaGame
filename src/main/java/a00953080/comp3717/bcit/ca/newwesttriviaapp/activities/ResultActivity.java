package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.animation.ValueAnimator;
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

        update();
    }

    public void update() {
        final String feedbackValue;

        feedbackValue = this.score.isPreviousAnswerCorrect() ? "Correct" : "Incorrect";

        scoreAnimation();
        changeBackGroundColor();

        feedback.setText(feedbackValue);
    }

    public void goToNextQuestion(final View view){
        Intent nextQuestionIntent = new Intent(this, QuestionActivity.class);
        startActivity(nextQuestionIntent);
        finish();
        //close current activity
    }

    public void changeBackGroundColor(){
        RelativeLayout bg = (RelativeLayout)findViewById(R.id.activity_result);
        int color = this.score.isPreviousAnswerCorrect() ? Color.GREEN : Color.RED;
        bg.setBackgroundColor(color);
    }

    private void scoreAnimation() {
        final long    scoreValue        = this.score.getScore();
        final long    previousScore     = this.score.getPreviousScore();

        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues((int)previousScore, (int)scoreValue);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ResultActivity.this.scoreView.setText("" + (int) animation.getAnimatedValue());
            }
        });
        animator.start();

    }

    public void quit(final View view) {
        finish();
    }
}
