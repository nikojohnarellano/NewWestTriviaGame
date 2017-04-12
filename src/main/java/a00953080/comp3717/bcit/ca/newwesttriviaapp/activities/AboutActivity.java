package a00953080.comp3717.bcit.ca.newwesttriviaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView about = (TextView) findViewById(R.id.about);

        about.setText(
                "We hope you enjoy the New West Trivia App!\n\n" +
                "This Project was created by:\n" +
                "Clinton Bock\n" +
                "Niko Arellano\n" +
                "Connor Jang\n\n" +
                "All questions and answers were created using the open datasets available at: http://opendata.newwestcity.ca/");
    }

    public void back(final View view) { finish();}
}
