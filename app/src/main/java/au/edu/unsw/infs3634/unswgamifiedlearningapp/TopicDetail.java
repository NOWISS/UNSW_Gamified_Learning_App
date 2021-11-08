package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicDetail extends AppCompatActivity {

    String api_key = "563b4217c7d642139a8bf45a9fe0eae7";
    String q = "climate";
    String country = "us";
    ArrayList<ModelClass> list;
    NewsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        list = new ArrayList<>();
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
        RequestManager.getApiInterface().getQ(country,q,100,api_key).enqueue(new Callback<NewsResponse>() {
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