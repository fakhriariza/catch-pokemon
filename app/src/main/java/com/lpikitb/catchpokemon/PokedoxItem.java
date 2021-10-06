package com.lpikitb.catchpokemon;

import com.google.gson.annotations.SerializedName;

public class PokedoxItem{

	@SerializedName("name")
	private String name;

	@SerializedName("photo")
	private String photo;

	@SerializedName("weight")
	private String weight;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("height")
	private String height;


	public String getName(){
		return name;
	}

	public String getPhoto(){
		return photo;
	}

	public String getWeight(){
		return weight;
	}

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}
	public String getHeight(){
		return height;
	}
}