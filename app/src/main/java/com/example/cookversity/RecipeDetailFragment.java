package com.example.cookversity;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cookversity.RecipeLongEntities.ExtendedIngredient;
import com.example.cookversity.RecipeLongEntities.RecipeLongResponse;
import com.example.cookversity.RecipeLongEntities.Step;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecipeDetailFragment extends Fragment {
    public static final String RECIPE_ID = "recipe_id";
    private TextView title;
    private TextView readyServings;
    private TextView ingredients;
    private TextView instructions;
    private ImageView recipeImage;


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
        View v = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        title = v.findViewById(R.id.tvTitle);
        readyServings = v.findViewById(R.id.tvReadyServings);
        ingredients = v.findViewById(R.id.tvIngredients);
        instructions = v.findViewById(R.id.tvInstructions);
        new GetRecipe().execute();
        return v;
    }

    private class GetRecipe extends AsyncTask<Void, Void, RecipeLongResponse> {

        @Override
        protected RecipeLongResponse doInBackground(Void... voids) {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.spoonacular.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RecipeService service = retrofit.create(RecipeService.class);
                System.out.println(getArguments().getInt(RECIPE_ID));
                Call<RecipeLongResponse> recipeCall = service.getRecipeID(getArguments().getInt(RECIPE_ID));
//                Call<RecipeLongResponse> recipeCall = service.getRecipeID();
                Response<RecipeLongResponse> recipeResponse = recipeCall.execute();
                RecipeLongResponse r = recipeResponse.body();
                return r;
            } catch (IOException e) {
                System.out.println("Exception");
                return null;
            }
        }

        @Override
        protected void onPostExecute(RecipeLongResponse recipe) {
            title.setText(recipe.getTitle());
            readyServings.setText(recipe.getServings() + " serving(s)     Ready in " + recipe.getReadyInMinutes() + " minutes(s)");
            View rootView = getView();
            Glide.with(getContext()).load(recipe.getImage()).fitCenter()
                    .into(((ImageView) rootView.findViewById(R.id.ivRecipePic)));
            String ing = "";
            for (ExtendedIngredient e : recipe.getExtendedIngredients()) {
                ing = ing + e.getAmount() + " " + e.getUnit() + "(s) " + e.getName() + "\n";
            }
            String ins = "";
            ingredients.setText(ing);
            int num = 1;
            System.out.println(recipe.getInstructions());
            try {
                for (Step i : recipe.getAnalyzedInstructions().get(0).getSteps()) {
                    ins = ins + num + ". " + i.getStep() + "\n" + "\n";
                    num++;
                }
            } catch (IndexOutOfBoundsException e) {
                ins = "no instructions";
            }


            instructions.setText(ins);
        }
    }

}
