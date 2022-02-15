package com.example.freedom20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.widget.Toast;

import com.example.freedom20.databinding.ActivityMainBinding;
import com.example.freedom20.fragments.fragments.ExploreFragment;
import com.example.freedom20.fragments.fragments.PostFragment;
import com.example.freedom20.fragments.fragments.ProfileFragment;
import com.example.freedom20.fragments.fragments.QnAFragment;
import com.example.freedom20.fragments.fragments.homeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomNavigationView bottomNavigationView;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new homeFragment());
        transaction.commit();
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.readableBottomBar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch(item.getItemId()){

                    case (R.id.btnhome):
                        transaction.replace(R.id.container,new homeFragment());
                        break;
                    case R.id.btnexplore:
                        transaction.replace(R.id.container,new ExploreFragment());
                        break;
                    case R.id.btnpost:
                        transaction.replace(R.id.container,new PostFragment());
                        break;
                    case R.id.btnlogs:
                        transaction.replace(R.id.container,new QnAFragment());
                        break;
                    case R.id.btnprofile:
                        transaction.replace(R.id.container,new ProfileFragment());
                        break;

                }
                transaction.commit();

                return true;
            }
        });

    }
}