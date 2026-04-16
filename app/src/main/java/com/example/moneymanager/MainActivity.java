package com.example.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LIFECYCLE", "MainActivity: onCreate");

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("my_text", text);
                startActivity(intent);
            }
        });

        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString("saved_text");
            if (savedText != null) {
                editText.setText(savedText);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saved_text", editText.getText().toString());
        Log.d("LIFECYCLE", "MainActivity: сохранено");
    }

    @Override
    protected void onStart() { super.onStart(); Log.d("LIFECYCLE", "MainActivity: onStart"); }
    @Override
    protected void onResume() { super.onResume(); Log.d("LIFECYCLE", "MainActivity: onResume"); }
    @Override
    protected void onPause() { super.onPause(); Log.d("LIFECYCLE", "MainActivity: onPause"); }
    @Override
    protected void onStop() { super.onStop(); Log.d("LIFECYCLE", "MainActivity: onStop"); }
    @Override
    protected void onDestroy() { super.onDestroy(); Log.d("LIFECYCLE", "MainActivity: onDestroy"); }
}