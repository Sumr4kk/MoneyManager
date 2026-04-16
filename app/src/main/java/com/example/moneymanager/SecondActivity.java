package com.example.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class SecondActivity extends Activity {

    TextView textViewReceived;
    EditText editTextResult;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("INTENT", "SecondActivity: onCreate");

        textViewReceived = findViewById(R.id.textViewReceived);
        editTextResult = findViewById(R.id.editTextResult);
        buttonBack = findViewById(R.id.buttonBack);

        String receivedText = getIntent().getStringExtra("text_key");
        if (receivedText != null && !receivedText.isEmpty()) {
            textViewReceived.setText(receivedText);
            Log.d("INTENT", "Получен текст: " + receivedText);
        } else {
            textViewReceived.setText("Текст не передан");
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultText = editTextResult.getText().toString();
                if (resultText.isEmpty()) {
                    resultText = "Пустой результат";
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_key", resultText);
                setResult(RESULT_OK, resultIntent);

                Log.d("INTENT", "Возвращаем результат: " + resultText);

                finish();
            }
        });
    }

    @Override protected void onStart() { super.onStart(); Log.d("LIFECYCLE", "SecondActivity: onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("LIFECYCLE", "SecondActivity: onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("LIFECYCLE", "SecondActivity: onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("LIFECYCLE", "SecondActivity: onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("LIFECYCLE", "SecondActivity: onDestroy"); }
}