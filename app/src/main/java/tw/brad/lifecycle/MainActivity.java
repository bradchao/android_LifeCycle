package tw.brad.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private MyApp myApp;

    public MainActivity(){
        Log.d("brad", "MainActivity");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("brad", "onCreate");
        //tv.setText("OK");

        myApp = (MyApp)getApplication();
        Log.d("brad", "myApp:a=" + myApp.getA());
        Log.d("brad", "myApp:b=" + myApp.getB());
        myApp.setA(321);
        myApp.setB("III");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("brad", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("brad", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("brad", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("brad", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("brad", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("brad", "onDestroy");
    }

    public void gotoPage2(View v){
        Intent intent = new Intent(this, Page2Activity.class);
        intent.putExtra("name","Brad");
        intent.putExtra("stage",4);
        intent.putExtra("sound",false);
        startActivity(intent);
    }

    public void gotoPage2v2(View v){
        Intent intent = new Intent(this, Page2Activity.class);
        intent.putExtra("name","Brad");
        intent.putExtra("stage",4);
        intent.putExtra("sound",false);

        startActivityForResult(intent,77);
    }
    public void gotoPage3v2(View v){
        Intent intent = new Intent(this, Page3Activity.class);
        startActivityForResult(intent,66);

    }

    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("brad", "onActivityResult:" + resultCode);
        if(requestCode == 77) {
            int a = data.getIntExtra("a", -1);
            int b = data.getIntExtra("b", -1);
            Log.d("brad", a + " : " + b);
        }else if (requestCode == 66){
            Log.d("brad", "Page3 Back");
        }

    }

    public void exit(View v){
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("brad", "finish");
    }
}
