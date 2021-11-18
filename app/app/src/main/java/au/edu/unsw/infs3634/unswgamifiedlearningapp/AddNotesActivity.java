package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Context;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import org.xutils.ex.DbException;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;


public class AddNotesActivity extends AppCompatActivity {

	private TextView tvSave;
    private EditText etTitle;
    private EditText etDetail;
	private String userBean;
	private Notes notes;
	private Context mContext;
	private SqlUtils sqlUtils;
	private String from;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		setContentView(R.layout.activity_add_notes);
		sqlUtils = SqlUtils.getInstance();
		mContext = AddNotesActivity.this;
		from = getIntent().getStringExtra("from");
		tvSave = findViewById(R.id.title_right);
		etTitle = findViewById(R.id.et_title);
		etDetail = findViewById(R.id.et_detail);
		//Read userBean class
		notes = (Notes) getIntent().getSerializableExtra("bean");
		userBean = SPUtils.get("userName", "Admin");

		if(!from.equals("add")){
			etTitle.setText(notes.getTitle());
			etDetail.setText(notes.getDetail());
			etTitle.setEnabled(false);
			etDetail.setEnabled(false);
			tvSave.setVisibility(View.GONE);
		}

		tvSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(TextUtils.isEmpty(etTitle.getText().toString())||TextUtils.isEmpty(etDetail.getText().toString())){
					Toast.makeText(mContext,"Please complete",Toast.LENGTH_SHORT).show();
					return;
				}
				//add note
				Notes depBean = new Notes();
				depBean.setTitle(etTitle.getText().toString());
				depBean.setDetail(etDetail.getText().toString());
				depBean.setName(userBean);
				//Check format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				depBean.setDate(sdf.format(new Date()));

				try {
					sqlUtils.getDb().save(depBean);
					Toast.makeText(mContext,"Saved successfully",Toast.LENGTH_SHORT).show();
					finish();
				} catch (DbException e) {
					e.printStackTrace();
					Toast.makeText(mContext,"Save failed："+e.getMessage(),Toast.LENGTH_SHORT).show();
				}

			}
		});

	}



}
