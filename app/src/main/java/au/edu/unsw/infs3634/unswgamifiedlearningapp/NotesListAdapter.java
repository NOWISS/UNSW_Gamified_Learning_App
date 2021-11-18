package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Context;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;



public class NotesListAdapter extends BaseQuickAdapter<Notes, BaseViewHolder> {

	private Context context;
	private String from;
	private int id;

    public NotesListAdapter(int layoutResId, @Nullable List<Notes> data, Context context) {
        super(layoutResId,data);
        this.context = context;
    }


	@Override
    protected void convert(BaseViewHolder helper, Notes item) {
	    TextView tvTitle,tvDetai,tvDate;

		tvTitle = helper.getView(R.id.tv_title);
		tvDetai = helper.getView(R.id.tv_detail);
		tvDate = helper.getView(R.id.tv_date);

		tvTitle.setText(item.getTitle());
		tvDetai.setText(item.getDetail());
		tvDate.setText(item.getDate());
    }
}
