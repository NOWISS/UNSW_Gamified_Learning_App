package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    // Idea for notes screen taken from:
    // Title: EasyTutoNotes source code
    // Author: Easy Tuto
    // Date: 8/8/2021
    // Availability: https://www.youtube.com/watch?v=or_pH92l-IQ&t=706s&ab_channel=EasyTuto

    private ImageView lefticon;
    private RecyclerView rcView;
    private Button tvAdd;
    private List<Notes> list;
    private NotesListAdapter mAdapter;
    private Context mContext;
    private SqlUtils sqlUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        sqlUtils = SqlUtils.getInstance();
        mContext = NotesActivity.this;
        list=new ArrayList<>();
        tvAdd = findViewById(R.id.title_r2);
        rcView = findViewById(R.id.recycler);
        mAdapter=new NotesListAdapter(R.layout.item_note,list,mContext);
        rcView.setLayoutManager(new LinearLayoutManager(mContext));
        rcView.setAdapter(mAdapter);

        lefticon = findViewById(R.id.back);
        // Make the return button
        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(NotesActivity.this,HomeActivity.class);
                startActivity(intent1);
            }
        });

        tvAdd.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent intent = new Intent(NotesActivity.this,AddNotesActivity.class);
                                         intent.putExtra("from","add");
                                         intent.putExtra("bean",new Notes());
                                         startActivity(intent);
                                     }
                                 });

                // Look into detail
                mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(NotesActivity.this, AddNotesActivity.class);
                        intent.putExtra("from", "update");
                        intent.putExtra("bean", list.get(position));
                        startActivity(intent);
                    }
                });

    }

   private void getLeaveList(String msg){
        String userBean = SPUtils.get("userName", "Admin");
        try {
            list.clear();
            List<Notes> list2 ;
            list2 = sqlUtils.getDb().selector(Notes.class).where("name","=",userBean).findAll();

            if(list2!=null&&list2.size()>0){
                list.addAll(list2);
            }


            mAdapter.notifyDataSetChanged();
        } catch (DbException e) {
            Toast.makeText(mContext,"error："+e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    @Override protected void onResume() {
        super.onResume();
        getLeaveList("");
    }
}