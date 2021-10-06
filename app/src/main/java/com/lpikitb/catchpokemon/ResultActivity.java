package com.lpikitb.catchpokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvResults, tvName4;
    Button button;
    EditText etName;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResults = (TextView) findViewById(R.id.tvResults);
        tvName4 = (TextView) findViewById(R.id.tvName4);
        button = (Button) findViewById(R.id.button);
        etName = (EditText) findViewById(R.id.etName);
        showResults();

        sharedPreferences = getSharedPreferences("pokemon_user", MODE_PRIVATE);
        sharedPreferences.contains("pokename");
        sharedPreferences.contains("name");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pokename = etName.getText().toString();
                String name = tvName4.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("pokename", pokename);
                    editor.putString("name", name);
                    editor.apply();
                    Intent intent = new Intent(ResultActivity.this, MyPokelistActivity.class);
                    startActivity(intent);
                }
            });
    }

    private void showResults() {
        String name = getIntent().getStringExtra("NM_POKEDOX");
        tvResults.setText("Yay! You Found " + name);
        tvName4.setText(name);
    }
}