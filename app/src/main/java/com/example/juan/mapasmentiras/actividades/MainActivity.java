package com.example.juan.mapasmentiras.actividades;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.juan.mapasmentiras.R;
import com.example.juan.mapasmentiras.entidades.AllFragments;
import com.example.juan.mapasmentiras.entidades.LugaresVo;
import com.example.juan.mapasmentiras.entidades.Puente;
import com.example.juan.mapasmentiras.fragments.DetalleFragment;
import com.example.juan.mapasmentiras.fragments.Hoteles;
import com.example.juan.mapasmentiras.fragments.Inicio;
import com.example.juan.mapasmentiras.fragments.Restaurantes;
import com.example.juan.mapasmentiras.fragments.Sitios;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AllFragments, Puente {


    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = new Inicio();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fragment = new Inicio();
            setTitle("Inicio");
        } else if (id == R.id.nav_gallery) {
            fragment = new Sitios();
            setTitle("Sitios");
        } else if (id == R.id.nav_slideshow) {
            fragment = new Hoteles();
            setTitle("Hoteles");
        } else if (id == R.id.nav_manage) {
            fragment = new Restaurantes();
            setTitle("Restaurantes");
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void pantalla(int numero) {
        Intent miIntent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(miIntent);
    }

    @Override
    public void enviar(int numero, LugaresVo objeto) {
        switch (numero) {
            case 1:
                fragment = new DetalleFragment();
                Bundle miBundle = new Bundle();
                miBundle.putSerializable("objeto", objeto);
                fragment.setArguments(miBundle);
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
    }
}
