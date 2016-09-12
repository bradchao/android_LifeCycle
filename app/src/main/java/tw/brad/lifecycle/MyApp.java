package tw.brad.lifecycle;

import android.app.Application;
import android.util.Log;

/**
 * Created by brad on 2016/9/12.
 */
public class MyApp extends Application {
    private int a;
    private String b;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("brad", "MyApp");

        a = 123;
        b = "Brad";
    }
    int getA(){return a;}
    String getB(){return b;}
    void setA(int a){this.a=a;}
    void setB(String b){this.b=b;}
}
