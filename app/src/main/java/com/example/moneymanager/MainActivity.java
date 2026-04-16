package com.example.moneymanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_SECOND = 1;

    EditText editTextInput;
    Button buttonSend;
    TextView textViewResult;
    Button buttonOpenWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("INTENT", "MainActivity: onCreate");

        editTextInput = findViewById(R.id.editTextInput);
        buttonSend = findViewById(R.id.buttonSend);
        textViewResult = findViewById(R.id.textViewResult);
        buttonOpenWeb = findViewById(R.id.buttonOpenWeb);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("text_key", text);
                startActivityForResult(intent, REQUEST_CODE_SECOND);
                Log.d("INTENT", "Отправлен текст: " + text);
            }
        });

        buttonOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
                Log.d("INTENT", "Открыт браузер через неявный Intent");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SECOND && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result_key");
            textViewResult.setText(result);
            Log.d("INTENT", "Получен результат: " + result);
        }
    }

    @Override protected void onStart() { super.onStart(); Log.d("LIFECYCLE", "MainActivity: onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("LIFECYCLE", "MainActivity: onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("LIFECYCLE", "MainActivity: onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("LIFECYCLE", "MainActivity: onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("LIFECYCLE", "MainActivity: onDestroy"); }
}