package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class DeFragment extends Fragment {

    String api_key = "563b4217c7d642139a8bf45a9fe0eae7";
    String q = "climate";
    String country = "us";
    ArrayList<ModelClass> list;
    NewsAdapter adapter;
    private RecyclerView recyclerView;

    public DeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_de,container,false);

        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recylcer_news);
        // declare model class
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //create adapter
        adapter = new NewsAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);

        getNews();


        return view;
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