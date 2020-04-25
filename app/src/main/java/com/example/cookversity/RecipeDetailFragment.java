package com.example.cookversity;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookversity.Entities.Recipe;
import com.example.cookversity.Entities.RecipeLongResponse;
import com.example.cookversity.Entities.RecipeResponse;
import com.example.cookversity.Entities.RecipeShort;
import com.example.cookversity.Entities.RecipeShortResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecipeDetailFragment extends Fragment {
    public static final String RECIPE_ID = "recipe_id";


    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new GetRecipe().execute();
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false);
    }

    private class GetRecipe extends AsyncTask<Void, Void, List<Recipe>> {

        @Override
        protected List<Recipe> doInBackground(Void... voids) {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.spoonacular.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RecipeService service = retrofit.create(RecipeService.class);
                System.out.println(getArguments().getInt(RECIPE_ID));
//                Call<RecipeLongResponse> recipeCall = service.getRecipeID(getArguments().getInt(RECIPE_ID));
                Call<RecipeLongResponse> recipeCall = service.getRecipeID();
                Response<RecipeLongResponse> recipeResponse = recipeCall.execute();
                List<Recipe> recipeList = recipeResponse.body().getRecipes();
                System.out.println(recipeList.size());
//                System.out.println(recipe.getTitle());
                return recipeList;
            } catch (IOException e) {
                System.out.println("Exception");
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Recipe> recipe) {

        }
    }

}
