package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.Method;
import java.util.Map;

import androidx.annotation.NonNull;


public class SPUtils {
    //保存在手机里面的文件名
    public static final String FILE_NAME = "psms";
    public static SharedPreferences sp ;

    private static SharedPreferences init(Context context) {
        return sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static <E>void put(@NonNull String key, @NonNull E value) {
        put(MyApp.getAppContext(),key,value);
    }


    public static <E>E get(@NonNull String key,@NonNull E defaultValue) {
        return get(MyApp.getAppContext(),key,defaultValue);
    }


    public static <E>void put(Context context,@NonNull String key,@NonNull E value) {
        SharedPreferences.Editor editor = init(context).edit();
        if (value instanceof String||value instanceof Integer||value instanceof Boolean||
                value instanceof Float|| value instanceof Long||value instanceof Double) {
            editor.putString(key, String.valueOf(value));
        }else {
            editor.putString(key, new Gson().toJson(value));
        }
        SPCompat.apply(editor);
    }


    public static <E>E get(Context context,@NonNull String key,@NonNull E defaultValue) {
        String value = init(context).getString(key, String.valueOf(defaultValue));
        if (defaultValue instanceof String){
            return (E) value;
        }if (defaultValue instanceof Integer){
            return (E) Integer.valueOf(value);
        }if (defaultValue instanceof Boolean){
            return (E) Boolean.valueOf(value);
        }if (defaultValue instanceof Float){
            return (E) Float.valueOf(value);
        }if (defaultValue instanceof Long){
            return (E) Long.valueOf(value);
        }if (defaultValue instanceof Double){
            return (E) Double.valueOf(value);
        }
        //When json is null, the returned object is null, and gson has been processed
        return (E) new Gson().fromJson(value,defaultValue.getClass());
    }


    // remove key
    public static void remove(Context context, String key) {
        SharedPreferences.Editor editor = init(context).edit();
        editor.remove(key);
        SPCompat.apply(editor);
    }

    //clear all data
    public static void clear(Context context) {
        SharedPreferences.Editor editor = init(context).edit();
        editor.clear();
        SPCompat.apply(editor);
    }

    // Check if a key exists
    public static boolean contains(Context context, String key) {
        return init(context).contains(key);
    }
    public static boolean contains(String key) {
        return contains(MyApp.getAppContext(),key);
    }

    // Return all
    public static Map<String, ?> getAll(Context context) {
        return init(context).getAll();
    }


    public static void saveObject( String key, Object value) {
        put(key,value);
    }


    public static <T>T readObject(String key,  Class<T> clazz) {
        try {
            return (T) get(key,clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static class SPCompat {
        private static final Method S_APPLY_METHOD = findApplyMethod();


        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }
            return null;
        }


        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (S_APPLY_METHOD != null) {
                    S_APPLY_METHOD.invoke(editor);
                    return;
                }
            } catch (Exception e) {
            }
            editor.commit();
        }
    }
}