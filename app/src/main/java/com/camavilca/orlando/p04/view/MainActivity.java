package com.camavilca.orlando.p04.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.camavilca.orlando.p04.frames.Inicio;
import com.camavilca.orlando.p04.frames.Listar;
import com.camavilca.orlando.p04.R;
import com.camavilca.orlando.p04.frames.Registrar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        final Fragment fragment2 = new Inicio();
        getSupportFragmentManager().beginTransaction().add(R.id.main_content,fragment2).commit();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                switch (item.getItemId()){
                    case R.id.nav_home:
                        //Fragment fragment2 = new Inicio();
                        fragmentManager.beginTransaction().replace(R.id.main_content,fragment2).addToBackStack("tag").commit();
                        break;
                    case R.id.nav_registrar:
                        Fragment fragment = new Registrar();
                        fragmentManager.beginTransaction().replace(R.id.main_content,fragment).addToBackStack("tag").commit();
                        break;
                    case R.id.nav_listar:
                        Fragment fragment1 = new Listar();
                        fragmentManager.beginTransaction().replace(R.id.main_content,fragment1).addToBackStack("tag").commit();
                        //Toast.makeText(MainActivity.this, "Go gallery...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_locations:
                        Toast.makeText(MainActivity.this, "Go locations...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity.this, "Go settings...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logaut:
                        Toast.makeText(MainActivity.this, "Do logout...", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText("Orlando Camavilca Chavez");

        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText("ocamavilca@tecsup.edu.pe");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if (!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);
                else
                    drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void Botones(View view){
        switch (view.getId()){
            case R.id.btn_fragment_guardar:
                guardarDatosFragmeto();
                break;
        }
    }

    private void guardarDatosFragmeto() {

        /*String nombre = nom.getText().toString();
        String raza = raz.getText().toString();
        String edad = eda.getText().toString();
        ///int e = Integer.parseInt(edad);

        if(nombre.isEmpty() || raza.isEmpty() || edad.isEmpty()){
            Toast.makeText(getContext(),"Los campos son requeridos",Toast.LENGTH_LONG).show();
        }
        RepositoryMascota.create(nombre,raza,edad);*/
    }
}
