package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;

public class ResultActivity extends AppCompatActivity {
    TextView feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        feedback = (TextView)findViewById(R.id.feedBack);
        Intent intent = getIntent();
        String feedBackValue = intent.getStringExtra("feedback");
        feedback.setText(feedBackValue);
        changeBackGroundColor(feedBackValue);
    }

    public void goToNextQuestion(final View view){
        Intent nextQuestionIntent = new Intent(this, QuestionActivity.class);
        startActivity(nextQuestionIntent);
        //close current activity
    }
    public void changeBackGroundColor(String feedBackValue){
        RelativeLayout bg = (RelativeLayout)findViewById(R.id.activity_result);
        int color = feedBackValue.contentEquals("Correct") ? Color.GREEN : Color.RED;
        System.out.println(feedBackValue);
        bg.setBackgroundColor(color);
    }
}
