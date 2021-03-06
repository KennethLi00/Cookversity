package com.example.cookversity;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookversity.Entities.Recipe;
import com.example.cookversity.Entities.RecipeShort;
import com.example.cookversity.Entities.RecipeShortResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeListFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private RecipeListAdapter ra;
    private RecyclerView rv;

    public RecipeListFragment() {
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
        View v = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        rv = v.findViewById(R.id.rvRecipeList);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        ra = new RecipeListAdapter(getActivity(), new ArrayList<RecipeShort>());
        rv.setAdapter(ra);
        new GetRecipeTask().execute();
        return v;
    }

    private class GetRecipeTask extends AsyncTask<Void, Void, List<RecipeShort>> {

        @Override
        protected List<RecipeShort> doInBackground(Void... voids) {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.spoonacular.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RecipeService service = retrofit.create(RecipeService.class);
                System.out.println(getArguments().getString(ARG_ITEM_ID));
                Call<RecipeShortResponse> recipeCall = service.getCuisineRecipe(getArguments().getString(ARG_ITEM_ID));
                Response<RecipeShortResponse> recipeResponse = recipeCall.execute();
                System.out.println(recipeResponse.isSuccessful());
                List<RecipeShort> recipeList = recipeResponse.body().getResults();
                System.out.println(recipeList.size());
                return recipeList;
            } catch (IOException e) {
                System.out.println("Exception");
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<RecipeShort> recipes) {
            ra.setRecipes(recipes);
        }
    }

}
