package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearnActivity extends AppCompatActivity {
    private Button btnNotes, btnQuizzes, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        getSupportActionBar().setTitle("Learn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNotes = (Button) findViewById(R.id.btnNotes);
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LearnActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });

        btnQuizzes = (Button) findViewById(R.id.btnQuizzes);
        btnQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LearnActivity.this, QuizzesActivity.class);
                startActivity(intent);
            }
        });

        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LearnActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}