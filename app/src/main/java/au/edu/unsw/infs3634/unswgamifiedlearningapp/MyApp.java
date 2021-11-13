package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.app.Application;

import org.xutils.x;

import androidx.paging.PagingSource;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
