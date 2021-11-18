package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public NewsAdapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_items,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.author.setText("Author: "+modelClassArrayList.get(position).getAuthor());
            holder.main.setText(modelClassArrayList.get(position).getDescription());
            holder.published.setText("Published at: "+modelClassArrayList.get(position).getPublishedAt());
            holder.title.setText(modelClassArrayList.get(position).getTitle());
            Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.img);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,Webview.class);
                    intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView author, main, published,title;
        ImageView img;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.news_author);
            main = itemView.findViewById(R.id.main_content);
            published = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.news_img);
            cardView = itemView.findViewById(R.id.card);
            title = itemView.findViewById(R.id.head);

        }
    }
}
