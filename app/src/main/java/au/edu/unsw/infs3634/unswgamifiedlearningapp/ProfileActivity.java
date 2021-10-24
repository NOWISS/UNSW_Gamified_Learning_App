package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    private Button btnLearn4, btnNotes4, btnQuizzes4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLearn4 = (Button) findViewById(R.id.btnLearn4);
        btnLearn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });

        btnNotes4 = (Button) findViewById(R.id.btnNotes4);
        btnNotes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });

        btnQuizzes4 = (Button) findViewById(R.id.btnQuizzes4);
        btnQuizzes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, QuizzesActivity.class);
                startActivity(intent);
            }
        });
    }
}