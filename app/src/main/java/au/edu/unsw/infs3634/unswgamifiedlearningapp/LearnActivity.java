package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class LearnActivity extends AppCompatActivity {
    private Button btnNotes, btnQuizzes, btnProfile;
    private static final String TAG = "LearnActivity";
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;
    private FirebaseRecyclerOptions<Topics> options;
    private ImageView lefticon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        //getSupportActionBar().setTitle("Learn");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get a handle to the Recyclerview
        recyclerView = findViewById(R.id.recycler_topic_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Set firebase recyclerview
        options = new FirebaseRecyclerOptions.Builder<Topics>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Topics"), Topics.class)
                .build();
        // Set adapter
        topicAdapter = new TopicAdapter(options);
        recyclerView.setAdapter(topicAdapter);

        lefticon = findViewById(R.id.back);
        // Make the return button
        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LearnActivity.this,HomeActivity.class);
                startActivity(intent1);
            }
        });

        }

    //The FirebaseRecyclerAdapter uses an event listener to monitor changes to the Firebase query.
    // To begin listening for data, call the startListening() method
    @Override
    protected void onStart() {
        super.onStart();
        topicAdapter.startListening();
    }
    // The stopListening() call removes the event listener and all data in the adapter.
    @Override
    protected void onStop() {
        super.onStop();
        topicAdapter.startListening();
    }

}