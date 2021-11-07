package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class TopicDetail extends AppCompatActivity {

    private static final String TAG = "TopicDetail";
    public static String INTENT_MESSAGE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        // Get the Intent that started this activity and extract the string
        Intent intent = new Intent();
        Bundle bundle = intent.getExtras();
        String name = getIntent().getStringExtra("MESSAGE");
    }
}