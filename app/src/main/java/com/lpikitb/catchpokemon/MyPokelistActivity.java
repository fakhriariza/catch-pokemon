package com.lpikitb.catchpokemon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MyPokelistActivity extends AppCompatActivity {

    TextView tvName, tvType, tvPokedex;
    ImageView ivPokePhoto;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypokelist);

        tvName = (TextView) findViewById(R.id.tvName);
        tvType = (TextView) findViewById(R.id.tvType);
        tvPokedex = (TextView) findViewById(R.id.tvPokedex);
        ivPokePhoto = (ImageView) findViewById(R.id.ivPokePhoto);

        sharedPreferences = getSharedPreferences("pokemon_user", MODE_PRIVATE);
        tvName.setText(sharedPreferences.getString("pokename",null));
        tvType.setText(sharedPreferences.getString("name",null));

        tvPokedex.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(MyPokelistActivity.this, MainActivity.class));
            }
        });
}


}