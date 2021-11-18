package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizzesActivity extends AppCompatActivity {
    private Button btnLearn3, btnNotes3, btnProfile3,btnEasy,btnNormal,btnHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);




        btnEasy = findViewById(R.id.btnEasy);
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizzesActivity.this, QuizActivity.class);
                intent.putExtra("status",1);
                startActivity(intent);
            }
        });

        btnNormal = findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizzesActivity.this, QuizActivity.class);
                intent.putExtra("status",2);
                startActivity(intent);
            }
        });

        btnHard = findViewById(R.id.btnHard);
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizzesActivity.this, QuizActivity.class);
                intent.putExtra("status",3);
                startActivity(intent);
            }
        });
    }
}