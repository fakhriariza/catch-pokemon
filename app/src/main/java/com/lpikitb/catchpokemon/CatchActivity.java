package com.lpikitb.catchpokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CatchActivity extends AppCompatActivity {

    TextView tvDesc, tvName3;
    ImageView ivPokeBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch);

        tvDesc = (TextView) findViewById(R.id.tvDesc);
        ivPokeBall = (ImageView) findViewById(R.id.ivPokeBall);
        tvName3 = (TextView) findViewById(R.id.tvName3);

        showCatch();

        ivPokeBall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent = new Intent(CatchActivity.this, ResultActivity.class);
                intent.putExtra("NM_POKEDOX", tvName3.getText().toString());
                startActivity(intent);
            }

    });
    };

    private void showCatch() {
        String name = getIntent().getStringExtra("NM_POKEDOX");
        tvDesc.setText("Find " + name + " and catch to your Pokelist");
        tvName3.setText(name);
    }
}