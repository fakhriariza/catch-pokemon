package com.lpikitb.catchpokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {

    TextView tvName, tvType, tvPokedex2;
    ImageView ivPokePhoto;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvListMyPokeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tvName = (TextView) findViewById(R.id.tvName);
        tvPokedex2 = (TextView) findViewById(R.id.tvPokedex2);
        tvType = (TextView) findViewById(R.id.tvType);
        ivPokePhoto = (ImageView) findViewById(R.id.ivPokePhoto);
        showPokedex();

        tvPokedex2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(MainActivity.this, MyPokelistActivity.class));
            }
        });
}

    private void showPokedex() {
        ApiServices api = InitRetrofit.getInstance();
        Call<Response> pokedexCall = api.request_show_all_pokedox();
        pokedexCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<PokedoxItem> data_pokedox = response.body().getPokedox();
                    boolean status = response.body().isStatus();
                    if (status){
                        PokedoxAdapter adapter = new PokedoxAdapter(MainActivity.this, data_pokedox);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(MainActivity.this, "No Pokedex", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}