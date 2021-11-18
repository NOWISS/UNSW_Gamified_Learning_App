package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.xutils.ex.DbException;


public class QuizActivity extends AppCompatActivity {



	private List<Quesstion> list;
	/**
	 * Mark the current number
	 */
	private int index = 0;
	private Context mContext;

	private SqlUtils sqlUtils;
	private ImageView lefticon;
    private TextView tvPro,tvTitle,tvJg,tvAnswer;
    private RadioButton r1,r2,r3,r4;
    private Button btnNext;
    private RadioGroup rg;
    private int count;
    private int status;
    private CardView cd;


	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		sqlUtils = SqlUtils.getInstance();
		list = new ArrayList<>();
		status = getIntent().getIntExtra("status",1);
		mContext = QuizActivity.this;
		tvPro = findViewById(R.id.tv_pro);
		tvJg = findViewById(R.id.tv_jg);
		tvTitle = findViewById(R.id.tv_title);
		tvAnswer = findViewById(R.id.tv_answer);
		btnNext = findViewById(R.id.btn_next);
		cd = findViewById(R.id.cd);
		r1 = findViewById(R.id.rb1);
        r2 = findViewById(R.id.rb2);
        r3 = findViewById(R.id.rb3);
        r4 = findViewById(R.id.rb4);
        rg = findViewById(R.id.rg);

		lefticon = findViewById(R.id.back);
		// Make the return button
		lefticon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent1 = new Intent(QuizActivity.this,QuizzesActivity.class);
				startActivity(intent1);
			}
		});

		tvJg.setVisibility(View.GONE);
		//Next question
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				setNext();
			}
		});


		getTestList();

		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override public void onCheckedChanged(RadioGroup radioGroup, int i) {
				RadioButton b = radioGroup.findViewById(i);
				if(b!=null&&b.isChecked()){
					if(b.getText().equals(list.get(index).getAnswer())){
						// Correct pick
						tvJg.setVisibility(View.VISIBLE);
						tvJg.setText("√");
						tvJg.setTextColor(Color.GREEN);
						tvPro.setText((index+1)+" / "+count);
					}else{
						// Wrong pick
						tvJg.setVisibility(View.VISIBLE);
						tvJg.setText("X");
						tvJg.setTextColor(Color.RED);
                        tvPro.setText((index+1)+" / "+count);
					}
				}

			}
		});

	}

	//Go to next question
	private void setNext(){
		index++;
		if (index == count||index>count) {//Last question
			index = count;
			//Toast.makeText(QuizActivity.this,
                    //"End of current quizzes" , Toast.LENGTH_LONG).show();
			startActivity(new Intent(this,Checkpoint.class));
		}else{
			rg.clearCheck();
			tvJg.setVisibility(View.INVISIBLE);
			tvTitle.setText(list.get(index).getTitle());
			r1.setText(list.get(index).getAnswer1());
            r2.setText(list.get(index).getAnswer2());
            r3.setText(list.get(index).getAnswer3());
            r4.setText(list.get(index).getAnswer4());
		}
	}


	@SuppressLint("CheckResult") private void getTestList(){
		try {
			list.clear();
		    List<Quesstion> l = sqlUtils.getDb().selector(Quesstion.class).where("status","=",status).findAll();
			if(l!=null&&l.size()>0){
			 list.addAll(l);
            }
		    if(list.size()==0){
				// No question left
				Toast.makeText(mContext,"No Quesstion",Toast.LENGTH_SHORT).show();
				btnNext.setVisibility(View.GONE);
				cd.setVisibility(View.GONE);

			}else{
                tvPro.setText("0/"+list.size());
                count = list.size();
				index = 0;
                tvTitle.setText(list.get(index).getTitle());
                r1.setText(list.get(index).getAnswer1());
                r2.setText(list.get(index).getAnswer2());
                r3.setText(list.get(index).getAnswer3());
                r4.setText(list.get(index).getAnswer4());

			}

		} catch (DbException e) {
			Toast.makeText(mContext,"error："+e.getMessage(),Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}

	}




}
