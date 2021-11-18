package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class TopicAdapter extends FirebaseRecyclerAdapter<Topics,TopicAdapter.ViewHolder>{

    private ArrayList<Topics> top;

    public TopicAdapter(@NonNull FirebaseRecyclerOptions<Topics> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Topics model) {
        //Topics topics = top.get(position);
        holder.name.setText(model.getName());
        holder.length.setText(model.getLength());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TopicDetail.class);
                intent.putExtra(TopicDetail.INTENT_MESSAGE,model.getId());
                view.getContext().startActivity(intent);
            }
        });
        Glide.with(holder.img.getContext())
                .load(model.getIurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark_normal)
                .error(R.drawable.common_google_signin_btn_icon_dark_focused)
                .into(holder.img);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list,parent,false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img,button;
        TextView name, length;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.item_topic_name);
            length = itemView.findViewById(R.id.length);
            button = itemView.findViewById(R.id.button);
        }
    }
}


