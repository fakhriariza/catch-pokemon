package com.lpikitb.catchpokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView tvName2, tvType2, tvWeight, tvHeight, tvCatch;
    ImageView ivPokePhoto;
    ConstraintLayout ClCatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName2 = (TextView) findViewById(R.id.tvName2);
        tvType2 = (TextView) findViewById(R.id.tvType2);
        tvWeight = (TextView) findViewById(R.id.tvWeight);
        tvHeight = (TextView) findViewById(R.id.tvHeight);
        tvCatch = (TextView) findViewById(R.id.tvCatch);
        ivPokePhoto = (ImageView) findViewById(R.id.ivPokePhoto);
        ClCatch = (ConstraintLayout) findViewById(R.id.ClCatch);
        showDetail();


        ClCatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent = new Intent (DetailActivity.this, CatchActivity.class);
                intent.putExtra("NM_POKEDOX", tvName2.getText().toString());
                intent.putExtra("PH_POKEDOX", ivPokePhoto.toString());
                startActivity(intent);
            }
        });

    }

    private void showDetail() {
        String name = getIntent().getStringExtra("NM_POKEDOX");
        String type = getIntent().getStringExtra("TP_POKEDOX");
        String weight = getIntent().getStringExtra("WG_POKEDOX");
        String height = getIntent().getStringExtra("HG_POKEDOX");
        String photo = getIntent().getStringExtra("PH_POKEDOX");

        tvName2.setText(name);
        tvType2.setText(type);
        tvWeight.setText("Weight : " + weight + " Kg");
        tvHeight.setText("Height : " + height + " Cm");
        tvCatch.setText("Catch " + name);
        Picasso.with(this).load(photo).into(ivPokePhoto);
    }

}