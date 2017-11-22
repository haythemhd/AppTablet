package haythem.hd.appfortablet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FragTwo fragmentTwo = (FragTwo)
                getSupportFragmentManager().findFragmentById(R.id.list_frag);


        String ch = getIntent().getStringExtra("text");
        fragmentTwo.updateContent(ch);
    }
}
