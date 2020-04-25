package com.example.cookversity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements NotesFragment.OnFragmentInteractionListener, ShoppingListFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView menu = findViewById(R.id.bnNavigation);
        menu.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);
        Fragment fragment = new HomeFragment();
        loadFragment(fragment);
        System.out.println("1");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment f;
            System.out.println("2");
            switch (menuItem.getItemId()) {
                case R.id.miRecipes:
                    f = new RecipesFragment();
                    loadFragment(f);
                    System.out.println("r");
                    return true;
                case R.id.miNutrition:
                    f = new NutritionFragment();
                    loadFragment(f);
                    System.out.println("n");
                    return true;
                case R.id.miHome:
                    f = new HomeFragment();
                    loadFragment(f);
                    System.out.println("mp");
                    return true;
                case R.id.miCookbook:
                    f = new CookbookFragment();
                    loadFragment(f);
                    System.out.println("cb");
                    return true;
                case R.id.miQuizzes:
                    f = new QuizFragment();
                    loadFragment(f);
                    System.out.println("q");
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment f) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frameContainer, f);
        t.addToBackStack(null);
        t.commit();
    }

    @Override
    public void onArticleSelected(int position) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
