package com.lpikitb.catchpokemon;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("pokedox")
	private List<PokedoxItem> pokedox;

	@SerializedName("status")
	private boolean status;

	public List<PokedoxItem> getPokedox(){
		return pokedox;
	}

	public boolean isStatus(){
		return status;
	}
}