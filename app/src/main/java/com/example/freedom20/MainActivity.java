package com.example.freedom20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.freedom20.fragments.fragments.ExploreFragment;
import com.example.freedom20.fragments.fragments.FeedbackFragment;
import com.example.freedom20.fragments.fragments.PostFragment;
import com.example.freedom20.fragments.fragments.ProfileFragment;
import com.example.freedom20.fragments.fragments.QnAFragment;
import com.example.freedom20.fragments.fragments.homeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    FirebaseDatabase database;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomNavigationView bottomNavigationView;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new homeFragment());
        transaction.commit();
        setContentView(R.layout.drawerlayout);
        bottomNavigationView=findViewById(R.id.readableBottomBar);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();


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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                  switch (item.getItemId()) {


                   case R.id.website:
                       break;

                      case R.id.discover_people:
                          transaction1.replace(R.id.container,new DiscoverFragment());
                          break;

                      case R.id.notification:


                       break;

                      case R.id.logout:
                          auth.signOut();
                          Intent intent1 = new Intent(MainActivity.this,loginActivity.class);
                          startActivity(intent1);
                       break;

                   case R.id.nav_rate:
                       transaction1.replace(R.id.container,new FeedbackFragment());
                       break;

                   case R.id.nav_share:
                       break;
                  }
                  transaction1.commit();
                  return true;
            }
        });


    }
}