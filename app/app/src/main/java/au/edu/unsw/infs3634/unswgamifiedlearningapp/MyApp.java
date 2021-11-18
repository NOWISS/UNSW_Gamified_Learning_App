package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

import androidx.paging.PagingSource;

public class MyApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        x.Ext.init(this);
    }

    public static Context getAppContext() {
        return context;
    }
}
