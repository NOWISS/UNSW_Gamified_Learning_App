package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;

import java.util.List;

public class TopicAdapter extends FirebaseRecyclerAdapter<Topics,TopicAdapter.ViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TopicAdapter(@NonNull FirebaseRecyclerOptions<Topics> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Topics model) {
        holder.name.setText(model.getName());
        holder.length.setText(model.getLength());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity act = (AppCompatActivity) view.getContext();
                act.getSupportFragmentManager().beginTransaction().replace(R.id.ghost_view,new DeFragment())
                        .addToBackStack(null).commit();
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

