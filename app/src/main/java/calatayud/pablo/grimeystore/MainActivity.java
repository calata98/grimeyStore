package calatayud.pablo.grimeystore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import calatayud.pablo.grimeystore.mFragments.AccesoriosFragment;
import calatayud.pablo.grimeystore.mFragments.CarroFragment;
import calatayud.pablo.grimeystore.mFragments.GorrasFragment;
import calatayud.pablo.grimeystore.mFragments.HombreFragment;
import calatayud.pablo.grimeystore.mFragments.LiquidacionesFragment;
import calatayud.pablo.grimeystore.mFragments.MujerFragment;
import calatayud.pablo.grimeystore.mFragments.OpcionesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static boolean registrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.filter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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
        getMenuInflater().inflate(R.menu.app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Carro) {
            CarroFragment carroF= new CarroFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,carroF)
                    .addToBackStack(null)
                    .commit();
            return true;
        } else if (id == R.id.action_Log){
            if (registrado){

            }else{
                Intent intLog = new Intent(this, LoginActivity.class);

                startActivity(intLog);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FloatingActionButton filter = (FloatingActionButton) findViewById(R.id.filter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_inicio) {
            filter.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_hombre) {
            HombreFragment hombreF = new HombreFragment();
            filter.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,hombreF)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_mujer) {
            MujerFragment MujerF = new MujerFragment();
            filter.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,MujerF)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_gorras) {
            GorrasFragment gorrasF = new GorrasFragment();
            filter.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,gorrasF)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_accesorios) {
            AccesoriosFragment accesoriosF = new AccesoriosFragment();
            filter.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,accesoriosF)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_liquidaciones) {
            LiquidacionesFragment liquidacionesF = new LiquidacionesFragment();
            filter.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,liquidacionesF)
                    .addToBackStack(null)
                    .commit();

        }else if (id == R.id.nav_tools) {
            OpcionesFragment opcionesF = new OpcionesFragment();
            filter.setVisibility(View.INVISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,opcionesF)
                    .addToBackStack(null)
                    .commit();
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
