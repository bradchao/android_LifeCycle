package tw.brad.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {
    private TextView mesg;
    private MyApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        myApp = (MyApp)getApplication();
        Log.d("brad", "myApp:a=" + myApp.getA());
        Log.d("brad", "myApp:b=" + myApp.getB());

        Intent intent = getIntent();
        int stage = intent.getIntExtra("stage",0);
        String name = intent.getStringExtra("name");
        boolean sound = intent.getBooleanExtra("sound",true);
        int temp = intent.getIntExtra("temp",0);

        mesg = (TextView)findViewById(R.id.page2_mesg);
        mesg.setText("Name: " + name + "\n" +
                    "Stage:" + stage + "\n" +
                    "Sound: " + (sound?"On":"Off") + "\n" +
                    "Temp: " + temp);

    }

    @Override
    public void finish() {
        Intent it = new Intent();
        it.putExtra("a",1);
        it.putExtra("b",2);
        setResult(99,it);
        super.finish();

    }
}
