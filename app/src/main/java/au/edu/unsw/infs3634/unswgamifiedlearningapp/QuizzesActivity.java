package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizzesActivity extends AppCompatActivity {
    private Button btnLearn3, btnNotes3, btnProfile3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);
        getSupportActionBar().setTitle("Quizzes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLearn3 = (Button) findViewById(R.id.btnLearn3);
        btnLearn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizzesActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });

        btnNotes3 = (Button) findViewById(R.id.btnNotes3);
        btnNotes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizzesActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });

        btnProfile3 = (Button) findViewById(R.id.btnProfile3);
        btnProfile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizzesActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}