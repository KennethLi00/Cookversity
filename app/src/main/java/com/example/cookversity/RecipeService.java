package com.example.cookversity;

import com.example.cookversity.Entities.Recipe;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeService {
    @GET("/recipes/random?number=1&apiKey=6a3e2feb9e064238916370643b6e784b")
    Call<Recipe> getRandomRecipe();
}
