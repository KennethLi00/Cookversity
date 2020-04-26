package com.example.cookversity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.cookversity.Entities.Recipe;
import com.example.cookversity.Entities.RecipeResponse;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;
    private ViewFlipper viewFlipper;
    private Context mContext;
    private ImageView cookingTip;
    private ImageView randomRecipe;
    private TextView cookingTipText;
    private TextView randomRecipeText;
    private ArrayList<CookingTips> mlist;
    private Recipe mRecipe;
    private Bitmap myBitmap;
    private ImageView mealPlanIcon;
    private TextView mealPlanText;
    private ImageView nutritionIcon;
    private TextView nutritionText;
    private ProgressBar progressBar;

    public HomeFragment() {
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
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //connect variables to UI elements in xml file
        viewFlipper = (ViewFlipper) root.findViewById(R.id.vfFlipper);
        cookingTip = root.findViewById(R.id.ivCookingTip);
        randomRecipe = root.findViewById(R.id.ivRandomRecipe);
        cookingTipText = root.findViewById(R.id.tvCookingTip);
        randomRecipeText = root.findViewById(R.id.tvRandomRecipe);
        mealPlanIcon = root.findViewById(R.id.ivMealPrep);
        mealPlanText = root.findViewById(R.id.tvMealPrepText);
        nutritionIcon = root.findViewById(R.id.ivNutritionInfo);
        nutritionText = root.findViewById(R.id.tvNutritionText);

        progressBar = root.findViewById(R.id.loading);
        progressBar.setVisibility(View.INVISIBLE);

        //getActivity provides context for fragments (https://stackoverflow.com/questions/8215308/using-context-in-a-fragment)
        mContext = getActivity();

        //Makes textviews look like they're sliding
        //Source: https://abhiandroid.com/ui/viewflipper
        Animation in = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

        //Source: https://developer.android.com/reference/android/widget/ViewFlipper
        //Used website to understand methods for ViewFlipper and how to code methods.
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        //click cooking tip icon and text triggers display tip method
        cookingTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTip();
            }
        });

        cookingTipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTip();
            }
        });

        //click random recipe to get random recipe
        randomRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //execute asynctask
                new GetRandomRecipeTask().execute();
                root.findViewById(R.id.loading).setVisibility(View.VISIBLE);
            }
        });

        randomRecipeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetRandomRecipeTask().execute();
                root.findViewById(R.id.loading).setVisibility(View.VISIBLE);
            }
        });
        //click to show meal planning info
        mealPlanIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new MealPlanningFragment();
                loadFragment(f);
            }
        });

        mealPlanText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new MealPlanningFragment();
                loadFragment(f);
            }
        });

        //click to show nutrition info
        nutritionIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new NutritionInfoFragment();
                loadFragment(f);
            }
        });

        nutritionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new NutritionInfoFragment();
                loadFragment(f);
            }
        });

//      https://stackoverflow.com/questions/25093546/android-os-networkonmainthreadexception-at-android-os-strictmodeandroidblockgua
//      Used code from stackoverflow to fix error
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        return root;
    }

//  https://developer.android.com/guide/topics/ui/dialogs
//  Used website to learn how to create dialogs
    public void displayTip() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Cooking Tip");
        builder.setIcon(R.drawable.ic_tip);
        builder.setMessage(getRandomTip());
        builder.setPositiveButton("Another tip!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.setMessage(getRandomTip());
                builder.show();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    //https://www.baeldung.com/java-random-list-element
    //Used website to get code to produce random result from arraylist of cooking tips
    public String getRandomTip() {
        mlist = CookingTips.getCookingTips();
        Random random = new Random();
        CookingTips result = mlist.get(random.nextInt(mlist.size()));
        return result.toString();
    }

    //asynctask class
    private class GetRandomRecipeTask extends AsyncTask<Void, Void, Recipe> {

        @Override
        protected Recipe doInBackground(Void... voids) {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.spoonacular.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RecipeService service = retrofit.create(RecipeService.class);
                Call<RecipeResponse> recipeCall = service.getRandomRecipe();
                Response<RecipeResponse> recipeResponse = recipeCall.execute();
                String r = recipeResponse.body().getRecipes().get(0).getTitle();
                System.out.println(r);
                return recipeResponse.body().getRecipes().get(0);
            } catch (IOException ex) {
                System.out.println("failed");
                ex.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Recipe recipe) {
            super.onPostExecute(recipe);
            mRecipe = recipe;
            final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);


//          https://stackoverflow.com/questions/18953632/how-to-set-image-from-url-for-imageview
//          Used stack overflow code to get image from url from spoonacular api
            try {
                URL urlConnection = new URL("https://spoonacular.com/recipeImages/" + Integer.toString(mRecipe.getId()) + "-240x150.jpg");
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                myBitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }

//          https://stackoverflow.com/questions/6276501/how-to-put-an-image-in-an-alertdialog-android
//          Used to create image in dialog
            ImageView image = new ImageView(mContext);
            image.setImageBitmap(myBitmap);
            builder.setView(image);
            progressBar.setVisibility(View.INVISIBLE);
            builder.setMessage(mRecipe.getTitle());
            builder.setPositiveButton("Show recipe!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.out.println("show recipe");
                }
            });
            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create();
            AlertDialog dialog = builder.show();

//          https://stackoverflow.com/questions/4954130/center-message-in-android-dialog-box/19026918
//          Center dialog message
            TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
            messageView.setGravity(Gravity.CENTER);
        }
    }

    private void loadFragment(Fragment f) {
        FragmentTransaction t = getActivity().getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frameContainer, f);
        t.addToBackStack(null);
        t.commit();
    }
}
