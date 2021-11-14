package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    private Button btnLearn, btnNotes, btnQuizzes, btnProfile;
    private TextView title, content;
    private ImageView imageView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportActionBar().setTitle("Home");

        //title = findViewById(R.id.ttl);
        content = findViewById(R.id.tip);
        imageView = findViewById(R.id.tipimg);
        seekBar = findViewById(R.id.seekBar);

        // set seekbar action
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i>0 && i<25){
                    //title.setText("Eat less meat and dairy");
                    content.setText("Studies suggest that a high-fibre, plant-based diet is also better for your health - so it can be a win-win.");
                    imageView.setImageResource(R.drawable.meat);
                }else if (i>=25 && i <50){
                    //title.setText("Cut back on flying");
                    content.setText("If you need to fly for work, consider using video-conferencing instead.");
                    imageView.setImageResource(R.drawable.plane);
                }else if (i>=50 && i<75){
                    //title.setText("Leave the car at home");
                    content.setText("Instead of getting in the car, walk or cycle – and enjoy the physical and mental health benefits.");
                    imageView.setImageResource(R.drawable.car);
                }else if (i>=75 && i<100){
                    //title.setText("Reduce your energy use, and bills");
                    content.setText("Put on an extra layer and turn down the heating a degree or two.");
                    imageView.setImageResource(R.drawable.electricity);
                }else if (i==100){
                    //title.setText("Respect and protect green spaces");
                    content.setText("If you have your own outdoor space, don't replace the grass with paving or artificial turf.");
                    imageView.setImageResource(R.drawable.walk);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        btnLearn = (Button) findViewById(R.id.btnLearn);
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });

        btnNotes = (Button) findViewById(R.id.btnNotes);
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });

        btnQuizzes = (Button) findViewById(R.id.btnQuizzes);
        btnQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, QuizzesActivity.class);
                startActivity(intent);
            }
        });

        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}