package com.lpikitb.catchpokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("show_pokedox.php")
    Call<Response> request_show_all_pokedox();
}
