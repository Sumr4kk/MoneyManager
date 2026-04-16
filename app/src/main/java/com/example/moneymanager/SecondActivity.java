package com.example.moneymanager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.app.Activity;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("LIFECYCLE", "SecondActivity: onCreate");

        TextView displayText = findViewById(R.id.displayText);
        String text = getIntent().getStringExtra("my_text");
        displayText.setText(text);
    }

    @Override
    protected void onStart() { super.onStart(); Log.d("LIFECYCLE", "SecondActivity: onStart"); }
    @Override
    protected void onResume() { super.onResume(); Log.d("LIFECYCLE", "SecondActivity: onResume"); }
    @Override
    protected void onPause() { super.onPause(); Log.d("LIFECYCLE", "SecondActivity: onPause"); }
    @Override
    protected void onStop() { super.onStop(); Log.d("LIFECYCLE", "SecondActivity: onStop"); }
    @Override
    protected void onDestroy() { super.onDestroy(); Log.d("LIFECYCLE", "SecondActivity: onDestroy"); }
}