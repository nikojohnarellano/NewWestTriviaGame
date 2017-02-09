package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;

public class QuestionActivity extends AppCompatActivity {
    private TextView questionView;
    private TextView feedBackView;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button clickedButton;
    ///this might have to change unless we can get a random question from a different class and call it here
    long one = 1;
    private Question q = new Question(one, "How rich is Jason's Kid?", "Richer than you", "Richer than Jason",
            "Richer than Darcy", "Richer than you");
    ///////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //sets the question on the page to the question of Question object
        questionView = (TextView)findViewById(R.id.question_text);
        questionView.setText(q.getQuestion());

        //sets the buttons to the values of the options of the question Object
        answerButton1 = (Button)findViewById(R.id.answerButton1);
        answerButton1.setText(q.getOption1());

        answerButton2 = (Button)findViewById(R.id.answerButton2);
        answerButton2.setText(q.getOption2());

        answerButton3 = (Button)findViewById(R.id.answerButton3);
        answerButton3.setText(q.getOption3());
    }
    //somehow need to get the question
    public void checkAnswer(final View View){
        feedBackView = (TextView)findViewById(R.id.feedback);
        clickedButton = (Button)findViewById(View.getId());
        String feedBackValue = clickedButton.getText() == q.getAnswer() ? "Correct" : "Incorrect";
        feedBackView.setText(feedBackValue);
    }
}
