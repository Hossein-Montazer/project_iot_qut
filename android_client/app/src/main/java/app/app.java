package app;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class app {
    public static  class main{
        public static final String TAG="part1";
        public static final String font_patch="Font/";
        public static final String font_IRANMarker="IRANMarker.ttf";
    }

    public static void log(String message){
        Log.e(main.TAG,message);
    }
    public static void toast(String message){
        Toast.makeText(application.getContext(),message,Toast.LENGTH_LONG).show();
    }
}
