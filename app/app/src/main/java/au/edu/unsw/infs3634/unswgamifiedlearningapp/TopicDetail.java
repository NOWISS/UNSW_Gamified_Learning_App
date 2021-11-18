package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicDetail extends AppCompatActivity {

    private String TAG = "TopicDetail";
    String api_key = "563b4217c7d642139a8bf45a9fe0eae7";
    String q = "climate";

    ArrayList<ModelClass> list;
    NewsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView tx;
    private Button play;
    public static String INTENT_MESSAGE;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        // Set up material 1
        tx = findViewById(R.id.tx);
        play = findViewById(R.id.play);

        // Get the Intent that started this activity and extract the string
        Intent intent = new Intent();
        Bundle bundle = intent.getExtras();
        String name = getIntent().getStringExtra(INTENT_MESSAGE);
        Log.d(TAG,name);

        // use data location reference to find id
        ref = FirebaseDatabase.getInstance().getReference().child("Topics");
        ref.child("t"+name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String title = snapshot.child("m1_text").getValue().toString();
                    String link = snapshot.child("m1_v").getValue().toString();

                    tx.setText(title);
                    play.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String searchTerm = "ytb";
                            //Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                            //intent1.putExtra(SearchManager.QUERY, searchTerm);
                            //startActivity(intent1);
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        recyclerView = findViewById(R.id.recylcer_news);
        // declare model class
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //create adapter
        adapter = new NewsAdapter(this,list);
        recyclerView.setAdapter(adapter);

        getNews();
    }
    private void getNews() {
        RequestManager.getApiInterface().getQ(q,100,api_key).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful()){
                    list.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
    }
}