package com.example.pcportatil.coffeeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.pcportatil.coffeeapp.databinding.ActivityMainBinding;
import com.example.pcportatil.coffeeapp.fragments.MainFragment;
import com.example.pcportatil.coffeeapp.net.PlantacionesClient;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;
    PlantacionesClient client;
    FloatingActionButton floatbut;
    int content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawer, R.string.open_menu, R.string.close_menu);
        binding.drawer.addDrawerListener(this);
        binding.nav.setNavigationItemSelectedListener(this);
        content = R.id.nav_home;
        if (savedInstanceState != null){

            content = savedInstanceState.getInt("content");
        }
        setContent(content);


        putFragment(R.id.container, MainFragment.instance(1));

    }


    public void add(){
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);

    }

    public void putFragment(int container, Fragment fragment){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container,fragment);
        ft.commit();


    }

    void setContent(int navItem){
        content = navItem;

        switch (navItem){

            case   R.id.nav_home:
                getSupportActionBar().setTitle(R.string.plantaciones);
                putFragment(R.id.container, MainFragment.instance(1)); // instance(template , contenido del template)

                break;
 /*           case  R.id.nav_restaurant:
                getSupportActionBar().setTitle(R.string.restaurante);
                putFragment(R.id.container, MainFragment.instance(2,2));

                break;
            case R.id.nav_discoteca:
                getSupportActionBar().setTitle(R.string.discotecas);
                putFragment(R.id.container, MainFragment.instance(2,3));

                break;
            case R.id.nav_promo:
                getSupportActionBar().setTitle(R.string.promociones);
                putFragment(R.id.container, MainFragment.instance(1,4));

                break;
            case R.id.nav_reserva:
                getSupportActionBar().setTitle(R.string.reservas);
                putFragment(R.id.container, MainFragment.instance(3,5));

                break;

            case R.id.nav_exit:
              //  Intent intent = new Intent(this,LoginActivity.class);
               // startActivity(intent);
                //finish();

                break;

*/
        }

    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView,slideOffset);

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawer.closeDrawers();
        setContent(item.getItemId());
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("content",content);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        Log.d("hola","entro");
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
}
