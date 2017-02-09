package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toQuestion(final View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
        finish();
    }
    public void toHelp(final View view){

    }
}
