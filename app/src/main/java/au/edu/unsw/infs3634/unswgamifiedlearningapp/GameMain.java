package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class GameMain extends AppCompatActivity {
    private ImageButton btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);

        btn1 = findViewById(R.id.firstp);
        btn2 = findViewById(R.id.secondp);
        btn3 = findViewById(R.id.thirdp);

        btn1.setImageResource(R.drawable.bo);
        btn2.setImageResource(R.drawable.badge1);
        btn3.setImageResource(R.drawable.badge2);
    }
}