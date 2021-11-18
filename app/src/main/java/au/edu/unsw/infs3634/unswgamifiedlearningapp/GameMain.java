package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GameMain extends AppCompatActivity {
    private ImageButton btn1, btn2, btn3;
    private String TAG="GameMain";

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