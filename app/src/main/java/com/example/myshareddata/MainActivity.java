package com.example.myshareddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewData;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewData = findViewById(R.id.textViewData);
        loadData();
    }

    public void button_Add(View view) {
        counter++;
        textViewData.setText(String.valueOf(counter));
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("CounterValue",counter);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        counter = sharedPreferences.getInt("CounterValue",MODE_PRIVATE);
        textViewData.setText(String.valueOf(counter));

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }
}
