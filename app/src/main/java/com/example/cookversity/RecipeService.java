package com.example.cookversity;

import com.example.cookversity.Entities.RecipeResponse;
import com.example.cookversity.Entities.RecipeShortResponse;
import com.example.cookversity.RecipeLongEntities.RecipeLongResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipeService {
    @GET("/recipes/random?number=1&apiKey=6a3e2feb9e064238916370643b6e784b")
    Call<RecipeResponse> getRandomRecipe();

//    @GET("/recipes/random?number=5&tags=european&apiKey=6a3e2feb9e064238916370643b6e784b")
//    Call<RecipeResponse> getCuisineRecipe();

    @GET("/recipes/search?&number=10&apiKey=fdb2f73334a5430e86885aeec27503da")
    Call<RecipeShortResponse> getCuisineRecipe(@Query("cuisine") String cuisine);

    @GET("/recipes/{id}/information?&apiKey=6a3e2feb9e064238916370643b6e784b")
    Call<RecipeLongResponse> getRecipeID(@Path("id") int id);
//    Call<RecipeLongResponse> getRecipeID();
}
