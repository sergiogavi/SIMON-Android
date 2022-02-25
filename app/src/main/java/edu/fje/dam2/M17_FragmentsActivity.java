package edu.fje.dam2;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import java.util.ArrayList;

/**
 * Classe que demostra el funcionament dels m39_fragments amb Android
 * Disposa d'una classe d'utilitat per a facilitar la manipulació de la taula
 * per detectar els canvis afegeix   android:configChanges="orientation|screenSize" a
 * l'activity en el manifest
 *
 * @author sergi.grau@fje.edu
 * @version 5.0 27.01.2020
 */
@SuppressLint("ValidFragment")
public class M17_FragmentsActivity extends AppCompatActivity
        implements M17_DetallFragmentActivity.OnNomAfegitListener {

    public static ArrayList<String> CURSOS = new ArrayList<>();
    LinearLayout ll;

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof M17_DetallFragmentActivity) {
            M17_DetallFragmentActivity detallFragmentActivity = (M17_DetallFragmentActivity) fragment;
            detallFragmentActivity.setOnNomAfegitListener(this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m17_fragments);
        ll = findViewById(R.id.elLayout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CURSOS.add("DAW2");
        CURSOS.add("DAM2");
        // FragmentTransaction transaction = getFragmentManager()
        // .beginTransaction();
        // transaction.add(R.id.fragmentcontainer1, new MyListFragment());
        //
        // transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m17_fragments, menu);
        return true;
    }

    @Override
    public void onNomAfegit(String nom) {
        CURSOS.add(nom);
        Log.v("DAM", CURSOS.toString());
        M17_LlistaFragmentActivity llistaFragmentActivity = (M17_LlistaFragmentActivity)
                getFragmentManager().findFragmentById(R.id.contenidorFragmentLlista);

        llistaFragmentActivity.afegirNom(nom);


    }

    public static class FragmentInterna extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.m17_fragment_detall2,
                    container, false);
            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager manager = getFragmentManager();
        switch (item.getItemId()) {
            case R.id.afegirLlista:
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.contenidorFragmentLlista, new M17_LlistaFragmentActivity());
                transaction
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
                break;
            case R.id.afegirDetall:
                transaction = manager.beginTransaction();
                transaction.add(R.id.contenidorFragmentDetall, new M17_DetallFragmentActivity());

                transaction.commit();
                break;

            case R.id.canviarDetall:
                Fragment f = new FragmentInterna();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.contenidorFragmentDetall, f);

                transaction.commit();
                break;


            default:
                break;
        }

        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration novaConfiguracio) {
        super.onConfigurationChanged(novaConfiguracio);
        if (novaConfiguracio.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();

            CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                    CoordinatorLayout.LayoutParams.WRAP_CONTENT);
            ll.setLayoutParams(lp);
            ll.setOrientation(LinearLayout.HORIZONTAL);

        } else if (novaConfiguracio.orientation == Configuration.ORIENTATION_PORTRAIT) {

            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();

            CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                CoordinatorLayout.LayoutParams.WRAP_CONTENT);
            ll.setLayoutParams(lp);
            ll.setOrientation(LinearLayout.VERTICAL);
        }
    }

}